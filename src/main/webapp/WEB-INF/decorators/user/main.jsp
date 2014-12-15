<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/imports.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="common/css.jsp" %>
<%@ include file="common/js.jsp" %>
<sitemesh:write property="head" />
<link rel="shortcut icon" type="image/x-icon" href="img/icon/site_icon.png">
<title>
	<sitemesh:write property="title" />
</title>
</head>
<body ng-app="myApp" ng-controller="userInfoController">
	<%@ include file="menus/mainMenu.jsp" %>
	<div id="mainContainer" style="min-height: 80%;">
		<div id="mainSubMenu" class="col-sm-2 hidden-xs">
			<%@ include file="menus/sideMenu.jsp" %>
		</div>
		<div class="col-sm-9" style="background-color: #FFFFFF;">
			<div class="row">
				<div id="subContainer">
					<sitemesh:write property="body" />
				</div>
				
			</div>
		
		</div>
	</div>
   	<%@ include file="../footer.jsp" %>
   	<script type="text/javascript">
   		$('#mainSubMenu').css('height',$('#mainContainer').css('height'));
   		$('#subContainer').css('height',$('#mainContainer').css('height'));
   	</script>
    
</body>
</html>