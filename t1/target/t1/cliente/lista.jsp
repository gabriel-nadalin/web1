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
		<h1><fmt:message key="clients.welcome" /></h1>
		<h2>
			<a href="/${requestScope.contextPath}"><fmt:message key="main.link" /></a> &nbsp;&nbsp;&nbsp;
			<a href="/${requestScope.contextPath}/clientes/cadastro"><fmt:message key="clients.create" /></a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption><fmt:message key="clients.list" /></caption>
			<tr>
				<th><fmt:message key="user.email" /></th>
				<th><fmt:message key="user.password" /></th>
				<th><fmt:message key="client.cpf" /></th>
				<th><fmt:message key="user.name" /></th>
				<th><fmt:message key="client.phone" /></th>
				<th><fmt:message key="client.sex" /></th>
				<th><fmt:message key="client.birthdate" /></th>
				<th><fmt:message key="actions.link" /></th>
			</tr>
			<c:forEach var="cliente" items="${requestScope.listaClientes}">
				<tr>
					<td>${cliente.email}</td>
					<td>${cliente.senha}</td>
					<td>${cliente.cpf}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.telefone}</td>
					<td>${cliente.sexo}</td>
					<td>${cliente.dataNascimento}</td>
					<td><a href="/${requestScope.contextPath}/clientes/edicao?id=${cliente.id}"><fmt:message key="clients.update" /></a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/${requestScope.contextPath}/clientes/remocao?id=${cliente.id}"
						onclick="return confirm('<fmt:message key="confirm.link" />');">
							<fmt:message key="clients.delete" /> </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</fmt:bundle>
</html>