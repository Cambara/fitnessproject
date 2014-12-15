<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script type="text/javascript" src="/fitnessproject/js/angular/angular.min.js"></script>
<script type="text/javascript" src="/fitnessproject/js/angular/ajax.js"></script>
<script type="text/javascript" src="/fitnessproject/js/angular/validate/model.js"></script>
<script type="text/javascript" src="/fitnessproject/js/angular/login/model.js"></script>
<script type="text/javascript" src="/fitnessproject/js/angular/login/controller.js"></script> 
</head>
<body>
	<%@ include file="menuGuest.jsp" %>
	<div class="container" style="min-height: 80%;"ng-app="myApp" ng-controller="loginController">
		<div class="row">
			<div class="col-sm-offset-1">
				<h1>Login</h1>
				<div class="row">
					<div class="col-xs-offset-1 col-xs-10 col-sm-offset-1 col-sm-5 col-md-3">
						<div action="doLogin" role="form" class="form_signup" method="post">
							<div class="form-group">
								<label>Email:</label>
								<input class="form-control" type="text"ng-model="login.form.email">
								<div class="alert alert-danger fade in error_form_box" ng-show="login.validate.email.status">
									<button type="button" class="close" ng-click="login.validate.close('email')">
										<span aria-hidden="true">×</span>
										<span class="sr-only">Close</span>
									</button>
									<strong>{_login.validate.email.msg_}</strong>
								</div>
							</div>	
							<div class="form-group">
								<label>Senha:</label>
								<input class="form-control" type="password" ng-model="login.form.password">
								<div class="alert alert-danger fade in error_form_box" ng-show="login.validate.password.status">
									<button type="button" class="close" ng-click="login.validate.close('password')">
										<span aria-hidden="true">×</span>
										<span class="sr-only">Close</span>
									</button>
									<strong>{_login.validate.password.msg_}</strong>
								</div>
							</div>
							<button type="button" class="btn btn-primary btn-lg hidden-xs" ng-click="login.doLogin()">Entrar</button>
							<button type="button" class="btn btn-primary btn-lg btn-block visible-xs" ng-click="login.doLogin()">Entrar</button>
							<a href="newPassword" style="display: block;">Esqueceu a senha?</a>
						</div>
					</div>
				</div>
			</div>
		</div>		
		<iframe  id="iframe" height="400px" width="100%" src="http://localhost:8080/fitnessproject/list" frameborder="1"></iframe>
	</div>
</body>
</html>