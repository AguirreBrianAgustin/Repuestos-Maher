<%@page import="Entidad.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<title>Home</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
background-image: url("imagenes/3.jpg");
background-position:center;
}
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif;}
.w3-sidebar {
  z-index: 3;
  width: 250px;
  top: 43px;
  bottom: 0;
  height: inherit;
}
</style>
<body>
	<jsp:include page="Header.jsp"/>
	<jsp:include page="MenuLateral.jsp"/>
	<jsp:include page="Footer.jsp"/>
	
		<div style="position:absolute;right: 0; top: 100px; left: 400px; bottom: 0; right: 0;" class="container">

 
  
	<form method="post" action="ServletProveedores">
			<fieldset>
	<legend>Agregar Proveedor</legend>
  
  	<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text">Nombre:</label>
						</div>
						<input id="nombre" type="text" class="form-control" name="txtNombre"
							required pattern="^(?!\s*$).+">
						<div class="input-group-append">
							<button class="btn btn-outline-primary" type="button"
								data-toggle="collapse" data-target="#collapseMsjNombre"
								aria-expanded="false" aria-controls="collapseMsjNombre">?</button>
						</div>
					</div>
					
					<div class="collapse mb-3" id="collapseMsjNombre">
						<div class="card card-body">El nombre debe contener letras.</div>
					</div>
  
  
  <p>
  
  <div class="collapse mb-3" id="collapseMsjApellido">
						<div class="card card-body">El nombre debe contener letras.</div>
					</div>

					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text">Telefono:</label>
						</div>
						<input id="dni" type="text" class="form-control" name="txtTelefono"
							required pattern="^[0-9]*$">
						<div class="input-group-append">
							<button class="btn btn-outline-primary" type="button"
								data-toggle="collapse" data-target="#collapseMsjDNI"
								aria-expanded="false" aria-controls="collapseMsjDNI">?</button>
						</div>
					</div>

					<div class="collapse mb-3" id="collapseMsjDNI">
						<div class="card card-body">El telefono debe contener solo caracteres numericos.</div>
					</div>
  

  <br>
  <input type="submit" name="btnAceptar" value="Aceptar">
  </fieldset>
</form> 
<% 
	if(request.getAttribute("estadoProveedor")!=null)
	{
			if(((Boolean)request.getAttribute("estadoProveedor"))==true)
			{
				out.print("Se agrego el proveedor");
			}
			else
			{
				out.print("No se agrego el proveedor");
			}
	}
 %>
</div>
	
</body>
</html>