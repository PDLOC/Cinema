app.controller("combo-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};
	$scope.cates = [];

	$scope.initialize = function() {
		//Load Combo
		$http.get("/rest/combo").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				console.log(item);
			})
		});
	}
	//Reset form
	$scope.reset = function() {
		$scope.form = {
			hinh: 'cloud-upload.jpg',
		}
	}
	$scope.search = function(keyword) {
          if (keyword == null) {
            return;
          }

          $http.get("/rest/combo").then(function(response) {
            var tk = response.data;
            var matching = tk.filter(function(combo) {
              var maMatch = combo.macb.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
              var tenMatch = combo.tencb.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;         
              
              return maMatch || tenMatch;
            });
            $scope.items = matching;
          }).catch(function(error) {
            console.error("Error fetching data:", error);
          });
        };
	//Hiển thị lên form
	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		/*$('#pills-home-tab').tab('show');*/
	}

	//Thêm 
	$scope.create = function() {
		var item = angular.copy($scope.form);
		// Kiểm tra mã trùng
		var duplicateItem = $scope.items.find(function(existingItem) {
			return existingItem.macb === item.macb;
		});

		if (duplicateItem) {
			alert('Mã đã tồn tại. Vui lòng nhập mã khác!');
			return;
		}
		
		$http.post(`/rest/combo`, item).then(resp => {
			resp.data.createDate = new Date(resp.data.createDate);
			$scope.items.push(resp.data);
			$scope.reset();
			$scope.initialize();
			alert('Thêm mới  thành công!');
			console.log(resp.data);
		}).catch(err => {
			alert('Lỗi thêm mới !')
			console.log("Error ", err);
		})
	}

	//Update 
	$scope.update = function() {
		var item = angular.copy($scope.form);
		if($scope.form.macb === ''){
				alert('Cập nhật thất bại');
				return;
			}
		if($scope.form.tencb === ''){
				alert('Cập nhật thất bại');
				return;
			}
		if($scope.form.mota === ''){
				alert('Cập nhật thất bại');
				return;
			}		
		$http.put(`/rest/combo/${item.stt}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.stt == item.stt);
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
		$http.post('/rest/upload/combo', data, {
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
		$http.delete(`/rest/combo/${item.stt}`).then(resp => {
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
		size: 3,
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