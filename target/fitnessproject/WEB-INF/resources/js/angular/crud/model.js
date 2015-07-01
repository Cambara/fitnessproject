angular.module('CrudModel', ['Ajax']);
angular.module('CrudModel').factory('Crud', function(Request){
	
	var crud = {
		params:{},
		request:{put:'',delete:'',list:'',params:''}, 
		list:[] 
	};
	crud.validate = function() {
		var status = true;
		for(var param in crud.params){
			if(crud.params[param].required == true && 
					(crud.params[param].value == '' ||crud.params[param].value == null)){
				status = false;
				crud.params[param].msg_error = 'Campo vazio';
				crud.params[param].show_error = true;
			}
		}
		return status;
	};
	crud.put = function() {
		var params = {};
		for(var i in crud.params){
			params[crud.params[i].name]= crud.params[i].value;
		}
		Request.url = crud.request.put;
		Request.params = params;
		Request.post().then(function(data) {
			if(data.result == true){
				if(data.type == 'params'){
					for(var i in crud.params){
						crud.params[i].value = data.params[i];
					}
				}
				else if(data.type == 'update'){
					for(var i in crud.list){
						if(crud.list[i].id == data.card.id){
							crud.list[i] = data.card;
							break;
						}
					}
				}else{
					crud.list.push(data.card);
				}
			}else{
				alert('Ops tivemos um problema!');
			}
		},function(data) {
			alert('Ops tivemos um problema!');
		});
	};
	crud.delete = function(id) {
		Request.params =  id;
		Request.url = crud.request.delete;
		Request.post().then(function(data) {
			if(data.result == true){
				for(var i in crud.list){
					if(crud.list[i].id == id){
						crud.list.splice(i,1);
						break;
					}
				}
			}else{
				console.log('deu rum pra deletar o cara');
			}
		},function(data) {
			alert('Ops tivemos um problema!');
		});
	};
	crud.get_list = function(callback) {
		Request.url = crud.request.list;
		Request.get().then(function(data) {
			if(data.result == 200){
				crud.list = data.list;
				if(callback != undefined && callback != null && callback != ''){
					callback();
				}
			}else{
				alert('Ops tivemos um problema!');
			}
		},function(data) {
			alert('Ops tivemos um problema!');
		});
	};
	crud.get_params = function(callback) {
		Request.url = crud.request.params;
		Request.get().then(function(data) {
			for(var i in crud.params){
				crud.params[i].value = data[i];
			}
			
		},function(data) {
			alert('Ops tivemos um problema!');
		});
	};
	crud.clear_params = function() {
		for(var param in crud.params){
			crud.params[param].value = '';
			crud.params[param].show_error = false;
		}
	};
	crud.close_all_msg_error = function() {
		for(var param in crud.params){
			crud.params[param].msg_error = '';
			crud.params[param].show_error = false;
		}
	}
	crud.close_msg_error = function(param) {
		crud.params[param].show_error = false;
	};
	crud.show_question_popup = function(id) {
		$('#'+id).popover('show');
	}
	return crud;
});

