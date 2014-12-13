
angular.module('LoginModel', ['Ajax']);
angular.module('LoginModel').factory('Login', function(Request){
	
	var login = {
		form:{},
		validate:{}
	};
	login.save = function() {
		Request.url = '/fitnessproject/doSignup';
		post();
	};
	login.doLogin = function() {
		Request.url = '/fitnessproject/doLogin';
		post();
	}
	
	login.validate.formValidate = function() {
		var resp = true;
		for ( var param in login.form) {
			if(login.form[param] == undefined || login.form[param] == ''){
				login.validate[param] = new Validate();
				login.validate[param].status = true;
				login.validate[param].msg = 'Campo vazio';
				resp = false;
			}
		}
		if(login.form.confirmPassword != undefined && login.form.confirmPassword != login.form.password){
			login.validate.confirmPassword = new Validate();
			login.validate.confirmPassword.status = true;
			login.validate.confirmPassword.msg = 'Senhas diferentes';
			resp = false;
		}
		return resp;
	}
		
	login.validate.close = function(name) {
		login.validate[name].status = false;
	}
	login.validate.reset = function() {
		for ( var validate in login.validate) {
			login.validate[validate].status = false;
			login.validate[validate].msg = '';
		}
	}
	login.validate.errorServidor = function(errors) {
		for ( var error in errors) {
			login.validate[error].status = true;
			login.validate[error].msg = errors[error];
		}
	}
	var post = function() {
		login.validate.reset();
		Request.params = login.form;
		if(login.validate.formValidate()){
			Request.post().then(function(data) {
				if(data.result == 200){
					window.location = data.location;
				}else{
					login.validate.errorServidor(data.errors);
				}
			},function(data) {
				alert('Ops tivemos um problema!');
				login.validate.errorServidor(data.errors);
			});
		}
	}
	return login;
});

