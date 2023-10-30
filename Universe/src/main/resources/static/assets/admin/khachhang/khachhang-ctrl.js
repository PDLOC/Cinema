app.controller("khachhang-ctrl",function($scope,$http){
	$scope.items = [];
	
	$scope.initialize = function(){
		//load Khách hàng
		$http.get("/rest/customers").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				console.log(item);
			})
		});
	}
	
	$scope.pager = {
		page: 0,
		size: 5,
		get items(){
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
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
			this.page = this.count - 1;
		}
		
	}
	
	$scope.initialize();
});