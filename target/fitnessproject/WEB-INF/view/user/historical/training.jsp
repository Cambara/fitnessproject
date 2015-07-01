<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/fitnessproject/css/jquery.e-calendar.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Histórico Treinos</title>
</head>
<body>
	<div style="margin-left: 10%;" ng-controller="historicalTrainingController">
		<div class="row"><h3 class="col-md-offset-1"><span>Histórico Treino</span></h3></div>
		<div class="row">
			<div class="col-sm-offset-1">
				<div id="calendar"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/fitnessproject/js/Jquery/jquery.e-calendar.js"></script>
	<script type="text/javascript" src="/fitnessproject/js/angular/user/historical/controller.js"></script>
</body>
</html>