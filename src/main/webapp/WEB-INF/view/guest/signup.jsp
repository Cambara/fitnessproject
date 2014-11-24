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
						<form id="formSignup" role="form" class="form_signup" action="doSignup" method="post" onsubmit="return false">
							<div id="groupname" class="form-group">
								<label>Nome*:</label>
								<input id="name" class="form-control validate_form" name="name" value="${name}">
								
							</div>
							<div id="groupemail" class="form-group">
								<label>Email*:</label>
								<input id="email" class="form-control validate_form" type="email" name="email" value="${login.email}">
								
							</div>
							<div id="grouppassword" class="form-group">
								<label>Senha*:</label>
								<input id="password" class="form-control validate_form" type="password" name="password">
							</div>
							<div id="groupConfirmPassword" class="form-group">
								<label>Confirma Senha*:</label>
								<input id="confirmPassword" class="form-control" type="password" name="confirmPassword">
							</div>
							<div class="form-group">
								<label>Tipo*:</label>
								<select class="form-control" name="type">
									<option value="USER">Usuário</option>
									<option value="GYM">Academia</option>
								</select>
							</div>
							<button type="button" class="btn btn-primary btn-lg hidden-xs" onclick="doSignup();">Cadastrar</button>
							<button type="button" class="btn btn-primary btn-lg btn-block visible-xs" onclick="doSignup();" >Cadastrar</button>
						</form>
						<script type="text/javascript">
							function doSignup()
							{
								if(validatorSignup())
								{
									$('#formSignup').attr('onsubmit','true');
									$('#formSignup').submit();
								}
							}
							function validatorSignup()
							{
								var response = true;
								var div = '<div class="alert alert-danger fade in error_form_box" role="alert"><button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button><strong>Campo vazio</strong></div>';
								var divSenha = '<div class="alert alert-danger fade in error_form_box" role="alert"><button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button><strong>Senhas estão diferentes</strong></div>';
								var formInput = $('#formSignup').find('.validate_form');
								for(var i = 0; i < formInput.length; i++){
									var id = formInput[i].attributes.id.value;
									if($('#'+id).val()=="")
	 								{	
	 									var divError = $('#group'+id).find('.alert')
	 									var existError = divError.length == 1?true:false;
	 									if(!existError)
	 									{
	 										$('#group'+id).append(div);									
	 									}
	 									console.log('campo vazio');
	 									response = false;
										
	 								}else{
	 									var divError = $('#group'+id).find('.alert')
	 									var existError = divError.length == 1?true:false;
	 									if(existError)
	 									{									
	 										divError.alert('close');
	 									}
	 								}	
									
								}
								if($('#password').val() != $('#confirmPassword').val() && $('#password').val()!="")
								{	
									var divError = $('#groupConfirmPassword').find('.alert')
									var existError = divError.length == 1?true:false;
									if(!existError)
									{
										$('#groupConfirmPassword').append(divSenha);
									}
									console.log('senhas diferentes!');
									response = false;
								}else{
									var divError = $('#groupConfirmPassword').find('.alert')
									var existError = divError.length == 1?true:false;
									if(existError)
									{									
										divError.alert('close');
									}
								}
								
								return response;
							}
						</script>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>