<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${cliente != null}">
                            <fmt:message key="clients.update" />
                        </c:when>
			<c:otherwise>
                            <fmt:message key="clients.create" />
                        </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${cliente != null}">
		<input type="hidden" name="id" value="${cliente.id}" />
	</c:if>
	<tr>
		<td><label for="email"><fmt:message key="user.email" /></label></td>
		<td><input type="text" id="email" name="email" size="45"
			required value="${cliente.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="user.password" /></label></td>
		<td><input type="text" id="senha" name="senha" size="45" required
			value="${cliente.senha}" /></td>
	</tr>
	<tr>
		<td><label for="cpf"><fmt:message key="client.cpf" /></label></td>
		<td><input type="text" id="cpf" name="cpf" size="45" required
			value="${cliente.cpf}" /></td>
	</tr>
	<tr>
		<td><label for="nome"><fmt:message key="user.name" /></label></td>
		<td><input type="text" id="nome" name="nome" required
			size="45" value="${cliente.nome}" /></td>
	</tr>
	<tr>
		<td><label for="telefone"><fmt:message key="client.phone" /></label></td>
		<td><input type="text" id="telefone" name="telefone" required
			size="45" value="${cliente.telefone}" /></td>
	</tr>
	<tr>
		<td><label for="sexo"><fmt:message key="client.sex" /></label></td>
		<td><input type="text" id="sexo" name="sexo" required
			size="45" value="${cliente.sexo}" /></td>
	</tr>
	<tr>
		<td><label for="data_nascimento"><fmt:message key="client.birthdate" /></label></td>
		<td><input type="text" id="data_nascimento" name="data_nascimento" required
			size="45" value="${cliente.dataNascimento}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="<fmt:message key="save.link" />" /></td>
	</tr>
</table>