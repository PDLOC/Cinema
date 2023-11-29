app.controller("lich-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};
	$scope.cates = [];

	$scope.initialize = function() {
		//Load lịch chiếu
		$http.get("/rest/lich").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				console.log(item);
			})
		});
		 //load phim
        $http.get("/rest/ctphim").then(resp=>{
            $scope.cates = resp.data;
            $scope.cates.forEach(cate => {
				console.log(cate);
				})
        });
	}
	//Reset form
	$scope.reset = function() {
		$scope.form = {
			hinh: 'cloud-upload.jpg',
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
		$http.post(`/rest/lich`, item).then(resp => {
			resp.data.createDate = new Date(resp.data.createDate);
			$scope.items.push(resp.data);
			$scope.reset();
			alert('Thêm mới  thành công!');
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
		$http.put(`/rest/lich/${item.stt}`, item).then(resp => {
			var index = $scope.items.findIndex(l => l.stt == item.stt);
			$scope.items[index] = item;
			alert('Cập nhật  thành công!');
			console.log(resp.data);
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
$scope.updateHinh = function() {
            var selectedPhim = $scope.cates.find(function(phim) {
                return phim.mact === $scope.form.ctphims.mact;
            });
            $scope.selectedHinh = selectedPhim.hinh;
        };
   

	//Remove 
	$scope.delete = function(item) {
		$http.delete(`/rest/lich/${item.stt}`).then(resp => {
			var index = $scope.items.findIndex(cb => cb.stt == item.stt);
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

	$scope.initialize();
	$scope.reset();
});