<%@page import="Entidad.Repuestos"%>
<%@page import="java.util.List"%>
<%@page import="Entidad.Clientes"%>
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
</style>
<body>
	<jsp:include page="Header.jsp"/>
	<jsp:include page="MenuLateral.jsp"/>
	<jsp:include page="Footer.jsp"/>
	<div style="position:absolute;right: 0; top: 40px; left: 250px; bottom: 0; right: 0;" class="container">
	<h1  class="text-primary">Carro de compras</h1>

<div id="contenedor">
<table class="table table-striped table-dark">
  <tr>
  <th>*</th>
    <th>IDregistro</th>
    <th>Nombre</th>
    <th>Precio</th>
    <th>cantidad</th>
    <th>Eliminar</th>
  </tr>  
  	<%
  	
	List<Clientes> listaA = new ArrayList<Clientes>();
	if (request.getAttribute("ClieUno") != null) {
		listaA = (List<Clientes>) request.getAttribute("ClieUno");
	}

  	String resultado="";
  	
  	
	ArrayList<Repuestos> lProducto = new ArrayList<Repuestos>();
	
	if(session.getAttribute("Session_carro")!=null)	{
		HttpSession obj_session = request.getSession();
		lProducto = (ArrayList<Repuestos>)obj_session.getAttribute("Session_carro");
		int i=0;
		float total=0;
		int cant=0;
	%>
		<h3 class="text-info">Productos seleccionados:</h3>
		<br>
	<%
	for(Repuestos r :  lProducto)
	{
		i++;
		total+=r.getPrecio() * r.getCantidad();
		cant+=r.getCantidad();
		%>
		<form action="ServletCarro" method="post">
		<input type="text" readonly	class="form-control-plaintext" name="numero" value="<%= i %>" hidden="true">
						
						
			<tr>
				<td><%= i %></td>
			<td><%=r.getId()%></td>
			<td><%=r.getNombre()%></td>
			<td><%=r.getPrecio()%></td>
			<td><%=r.getCantidad()%></td>
			
				<td><button type="submit" name="btnCarroEliminar" class="btn btn-primary btn-sm" style="min-width:80px;max-width:100px;">Eliminar</button></td>
						</tr>
					</form>
			
		
		<%
	}
	%><tr class="table-primary">
						<td></td>
						<td style="min-width:60;">El total es de: </td>
						<td>$<%= total %></td>
						<td></td>
						<td><%= cant %></td>
						<td></td>
					</tr> <% 
	}
%>
  

</table>
</div>
<form action="ServletClientes" method="post">


						<div >
							<label class="p-3 mb-2 bg-info text-white">DNI:</label>
								
						</div>
						<input  type="text" name="dnicliente"
							required pattern="^[0-9]*$">
						

<input type="submit" name="btnObtenerDatos" size="2" value="cargar" class="btn btn-primary">
</form>
	<form action="ServletCarro" method="post">
  <%String pago=""; %>
	<b class="p-3 mb-2 bg-info text-white">Forma de pago:</b>
Efectivo <input type="radio" name="radio" value="Efectivo" checked>
Tarjeta  <input type="radio" name="radio" value="Tarjeta">

<br/>
						    
						   
						       
	<%
			for (Clientes a : listaA) {
				resultado =a.getNombre();
		%>
		
Nombre:<input type="text" name="nombre" readonly=»readonly» required pattern="^[a-z]*$" value="<%=a.getNombre()%> ">						
id:<input type="text" name="id" readonly=»readonly» value="<%=a.getId()%> " required pattern="^[0-9]*$">
		
			
			

		<%
			}
	
	
		%>
	<input type="hidden" name="idusu" readonly=»readonly» value="<%=session.getAttribute("Session_idusuario")%> " >
<%
if(request.getAttribute("estadocliente")!=null)
{
 if(session.getAttribute("Session_permiso")!= null && ((Boolean)request.getAttribute("estadocliente"))==true){
	
	
	%>
	<br>
				<input type="submit" name="btnCarroComprar" value="Comprar"  style="min-width:100px;max-width:100px;" class="btn btn-primary">
	
	<%
}}%>
	
				    	
				
			</form>
			<% 
			
			if(request.getAttribute("estadostock")!=null)
			{
					if(((Boolean)request.getAttribute("estadostock"))==true)
					{
						%>
						<h5 style="position: absolute; top:10%; left:70%" class="p-3 mb-2 bg-info text-white" >Cantidad agregada supera estock</h5>
						<%
						
					}}
			
	if(request.getAttribute("compro")!=null)
	{
			if(((Boolean)request.getAttribute("compro"))==true)
			{
				%>
				<h2 style="position: absolute; top:80%; left:40%" >Compra correcta</h2>
				<%
				
			}
			else
			{
%>               <h2 style="position: absolute; top:80%; left:40%" >Compra incorrecta</h2>
			
				<%
				
			}
	}
 %>
	</div>
</body>
</html>