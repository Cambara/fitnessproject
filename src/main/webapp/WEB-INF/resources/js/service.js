function get_parameters(){
  var header = window.location.href;
  var params = header.split("?")[1];
  var listParameter = params.split("&");
  var data = {};
  for(var i = 0; i < listParameter.length; i ++){
    var tempList = listParameter[i].split("="); 
    data[tempList[0]] = tempList[1];
  } 
  return data;
}
var exercise_convert_string_obj = function(exercise) {
	if(typeof exercise.weight == "string"){
		exercise.weight = JSON.parse(exercise.weight);
	}
	if(typeof exercise.nRepeat == "string"){
		exercise.nRepeat = JSON.parse(exercise.nRepeat);
	}
}
function alert_delete(header_title,body_msg, ng_ok) {
	
	var modal_fade = document.createElement('div');
	modal_fade.classList.add('modal');
	modal_fade.classList.add('fade');
	modal_fade.setAttribute('id','modal_alert_delete');
	modal_fade.setAttribute('tabindex','-1');
	modal_fade.setAttribute('role','dialog');
	modal_fade.setAttribute('aria-labelledby','myModalLabel');
	modal_fade.setAttribute('aria-hidden','true');
	
	

	var modal_dialog = document.createElement('div');
	modal_dialog.classList.add('modal-dialog');	
	var modal_content = document.createElement('div');
	modal_content.classList.add('modal-content');
	
	//header
	var modal_header = document.createElement('div');
	modal_header.classList.add('modal-header');
	
	var modal_header_close_btn = document.createElement('button');
	modal_header_close_btn.classList.add('close');
	modal_header_close_btn.setAttribute('aria-label','Fechar');
	var modal_close_btn_span = document.createElement('span');
	modal_close_btn_span.innerHTML = '&times;';
	modal_close_btn_span.setAttribute('aria-hidden','true');
	modal_close_btn_span.setAttribute('data-dismiss','modal');
	modal_header_close_btn.appendChild(modal_close_btn_span);
	
	var modal_header_title = document.createElement('h4');
	modal_header_title.classList.add('modal-title');
	modal_header_title.innerHTML = header_title;
	
	modal_header.appendChild(modal_header_close_btn);
	modal_header.appendChild(modal_header_title);
	//body
	var modal_body = document.createElement('div');
	modal_body.classList.add('modal-body');
	var modal_body_msg = document.createElement('div');
	modal_body_msg.innerHTML = body_msg;
	modal_body.appendChild(modal_body_msg);
	
	//footer
	var modal_footer = document.createElement('div');
	modal_footer.classList.add('modal-footer');
	var modal_footer_close_btn = document.createElement('button');
	modal_footer_close_btn.className = 'btn btn-default';
	modal_footer_close_btn.setAttribute('data-dismiss','modal');
	modal_footer_close_btn.innerHTML = 'Não';
	var modal_footer_ok_btn = document.createElement('button');
	modal_footer_ok_btn.className = 'btn btn-primary';
	modal_footer_ok_btn.innerHTML = 'Sim';
	modal_footer_ok_btn.setAttribute('onclick',ng_ok);
	modal_footer.appendChild(modal_footer_close_btn);
	modal_footer.appendChild(modal_footer_ok_btn);
	
	modal_content.appendChild(modal_header);
	modal_content.appendChild(modal_body);
	modal_content.appendChild(modal_footer);
	
	modal_dialog.appendChild(modal_content);
	modal_fade.appendChild(modal_dialog);
	
	return modal_fade;
}