app.controller("ghe-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};

	$scope.initialize = function() {
		//load phim
		$http.get("/rest/ghe").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				console.log(item);
			})
		});
	}


	//Xoá form
	$scope.reset = function() {
		$scope.form = {

		}
	}

	//Hiển thị lên form
	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		/*$('#pills-home-tab').tab('show');*/
	}

	//Thêm 
	$scope.create = function() {
		var item = angular.copy($scope.form);

		// Check if the room already exists
		var gheExists = $scope.items.find(function(ghe) {
			return ghe.tenghe === ghe.tenghe;
		});

		if (gheExists) {
			alert('Ghế đã tồn tại!'); // Display error message
			return;
		}

		$http.post(`/rest/ghe`, item).then(function(resp) {
			$scope.items.push(resp.data);
			$scope.reset();
			alert('Thêm mới thành công!');
			console.log(resp.data);
		}).catch(function(err) {
			alert('Lỗi thêm mới!');
			console.log("Error ", err);
		});
	}

	//Update 
	$scope.update = function() {
		var item = angular.copy($scope.form);
		$http.put(`/rest/ghe/${item.maghe}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.maghe == item.maghe);
			$scope.items[index] = item;
			alert('Cập nhật thành công!');
			console.log(resp.data);
		}).catch(err => {
			alert('Lỗi cập nhật !')
			console.log("Error ", err);
		})
	}

	//Remove 
	$scope.delete = function(item) {
		$http.delete(`/rest/ghe/${item.maghe}`).then(resp => {
			var index = $scope.items.findIndex(p => p.maghe == item.maghe);
			$scope.items.splice(index, 1);
			$scope.reset();
			alert('Xoá ghế thành công!');
			console.log(resp.data);
		}).catch(err => {
			alert('Lỗi xoá phòng!')
			console.log("Error ", err);
		})
	}
	$scope.pager = {
		page: 0,
		size: 8,
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

	$scope.initialize();
	$scope.reset();
});