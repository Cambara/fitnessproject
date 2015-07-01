<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Séries</title>
</head>
<body>

	<div style="margin-left: 10%;" ng-controller="cardController" id="card_controller">
		<div class="row"><h1 class="col-xs-offset-2 col-sm-offset-1 title_subsession_user"><span>Séries</span></h1></div>
		<div class="row">
			<div class="col-xs-offset-2 col-sm-offset-1 col-xs-10">
				<div class="row">
					<div class="col-md-4 col-sm-6 col-xs-10 card" ng-repeat="c in crud.list">
						
						<div class="row">
							<div class="col-xs-offset-1">
								<h4>{_c.name_}</h4>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-offset-1 col-xs-8">
								<div class="row">
									<h6>Inicio:{_c.date_begin|date:'dd/MM/yyyy'_}</h6>
								</div>
								<div class="row">
									<h6>Fim:{_c.date_end|date:'dd/MM/yyyy'_}</h6>
								</div>
							</div>
							<div class="col-xs-offset-1 col-xs-2">
								
								<div class="row card_sub">
									<a href="${pageContext.request.contextPath}/user/card/trainer?id={_c.id_}" title="Treinos">
										<img alt="" src="/fitnessproject/img/icon/trainer.png" width="14px">
									</a>
								</div>
								<div class="row card_sub">
									<a href="#" title="Editar" ng-click="card_btn_update(c.id)">
										<span class="glyphicon glyphicon-pencil"></span>
									</a>
								</div>
								<div class="row card_sub">
									<a href="#" title="Remover" ng-click="card_btn_remove(c.id)">
										<span class="glyphicon glyphicon-trash" style="color:red;"></span>
									</a>
								</div>
							
							</div>
						</div>

					</div>
					<a href="#" class="col-md-4 col-sm-6 col-xs-10 card card_add" title="Adicionar Série" ng-click="card_btn_add()">
						<div>
							<span class="glyphicon glyphicon-plus" style="font-size:6em;"></span>
						</div>
					</a>
							
				</div>
			</div>
		</div>
		<%@ include file="formCard.jsp" %>
	</div>
	
<script type="text/javascript" src="/fitnessproject/js/angular/card/controller.js"></script>
</body>
</html>