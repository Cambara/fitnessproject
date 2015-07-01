<div class="modal fade" id="modal_form_measures" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
        	<span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="myModalLabel">
        	Editar Medidas
        </h4>
      </div>
      <div class="modal-body">
       	<div class="form row" style="font-size:12px;">

	       		<div class="form-group col-xs-5 col-sm-3">
					<label>Peso*:</label>
					<input id="weigth" class="form-control validate_form width_input_measures" ng-model="crud.params.weigth.value">
					<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.weigth.show_error"
					ng-click="crud.close_msg_error('weigth')">
						<button type="button" class="close">
							<span aria-hidden="true">×</span>
							<span class="sr-only">Close</span>
						</button>
						<strong><strong>{_crud.params.weigth.msg_error_}</strong></strong>
					</div>
				</div>
			<div class="form-group col-xs-5 col-sm-3">
				<label>Altura*:</label>
				<input id="heigth" class="form-control validate_form width_input_measures" ng-model="crud.params.heigth.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.heigth.show_error"
				ng-click="crud.close_msg_error('heigth')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.heigth.msg_error_}</strong></strong>
				</div>
			</div>

			<div class="form-group col-xs-5 col-sm-3">
				<label>
					<span>Peito*:</span>
					<span id="popup_bust" tabindex="0" class="glyphicon glyphicon-question-sign" 
						role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
						data-content="Meça a circuferência do peito um pouco acima dos mamilos."
						ng-click="crud.show_question_popup('popup_bust')" data-placement="bottom"></span>		
				</label>
				<input id="bust" class="form-control validate_form width_input_measures" ng-model="crud.params.bust.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.bust.show_error"
				ng-click="crud.close_msg_error('bust')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.bust.msg_error_}</strong></strong>
				</div>
			</div>
			<div class="form-group col-xs-5 col-sm-3">
				<label>
					<span>
						Cintura*:
					</span>
					<span id="popup_waist" tabindex="0" class="glyphicon glyphicon-question-sign" 
						role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
						data-content="Meça a circuferência da cintura na altura do umbigo."
						ng-click="crud.show_question_popup('popup_waist')" data-placement="right"></span>
				</label>
				<input id="waist" class="form-control validate_form width_input_measures" ng-model="crud.params.waist.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.waist.show_error"
				ng-click="crud.close_msg_error('waist')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.waist.msg_error_}</strong></strong>
				</div>
			</div>
			<div class="form-group col-xs-5 col-sm-3">
				<label>
					<span>
						Costas*:
					</span>
					<span id="popup_back" tabindex="0" class="glyphicon glyphicon-question-sign" 
						role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
						data-content="Meça a largura das costas de ombro a ombro."
						ng-click="crud.show_question_popup('popup_back')" data-placement="bottom"></span>
				</label>
				<input id="back" class="form-control validate_form width_input_measures" ng-model="crud.params.back.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.back.show_error"
				ng-click="crud.close_msg_error('back')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.back.msg_error_}</strong></strong>
				</div>
			</div>
			<div class="form-group col-xs-5 col-sm-3">
				<label>
					<span>
						Quadril*:
					</span>
					<span id="popup_hip" tabindex="0" class="glyphicon glyphicon-question-sign" 
						role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
						data-content="Meça a circuferência ao redor dos quadris em seu ponto mais largo, logo acima da linha da virilha."
						ng-click="crud.show_question_popup('popup_hip')" data-placement="bottom"></span>
				</label>
				<input id="hip" class="form-control validate_form  width_input_measures" ng-model="crud.params.hip.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.hip.show_error"
				ng-click="crud.close_msg_error('hip')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.hip.msg_error_}</strong></strong>
				</div>
			</div>
			<div class="form-group col-xs-5 col-sm-3">
				<label>
					<span>
						Braço E.*:
					</span>
					<span id="popup_biceps_l" tabindex="0" class="glyphicon glyphicon-question-sign" 
						role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
						data-content="Meça a circuferência em torno da parte mais grossa do seu braço, geralmente no bíceps."
						ng-click="crud.show_question_popup('popup_biceps_l')" data-placement="bottom"></span>
				</label>
				<input id="biceps_l" class="form-control validate_form width_input_measures" ng-model="crud.params.biceps_l.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.biceps_l.show_error"
				ng-click="crud.close_msg_error('biceps_l')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.biceps_l.msg_error_}</strong></strong>
				</div>
			</div>
			<div class="form-group col-xs-5 col-sm-3">
				<label>
					<span>
						Braço D.*:
					</span>
					<span id="popup_biceps_r" tabindex="0" class="glyphicon glyphicon-question-sign" 
						role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
						data-content="Meça a circuferência em torno da parte mais grossa do seu braço, geralmente no bíceps."
						ng-click="crud.show_question_popup('popup_biceps_r')" data-placement="bottom"></span>
				</label>
				<input id="biceps_r" class="form-control validate_form width_input_measures" ng-model="crud.params.biceps_r.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.biceps_r.show_error"
				ng-click="crud.close_msg_error('biceps_r')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.biceps_r.msg_error_}</strong></strong>
				</div>
			</div>
			<div class="form-group col-xs-5 col-sm-3">
				<label>
					<span>
						Antebraço E.*:
					</span>
					<span id="popup_forearm_l" tabindex="0" class="glyphicon glyphicon-question-sign" 
						role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
						data-content="Meça a circuferência próximo ao cotovelo."
						ng-click="crud.show_question_popup('popup_forearm_l')" data-placement="bottom"></span>
				</label>
				<input id="forearm_l" class="form-control validate_form width_input_measures" ng-model="crud.params.forearm_l.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.forearm_l.show_error"
				ng-click="crud.close_msg_error('forearm_l')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.forearm_l.msg_error_}</strong></strong>
				</div>
			</div>
			<div class="form-group col-xs-5 col-sm-3">
				<label>
					<span>
						Antebraço D.*:
					</span>
					<span id="popup_forearm_r" tabindex="0" class="glyphicon glyphicon-question-sign" 
						role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
						data-content="Meça a circuferência próximo ao cotovelo."
						ng-click="crud.show_question_popup('popup_forearm_r')" data-placement="bottom"></span>
				</label>
				<input id="forearm_r" class="form-control validate_form width_input_measures" ng-model="crud.params.forearm_r.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.forearm_r.show_error"
				ng-click="crud.close_msg_error('forearm_r')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.forearm_r.msg_error_}</strong></strong>
				</div>
			</div>
			<div class="form-group col-xs-5 col-sm-3">
				<label>
					<span>
						Coxa E.*:
					</span>
					<span id="popup_leg_l" tabindex="0" class="glyphicon glyphicon-question-sign" 
						role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
						data-content="Meça a circuferência em torno de sua coxa em seu ponto mais largo."
						ng-click="crud.show_question_popup('popup_leg_l')" data-placement="bottom"></span>
				</label>
				<input id="leg_l" class="form-control validate_form width_input_measures" ng-model="crud.params.leg_l.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.leg_l.show_error"
				ng-click="crud.close_msg_error('leg_l')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.leg_l.msg_error_}</strong></strong>
				</div>
			</div>
			<div class="form-group col-xs-5 col-sm-3">
				<label>
					<span>
						Coxa D.*:
					</span>
					<span id="popup_leg_r" tabindex="0" class="glyphicon glyphicon-question-sign" 
						role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
						data-content="Meça a circuferência em torno de sua coxa em seu ponto mais largo."
						ng-click="crud.show_question_popup('popup_leg_r')" data-placement="bottom"></span>
				</label>
				<input id="leg_r" class="form-control validate_form width_input_measures" ng-model="crud.params.leg_r.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.leg_r.show_error"
				ng-click="crud.close_msg_error('leg_r')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.leg_r.msg_error_}</strong></strong>
				</div>
			</div>
			<div class="form-group col-xs-5 col-sm-3">
				<label>
					<span>
						Panturrilha E.*:
					</span>
					<span id="popup_calf_l" tabindex="0" class="glyphicon glyphicon-question-sign" 
						role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
						data-content="Meça a circuferência ao redor da panturrilha em seu ponto mais largo."
						ng-click="crud.show_question_popup('popup_calf_l')" data-placement="bottom"></span>
				</label>
				<input id="calf_l" class="form-control validate_form width_input_measures" ng-model="crud.params.calf_l.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.calf_l.show_error"
				ng-click="crud.close_msg_error('calf_l')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.calf_l.msg_error_}</strong></strong>
				</div>
			</div>
			<div class="form-group col-xs-5 col-sm-3">
				<label>
					<span>
						Panturrilha D.*:
					</span>
					<span id="popup_calf_r" tabindex="0" class="glyphicon glyphicon-question-sign" 
						role="button" data-toggle="popover" data-trigger="focus" title="Dica" 
						data-content="Meça a circuferência ao redor da panturrilha em seu ponto mais largo."
						ng-click="crud.show_question_popup('popup_calf_r')" data-placement="bottom"></span>
				</label>
				<input id="calf_r" class="form-control validate_form width_input_measures" ng-model="crud.params.calf_r.value">
				<div class="alert alert-danger fade in error_form_box" ng-show="crud.params.calf_r.show_error"
				ng-click="crud.close_msg_error('calf_r')">
					<button type="button" class="close">
						<span aria-hidden="true">×</span>
						<span class="sr-only">Close</span>
					</button>
					<strong><strong>{_crud.params.calf_r.msg_error_}</strong></strong>
				</div>
			</div>
			
			
       	</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Sair</button>
        <button type="button" class="btn btn-primary" ng-click="save_measures()">Enviar</button>
      </div>
    </div>
  </div>
</div>