<div class="modal fade" id="modal_form_card" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
        	<span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="myModalLabel">
        	Série
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
				<label>Data Início*:</label>
				<input id="name" type="date" class="form-control validate_form" ng-model="crud.params.date_begin.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.date_begin.show_error"
				ng-click="crud.close_msg_error('date_begin')">
					<button type="button" class="close" >
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong>{_crud.params.date_begin.msg_error_}</strong>
				</div>
			</div>
			<div id="groupname" class="form-group">
				<label>Data Final*:</label>
				<input id="name" type="date" class="form-control validate_form" ng-model="crud.params.date_end.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.date_end.show_error"
				ng-click="crud.close_msg_error('date_end')">
					<button type="button" class="close" >
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong>{_crud.params.date_end.msg_error_}</strong>
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