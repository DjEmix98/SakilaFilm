<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${lista}" var="film">
		<a href="attori?idFilm=${film.id}">${film.name}</a>
		<p>Descrizione: ${film.descrizione}</p>
		<p>anno: ${film.year}</p>
	</c:forEach>
</body>
</html>