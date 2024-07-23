<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<fmt:bundle basename="message">

<head>
<title><fmt:message key="page.title" /></title>
</head>
    <body>
        <div align="center">
            <h1><fmt:message key="page.title" /></h1>
            <%-- <h2>Catálogo de Imóveis</h2> --%>
        </div>
        <a href="imoveis"><fmt:message key="properties.entity" /></a>
        <a href="clientes"><fmt:message key="clients.entity" /></a>
        <a href="imobiliarias"><fmt:message key="agencies.entity" /></a>
    </body>
</fmt:bundle>
</html>