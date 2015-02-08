<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	
	<div class="row" style="margin-bottom:30px">
		<div class="col-xs-offset-1 col-xs-10">
			<a href="#" title="Menu" ng-click="button.menu.open_close()">
				<img src="${pageContext.request.contextPath}/img/icon/menu_icon.png">
			</a>
		</div>
	</div>
	<div ng-show="button.menu.status">
		<div class="mask_side_menu_mobile" ng-click="button.menu.open_close()"></div>
		<div class="side_menu_mobile">
			<div class="row" style="margin-bottom:30px">
				<div class="col-xs-offset-1 col-xs-10">
					<a href="#" title="Menu" ng-click="button.menu.open_close()">
						<img src="${pageContext.request.contextPath}/img/icon/menu_icon.png">
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-offset-1 col-xs-10">
					<label>{_user.info.name_}</label>
				</div>
			</div>
			<div class="row">
				<div class="section_menu_mobile col-xs-offset-1 col-xs-10">
					{_user.info.email_}
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-offset-1 col-xs-10">
					Serie
				</div>
			</div>
			<div class="row">
				<div class="col-xs-offset-1 col-xs-10">
					Medidas
				</div>
			</div>
			<div class="row">
				<div class="section_menu_mobile col-xs-offset-1 col-xs-10">
					Academia
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>