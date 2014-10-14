<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<%@ include file="menuGuest.jsp" %>
	<div class="container" style="min-height: 80%;">
		<div class="row">
			<div class="col-sm-offset-1">
				<h1>Login</h1>
				<div class="row">
					<div class="col-xs-offset-1 col-xs-10 col-sm-offset-1 col-sm-5 col-md-3">
						<form action="doLogin" role="form" class="form_signup" method="post">
							<div class="form-group">
								<label>Email:</label>
								<input class="form-control" type="email">
							</div>	
							<div class="form-group">
								<label>Senha:</label>
								<input class="form-control" type="password">
							</div>
							<button type="button" class="btn btn-primary btn-lg hidden-xs">Entrar</button>
							<button type="button" class="btn btn-primary btn-lg btn-block visible-xs">Entrar</button>
							<a href="newPassword" style="display: block;">Esqueceu a senha?</a>
						</form>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>