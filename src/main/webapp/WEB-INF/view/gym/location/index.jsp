<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
</head>
<body>
	<div style="margin-bottom:20px;" ng-app="myApp" ng-controller="locationController">
	<h1 class="section_title">
		<span>Localização</span>	
	</h1>
	<div class="row" >
		<div class="col-xs-12 col-sm-4">
			<div class="form-group">
				<label>Rua</label>
				<input class="form-control" ng-model="location.street">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 col-sm-2">
			<div class="form-group">
				<label>Número</label>
				<input class="form-control" ng-model="location.number">
			</div>
		</div>
	</div>
			
	<div class="row">
		<div class="col-xs-12 col-sm-4">
			<div class="form-group">
				<label>Bairro</label>
				<input class="form-control" ng-model="location.neighborhood">
			</div>
		</div>
	</div>
			
	<div class="row">
		<div class="col-xs-12 col-sm-4">
			<div class="form-group">
				<label>Cidade</label>
				<input class="form-control" ng-model="location.city">
			</div>
		</div>
	</div>
			
			
	<div class="row">
		<div class="col-xs-12 col-sm-4">
			<button type="button" class="btn btn-lg btn-primary " style="width: 100%;" ng-click="search_address()">
				<span class="">Enviar</span>
			</button>
		</div>
	</div>
	</div>		
<script type="text/javascript" src="/fitnessproject/js/angular/location/controller.js"></script>
</body>
</html>