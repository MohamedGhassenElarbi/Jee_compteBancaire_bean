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
<h1>Recherche Compte Bancaire</h1>
<form action="RechercheCompte" method="post">
<input type="text" name="idCompteR"/>
<input type="submit" value="Chercher"/>
</form>
<table>
<tr>
    <th>idCompte</th>
    <th>Solde</th> 
    <th>dateCreation</th>
    <th>Proprietaire</th>
  </tr>
  
  <tr>
    <td><c:out value="${compte.idCompte }"></c:out></td>
    <td><c:out value="${compte.solde }"></c:out></td>
    <td><c:out value="${compte.dateCreation }"></c:out></td>
    <td><c:out value="${compte.proprietaire }"></c:out></td>
  </tr>
 
</table>
<a href="Retrait?idCompte=${compte.idCompte }"><button>Retrait</button></a>
<a href="Virement?idCompte=${compte.idCompte }"><button>Virement</button></a>
<a href="SuppressionCompte?idCompte=${compte.idCompte }"><button>Supprimer</button></a>
</body>
</html>