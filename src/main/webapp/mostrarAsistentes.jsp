<%--
  Created by IntelliJ IDEA.
  User: Nicho
  Date: 18-06-2024
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
    <title>Mostrar Asistentes</title>
</head>
<body>
<h1 class="encabezado">Asistentes Registrados</h1>
<div class="centrado">
    <table>
        <tr>
            <th>ID Asistente</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Edad</th>
            <th>RUT</th>
        </tr>
        <c:forEach items="${asistentes}" var="asistente">
            <tr>
                <td><c:out value="${asistente.idAsistente}"></c:out></td>
                <td><c:out value="${asistente.nombreAsistente}"></c:out></td>
                <td><c:out value="${asistente.apellidoAsistente}"></c:out></td>
                <td><c:out value="${asistente.edadAsistente}"></c:out></td>
                <td><c:out value="${asistente.rutAsistente}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
