app.controller("cardController",function($scope, $compile, Crud) {
	$scope.crud = Crud;
	$scope.crud.request.list = '/fitnessproject/user/card/list';
	$scope.crud.request.put = '/fitnessproject/user/card/put';
	$scope.crud.request.delete = '/fitnessproject/user/card/delete';
	$scope.crud.get_list();
	
	var params = {
			id:{value:'',required:false, name:'id'},
			name:{value:'', required:true, msg_error:'', show_error:false, name:'name'},
			date_begin:{value:'', required:true, msg_error:'', show_error:false, name:'dateBegin'},
			date_end:{value:'', required:true, msg_error:'', show_error:false,name:'dateEnd'},
	}
	$scope.crud.params = params;
	
	$scope.card_btn_remove = function(id) {
		var modal_delete = alert_delete('Deletar Série','Você tem certeza que deseja deletar?','card_remove('+id+')');
		var container = document.getElementById('card_controller');
		container.appendChild(modal_delete);
		$('#modal_alert_delete').on('hide.bs.modal', function () {
			document.getElementById('modal_alert_delete').remove();
		});
		$('#modal_alert_delete').modal('show');
		
	} 
	$scope.card_btn_add = function(){
		$('#modal_form_card').on('hide.bs.modal', function () {
			//limpar o parametros do crud
			$scope.crud.clear_params();
		});
		$('#modal_form_card').modal('show');
	}
	$scope.card_btn_update = function(id){
		//pegar a posição no objeto na lista
		for(var i in $scope.crud.list){
			if($scope.crud.list[i].id == id){
				var card = $scope.crud.list[i];
				$scope.crud.params.id.value = card.id;
				$scope.crud.params.name.value = card.name;
				$scope.crud.params.date_begin.value = card.date_begin;
				$scope.crud.params.date_end.value = card.date_end;
			}
		}
		
		$('#modal_form_card').on('hide.bs.modal', function () {
			//limpar o parametros do crud
			$scope.crud.clear_params();
		});
		$('#modal_form_card').modal('show');
	}
	$scope.card_btn_save = function(){
		$scope.crud.close_all_msg_error();
		if($scope.crud.validate()){
			if($scope.crud.params.date_begin.value >= $scope.crud.params.date_end.value ){
				$scope.crud.params.date_begin.msg_error  = 'Data inicial não pode ser maior que a final'; 
				$scope.crud.params.date_begin.show_error = true;
			}else{
				$scope.crud.put();
				$('#modal_form_card').modal('hide');
			}
			
			
		}
	}
});

function card_remove(id) {
	var container = document.getElementById('card_controller');
	angular.element(container).scope().crud.delete(id);
	$('#modal_alert_delete').modal('hide');
	document.getElementById('modal_alert_delete').remove();
}