app.controller("ctphim-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};
	$scope.cates = [];
	$scope.phim = [];
	$scope.initialize = function() {
		//load phim
		$http.get("/rest/ctphim").then(resp => {
			$scope.items = resp.data;
		});


		//load phim
		$http.get("/rest/phim").then(resp => {
			$scope.phim = resp.data;
		});

		//load trạng thái
		$http.get("/rest/trangthai").then(resp => {
			$scope.cates = resp.data;
		})
	}

	$scope.search = function(keyword) {
		if (keyword == null) {
			return;
		}

		$http.get("/rest/ctphim").then(function(response) {
			var tk = response.data;
			var matching = tk.filter(function(matk) {
				var ten = matk.tenphim.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;


				return ten;
			});
			$scope.items = matching;
		}).catch(function(error) {
			console.error("Error fetching data:", error);
		});
	};
	//Xoá form
	$scope.reset = function() {
		$scope.form = {
			hinh: 'cloud-upload.jpg'
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
		$http.post(`/rest/ctphim`, item).then(resp => {
			resp.data.createDate = new Date(resp.data.createDate);
			$scope.items.push(resp.data);
			$scope.reset();
			alert('Thêm mới thành công!');
			$scope.initialize();
			console.log(resp.data);
		}).catch(err => {
			alert('Lỗi thêm mới !')
			console.log("Error ", err);
		})
	}

	//Update 
	$scope.update = function() {
		var item = angular.copy($scope.form);
		if ($scope.form.loaiphim === '') {
			alert('Cập nhật thất bại');
			return;
		}
		if ($scope.form.daodien === '') {
			alert('Cập nhật thất bại');
			return;
		}
		if ($scope.form.dienvien === '') {
			alert('Cập nhật thất bại');
			return;
		}
		if ($scope.form.linkytb === '') {
			alert('Cập nhật thất bại');
			return;
		}
		if ($scope.form.noidung === '') {
			alert('Cập nhật thất bại');
			return;
		}
		$http.put(`/rest/ctphim/${item.maphim}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.maphim == item.maphim);
			$scope.items[index] = item;
			alert('Cập nhật  thành công!');
			$scope.initialize();
		}).catch(err => {
			alert('Lỗi cập nhật !')
			console.log("Error ", err);
		})
	}
	//Upload Hình
	$scope.imageChanged = function(files) {
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/Images', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.hinh = resp.data.name;
		}).catch(err => {
			alert('Lỗi upload Ảnh');
			console.log("Error ", err)
		})
	}


	//Remove 
	$scope.delete = function(item) {
		$http.delete(`/rest/ctphim/${item.mact}`).then(resp => {
			var index = $scope.items.findIndex(p => p.mact == item.mact);
			$scope.items.splice(index, 1);
			$scope.reset();
			alert('Xoá sản phẩm thành công!');
			console.log(resp.data);
		}).catch(err => {
			alert('Lỗi xoá sản phẩm!')
			console.log("Error ", err);
		})
	}
	$scope.pager = {
		page: 0,
		size: 5,
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

	$scope.updateMaPhim = function() {
		var selectedPhim = $scope.form.tenphim;
		var foundPhim = $scope.phim.find(function(phim) {
			return phim.tenphim === selectedPhim;
		});
		if (foundPhim) {
			$scope.form.film = $scope.form.film || {}; // Initialize $scope.form.film if it's undefined
			$scope.form.film.maphim = foundPhim.maphim;
		} else {
			$scope.form.film = {}; // Reset $scope.form.film to an empty object
		}
	};


	$scope.initialize();
	$scope.reset();
});