app.controller("trainerController",function($scope, $compile, Crud,Request) {
	var exercises_convert_string_obj = function() {
		for(var i in $scope.crud.list){
			var exercises = $scope.crud.list[i].exercises;
			for(var j in exercises){
				exercise_convert_string_obj(exercises[j]);
			}
		}
	}
	var get_param = get_parameters(); 
	$scope.crud = Crud;
	$scope.crud.request.list = '/fitnessproject/user/card/trainer/list?id='+get_param.id;
	$scope.crud.request.put = '/fitnessproject/user/card/trainer/put';
	$scope.crud.request.delete = '/fitnessproject/user/card/trainer/delete';
	$scope.crud.get_list(exercises_convert_string_obj);
	$scope.trainer = {};
	var params = {
			id:{value:'',required:false, name:'id'},
			name:{value:'', required:true, msg_error:'', show_error:false, name:'name'},
			desc:{value:'', required:true, msg_error:'', show_error:false, name:'desc'},
			rest_begin:{value:'', required:true, msg_error:'', show_error:false,name:'restBegin'},
			rest_end:{value:'', required:true, msg_error:'', show_error:false,name:'restEnd'},
			card:{value:{id:''}, required:false,name:'card'},
			last_trainer:{value:'', required:false,name:'lastTrainer'},
			exercises:{value:null, required:false,name:'exercises'}

	}
	$scope.crud.params = params;
	$scope.trainer_btn_remove = function(id) {
		var modal_delete = alert_delete('Deletar Treino','Você tem certeza que deseja deletar?','trainer_remove('+id+')');
		var container = document.getElementById('trainer_controller');
		container.appendChild(modal_delete);
		$('#modal_alert_delete').on('hide.bs.modal', function () {
			document.getElementById('modal_alert_delete').remove();
		});
		$('#modal_alert_delete').modal('show');
		
	} 
	$scope.trainer_btn_add = function() {
		$scope.crud.params.card.value = {id : get_param.id};
		$scope.crud.params.last_trainer.value = null;
		$scope.crud.params.exercises.value = [];
		$('#modal_form_edit_trainer').on('hide.bs.modal', function () {
			//limpar o parametros do crud
			$scope.crud.clear_params();
		});
		$('#modal_form_edit_trainer').modal('show');
	}
	
	$scope.trainer_btn_update = function(id){
		//pegar a posição no objeto na lista
		for(var i in $scope.crud.list){
			if($scope.crud.list[i].id == id){
				var trainer_card = $scope.crud.list[i];
				$scope.crud.params.id.value = trainer_card.id;
				$scope.crud.params.name.value = trainer_card.name;
				$scope.crud.params.desc.value = trainer_card.desc;
				$scope.crud.params.card.value = trainer_card.card;
				$scope.crud.params.last_trainer.value = trainer_card.last_trainer;
				$scope.crud.params.rest_begin.value = trainer_card.rest_begin;
				$scope.crud.params.rest_end.value = trainer_card.rest_end;
				$scope.crud.params.exercises.value = trainer_card.exercises;
			}
		}
		
		$('#modal_form_edit_trainer').on('hide.bs.modal', function () {
			//limpar o parametros do crud
			$scope.crud.clear_params();
		});
		$('#modal_form_edit_trainer').modal('show');
	}
	
	$scope.card_btn_save = function(){
		$scope.crud.close_all_msg_error();
		
		if($scope.crud.validate()){
			$scope.crud.put();
			$('#modal_form_edit_trainer').modal('hide');
		
			
			
		}
	}
	$scope.add_exercise = function() {
		var exercises = $scope.crud.params.exercises.value;
		var exercise = {id:'',name:'',weight:0,nRepeat:0, show_sub_menu:true};
		exercises.push(exercise);
	}
	$scope.remove_exercise = function(exercise) {
		var exercises = $scope.crud.params.exercises.value;
		for(var i in exercises){
			if(exercise.$$hashKey == exercises[i].$$hashKey){
				exercises.splice(i,1);
				break;
			}
		}
	}
	$scope.show_edit_menu_exercise = function(exercise) {
		if(exercise.show_sub_menu == true){
			exercise.show_sub_menu = false;
		}else{
			exercise.show_sub_menu = true;			
		}
	}
	$scope.start_trainer = function(trainer) {
		if(trainer.id != $scope.trainer.id){
			for(i in trainer.exercises){
				exercise_convert_string_obj(trainer.exercises[i]);				
			}
			$scope.trainer = convert_params_to_trainer_obj(trainer);
			
		}
		$('#modal_form_start_trainer').modal('show');
	}
	var convert_params_to_trainer_obj = function(trainer) {
		var t = {};
		t.id = trainer.id;
		t.name = trainer.name;
		t.rest_begin = trainer.rest_begin;
		t.rest_end = trainer.rest_end;
		t.exercises = [];
		for(i in trainer.exercises){
			var exercise = new Object();
			exercise.id = trainer.exercises[i].id;
			exercise.name = trainer.exercises[i].name;
			exercise.weight = trainer.exercises[i].weight;
			exercise.nRepeat = trainer.exercises[i].nRepeat;
			exercise.serie = trainer.exercises[i].serie;
			t.exercises.push(exercise);
		}
		return t;
	}
	$scope.rest = function(exercise) {
		if(exercise.serie > 1){		
			exercise.serie -= 1;
		}else{
			for(var i in $scope.trainer.exercises){
				if($scope.trainer.exercises[i].id == exercise.id){
					$scope.trainer.exercises.splice(i,1);
					if($scope.trainer.exercises.length == 0){
						finished_trainer();
					}
					break;
				}
			}
			
		}
		
	}
	var finished_trainer = function() {
		for(var i in $scope.crud.list){
			if($scope.crud.list[i].id == $scope.trainer.id){
				$('#modal_form_start_trainer').modal('hide');
				//criar uma mascara de loading
				Request.url = '/fitnessproject/user/card/trainer/finishedTrainer';
				Request.params = $scope.crud.list[i];
				Request.post().then(function(data) {
					if(data.result == true){
						//aparecer um popup avisando que terminou o treino =)
						for(var i in $scope.crud.list){
							if($scope.crud.list[i].id == data.card.id){
								$scope.crud.list[i] = data.card;
								for(var j in $scope.crud.list[i].exercises){
									exercise_convert_string_obj($scope.crud.list[i].exercises[j]);
								}
								break;
							}
						}
					}else{
						alert('Ops tivemos um problema!');
					}
				},function(data) {
					alert('Ops tivemos um problema!');
				});
				break;
			}
		}
	}
	
});
app.controller("fastTrainerController",function($scope, Crud,Request) {
	var params = {
			id:{value:'',required:false, name:'id'},
			name:{value:'', required:true, msg_error:'', show_error:false, name:'name'},
			desc:{value:'', required:true, msg_error:'', show_error:false, name:'desc'},
			card:{value:{id:''}, required:false,name:'card'},
			last_trainer:{value:'', required:false,name:'lastTrainer'},
			rest_begin:{value:'', required:false,name:'restBegin'},
			rest_end:{value:'', required:false,name:'restEnd'},
			exercises:{value:null, required:false,name:'exercises'}

	};
	$scope.crud = Crud;
	$scope.crud.request.params = '/fitnessproject/user/card/trainer/next_trainer';
	$scope.crud.params = params;
	$scope.crud.get_params();
	$scope.trainer = {};
	$scope.start_trainer = function() {
		var trainer = $scope.crud.params;
		if(trainer.id.value != $scope.trainer.id){
			for(i in trainer.exercises.value){
				exercise_convert_string_obj(trainer.exercises.value[i]);				
			}
			$scope.trainer = convert_params_to_trainer_obj(trainer);
			
		}
		$('#modal_form_start_trainer').modal('show');
	}
	$scope.rest = function(exercise) {
		if(exercise.serie > 1){		
			exercise.serie -= 1;
		}else{
			for(var i in $scope.trainer.exercises){
				if($scope.trainer.exercises[i].id == exercise.id){
					$scope.trainer.exercises.splice(i,1);
					if($scope.trainer.exercises.length == 0){
						finished_trainer();
					}
					break;
				}
			}
			
		}
		
	}
	var convert_params_to_trainer_obj = function(trainer) {
		var t = {};
		t.id = trainer.id.value;
		t.name = trainer.name.value;
		t.desc = trainer.desc.value;
		t.card = trainer.card.value;
		t.rest_begin = trainer.rest_begin.value;
		t.rest_end = trainer.rest_end.value;
		t.exercises = [];
		for(i in trainer.exercises.value){
			var exercise = new Object();
			exercise.id = trainer.exercises.value[i].id;
			exercise.name = trainer.exercises.value[i].name;
			exercise.weight = trainer.exercises.value[i].weight;
			exercise.nRepeat = trainer.exercises.value[i].nRepeat;
			exercise.serie = trainer.exercises.value[i].serie;
			t.exercises.push(exercise);
		}
		return t;
	}
	var finished_trainer = function() {
		$('#modal_form_start_trainer').modal('hide');
		Request.url = '/fitnessproject/user/card/trainer/finishedTrainer';
		Request.params = convert_params_to_trainer_obj($scope.crud.params);
		Request.post().then(function(data) {
			alert('Treino Finalizado!');
			location.reload();
		},function(data) {
			location.reload();
		});

		
	}
	
	
	
});

function trainer_remove(id) {
	var container = document.getElementById('trainer_controller');
	angular.element(container).scope().crud.delete(id);
	$('#modal_alert_delete').modal('hide');
	document.getElementById('modal_alert_delete').remove();
}

function add_box_edit_exercise() {
		
	var container = document.createElement('div');
	container.classList.add('container_box_edit_exercise');
	col.appendChild(container);
	var col = document.createElement('div');
	col.classList.add('col-xs-12');
	
	var box_edit_exercise = document.createElement('div');
	box_edit_exercise.appendChild(col);
	
	box_edit_exercise.classList.add('row');
	return box_edit_exercise;
	
	
	
}




