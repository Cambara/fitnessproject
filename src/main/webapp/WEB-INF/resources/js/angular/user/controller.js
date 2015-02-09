var app = angular.module('myApp', ['UserModel'],function($interpolateProvider){
	$interpolateProvider.startSymbol('{_');
	$interpolateProvider.endSymbol('_}');
});

app.controller("userInfoController",function($scope, User) {
	var body = $('body');
	var menu = $('#menuMobile');
	$scope.user= User;
	$scope.user.getInfo();
	$scope.button = {menu:{}};
	$scope.button.menu.status = false;
	$scope.button.menu.open_close = function(){
		if(!$scope.button.menu.status){
			$scope.button.menu.status = true;
			body.css('overflow-y','hidden');
			if(body.height() < 465){
				menu.css('overflow-y','visible');
			}else{
				menu.css('overflow-y','hidden');
			}
		}else{
			$scope.button.menu.status = false;
			body.css('overflow-y','visible');
		}
	};
});