
angular.module('LoginModel', ['Ajax']);
angular.module('LoginModel').factory('Login', function(Request){
	var login = {
		
		email : '',
		password : '',
		type : 'USER',
		confirmPassword: '',
		name: '',
		validate:{
			email:{status:false,msg:''},password:{status:false,msg:''}
			,confirmPassword:{status:false,msg:''},name:{status:false,msg:''}
		}
	};
	login.save = function() {
		login.validate.reset();
		var data = {};
		
		data.email = login.email;
		data.password = login.password; 
		data.type = login.type;
		data.confirmPassword = login.confirmPassword;
		data.name = login.name;
		Request.url = '/fitnessproject/doSignup';
		Request.params = data;
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
	login.validate.formValidate = function() {
		var resp = true;
		if(login.name == undefined || login.name == ''){
			login.validate.name.status = true;
			login.validate.name.msg = 'Campo vazio';
			resp = false;
		}
		if(login.email == undefined || login.email == ''){
			login.validate.email.status = true;
			login.validate.email.msg = 'Campo vazio';
			resp = false;
		}
		if(login.password == undefined || login.password == ''){
			login.validate.password.status = true;
			login.validate.password.msg = 'Campo vazio';
			resp = false;
		}
		if(login.confirmPassword != login.password){
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
	return login;
});

