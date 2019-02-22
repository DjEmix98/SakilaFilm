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
<p>Nome attori:</p>
<c:forEach items="${listaAttori}" var="attore">
		<a href="film?idAttore=${attore.id}">Nome: ${attore.nome} Cognome: ${attore.cognome}</a><br>
	</c:forEach>
</body>
</html>