<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro</title>
<script type="text/javascript" src="/fitnessproject/js/angular/angular.min.js"></script>
<script type="text/javascript" src="/fitnessproject/js/angular/ajax.js"></script>
<script type="text/javascript" src="/fitnessproject/js/angular/validate/model.js"></script>
<script type="text/javascript" src="/fitnessproject/js/angular/login/model.js"></script>
<script type="text/javascript" src="/fitnessproject/js/angular/login/controller.js"></script> 
</head>
<body>
	<%@ include file="menuGuest.jsp" %>
	<div class="container" style="min-height: 80%;" ng-app="myApp" ng-controller="signupController">
		<div class="row">
			<div class="col-xs-offset-1">
				<h1 class="section_title">
					<span>Cadastre-se</span>	
				</h1>
				<div ng-keyup="$event.keyCode == 13 ? login.save() : null">
					<div class="col-xs-offset-1 col-xs-10 col-sm-offset-1 col-sm-5 col-md-3">
						<div id="formSignup" role="form" class="form_signup">
							<div id="groupname" class="form-group">
								<label>Nome*:</label>
								<input id="name" class="form-control validate_form" ng-model="login.form.name">
								<div class="alert alert-danger fade in error_form_box" ng-show="login.validate.name.status">
									<button type="button" class="close" ng-click="login.validate.close('name')">
										<span aria-hidden="true">×</span>
										<span class="sr-only">Close</span>
									</button>
									<strong>{_login.validate.name.msg_}</strong>
								</div>
								
							</div>
							<div id="groupemail" class="form-group">
								<label>Email*:</label>
								<input id="email" class="form-control validate_form" type="text" ng-model="login.form.email">
								<div class="alert alert-danger fade in error_form_box" ng-show="login.validate.email.status">
									<button type="button" class="close" ng-click="login.validate.close('email')">
										<span aria-hidden="true">×</span>
										<span class="sr-only">Close</span>
									</button>
									<strong>{_login.validate.email.msg_}</strong>
								</div>
								
							</div>
							<div id="grouppassword" class="form-group">
								<label>Senha*:</label>
								<input id="password" class="form-control validate_form" type="password" ng-model="login.form.password">
								<div class="alert alert-danger fade in error_form_box" ng-show="login.validate.password.status">
									<button type="button" class="close" ng-click="login.validate.close('password')">
										<span aria-hidden="true">×</span>
										<span class="sr-only">Close</span>
									</button>
									<strong>{_login.validate.password.msg_}</strong>
								</div>
							</div>
							<div id="groupConfirmPassword" class="form-group">
								<label>Confirma Senha*:</label>
								<input id="confirmPassword" class="form-control" type="password" ng-model="login.form.confirmPassword">
								<div class="alert alert-danger fade in error_form_box" ng-show="login.validate.confirmPassword.status">
									<button type="button" class="close" ng-click="login.validate.close('confirmPassword')">
										<span aria-hidden="true">×</span>
										<span class="sr-only">Close</span>
									</button>
									<strong>{_login.validate.confirmPassword.msg_}</strong>
								</div>
							</div>
							<div class="form-group">
								<label>Tipo*:</label>
								<select class="form-control" ng-model="login.form.type">
									<option value="USER" ng-selected="true">Usuário</option>
									<option value="GYM">Academia</option>
								</select>								
							</div>
							<button type="button" class="btn btn-primary btn-lg hidden-xs" ng-click="login.save();">Cadastrar</button>
							<button type="button" class="btn btn-primary btn-lg btn-block visible-xs" ng-click="login.save();" >Cadastrar</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>