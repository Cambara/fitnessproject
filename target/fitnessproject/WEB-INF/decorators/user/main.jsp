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
<link rel="shortcut icon" type="image/x-icon" href="/fitnessproject/img/icon/site_icon.png">
<title>
	<sitemesh:write property="title" />
</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<body ng-app="myApp" ng-controller="userInfoController">
	<%@ include file="menus/mainMenu.jsp" %>
	<div id="mainContainer" style="min-height: 80%;">
		<div id="mainSubMenu" class="col-sm-2 hidden-xs">
			<%@ include file="menus/sideMenu.jsp" %>
		</div>
		<div class="visible-xs col-xs-12">
			<%@ include file="menus/sideMenuMobile.jsp" %>
		</div>
		<div class="col-sm-9 col-xs-12" style="background-color: #FFFFFF;">
			<div >
				<div id="subContainer">
					<sitemesh:write property="body" />
				</div>
				
			</div>
		
		</div>
	</div>
   	<%@ include file="../footer.jsp" %>
    	<!-- <script type="text/javascript"> 
    		$('#mainSubMenu').css('min-height',$('#mainContainer').css('height'));
    		$('#subContainer').css('min-height',$('#mainContainer').css('height'));
    	</script> --> 
    
</body>
</html>