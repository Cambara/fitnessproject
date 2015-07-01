angular.module('UserModel', ['Ajax']);
angular.module('UserModel').factory('User', function(Request){
	
	var user = {
		form:{},
		info:{}
		}
	user.getInfo = function() {
		Request.url = "/fitnessproject/user/info";
		Request.post().then(function(data) {
			if(data.result == 200){
				user.info = data.info;
			}else{
				alert('Ops tivemos um problema!');
			}
		},function(data) {
			alert('Ops tivemos um problema!');
		});
	}
	return user;
	
});