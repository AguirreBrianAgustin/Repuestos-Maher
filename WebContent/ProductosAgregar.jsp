<%@page import="Entidad.Marcas"%>
<%@page import="Entidad.Proveedores"%>
<%@page import="Entidad.Categorias"%>
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
	
	
		<%
		List<Categorias> listaC = new ArrayList<Categorias>();
		if (request.getAttribute("listaCat") != null) {
			listaC = (List<Categorias>) request.getAttribute("listaCat");
		}
	    %>
	
		<%
		List<Marcas> listaM = new ArrayList<Marcas>();
		if (request.getAttribute("listaMarc") != null) {
			listaM = (List<Marcas>) request.getAttribute("listaMarc");
		}
		%>
		
		<%
		List<Proveedores> listaP = new ArrayList<Proveedores>();
		if (request.getAttribute("listaProv") != null) {
			listaP = (List<Proveedores>) request.getAttribute("listaProv");
		}
		%>
	

	<div style="position:absolute;right: 0; top: 40px; left: 400px; bottom: 0; right: 0;" class="container">
	
	<form method="post" action="ServletProductos">
	<fieldset>
	<legend>Agregar Producto</legend>
  <tr>
  <div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text">Nombre:</label>
						</div>
						<input id="nombre" type="text" class="form-control" name="nombreProducto"
							required pattern="^(?!\s*$).+" >
							<!-- "^(?!\s*$).+" -->
						<div class="input-group-append">
							<button class="btn btn-outline-primary" type="button"
								data-toggle="collapse" data-target="#collapseMsjNombre"
								aria-expanded="false" aria-controls="collapseMsjNombre">?</button>
						</div>
					</div>
					
					<div class="collapse mb-3" id="collapseMsjNombre">
						<div class="card card-body">El nombre debe contener letras.</div>
					</div>
					</tr>
  
  
   <tr>
  <div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text">Descripcion:</label>
						</div>
						<input id="nombre" type="text" class="form-control" name="descripcionProducto"
							required pattern="^(?!\s*$).+" >
							<!-- "^(?!\s*$).+" -->
						<div class="input-group-append">
							<button class="btn btn-outline-primary" type="button"
								data-toggle="collapse" data-target="#collapseMsjDescripcion"
								aria-expanded="false" aria-controls="collapseMsjDescripcion">?</button>
						</div>
					</div>
					
					<div class="collapse mb-3" id="collapseMsjDescripcion">
						<div class="card card-body">Descripcion debe contener letras.</div>
					</div>
					</tr>
					
					 <tr>
  <div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text">Precio:</label>
						</div>
						<input id="nombre" type="text" class="form-control" name="precioProducto"
							required pattern="^[0-9\.]*$">
							<!-- "^(?!\s*$).+" -->
						<div class="input-group-append">
							<button class="btn btn-outline-primary" type="button"
								data-toggle="collapse" data-target="#collapseMsjPrecio"
								aria-expanded="false" aria-controls="collapseMsjPrecio">?</button>
						</div>
					</div>
					
					<div class="collapse mb-3" id="collapseMsjPrecio">
						<div class="card card-body">El precio debe contener numeros.</div>
					</div>
					</tr>
					
					
					 <tr>
  <div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text">Stock:</label>
						</div>
						<input id="nombre" type="text" class="form-control" name="stockProducto"
							required pattern="^[0-9]*$">
							<!-- "^(?!\s*$).+" -->
						<div class="input-group-append">
							<button class="btn btn-outline-primary" type="button"
								data-toggle="collapse" data-target="#collapseMsjStock"
								aria-expanded="false" aria-controls="collapseMsjStock">?</button>
						</div>
					</div>
					
					<div class="collapse mb-3" id="collapseMsjStock">
						<div class="card card-body">Stock solo debe contener numeros.</div>
					</div>
					</tr>
					
  
						
					
  <p>
			<tr>
				<td><label>Modelo: </label></td>
				<td><select name=comboMar>
						<%
							for (Marcas m : listaM) {
						%>
						<option value="<%=m.getId()%>"><%=m.getNombre()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
  </p>
    <p>
			<tr>
				<td><label>Categoria: </label></td>
				<td><select name=comboCat>
						<%
							for (Categorias c : listaC) {
						%>
							<option value="<%=c.getId()%>"><%=c.getNombre()%></option>
						<%
						}
						%>
				</select></td>
			</tr>
  </p>
  <p>
			<tr>
				<td><label>Proveedor: </label></td>
				<td><select name=comboPro>
						<%
							for (Proveedores p : listaP) {
						%>
						<option value="<%=p.getIdProveedores()%>"><%=p.getNombre()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
  </p>

  </p>
  <p>
    <input type="submit" name="btnAceptar" value="Aceptar">
  </p>
  </fieldset>
</form>
<% 
	if(request.getAttribute("estadoRepuestos")!=null)
	{
			if(((Boolean)request.getAttribute("estadoRepuestos"))==true)
			{
				out.print("Se agrego el repuesto");
			}
			else
			{
				out.print("No se agrego el repuesto");
			}
	}
 %>

	</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>