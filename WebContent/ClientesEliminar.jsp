<%@page import="Entidad.Clientes"%>
<%@page import="Entidad.Localidades"%>
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
<body background="">

	<jsp:include page="Header.jsp"/>
	<jsp:include page="MenuLateral.jsp"/>
	<jsp:include page="Footer.jsp"/>
		<%
		List<Clientes> listaA = new ArrayList<Clientes>();
		if (request.getAttribute("Clie") != null) {
			listaA = (List<Clientes>) request.getAttribute("Clie");
		}
	%>

<%
		List<Localidades> listaL = new ArrayList<Localidades>();
		if (request.getAttribute("listaLocal") != null) {
			listaL = (List<Localidades>) request.getAttribute("listaLocal");
		}
	%>
	
	<!--  -->
			<div style="position:absolute;right: 0; top: 40px; left: 250px; bottom: 0; right: 0;" class="container">
	<h2>Eliminar clientes</h2>
	<div id="contenedor">
<table class="table table-striped table-dark">
    <thead>
	    <thead>
	
    
  <tr>
			<td><b>ID Cliente</b></td>
			<td><b>NOMBRE</b></td>
			<td><b>telefono</b></td>
			<td><b>direccion</b></td>
			<td><b>mail</b></td>
			<td><b>dni</b></td>
			<td><b>estado</b></td>
			<td><b>idlocalidades</b></td>
				<td><b>eliminar</b></td>
			  </tr>
     </thead>
    <tbody>
		<%
			for (Clientes a : listaA) {
		%>

		<tr>
			 <form method="post" action="ServletClientes?Param=<%=a.getId()%>">
			<td><%=a.getId()%></td>
			<td><%=a.getNombre()%></td>
				<td><%=a.getTelefono()%></td>
					<td><%=a.getDireccion()%></td>
						<td><%=a.getMail()%></td>
						<td><%=a.getDni()%></td>
			
			<%
			String resu =a.getEstado();
			int numEntero = Integer.parseInt(a.getEstado());
			%>
			
			<% 
			if(numEntero==1){%> <td>Activo</td> <%}
			
			else{%><td>Inactivo</td><%}%>
			
			
			<%
int rr=a.getIdLocalidades();
for (Localidades m : listaL) {
%>
<%if(rr == m.getId() ) {%>
<td><%=m.getNombre()%></td>
<%
}}%>
         <td> <input type="submit" name="btnEliminarclientes" value="Eliminar"> </td>
		</form>
		</tr>
	
		<%
			}
		%>

      


    </tbody>
</table>

</div>
<input type="submit" name="btnEliminar2" value="<<" onClick="location.href='ServletClientes?Param=Eliminar&pag=prev'" style="position:relative; top:60%; left:40% ; transform:translate(-50%,-50%)";>
<button style="position:relative; top:60%; left:42% ; transform:translate(-50%,-50%)"><%= request.getAttribute("pagina") %></button> 
<input type="submit" name="adelantar" value=">>" onClick="location.href='ServletClientes?Param=Eliminar&pag=next'" style="position:relative; top:60%; left:45% ; transform:translate(-50%,-50%)">
		

</body>
</html>