var app = angular.module("admin-app", ["ngRoute"]);

app.config(function($routeProvider) {
	$routeProvider
		.when("/taikhoan", {
			templateUrl: "/assets/admin/taikhoan/index.html",
			controller: "taikhoan-ctrl"
		})
		.when("/ve", {
			templateUrl: "/assets/admin/ve/index.html",
			controller: "ve-ctrl"
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
		.when("/ctphim", {
			templateUrl: "/assets/admin/ctphim/index.html",
			controller: "ctphim-ctrl"
		})
		.when("/lichchieu", {
			templateUrl: "/assets/admin/lichchieu/index.html",
			controller: "lich-ctrl"
		})
		.when("/thongke", {
			templateUrl: "/assets/admin/thongke/index.html",
			controller: "thongke-ctrl"
		})
		.otherwise({
			templateUrl: "/assets/admin/thongke/index.html",
			controller: "thongke-ctrl"
		});
})

app.controller("myController", function($scope, $http) {
	$http.get('/api/session').then(function(response) {
		$scope.username = response.data.username;
		$scope.profileImage = response.data.profileImage;
	});
});