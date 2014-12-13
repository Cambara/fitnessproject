
angular.module('LoginModel', ['Ajax']);
angular.module('LoginModel').factory('Login', function(Request){
	var login = {
		form:{
			email : '',
			password : '',
			type : 'USER',
			confirmPassword: '',
			name: ''
		},
		validate:{
			email:{status:false,msg:''},password:{status:false,msg:''}
			,confirmPassword:{status:false,msg:''},name:{status:false,msg:''}
		}
	};
	login.save = function() {
		login.validate.reset();
		Request.url = '/fitnessproject/doSignup';
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
	};
	login.doLogin = function() {
		login.validate.reset();
		Request.url = '/fitnessproject/doLogin';
		Request.params = login.form;
		if (login.validate.doLogin) {
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
	
	login.validate.formValidate = function() {
		var resp = true;
		if(login.form.name == undefined || login.form.name == ''){
			login.validate.name.status = true;
			login.validate.name.msg = 'Campo vazio';
			resp = false;
		}
		if(login.form.email == undefined || login.form.email == ''){
			login.validate.email.status = true;
			login.validate.email.msg = 'Campo vazio';
			resp = false;
		}
		if(login.form.password == undefined || login.form.password == ''){
			login.validate.password.status = true;
			login.validate.password.msg = 'Campo vazio';
			resp = false;
		}
		if(login.form.confirmPassword != login.form.password){
			login.validate.confirmPassword.status = true;
			login.validate.confirmPassword.msg = 'Senhas diferentes';
			resp = false;
		}
		return resp;
	}
	login.validate.doLogin = function() {
		var resp = true;
		if(login.form.email == undefined || login.form.email == ''){
			login.validate.name.status = true;
			login.validate.name.msg = 'Campo vazio';
			resp = false;
		}
		if(login.form.password == undefined || login.form.password == ''){
			login.validate.password.status = true;
			login.validate.password.msg = 'Campo vazio';
			resp = false;
		}
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
	return login;
});

