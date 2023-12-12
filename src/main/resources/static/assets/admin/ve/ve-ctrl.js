app.controller("ve-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};

	$scope.initialize = function() {
		//load vé
		$http.get("/rest/ve").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				console.log(item);
			})
		});

	}
	$scope.search = function(keyword) {
		if (keyword == null) {
			return;
		}

		$http.get("/rest/ve").then(function(response) {
			var ve = response.data;
			var mavechinh = ve.filter(function(ve) {
				var maveString = ve.mave.toString();
				var mavematch = maveString.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
				var tenphimMatch = ve.tenphim.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
				var gheMatch = ve.ghe.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
				var pcMatch = ve.tenpc.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
				return mavematch || tenphimMatch || gheMatch || pcMatch;
			});
			$scope.items = mavechinh;
		}).catch(function(error) {
			console.error("Error fetching data:", error);
		});
	};
	//Hiển thị lên form
	$scope.edit = function(item) {
		$scope.form = angular.copy(item);

		// Định dạng giobatdau theo HH:mm
		if ($scope.form.giobatdau) {
			var timeParts = $scope.form.giobatdau.split(':');
			var formattedTime = timeParts[0].padStart(2, '0') + ':' + timeParts[1].padStart(2, '0');
			$scope.form.giobatdau = formattedTime;
		}

		//Định dạng tiền theo VNĐ
		if ($scope.form.thanhtien) {
			var formattedAmount = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format($scope.form.thanhtien);
			$scope.form.thanhtien = formattedAmount;
		}

		// Định dạng ngày chiếu theo dd-MM-yyyy
		if ($scope.form.ngaychieu) {
			var dateParts = $scope.form.ngaychieu.split('-');
			var formattedDate = dateParts[2] + '-' + dateParts[1] + '-' + dateParts[0];
			$scope.form.ngaychieu = formattedDate;
		}

		// Định dạng ngày giao dịch theo dd-MM-yyyy
		if ($scope.form.ngaygiaodich) {
			var dateParts = $scope.form.ngaygiaodich.split('-');
			var formattedDate = dateParts[2] + '-' + dateParts[1] + '-' + dateParts[0];
			$scope.form.ngaygiaodich = formattedDate;
		}
	}

	$scope.pager = {
		page: 0,
		size: 10,
		get items() {
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first() {
			this.page = 0;
		},
		prev() {
			this.page--;
			if (this.page < 0) {
				this.first();
			}
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.last();
			}
		},
		last() {
			this.page = this.count - 1;
		}
	}

	$scope.formatCurrency = function(amount) {
		if (amount) {
			return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(amount);
		}
		return '';
	};

	$scope.initialize();

});