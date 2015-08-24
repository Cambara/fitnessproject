<div class="modal fade" id="modal_form_start_trainer" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
        	<span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="myModalLabel">
        	Treino - {_trainer.name_}
        </h4>
      </div>
      <div class="modal-body">
       	<table class="table table-condensed table-responsive">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Carga</th>
					<th>Rep</th>
					<th></th>
				</tr>
			</thead>
			<tbody class="table_start_trainer_font">
				<tr ng-repeat="e in trainer.exercises">
					<td class="table_start_trainer_td_name">{_ e.name _}  </td>
					<td>
						<span ng-repeat="w in e.weight">
							{_ w _} 
						</span>
					</td>
					<td>
						<span ng-if="e.nRepeat.length == 1">
							{_e.nRepeat[0]_}
						</span>
						<span ng-if="e.nRepeat.length == 2">
							{_e.nRepeat[0]_} a {_e.nRepeat[1]_} 
						</span>
						<span ng-if="e.nRepeat.length == 3">
							{_e.nRepeat[0]_} x {_e.nRepeat[1]_} x {_e.nRepeat[2]_} 
						</span>
						<span>
							- {_e.serie_} 
						</span>
					</td>
					<td>
						<button class="btn btn-xs btn-default" title="Descansar" ng-click="rest(e)">
							<img alt="" src="${pageContext.request.contextPath}/img/icon/rest_icon.png">
						</button>
<!-- 							<span>120</span> -->
					</td>
				</tr>
			</tbody>
		</table>
		<div class="row">
			<div class="col-xs-12">
				<div class="inline-block">
					<img alt="" src="${pageContext.request.contextPath}/img/icon/rest_icon.png"> 
				</div>
				<div class="inline-block">
					<span>- Descanso de {_ trainer.rest_begin _} - {_trainer.rest_end _} segundos.</span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="inline-block">
					<h5><b>Rep</b></h5> 
				</div>
				<div class="inline-block">
					<span>- Repetição</span>
				</div>
			</div>
		</div>
      </div>
    </div>
  </div>
</div>