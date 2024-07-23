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
		<h1><fmt:message key="agencies.welcome" /></h1>
		<h2>
			<a href="/${requestScope.contextPath}"><fmt:message key="main.link" /></a> &nbsp;&nbsp;&nbsp;
			<a href="/${requestScope.contextPath}/imobiliarias/cadastro"><fmt:message key="agencies.create" /></a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption><fmt:message key="agencies.list" /></caption>
			<tr>
                <th><fmt:message key="user.email" /></th>
                <th><fmt:message key="user.password" /></th>
                <th><fmt:message key="agency.cnpj" /></th>
                <th><fmt:message key="user.name" /></th>
                <th><fmt:message key="agency.description" /></th>
				<th><fmt:message key="actions.link" /></th>
			</tr>
			<c:forEach var="imobiliaria" items="${requestScope.listaImobiliarias}">
				<tr>
                    <td>${imobiliaria.email}</td>
                    <td>${imobiliaria.senha}</td>
                    <td>${imobiliaria.cnpj}</td>
                    <td>${imobiliaria.nome}</td>
                    <td>${imobiliaria.descricao}</td>
					<td><a href="/${requestScope.contextPath}/imobiliarias/edicao?id=${imobiliaria.id}"><fmt:message key="agencies.update" /></a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/${requestScope.contextPath}/imobiliarias/remocao?id=${imobiliaria.id}"
						onclick="return confirm('<fmt:message key="confirm.link" />');">
							<fmt:message key="agencies.delete" /> </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</fmt:bundle>
</html>