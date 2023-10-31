app.controller("khachhang-ctrl",function($scope,$http){
	$scope.items = [];
	$scope.form = {};
    $scope.cates = [];
	$scope.initialize = function(){
		//load Khách hàng
		$http.get("/rest/customers").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				console.log(item);
			})
		});
	}
	    //Xoá form
    $scope.reset = function(){
		$scope.form = {
			createDate:new Date(),
			image:'cloud-upload.jpg',
			available:true,
		}
    }
	    //Hiển thị lên form
    $scope.edit = function(item){
		$scope.form = angular.copy(item);
		$('#pills-home-tab').tab('show');
    }
    
        //Thêm khách hàng
    $scope.create = function(){
		var item = angular.copy($scope.form);
		$http.post(`/rest/customers`,item).then(resp=>{
			resp.data.createDate = new Date(resp.data.createDate);
			$scope.items.push(resp.data);
			$scope.reset();
			alert('Thêm mới khách hàng thành công!');
			console.log(resp.data);
		}).catch(err=>{
			alert('Lỗi thêm mới khách hàng!')
			console.log("Error ",err);
		})
    }
    
        //Update khách hàng
    $scope.update = function(){
		var item = angular.copy($scope.form);
		$http.put(`/rest/customers/${item.makh}`,item).then(resp=>{
			var index = $scope.items.findIndex(p=>p.id == item.makh);
			$scope.items[index] = item;
			alert('Cập nhật  thành công!');
			console.log(resp.data);
		}).catch(err=>{
			alert('Lỗi cập nhật !')
			console.log("Error ",err);
		})
	}
	
      //Remove khách hàng
    $scope.delete = function(item){
		$http.delete(`/rest/customers/${item.makh}`).then(resp=>{
			var index = $scope.items.findIndex(kh=> kh.makh == item.makh);
			$scope.items.splice(index,1);
			$scope.reset();
			alert('Xoá sản phẩm thành công!');
			console.log(resp.data);
		}).catch(err=>{
			alert('Lỗi xoá sản phẩm!')
			console.log("Error ",err);
		})
	}
	$scope.pager = {
		page: 0,
		size: 5,
		get items(){
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count(){
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first(){
			this.page = 0;
		},
		prev(){
			this.page--;
			if(this.page < 0){
				this.first();
			}
		},
		next(){
			this.page++;
			if(this.page >= this.count){
				this.last();
			}
		},
		last(){
			this.page = this.count-1;
		}
	}
	
	$scope.initialize();
});