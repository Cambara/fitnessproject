var app = angular.module('myApp', ['Ajax'],function($interpolateProvider){
	$interpolateProvider.startSymbol('{_');
	$interpolateProvider.endSymbol('_}');
});

app.controller("locationController",function($scope, Request) {
	$scope.location = {
			street:"",
			number:"",
			neighborhood:"",
			city:"",
			lat:0,
			lng:0,
			location_url : "http://maps.googleapis.com/maps/api/geocode/json?address="
	}
	
	$scope.search_address = function() {
		var location = $scope.location;
		address = location.street+" "+location.number+" "+location.neighborhood+" "+location.city;
		var url = location.location_url +address+"&sensor=false";
		Request.url = url ;
		Request.get().then(function(data) {
			console.log(data);
			
		},function(data) {
			alert('Tivemos problema para encontrar o seu endereço, tente novamente!');
		});
	}
	
});