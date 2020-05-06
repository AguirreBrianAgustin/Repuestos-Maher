<%@page import="Entidad.Repuestos"%>
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

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #000000;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color:#1a53ff;
}
tr {
  background-color:#1a53ff;
}
</style>
<body>
<jsp:include page="Header.jsp"/>

<jsp:include page="Footer.jsp"/>
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
<div >
<h2>Lista de productos</h2>

<div id="contenedor">
<table class="table table-striped table-dark">
  <tr>
   
    <th>Nombre</th>
    <th>Descripcion</th>
    <th>Precio</th>
    <th>Stock</th>
    <th>Estado</th>
    <th size="10">Modelo</th>
    <th>Categoria</th>
    <th>Proveedor</th>
     <th>Actualizar</th>
  </tr>  
  <%
List<Repuestos> listaR = new ArrayList<Repuestos>();
if (request.getAttribute("listaRep") != null) {
listaR = (List<Repuestos>) request.getAttribute("listaRep");
}
%>
<h2>Lista de Repuestoss</h2>
<%
for(Repuestos r : listaR)
{
%>
<form method="post" action="ServletProductos?Param=<%=r.getId()%>">
<tr>

<td><input type="text" name="Nombretxt" size="2" value="<%=r.getNombre()%>" required pattern="^(?!\s*$).+" ></td>
<td><input type="text" name="Descripciontxt" size="2" value="<%=r.getDescripcion()%>"  required pattern="^(?!\s*$).+"></td>
<td><input type="text" name="Precioetxt" size="2" value="<%=r.getPrecio()%>" required pattern="^[0-9\.]*$"></td>
<td><input type="text" name="Stocktxt" size="2" value="<%=r.getStock()%>" required pattern="^[0-9]*$"></td>
<td>
			<%
			
			int numEntero2 = Integer.parseInt(r.getEstado());
			if(numEntero2==1){
				%><select name="estado">
				<option value="1">Activo</option>
				<option value="0">Inactivo</option>
			
			</select> <% 
			
			} 
			else if(numEntero2==0){
				
				%><select name="estado">
				<option value="0">Inactivo</option>
				<option value="1">Activo</option>
			
			</select> <% 
				
			}%>
			</td>


<td><select name=comboMar>
<option value="<%=r.getMarca().getId()%>"><%=r.getMarca().getNombre()%></option>

<%
int rr=r.getMarca().getId();
for (Marcas m : listaM) {
%>
<%if(rr != m.getId() ) {%>

<%
}}
%>
</select></td>

  </p>

 <p>


<td><select name=comboCat>
<option value="<%=r.getCategoria().getId()%>"><%=r.getCategoria().getNombre()%></option>

<%
int rc=r.getCategoria().getId();
for (Categorias m : listaC) {
%>
<%if(rc != m.getId() ) {%>

<%
}}
%>
</select></td>

  </p>






 <p>


<td><select name=comboPro>
<option value="<%=r.getProveedor().getIdProveedores()%>"><%=r.getProveedor().getNombre()%></option>

<%
int rp=r.getProveedor().getIdProveedores();
for (Proveedores m : listaP) {
%>
<%if(rc != m.getIdProveedores() ) {%>
<option value="<%=m.getIdProveedores()%>"><%=m.getNombre()%></option>
<%
}}
%>
</select></td>

  </p>


<td> <input type="submit" name="btnModificarProductos" size="2" value="Modificar"> </td>
</tr>

</form>
<%
}
%>



 

</table>
</div>

<input type="submit" name="btnEliminar2" value="<<" onClick="location.href='ServletProductos?Param=Modificar&pag=prev'" style="position:relative; top:60%; left:40% ; transform:translate(-50%,-50%)";>
<button style="position:relative; top:60%; left:42% ; transform:translate(-50%,-50%)"><%= request.getAttribute("pagina") %></button> 
<input type="submit" name="adelantar" value=">>" onClick="location.href='ServletProductos?Param=Modificar&pag=next'" style="position:relative; top:60%; left:45% ; transform:translate(-50%,-50%)">
		
</div>
<br><br><br><br><br>
<% 
	if(request.getAttribute("estadoproducto")!=null)
	{
			if(((Boolean)request.getAttribute("estadoproducto"))==true)
			{
				%>
				<h2 style="position: absolute; top:85%; left:35%" >Actualizacion correcta</h2>
				<%
				
			}
			else
			{
%>               <h2 style="position: absolute; top:85%; left:35%" >Actualizacion incorrecta</h2>
			
				<%
				
			}
	}
 %>
</body>
</html>