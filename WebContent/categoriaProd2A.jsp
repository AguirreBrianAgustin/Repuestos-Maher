<%@page import="Entidad.Repuestos"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<title>Seleccion de producto</title>
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


#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}

</style>
<body>
	<jsp:include page="Header.jsp"/>
	<jsp:include page="MenuLateral.jsp"/>
	<jsp:include page="Footer.jsp"/>
	<div style="position:absolute;right: 0; top: 40px; left: 250px; bottom: 0; right: 0;" class="container">
	<h2>Seleccion de producto y cantidad para agregar al carro de compra!</h2>

<table id="customers">
  <tr>
    <th>ID</th>
    <th>Nombre</th>
    <th>Descripcion</th>
    <th>Precio</th>
    <th>Stock</th>
    <th>cantXcomprar</th>
    <th>Agregar</th>

  </tr>  
  	<%
		List<Repuestos> listaR = new ArrayList<Repuestos>();
		if (request.getAttribute("listaRep") != null) {
			listaR = (List<Repuestos>) request.getAttribute("listaRep");
		}
	%>
		<h2>Seleccione cantidad deseada</h2>
	<%
	for(Repuestos r : listaR)
	{
		
		%>
		<form method="post" action="ServletCarro?Param=<%=r.getId()%>">
			<tr>
			<td><%=r.getId()%></td>
		
			
			<td><input type="text" name="nombre" readonly=»readonly» value="<%=r.getNombre()%> "></td>
			<td><%=r.getDescripcion()%></td>
		<td><input type="text" name="precio" readonly=»readonly» value="<%=r.getPrecio()%> "></td>
				
					<td><input type="text" name="stock" readonly=»readonly» value="<%=r.getStock()%> "></td>
				<input type="hidden" name="stst"  value="<%=r.getStock()%>" >

			<td>
				<label for="customRange"> </label>
			  		<input type="number" name="cant" class="d-inline custom-range slider" step="1" style="max-width:80px;" min="1" max="<%= r.getStock() %>" required pattern="^[0-9]*$" >
					</td>
		<td> <input type="submit" name="btnCarroAgregar" size="2" value="Agregar"> </td>
</tr>

</form>
		<%
	}
%>
  

</table>
	</div>
</body>
</html>