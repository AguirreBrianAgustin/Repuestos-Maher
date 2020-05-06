<%@page import="Entidad.DetalleFactura"%>
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

 <script type="text/javascript">
    $(document).ready( function () {
        $('#table_id').DataTable();
    } );
    </script>
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
		<%
		List<DetalleFactura> listaA = new ArrayList<DetalleFactura>();
		if (request.getAttribute("listaDetallefac") != null) {
			listaA = (List<DetalleFactura>) request.getAttribute("listaDetallefac");
		}
	%>


	
	<!--  -->
			<div style="position:absolute;right: 0; top: 40px; left: 250px; bottom: 0; right: 0;" class="container">
		<h2>Lista de Detalle factura</h2>
	
	<div id="contenedor">
<table class="table table-striped table-dark">
    <thead>
	    <thead>
    
  <tr>
			<td><b>ID </b></td>
			<td><b>Cantidad</b></td>
			<td><b>Precio</b></td>
			<td><b>ID_Repuesto</b></td>
			<td><b>IDFact</b></td>
			  </tr>
     </thead>
    <tbody>
		<%
			for (DetalleFactura a : listaA) {
		%>

		<tr>
			<td><%=a.getIddetalle()%></td>
			<td><%=a.getCantidad()%></td>
			<td><%=a.getPrecio()%></td>
			<td><%=a.getIdrepuestos()%></td>
			<td><%=a.getIdfacturas() %></td>
		
		
			
			

		</tr>

		<%
			}
		%>

    </tbody>
</table>


<input type="submit" name="btnEliminar2" value="<<" onClick="location.href='ServeltdetalleFactura?Param=Listar&pag=prev'" style="position:relative; top:60%; left:40% ; transform:translate(-50%,-50%)";>
<button style="position:relative; top:60%; left:42% ; transform:translate(-50%,-50%)"><%= request.getAttribute("pagina") %></button> 
<input type="submit" name="adelantar" value=">>" onClick="location.href='ServeltdetalleFactura?Param=Listar&pag=next'" style="position:relative; top:60%; left:45% ; transform:translate(-50%,-50%)">
		
		

</div>
			
	
</body>
</html>