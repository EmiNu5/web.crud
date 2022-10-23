
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Controlador" method="POST">
            <div class="container mt-4">
                <div class="card border-info mb-3" style="max-width: 18rem;">
                    <div class="card-header">Agregar persona</div>
                    <div class="card-body texto-info">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" name="textNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Apellido</label>
                            <input type="text" name="textApellido" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="email" name="textCorreo" class="form-control">
                        </div>
                    </div>
                    <div class="card-footer">
                        <input type="submit" value="Agregar" name="accion" class="btn btn-outline-success">
                        <a href="Controlador?accion=listar" class="btn-link m1-2">Volver</a>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
