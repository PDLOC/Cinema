app.controller("ghe-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};
	$scope.catesSeat = [];
	$scope.rooms = [];
	$scope.initialize = function() {
		//load phim
		$http.get("/rest/ghe").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				//console.log(item);
			})
		});
		//load loại ghế
		$http.get("/rest/loaighe").then(resp => {
			$scope.catesSeat = resp.data;
		});


		$http.get("/rest/phong").then(resp => {
			$scope.rooms = resp.data;
			console.log($scope.rooms)
		});
	}

	$scope.search = function(keyword) {
		if (keyword == null) {
			return;
		}
		$http.get("/rest/ghe").then(function(resp) {
			var ghes = resp.data;
			var matchingGhes = ghes.filter(function(ghe) {
				var mapcMatch = ghe.room && ghe.room.mapc && ghe.room.mapc.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
				var tenpcMatch = ghe.room && ghe.room.tenpc && ghe.room.tenpc.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
				var maloaigheMatch = ghe.loaighe && ghe.loaighe.maloaighe && ghe.loaighe.maloaighe.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
				var tenloaigheMatch = ghe.loaighe && ghe.loaighe.tenloaighe && ghe.loaighe.tenloaighe.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
				return mapcMatch || tenpcMatch || maloaigheMatch || tenloaigheMatch;
			});

			$scope.items = matchingGhes;
		}).catch(function(error) {
			console.error("Error fetching data:", error);
		});
	};


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
		$http.post(`/rest/ghe`, item).then(function(resp) {
			if($scope.form.tenghe === ''){
				alert('Thêm mới thất bại');
				return;
			}
			$scope.items.push(resp.data);
			$scope.reset();
			$scope.initialize();
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
		$http.put(`/rest/ghe/update/${item.maghe}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.maghe == item.maghe);
			if($scope.form.tenghe === ''){
				alert('Cập nhật thất bại');
				return;
			}
			$scope.items[index] = item;
			alert('Cập nhật thành công!');
			$scope.initialize();
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