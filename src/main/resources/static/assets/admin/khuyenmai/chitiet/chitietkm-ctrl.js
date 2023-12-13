app.controller("chitietkm-ctrl",function($scope,$http){
	$scope.items = [];
	$scope.form = {};
    $scope.discount = [];
    
	$scope.initialize = function(){
		//load chi tiết khuyến mãi
		$http.get("/rest/chitietkm").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				console.log(item);
			})
		});
		
		$http.get("/rest/khuyenmai").then(resp => {
			$scope.discount = resp.data;
		});
		
	}
	
	    //Xoá form
    $scope.reset = function(){
		$scope.form = {
			
		}
    }
    
	    //Hiển thị lên form
    $scope.edit = function(item){
		$scope.form = angular.copy(item);
//		$('#pills-home-tab').tab('show');
    }
    
        //Thêm
    $scope.create = function(){
		var item = angular.copy($scope.form);
		$http.post(`/rest/chitietkm`,item).then(resp=>{
			$scope.items.push(resp.data);
			$scope.reset();
			alert('Thêm mới thành công!');
			console.log(resp.data);
		}).catch(err=>{
			alert('Thêm mói thất bại!')
			console.log("Error ",err);
		})
    }
    
        //Update
    $scope.update = function(){
		var item = angular.copy($scope.form);
		if($scope.form.mota === ''){
				alert('Cập nhật thất bại');
				return;
			}
		$http.put(`/rest/chitietkm/${item.id}`,item).then(resp=>{
			var index = $scope.items.findIndex(p=>p.id == item.id);
			$scope.items[index] = item;
			alert('Cập nhật thành công!');
			console.log(resp.data);
		}).catch(err=>{
			alert('Lỗi cập nhật!!!!')
			console.log("Error ",err);
		})
	}
	
      //Remove
    $scope.delete = function(item){
		$http.delete(`/rest/chitietkm/${item.id}`).then(resp=>{
			var index = $scope.items.findIndex(ctkm => ctkm.id == item.id);
			$scope.items.splice(index,1);
			$scope.reset();
			alert('Xoá thành công');
			console.log(resp.data);
		}).catch(err=>{
			alert('Lỗi xoá !!!!')
			console.log("Error ",err);
		})
	}
	 //Upload Hình
    $scope.imageChanged = function(files){
		var data = new FormData();
		data.append('file',files[0]);
		$http.post('/rest/upload/Images',data,{
			transformRequest:angular.identity,
			headers:{'Content-Type':undefined}
		}).then(resp=>{
			$scope.form.hinh = resp.data.name;
		}).catch(err=>{
			alert('Lỗi upload Ảnh');
			console.log("Error ",err)
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
	$scope.reset();
});