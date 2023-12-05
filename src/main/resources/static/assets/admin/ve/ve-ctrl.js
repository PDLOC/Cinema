app.controller("ve-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};

	$scope.initialize = function() {
		//load vé
		$http.get("/rest/ve").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				console.log(item);
			})
		});

	}
	  $scope.search = function(keyword) {
          if (keyword == null) {
            return;
          }

          $http.get("/rest/ve").then(function(response) {
            var ve = response.data;
            var mavechinh = ve.filter(function(ve) {
				var maveString = ve.mave.toString();
              var mavematch = maveString.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
              var tenphimMatch = ve.tenphim.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
              var gheMatch = ve.ghe.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
              var pcMatch = ve.tenpc.toLowerCase().indexOf(keyword.toLowerCase()) !== -1;
              return mavematch || tenphimMatch||gheMatch||pcMatch;
            });
            $scope.items = mavechinh;
          }).catch(function(error) {
            console.error("Error fetching data:", error);
          });
        };
	//Hiển thị lên form
	$scope.edit = function(item) {
		$scope.form = angular.copy(item);

	}

	$scope.pager = {
		page: 0,
		size: 10,
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

});