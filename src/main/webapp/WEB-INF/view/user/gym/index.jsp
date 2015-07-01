<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Academia</title>
</head>
<body>
	<div style="margin-left: 10%;" ng-controller="measuresController"> 
		<div class="row">
			<h1 class="title_subsession_user col-sm-offset-1 col-xs-offset-3"><span>Academia</span></h1>
		</div>
		<div class="row">
			<a href="/fitnessproject/user/gym/nearby_gyms" class="col-md-4 col-sm-5 col-sm-offset-1 col-xs-7 col-xs-offset-3 card card_add" 
			title="Academias próximas"style="text-decoration:none">
				<img class="card_img"alt="Academia próximas" src="${pageContext.request.contextPath}/img/icon/location_icon.png">
				<h5 class="card_text">Academias próximas</h5>
			
			</a>			
		</div>
	</div>
	
</body>
</html>