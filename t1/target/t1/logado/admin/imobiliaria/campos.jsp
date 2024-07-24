<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${imobiliaria != null}">
                            <fmt:message key="agencies.update" />
                        </c:when>
			<c:otherwise>
                            <fmt:message key="agencies.create" />
                        </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${imobiliaria != null}">
		<input type="hidden" name="id" value="${imobiliaria.id}" />
	</c:if>
	<tr>
		<td><label for="email"><fmt:message key="user.email" /></label></td>
		<td><input type="text" id="email" name="email" size="45"
			required value="${imobiliaria.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="user.password" /></label></td>
		<td><input type="text" id="senha" name="senha" size="45" required
			value="${imobiliaria.senha}" /></td>
	</tr>
	<tr>
		<td><label for="cnpj"><fmt:message key="agency.cnpj" /></label></td>
		<td><input type="text" id="cnpj" name="cnpj" size="45" required
			value="${imobiliaria.cnpj}" /></td>
	</tr>
	<tr>
		<td><label for="nome"><fmt:message key="user.name" /></label></td>
		<td><input type="text" id="nome" name="nome" size="45" required
			value="${imobiliaria.nome}" /></td>
	</tr>
	<tr>
		<td><label for="descricao"><fmt:message key="agency.description" /></label></td>
		<td><input type="text" id="descricao" name="descricao" size="45" required
			value="${imobiliaria.descricao}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="<fmt:message key="save.link" />" /></td>
	</tr>
</table>