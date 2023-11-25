app.controller("ve-ctrl",function($scope,$http){
	$scope.items = [];
	$scope.form = {};
    $scope.cates = [];
    
    	$scope.initialize = function(){
		//load vé
		$http.get("/rest/ve").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				console.log(item);
			})
		});
		
	}
		    //Hiển thị lên form
    $scope.edit = function(item){
		$scope.form = angular.copy(item);
		
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
		size: 10,
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