<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/fitnessproject/js/angular/angular.min.js"></script>
<script type="text/javascript" src="/fitnessproject/js/angular/ajax.js"></script>
<script type="text/javascript" src="/fitnessproject/js/angular/model.js"></script>
<script type="text/javascript" src="/fitnessproject/js/angular/controller.js"></script>
</head>
<body>
         
	<div ng-app="myApp" ng-controller="loginController">
		<input type="text" ng-model="login.email">
		<input type="text" ng-model="login.password">
		<input type="text" ng-model="login.type">
		<button ng-click="login.save()"></button>
		{_t_}
	</div>

</body>
</html>