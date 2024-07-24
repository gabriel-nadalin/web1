<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<fmt:bundle basename="message">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu do Sistema</title>
    </head>
    <body>
        <h1>Página do Administrador</h1>
        <p>Olá ${sessionScope.usuarioLogado.nome}</p>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/logout.jsp">Sair</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/clientes"><fmt:message key="clients.entity" /></a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/imobiliarias"><fmt:message key="agencies.entity" /></a>
            </li>
        </ul>
    </body>
</fmt:bundle>
</html>