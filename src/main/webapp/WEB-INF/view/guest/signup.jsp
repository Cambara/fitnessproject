<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro</title>
</head>
<body>
	<%@ include file="menuGuest.jsp" %>
	<div class="container" style="min-height: 80%;">
		<div class="row">
			<div class="col-sm-offset-1">
				<h1>Cadastre-se</h1>
				<div class="row">
					<div class="col-xs-offset-1 col-xs-10 col-sm-offset-1 col-sm-5 col-md-3">
						<form role="form" class="form_signup">
							<div class="form-group">
								<label>Nome*:</label>
								<input class="form-control">
							</div>
							<div class="form-group">
								<label>Email*:</label>
								<input class="form-control" type="email">
							</div>
							<div class="form-group">
								<label>Senha*:</label>
								<input class="form-control" type="password">
							</div>
							<div class="form-group">
								<label>Confirma Senha*:</label>
								<input class="form-control" type="password">
							</div>
							<div class="form-group">
								<label>Tipo*:</label>
								<select class="form-control">
									<option>Usuário</option>
									<option>Academia</option>
								</select>
							</div>
							<button type="button" class="btn btn-primary btn-lg hidden-xs">Cadastrar</button>
							<button type="button" class="btn btn-primary btn-lg btn-block visible-xs">Cadastrar</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>