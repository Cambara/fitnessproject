var app = angular.module('myApp', ['UserModel'],function($interpolateProvider){
	$interpolateProvider.startSymbol('{_');
	$interpolateProvider.endSymbol('_}');
});

app.controller("userInfoController",function($scope, User) {
	$scope.user= User;
	$scope.user.getInfo();
	
});