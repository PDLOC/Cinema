var app = angular.module("admin-app",["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	.when("/nhanvien",{
		templateUrl: "/assets/admin/nhanvien/index.html",
		controller:"nhanvien-ctrl"
	})
	.when("/khachhang",{
		templateUrl: "/assets/admin/admin.html",
		controller:"khachhang-ctrl"		
	})
	.when("/doan",{
		templateUrl: "/assets/admin/admin.html",
		controller:"doan-ctrl"		
	})
	.when("/khuyenmai",{
		templateUrl: "/assets/admin/admin.html",
		controller:"khuyenmai-ctrl"		
	})
	.when("/phim",{
		templateUrl: "/assets/admin/admin.html",
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