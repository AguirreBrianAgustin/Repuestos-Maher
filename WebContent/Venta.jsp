<%@page import="Entidad.Categorias"%>
<%@page import="Entidad.Marcas"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<title>venta</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

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
<body background="">

	<jsp:include page="Header.jsp"/>
	<jsp:include page="MenuLateral.jsp"/>
    <%
		List<Categorias> listaA = new ArrayList<Categorias>();
		if (request.getAttribute("listaCat") != null) {
			listaA = (List<Categorias>) request.getAttribute("listaCat");
		}
	%>
	 <%
		List<Marcas> listab = new ArrayList<Marcas>();
		if (request.getAttribute("listaMarc") != null) {
			listab = (List<Marcas>) request.getAttribute("listaMarc");
		}
	%>

<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main" style="margin-left:250px">

  <div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container">
      <h1 style="border-style: groove;" class="w3-text-teal">Repuestos Maher</h1>
      <p> Pagina orientada a la venta de repuestos vehiculares</p>
    </div>

  </div>
<div id="contenedor">
<table id="table_id" class="display">
<form action="ServletProductos" method="post">
   
			<tr>
				<td><label class="text-dark">Categoria: </label></td>
				<td><select name=comboCat  class="p-3 mb-2 bg-dark text-white">
						<%
							for (Categorias c : listaA) {
						%>
							
							<option value="<%=c.getId()%>"><%=c.getNombre()%></option>
						<%
						}
						%>
						
					</select><br></td>
								</tr>	
			
			<tr>
				<td><label class="text-dark">Modelo: </label></td>
				<td><select name=comboMar  class="p-3 mb-2 bg-dark text-white">
						<%
							for (Marcas c : listab) {
						%>
							
							<option value="<%=c.getId()%>"><%=c.getNombre()%></option>
						<%
						}
						%>
						
					</select></td>
			</tr>	
					<tr><td><input  class="btn btn-success" type="submit" value="cargar categorias" name = "venta"   ></td></tr>	
				
				
							</form>
						
  
  
  

		

 
</table>
</div>					
					
				







	<jsp:include page="Footer.jsp"/>

<!-- END MAIN -->
</div>


</body>
</html>