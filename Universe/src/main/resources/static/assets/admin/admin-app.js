var app = angular.module("admin-app",["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	.when("/nhanvien",{
		templateUrl: "/assets/admin/nhanvien/index.html",
		controller:"nhanvien-ctrl"
	})
	.when("/khachhang",{
		templateUrl: "/assets/admin/khachhang/index.html",
		controller:"khachhang-ctrl"		
	})
	.when("/combo",{
		templateUrl: "/assets/admin/combo/index.html",
		controller:"combo-ctrl"		
	})
	.when("/doan",{
		templateUrl: "/assets/admin/doan/index.html",
		controller:"doan-ctrl"		
	})
	.when("/khuyenmai",{
		templateUrl: "/assets/admin/admin.html",
		controller:"khuyenmai-ctrl"		
	})
	.when("/phim",{
		templateUrl: "/assets/admin/phim/index.html",
		controller:"phim-ctrl"		
	})
	.when("/lichchieu",{
		templateUrl: "/assets/admin/admin.html",
		controller:"lichchieu-ctrl"		
	})
	.otherwise({
		templateUrl: "/assets/admin/nhanvien/index.html",
		controller:"nhanvien-ctrl"		
	});
})