var app = angular.module('myApp', ['LoginModel'],function($interpolateProvider){
	$interpolateProvider.startSymbol('{_');
	$interpolateProvider.endSymbol('_}');
});

app.controller("signupController",function($scope, Login) {
	$scope.login = Login;
	$scope.login.form = {
			name:'',
			email:'',
			password:'',
			confirmPassword:'',
			type : 'USER'
	};
});
app.controller("loginController",function($scope, Login){
	$scope.login = Login;
	$scope.login.form = {
			email:'',
			password:''
	};
});

