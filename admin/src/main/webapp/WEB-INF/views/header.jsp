<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit header</title>
</head>
<body>
	<c:forEach items="${headerParams}" var="par">
			<p><c:out value="${par.param}"></c:out>
				<input type="text" value="${par.value}"/>
                <input type="checkbox" id="isDisplay" checked/>
                <input type="button" value="update" onclick='location.href="${contextPath}/edit/header/saveParam?pParam=${par}"'/>
                <input type="button" value="delete" onclick='location.href="${contextPath}/edit/header/deleteParam?pId=${par.id}"'/>
               <!-- <form id="saveParamForm" method="post" action="${contextPath}/edit/header/saveParam?pParam=${par}"/>
                <input type="button" value="update" onclick="document.forms['saveParamForm'].submit()"/>
                <form id="deleteParamForm" method="post" action="${contextPath}/edit/header/deleteParam?pId=${par.id}"/>
                <input type="button" value="delete" onclick="document.forms['deleteParamForm'].submit()"/>-->
            </p>
	</c:forEach>
	
</body>
</html>