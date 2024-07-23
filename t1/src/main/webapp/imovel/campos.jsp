<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${imovel != null}">
                            <fmt:message key="properties.update" />
                        </c:when>
			<c:otherwise>
                            <fmt:message key="properties.create" />
                        </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${imovel != null}">
		<input type="hidden" name="id" value="${imovel.id}" />
	</c:if>
	<tr>
		<td><label for="imobiliaria"><fmt:message key="property.agency" /></label></td>
		<td><select id="imobiliaria" name="imobiliaria">
				<c:forEach items="${imobiliarias}" var="imobiliaria">
					<option value="${imobiliaria.key}"
						${imovel.imobiliaria.nome==imobiliaria.value ? 'selected' : '' }>
						${imobiliaria.value}</option>
				</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td><label for="endereco"><fmt:message key="property.address" /></label></td>
		<td><input type="text" id="endereco" name="endereco" size="45"
			required value="${imovel.endereco}" /></td>
	</tr>
	<tr>
		<td><label for="cidade"><fmt:message key="property.city" /></label></td>
		<td><input type="text" id="cidade" name="cidade" size="45" required
			value="${imovel.cidade}" /></td>
	</tr>
	<tr>
		<td><label for="descricao"><fmt:message key="property.description" /></label></td>
		<td><input type="text" id="descricao" name="descricao" size="45" required
			value="${imovel.descricao}" /></td>
	</tr>
	<tr>
		<td><label for="valor"><fmt:message key="property.value" /></label></td>
		<td><input type="number" id="valor" name="valor" required
			min="0.01" step="any" size="25" value="${imovel.valor}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="<fmt:message key="save.link" />" /></td>
	</tr>
</table>