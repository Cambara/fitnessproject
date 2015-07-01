<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Medidas</title>
</head>
<body>
	<div style="margin-left: 10%;" ng-controller="measuresController"> 
		<div class="row">
			<h1 class="title_subsession_user col-xs-offset-3 col-sm-offset-1"><span>Medidas</span></h1>
		</div>
		<div class="row">
			<a href="#" class="col-md-4 col-sm-5 col-sm-offset-1 col-xs-7 col-xs-offset-3 card card_add" 
			title="Editar Medidas"style="text-decoration:none" data-toggle="modal" data-target="#modal_form_measures">
				
				<img class="card_img"alt="Editar Medias" src="${pageContext.request.contextPath}/img/icon/measure_icon.png">
				<h5 class="card_text">Editar Medidas</h5>
			</a>
			<a href="${pageContext.request.contextPath}/user/historical/measures" class="col-md-4 col-sm-5 col-sm-offset-0 col-xs-7 col-xs-offset-3 card card_add" title="Histórico Medidas" style="text-decoration:none">
				<img class="card_img"alt="Histórico Medidas" src="${pageContext.request.contextPath}/img/icon/historical_icon.png">
				<h5 class="card_text">Histórico Medidas</h5>
		
			</a>
		</div>
		
		<%@ include file="formMeasures.jsp" %>
	</div>
	<script type="text/javascript" src="/fitnessproject/js/angular/measures/controller.js"></script>
</body>
</html>