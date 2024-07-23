<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">

<head>
<title><fmt:message key="page.title" /></title>
</head>
<body>
	<div align="center">
		<h1><fmt:message key="properties.welcome" /></h1>
		<h2>
			<a href="/${requestScope.contextPath}"><fmt:message key="main.link" /></a> &nbsp;&nbsp;&nbsp; 
			<a href="/${requestScope.contextPath}/imoveis/cadastro"><fmt:message key="properties.create" /></a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption><fmt:message key="properties.list" /></caption>
			<tr>
				<th><fmt:message key="property.agency" /></th>
				<th><fmt:message key="property.address" /></th>
				<th><fmt:message key="property.city" /></th>
				<th><fmt:message key="property.description" /></th>
				<th><fmt:message key="property.value" /></th>
				<%-- <th>Fotos</th> --%>
				<th><fmt:message key="actions.link" /></th>
			</tr>
			<c:forEach var="imovel" items="${requestScope.listaImoveis}">
				<tr>
					<td>${imovel.imobiliaria.nome}</td>
					<td>${imovel.endereco}</td>
					<td>${imovel.cidade}</td>
					<td>${imovel.descricao}</td>
					<td>${imovel.valor}</td>
					<%-- <td>${imovel.fotos}</td> --%>
					<td><a href="/${requestScope.contextPath}/imoveis/edicao?id=${imovel.id}"><fmt:message key="properties.update" /></a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/${requestScope.contextPath}/imoveis/remocao?id=${imovel.id}"
						onclick="return confirm('<fmt:message key="confirm.link" />');">
							<fmt:message key="properties.delete" /> </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</fmt:bundle>
</html>