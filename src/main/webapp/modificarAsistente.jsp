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
    <title>Modificar Asistente</title>
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>
<body>
<h1 class="encabezado">Modificar Asistente</h1>
<div class="centrado">
    <form action="modificarAsistente" method="post">
        <label for="id">ID del Asistente:</label>
        <input type="text" id="id" name="id"><br>
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre"><br>
        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido"><br>
        <label for="edad">Edad:</label>
        <input type="text" id="edad" name="edad"><br>
        <label for="rut">RUT:</label>
        <input type="text" id="rut" name="rut"><br>
        <input class="boton" type="submit" value="Modificar">
    </form>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
