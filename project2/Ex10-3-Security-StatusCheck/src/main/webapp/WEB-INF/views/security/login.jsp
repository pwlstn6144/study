<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<h1>login.jsp</h1>

<c:if test="${not empty pageContext.request.userPrincipal }">
	<p>is Log-In</p>
</c:if>

<c:if test="${empty pageContext.request.userPrincipal }">
	<p>is Log-Out</p>
</c:if>

USER ID : ${pageContext.request.userPrincipal.name } <br />
<a href="<c:url value="j_spring_security_logout" />"> Log out</a><br/>
</body>
</html>