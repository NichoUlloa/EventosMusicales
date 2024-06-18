<%--
  Created by IntelliJ IDEA.
  User: Nicho
  Date: 18-06-2024
  Time: 5:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Eliminar Asistente</title>
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>
<body>
<h1 class="encabezado">Eliminar Asistente</h1>
<div class="centrado">
    <form action="eliminarAsistente" method="post">
        <label for="id">ID del Asistente:</label>
        <input type="text" id="id" name="id"><br>
        <input class="boton" type="submit" value="Eliminar">
    </form>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
