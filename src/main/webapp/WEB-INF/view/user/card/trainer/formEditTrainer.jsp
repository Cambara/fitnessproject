<div class="modal fade" id="modal_form_edit_trainer" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
        	<span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="myModalLabel">
        	Treino
        </h4>
      </div>
      <div class="modal-body">
       	<div class="form">
       		<div id="groupname" class="form-group">
				<label>Nome*:</label>
				<input id="name" class="form-control validate_form" ng-model="crud.params.name.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.name.show_error"
				ng-click="crud.close_msg_error('name')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.name.msg_error_}</strong></strong>
				</div>
			</div>
			
			<div id="groupname" class="form-group">
				<label>Descrição:</label>
				<textarea id="desc" class="form-control validate_form" ng-model="crud.params.desc.value" rows="5" ></textarea>
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.desc.show_error"
				ng-click="crud.close_msg_error('desc')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.name.msg_error_}</strong></strong>
				</div>
			</div>
			
       	</div>
      </div>
      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel">
        	Exercicios
	        <button class="btn btn-sm btn-default" ng-click="add_exercise()" title="adicionar Exercicio">
	        	<span class="glyphicon glyphicon-plus"></span>
	        </button>
        </h4>
      </div>
      <div class="modal-body">
      	<div class="row" ng-repeat="e in crud.params.exercises.value track by $index" id="execise_{_e.id_}">
      		<div class="row">
	      		<div class="col-xs-offset-1 col-xs-7">
	      			<span>
		      			<b>{_e.name_}</b>
	      			</span>
	      		</div>
	      		<div class="col-xs-4">
	      			<button class="btn btn-xs btn-primary" title="editar" ng-click="show_edit_menu_exercise(e)">
	      				<span class="glyphicon glyphicon-pencil"></span>
	      			</button>
	      			<button class="btn btn-xs btn-danger" title="remover" ng-click="remove_exercise(e)">
	      				<span class="glyphicon glyphicon-trash"></span>
	      			</button>
	      		</div>
      		</div>
      		<div class="row container_box_edit_exercise" ng-show="e.show_sub_menu">
      			<div class="col-xs-offset-1 col-xs-10">
      				<div class="row">
      					<div class="col-xs-12">
      						<div class="row">
      							<div class="col-xs-10">
      								<label>Nome:</label>	
      							</div>
      						</div>
      						<div class="row">
      							<div class="col-xs-8">
      								<input class="form-control validate_form" ng-model="e.name"/>
      							</div>
      						</div>
      					</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								<div class="col-xs-10">
									<label>
										<span>Repetição:</span>
										<span id="repeat_popup_{_$index_}" tabindex="0" class="glyphicon glyphicon-question-sign" 
										role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
										data-content="Adicione virgula para mais valores Ex: 10,10,10" 
										ng-click="crud.show_question_popup('repeat_popup_'+$index)" data-placement="top"></span>																				
									</label>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-8">
									<input class="form-control validate_form" ng-model="e.nRepeat" ng-list />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								<div class="col-xs-10">
									<label>
										<span>Serie:</span>
									</label>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-8">	
									<input class="form-control validate_form" ng-model="e.serie"/>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								<div class="col-xs-10">
									<label>
										<span>Carga: </span>
										<span id="weight_popup_{_$index_}" tabindex="0" class="glyphicon glyphicon-question-sign" 
										role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
										data-content="Adicione virgula para mais valores Ex: 10,10,10"
										ng-click="crud.show_question_popup('weight_popup_'+$index)" data-placement="top"></span>				
									</label>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-8" >
									<input class="form-control validate_form" ng-model="e.weight" ng-list />
								</div>
							</div>
						</div>
					</div>
					
      			</div>
      		</div>
      	</div>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Sair</button>
        <button type="button" class="btn btn-primary" ng-click="card_btn_save()">Enviar</button>
      </div>
    </div>
  </div>
</div>