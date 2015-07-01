app.controller("measuresController",function($scope, Crud) {
	$scope.crud = Crud;
	$scope.crud.request.put = '/fitnessproject/user/measures/put';
	$scope.crud.request.params = '/fitnessproject/user/measures/get_measures';
	var params = {
			user:{value:'', required:false, msg_error:'', show_error:false, name:'user'},
			back:{value:'', required:true, msg_error:'', show_error:false, name:'back'},
			hip:{value:'', required:true, msg_error:'', show_error:false, name:'hip'},
			biceps_l:{value:'', required:true, msg_error:'', show_error:false, name:'bicepsL'},
			biceps_r:{value:'', required:true, msg_error:'', show_error:false, name:'bicepsR'},
			forearm_l:{value:'', required:true, msg_error:'', show_error:false, name:'forearmL'},
			forearm_r:{value:'', required:true, msg_error:'', show_error:false, name:'forearmR'},
			bust:{value:'', required:true, msg_error:'', show_error:false, name:'bust'},
			heigth:{value:'', required:true, msg_error:'', show_error:false, name:'heigth'},
			leg_l:{value:'', required:true, msg_error:'', show_error:false, name:'legL'},
			leg_r:{value:'', required:true, msg_error:'', show_error:false, name:'legR'},
			calf_l:{value:'', required:true, msg_error:'', show_error:false, name:'calfL'},
			calf_r:{value:'', required:true, msg_error:'', show_error:false, name:'calfR'},
			waist:{value:'', required:true, msg_error:'', show_error:false, name:'waist'},
			weigth:{value:'', required:true, msg_error:'', show_error:false, name:'weigth'},
	}
	$scope.crud.params = params;
	$scope.crud.get_params();
	
	$scope.save_measures = function() {
		$scope.crud.close_all_msg_error();
		if($scope.crud.validate()){
			$scope.crud.put();
			$('#modal_form_measures').modal('hide');
		}
	}
});