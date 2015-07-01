app.controller("historicalTrainingController",function($scope, $compile, Crud,Calendar) {
	var init_calendar = function() {
		Calendar.init("#calendar","Treinos",$scope.crud.list);
	}
	$scope.crud = Crud;
	$scope.crud.request.list = '/fitnessproject/user/historical/training/list';
	$scope.crud.get_list(init_calendar);
	
	
});
app.controller("historicalMeasuresController",function($scope, Crud) {
	$scope.crud = Crud;
	$scope.crud.request.list = '/fitnessproject/user/historical/measures/list';
	$scope.crud.get_list();
	
	
});