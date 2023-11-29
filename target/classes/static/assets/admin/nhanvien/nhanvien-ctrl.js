app.controller("nhanvien-ctrl",function($scope,$http){
	$scope.items = [];
	$scope.form = {},
	$scope.role = [];
	$scope.initialize = function(){
		// load Nhân viên
		$http.get("/rest/staff").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item =>{
				console.log(item);	
			})
		});
		
		 //load vaitro
        $http.get("/rest/vaitro").then(resp=>{
            $scope.role = resp.data;
        })
	}
	    //Hiển thị lên form
    $scope.edit = function(item){
		$scope.form = angular.copy(item);
		$('#pills-home-tab').tab('show');
    }
    
	
	// Upload hình
	$scope.imageChanged = function(files){
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/Images',data,{
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		}).then(resp => {
			$scope.form.image = resp.data.name;
		}).catch(error =>{
			alert("Lỗi upload hình ảnh");
			console.log("Error",error);
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