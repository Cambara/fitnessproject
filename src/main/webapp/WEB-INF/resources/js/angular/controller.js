var app = angular.module('myApp', ['LoginModel'],function($interpolateProvider){
	$interpolateProvider.startSymbol('{_');
	$interpolateProvider.endSymbol('_}');
});

app.controller("loginController",function($scope, Login) {
	$scope.login = Login; 
	$scope.t = 'tiago';
});

