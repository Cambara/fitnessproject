<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Treinos</title>
</head>
<body>

	<div style="margin-left: 10%;" ng-controller="trainerController" id="trainer_controller">
		<div class="row"><h1 class="col-xs-offset-2 col-sm-offset-1 title_subsession_user"><span>Treinos</span></h1></div>
		<div class="row">
			<div class="col-xs-offset-2 col-sm-offset-1 col-xs-10">
				<div class="row">
					<div class="col-md-4 col-sm-6 col-xs-10 card" ng-repeat="t in crud.list">
						
						<div class="row">
							<div class="col-xs-offset-1">
								<h4>{_t.name_}</h4>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-offset-1 col-xs-8">
								<div class="row">
									<h6>
										{_t.desc_}
									
									</h6>
								</div>
								<div class="row">
									
									<h6 ng-if="t.last_trainer != null">
										Ultimo treino em {_t.last_trainer|date:'dd/MM/yyyy'_}
									</h6>
								</div>
							</div>
							<div class="col-xs-offset-1 col-xs-2">
								
								<div class="row card_sub">
									<a href="#" title="Treinar" ng-click="start_trainer(t)"><img alt="" src="/fitnessproject/img/icon/start_trainer.png" width="20px"></a>
								</div>
								<div class="row card_sub">
									<a href="#" title="Editar" ng-click="trainer_btn_update(t.id)"><span class="glyphicon glyphicon-pencil"></span></a>
								</div>
								<div class="row card_sub">
									<a href="#" title="Remover" ng-click="trainer_btn_remove(t.id)"><span class="glyphicon glyphicon-trash" style="color:red;"></span></a>
								</div>
							
							</div>
						</div>
				
					</div>
					<a href="#" class="col-md-4 col-sm-6 col-xs-10 card card_add" title="Adicionar Treino" ng-click="trainer_btn_add()">
						<div>
							<span class="glyphicon glyphicon-plus" style="font-size:6em;"></span>
						</div>
					</a>
				</div>
			</div>
		</div>
		<%@ include file="formEditTrainer.jsp" %>
		<%@ include file="startTrainer.jsp" %>
	</div>
<script type="text/javascript" src="/fitnessproject/js/angular/trainer/controller.js"></script>
</body>
</html>