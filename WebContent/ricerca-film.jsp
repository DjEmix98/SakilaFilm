<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action = "film">
<p>Seleziona categoria: <select name = "idCategoria">
<option value = "0">Tutte le categorie</option>
<c:forEach items = "${lista}" var = "categoria">
<option value = "${categoria.id}">${categoria.name}</option>
</c:forEach>
</select>
<p> Inserisci nome film: <input type = "text" name = "nomeFilm" value="${nomeAttore}"><br></p>
<input type="submit" value="Cerca film">
</form> 
</body>
</html>