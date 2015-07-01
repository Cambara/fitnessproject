<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
	<link rel="stylesheet" href="/fitnessproject/css/bootstrap/bootstrap-theme.css.map">
	<link rel="stylesheet" href="/fitnessproject/css/bootstrap/bootstrap-theme.min.css">
	<link rel="stylesheet" href="/fitnessproject/css/bootstrap/bootstrap.css.map">
	<link rel="stylesheet" href="/fitnessproject/css/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="/fitnessproject/css/style.css">
    <style>
       #map-canvas {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
    </style>
    
    <script type="text/javascript" src="/fitnessproject/js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="/fitnessproject/js/jquery-2.1.1.min.map"></script>
	<script type="text/javascript" src="/fitnessproject/js/bootstrap/bootstrap.min.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places"></script>
	<script type="text/javascript" src="/fitnessproject/js/angular/angular.min.js"></script>
    <script type="text/javascript" src="js/angular/maps/model.js"></script>
	<script type="text/javascript" src="js/angular/maps/controller.js"></script>
<title>Insert title here</title>
</head>
<body ng-app="myApp" ng-controller="mapsController">
		
		
		<div id="map-canvas"></div>
		
	
</body>
</html>