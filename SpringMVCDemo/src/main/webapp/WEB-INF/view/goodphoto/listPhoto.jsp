<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看所有照片</title>
</head>
<body>

	<h1>查看所有照片</h1>
	<c:forEach var="onePhoto" items="${goodPhotoList}">
	<tr>
	<td>${onePhoto.photoName}</td>
	<td><img src="${contextRoot}/downloadImage/${onePhoto.id}" width="400" height= "400" alt=""></td>
	<td></td>
	<td></td>
	<td></td>
	</tr>
	
	</c:forEach>

</body>
</html>