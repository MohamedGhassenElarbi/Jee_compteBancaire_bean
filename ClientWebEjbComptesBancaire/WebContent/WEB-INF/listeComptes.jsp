<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
    <th>idCompte</th>
    <th>Solde</th> 
    <th>dateCreation</th>
    <th>Proprietaire</th>
  </tr>
  <c:forEach var="parametre" items="${comptes }">
  <tr>
    <td><c:out value="${parametre.idCompte }"></c:out></td>
    <td><c:out value="${parametre.solde }"></c:out></td>
    <td><c:out value="${parametre.dateCreation }"></c:out></td>
    <td><c:out value="${parametre.proprietaire }"></c:out></td>
  </tr>
  </c:forEach>
</table>
</body>
</html>