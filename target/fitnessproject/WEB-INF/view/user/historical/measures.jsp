<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Histórico Medidas</title>
</head>
<body>
	<div style="margin-left: 10%;" ng-controller="historicalMeasuresController">
		<div class="row">
			<h3>Histórico de Medidas</h3>
		</div>
		
		<div class="row">
			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				<div class="panel panel-default" ng-repeat="body in crud.list">
					<div class="panel-heading" role="tab" id="heading{_body.id_}">
						<a class="panel-title"data-toggle="collapse" data-parent="#accordion" href="#collapse{_body.id_}" 
								aria-expanded="false" aria-controls="collapse{_body.id_}">
							<h4>
								{_body.date|date:'dd/MM/yyyy'_}
							</h4>
						</a>
					</div>
					<div id="collapse{_body.id_}" class="panel-collapse collapse" role="tabpanel" 
						aria-labelledby="heading{_body.id_}">
				      <div class="panel-body">
				         <div class="row accordion_historical_body_title">
				         	<div class="col-xs-3">	
				         		<span>Peso</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>Altura</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>Peito</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>Costas</span>
				         	</div>
				         </div>
				         <div class="row accordion_historical_body_value">
				         	<div class="col-xs-3">
				         		<span>{_body.weigth_}</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>{_body.heigth_}</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>{_body.bust_}</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>{_body.back_}</span>
				         	</div>
				         </div>
				         <div class="row accordion_historical_body_title">
				         	<div class="col-xs-3"><span>Cintura</span></div>
				         	<div class="col-xs-3"><span>Quadril</span></div>
				         </div>
				         <div class="row accordion_historical_body_value">
				         	<div class="col-xs-3"><span>{_body.waist_}</span></div>
				         	<div class="col-xs-3"><span>{_body.hip_}</span></div>
				         </div>
				         <div class="row accordion_historical_body_title">
				         	<div class="col-xs-3">	
				         		<span>Braço Esquerdo</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>Braço Direito</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>Antebraço Esquerdo</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>Antebraço Direito</span>
				         	</div>
				         </div>
				         <div class="row accordion_historical_body_value">
				         	<div class="col-xs-3">
				         		<span>{_body.biceps_l_}</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>{_body.biceps_r_}</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>{_body.forearm_l_}</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>{_body.forearm_r_}</span>
				         	</div>
				         </div>
						<div class="row accordion_historical_body_title">
				         	<div class="col-xs-3">	
				         		<span>Coxa Esquerda</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>Coxa Direita</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>Panturrilha Esquerda</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>Panturrilha Direita</span>
				         	</div>
				         </div>
				         <div class="row accordion_historical_body_value">
				         	<div class="col-xs-3">
				         		<span>{_body.leg_l_}</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>{_body.leg_r_}</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>{_body.calf_l_}</span>
				         	</div>
				         	<div class="col-xs-3">
				         		<span>{_body.calf_r_}</span>
				         	</div>
				         </div>
								         
				      </div>
				    </div>
				</div>
			
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/fitnessproject/js/Jquery/jquery.e-calendar.js"></script>
	<script type="text/javascript" src="/fitnessproject/js/angular/user/historical/controller.js"></script>
</body>
</html>