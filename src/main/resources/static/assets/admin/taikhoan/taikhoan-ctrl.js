app.controller("taikhoan-ctrl",function($scope,$http){
	$scope.items = [];
	$scope.form = {};
    $scope.roles = [];
    $scope.selection =[];
    
	$scope.initialize = function(){
		//load Khách hàng
		$http.get("/rest/customers").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				console.log(item);
			})
		});
		 //load vaitro
        $http.get("/rest/vaitro").then(resp=>{
            $scope.roles = resp.data;
        });
	}
	
	//Load Roles on form by clicking Edit
	$scope.getOneByRole = function(username){
		$http.get(`/rest/authoritiesOne?username=${username}`).then(resp=>{
			$scope.selection = [];
			$scope.roles.forEach(e=>{
				resp.data.forEach(e1=>{
					if(e.tenvaitro == e1.vaitro.tenvaitro){
						console.log(e1)
						$scope.selection.push(e);
					}
				})
			})
		})
	}
	  $scope.search = function(keyword) {
          if (keyword == null) {
            return;
          }

          $http.get("/rest/customers").then(function(response) {
            var tk = response.data;
            var matching = tk.filter(function(matk) {
              var maMatch = matk.matk.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
              var tenMatch = matk.hoten.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
              var email = matk.email.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;             
              var sdtmatch = matk.sdt.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
             
              return maMatch || tenMatch||email||sdtmatch;
            });
            $scope.items = matching;
          }).catch(function(error) {
            console.error("Error fetching data:", error);
          });
        };
	
	    //Xoá form
    $scope.reset = function(){
		$scope.form = {
			hinh:'cloud-upload.jpg',
		}
    }
	    //Hiển thị lên form
    $scope.edit = function(item){
		$scope.form = angular.copy(item);
		$scope.getOneByRole(item.username);
		/*$('#pills-home-tab').tab('show');*/
    }
    
        //Thêm khách hàng
    
    $scope.create = function(){
		var item = angular.copy($scope.form);
	  
	  var taikhoanExists = $scope.items.find(function(taikhoan) {
	    return taikhoan.matk === item.matk;
	  });
		console.log(taikhoanExists)
	  if (taikhoanExists) {
	    alert('Mã tài khoản đã tồn tại!'); // Display error message
	    return;
	  }
		var item = angular.copy($scope.form);
		$http.post(`/rest/customers`,item).then(resp=>{
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
		$http.put(`/rest/customers/${item.username}`,item).then(resp=>{
			var index = $scope.items.findIndex(p=>p.matk == item.matk);
			$scope.items[index] = item;
			alert('Cập nhật thành công!');
			console.log(resp.data);
		}).catch(err=>{
			alert('Lỗi cập nhật!!!!')
			console.log("Error ",err);
		})
	}
	
    //Remove khách hàng
    $scope.delete = function(item){
		$http.delete(`/rest/customers/${item.matk}`).then(resp=>{
			var index = $scope.items.findIndex(kh=> kh.matk == item.matk);
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