<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina Maestra!</h1>
        <ul>
            <li>
                <a href="<s:url action='nosotros'/>">Nosotros</a>
                <a href="<s:url action='portafolio'/>">Portafolio</a>
                <a href="<s:url action='contacto'/>">Contacto</a>
            </li>
        </ul>
        <div>
            Bienvenido a nuestra pagina
        </div>
    </body>
</html>
