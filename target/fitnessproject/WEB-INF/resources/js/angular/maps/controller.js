var app = angular.module('myApp', ['MapsModel'],function($interpolateProvider){
	$interpolateProvider.startSymbol('{_');
	$interpolateProvider.endSymbol('_}');
});

app.controller("mapsController",function($scope,Maps) {
	$scope.map = Maps;
	$scope.map.display = document.getElementById('map-canvas');
	$scope.map.options.zoom = 13
	$scope.map.url_place = '/fitnessproject/user/gym/get_all_gyms';
	$scope.map.load(); 
	
	
});



