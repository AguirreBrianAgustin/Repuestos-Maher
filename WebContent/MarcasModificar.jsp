<%@page import="Entidad.Marcas"%>
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

tr{
  background-color:#1a53ff;
}
</style>
<body>
	<jsp:include page="Header.jsp"/>
	<jsp:include page="MenuLateral.jsp"/>
	<jsp:include page="Footer.jsp"/>
	<div style="position:absolute;right: 0; top: 40px; left: 250px; bottom: 0; right: 0;" class="container">
	
		<div id="contenedor">
<table class="table table-striped table-dark">
	<tr>
   <th>ID</th>
   <th>NOMBRE</th>
   <th>Estado</th>
   <th>Opción</th>
 	</tr>
	
	
	<%
		List<Marcas> listaA = new ArrayList<Marcas>();
		if (request.getAttribute("listaMarc") != null) {
			listaA = (List<Marcas>) request.getAttribute("listaMarc");
		}
	%>
		<h2>Lista de Modelo para modificar</h2>
	<%
	for(Marcas a : listaA)
	{
		%>
		<form method="post" action="ServletMarcas?Param=<%=a.getId()%>">
			<tr><td><%=a.getId()%></td>
				<td><input type="text" name="Nombretxt" value="<%=a.getNombre()%>" 	required pattern="^(?!\s*$).+"></td>
				<td>
			<%
		
			int numEntero2 = Integer.parseInt(a.getEstado());
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
				<td><input type="submit" name="btnModicarMarcas" value="Modificar"> </td>
			</tr>
		</form>
		<%
	}
%>
	
	</table>
	</div>
	<br>

<input type="submit" name="btnEliminar2" value="<<" onClick="location.href='ServletMarcas?Param=Modificar&pag=prev'" style="position:relative; top:60%; left:40% ; transform:translate(-50%,-50%)";>
<button style="position:relative; top:60%; left:42% ; transform:translate(-50%,-50%)"><%= request.getAttribute("pagina") %></button> 
<input type="submit" name="adelantar" value=">>" onClick="location.href='ServletMarcas?Param=Modificar&pag=next'" style="position:relative; top:60%; left:45% ; transform:translate(-50%,-50%)">
		
	</div>
			<br><br><br><br><br>
<% 
	if(request.getAttribute("estadomarca")!=null)
	{
			if(((Boolean)request.getAttribute("estadomarca"))==true)
			{
				%>
				<h2 style="position: absolute; top:85%; left:45%" >Actualizacion correcta</h2>
				<%
				
			}
			else
			{
%>               <h2 style="position: absolute; top:85%; left:45%" >Actualizacion incorrecta</h2>
			
				<%
				
			}
	}
 %>
	
</body>
</html>