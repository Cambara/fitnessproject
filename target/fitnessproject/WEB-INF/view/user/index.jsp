<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>FitnessProject</title>
</head>
<body>
	<div class="row" ng-controller="fastTrainerController">
			<a href="#" class="col-md-4 col-sm-5  col-sm-offset-1 col-xs-7 col-xs-offset-3 card card_add" 
			title="Treinar"style="text-decoration:none" data-toggle="modal" data-target="#modal_form_measures" 
			ng-click="start_trainer()" ng-if="crud.params.id.value > 0">
				<img class="card_img"alt="Treinar" src="${pageContext.request.contextPath}/img/icon/fast_trainer_icon.png">
				<h5 class="card_text">Treinar</h5>
			
			</a>
			<a href="${pageContext.request.contextPath}/user/historical/training" class="col-md-4 col-sm-5 col-sm-offset-0 col-xs-7 col-xs-offset-3 card card_add" title="Histórico Treinos" style="text-decoration:none">
				<img class="card_img"alt="Histórico Treinos" src="${pageContext.request.contextPath}/img/icon/training_days_icon.png">
				<h5 class="card_text">Histórico Treinos</h5>
		
			</a>
			<a href="${pageContext.request.contextPath}/user/historical/measures" class="col-md-4 col-sm-5 col-sm-offset-1 col-xs-7 col-xs-offset-3 card card_add" title="Histórico Medidas" style="text-decoration:none">
		
				<img class="card_img"alt="Histórico Medias" src="${pageContext.request.contextPath}/img/icon/historical_icon.png">
				<h5 class="card_text">Histórico Medidas</h5>
		
			</a>
			<%@ include file="card/trainer/startTrainer.jsp" %>
	</div>
	<script type="text/javascript" src="/fitnessproject/js/angular/trainer/controller.js"></script>
</body>
</html>