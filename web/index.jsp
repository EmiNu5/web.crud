<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crud</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-4">
            <h1>Contactos</h1>
            <div class="d-flex">

                <a class="btn btn-outline-primary" href="Controlador?accion=listar">Listar</a>
                <a class="btn btn-outline-primary ml-2" href="Controlador?accion=nuevo">Agregar nuevo</a>
            </div>
            <table class="table">
                <tr>
                    <th>
                        idPersona
                    </th>
                    <th>
                        nombre
                    </th>
                    <th>
                        apellido
                    </th>
                    <th>
                        correo
                    </th>
                    <th>
                        acciones
                    </th>
                </tr>
                <c:forEach var="persona" items="${Personas}">
                    <tr>
                        <td>
                            ${persona.idPersona}
                        </td>
                        <td>
                            ${persona.nombre}
                        </td>
                        <td>
                            ${persona.apellido}
                        </td>
                        <td>
                            ${persona.correo}
                        </td>
                        <td>
                            <a href="Controlador?accion=Editar&id=${persona.idPersona}" class="btn btn-outline-warning">Editar</a> 
                            <a href="Controlador?accion=Delete&id=${persona.idPersona}" class="btn btn-outline-danger">Eliminar</a> 
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
