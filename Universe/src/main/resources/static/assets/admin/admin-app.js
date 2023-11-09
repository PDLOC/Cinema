var app = angular.module("admin-app", ["ngRoute"]);

app.config(function($routeProvider) {
	$routeProvider
		.when("/nhanvien", {
			templateUrl: "/assets/admin/nhanvien/index.html",
			controller: "nhanvien-ctrl"
		})
		.when("/khachhang", {
			templateUrl: "/assets/admin/taikhoan/index.html",
			controller: "taikhoan-ctrl"
		})
		.when("/combo", {
			templateUrl: "/assets/admin/combo/index.html",
			controller: "combo-ctrl"
		})
		.when("/doan", {
			templateUrl: "/assets/admin/doan/index.html",
			controller: "doan-ctrl"
		})
		.when("/khuyenmai", {
			templateUrl: "/assets/admin/khuyenmai/index.html",
			controller: "khuyenmai-ctrl"
		})
		.when("/chitietkm", {
			templateUrl: "/assets/admin/khuyenmai/chitiet/index.html",
			controller: "chitietkm-ctrl"
		})
		.when("/phim", {
			templateUrl: "/assets/admin/phim/index.html",
			controller: "phim-ctrl"
		})
		.when("/lichchieu", {
			templateUrl: "/assets/admin/admin.html",
			controller: "lichchieu-ctrl"
		})
		.otherwise({
			templateUrl: "/assets/admin/nhanvien/index.html",
			controller: "nhanvien-ctrl"
		});
})

app.controller("myController", function($scope, $http) {
	$http.get('/api/session').then(function(response) {
		$scope.username = response.data.username;
		$scope.profileImage = response.data.profileImage;
	});
});