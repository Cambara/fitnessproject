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
<body>
   	<sitemesh:write property="body" />
    <%@ include file="../footer.jsp" %>
</body>
</html>