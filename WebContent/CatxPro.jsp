<%@page import="Entidad.Repuestos"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<title>CategoriasProd</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>

.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button2 {background-color: #008CBA;} /* Blue */
.button3 {background-color: #f44336;} /* Red */ 
.button4 {background-color: #e7e7e7; color: black;} /* Gray */ 
.button5 {background-color: #555555;} /* Black */
body {
background-image: url("imagenes/3.jpg");
background-position:center;

}
.padre {
  top:100%;
   left:100% ;
  position: center;
 
}
.label {
  color: white;
  padding: 8px;
  font-family: Arial;
}
.success {background-color: #4CAF50;} /* Green */
.info {background-color: #2196F3;} /* Blue */
.warning {background-color: #ff9800;} /* Orange */
.danger {background-color: #f44336;} /* Red */ 
.other {background-color: #e7e7e7; color: black;} /* Gray */ 

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
	<div style="position:absolute;right: 0; top: 40px; left: 250px; bottom: 0; right: 0;" class="container">
		<h2 class="text-info">Lista de productos con filtrado en la categoria seleccionada</h2>
		</div>
    

<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->


  <br>
	<br>
	<br>
	<br>
	<div class="row container">
		<div class="col col-sm-2">
			<div class="container">
				<h3 class="text-info">Filtos de categoria</h3>
				<label for="sel1">Precio:</label>
				<form action="ServletProductos" method="post" class="tab-content">
				<% 	try{
					int idCategoria;
					if(request.getParameter("idCategoria")!=null){ 
						idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
						System.out.println("id cat desde jsp"+idCategoria);
						%>
					<input type="text" value="<%= idCategoria %>" name="idCategoria" readonly>
					<% } %>
					<div class="list-group">
						<div class="input-group mb-3">
						
							 <input type="text" class="form-control" name="precioMin"
								placeholder="Mínimo"  required pattern="^[0-9\.]*$"> <input type="text"
								class="form-control" name="precioMax" placeholder="Máximo"  required pattern="^[0-9\.]*$"> 
						</div>
						
                          <div class="input-group-append">
							<button type="submit" class="btn btn-primary btn-sm"
								name="btnProductosXCategoriaFiltroPrecio">Buscar</button>
						
						
						</div>
					</div>
				</form>
					<form  action="ServletProductos" method="post" class="tab-content">
					<button type="submit" class="btn btn-primary btn-sm"
								name="btnProductosXCategoriaQUITARFiltroPrecio">Quitar filtro</button>
			</form>
			</div>
		</div> 
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
		<div class="col col-sm-10">
			<div class="container">
				<div class="row">
					<%
						ArrayList<Repuestos> lProductos = null;

						if (request.getAttribute("listaRep") != null){
							System.out.println("SIN FILTRO");
							lProductos = (ArrayList<Repuestos>) (request.getAttribute("listaRep"));
							request.setAttribute("listaRep", null);
							int i = 0;
							for (Repuestos producto : lProductos) {
								i++;
								if (i % 5 == 0) {

								}
					%>
					<div class="col-sm-2 mb-4">
						<div class="card">
							<form action="ServletProductos" method="post" class="tab-content">
								<input type="hidden" value="<%= producto.getId() %>" name="idProductoSelected" >
								<input type="submit"  class="btn btn-primary btn-sm" alt="Card image cap" name="btnSelectedProductoid" value="<%= producto.getId() %>">
								<div class="card-block">
									<h4 class="p-3 mb-2 bg-info text-white"><%=producto.getNombre()%></h4>
									<h5 class="text-primary"><%=producto.getDescripcion()%></h6>
									<small class="text-muted">Stock: <%=producto.getStock()%>
										Precio: $<%=producto.getPrecio()%> 
									</small>
								</div>
							
							</form>
						</div>
					</div>
					<%
						}
							%>
							

	
		<%
						} else if (request.getAttribute("ProductoSelectFiltro") != null) {
							System.out.println("CON FILTRO");
							lProductos = (ArrayList<Repuestos>) (request.getAttribute("ProductoSelectFiltro"));
							int i = 0;
							for (Repuestos producto : lProductos) {
								i++;
								System.out.println(i);
								if (i % 5 == 0) {
									
								}
					%>
					<div class="col-sm-2 mb-4">
						<div class="card">
							
				alt="Card image" width="290" height="290">
			
							<div class="card-block">
								<h4 class="card-title"><%=producto.getNombre()%></h4>
								<small class="text-muted">Stock: <%=producto.getStock()%>
									Precio: <%=producto.getPrecio()%> $
								</small>
							</div>
						</div>
					</div>
					<%
						}}}
					catch(Exception e){
						e.printStackTrace();
					}
					%>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div class="row">
		<div class="col-4"></div>
		<div class="col-4 mx-auto text-center">
		
		
		
		<%if(request.getAttribute("muestaPag").equals(1)) {%>
		<input type="submit" name="btnEliminar2" value="<<" onClick="location.href='ServletProductos?Param=catpro&pag=prev'" style="position:relative; top:60%; left:-05% ; transform:translate(-50%,-50%)";>
<button style="position:relative; top:60%; left:0% ; transform:translate(-50%,-50%)"><%= request.getAttribute("pagina") %></button> 
<input type="submit" name="adelantar" value=">>" onClick="location.href='ServletProductos?Param=catpro&pag=next'" style="position:relative; top:60%; left:05% ; transform:translate(-50%,-50%)">
	
			<%}
		else{
			%>
			
			<input type="submit" name="btnEliminar2" value="<<" onClick="location.href='ServletProductos?Param=btnProductosXCategoriaFiltroPrecio&pag=prev'" style="position:relative; top:60%; left:-05% ; transform:translate(-50%,-50%)";>
<button style="position:relative; top:60%; left:0% ; transform:translate(-50%,-50%)"><%= request.getAttribute("pagina") %></button> 
<input type="submit" name="adelantar" value=">>" onClick="location.href='ServletProductos?Param=btnProductosXCategoriaFiltroPrecio&pag=next'" style="position:relative; top:60%; left:05% ; transform:translate(-50%,-50%)">
	
		
			<% 
		}%>
		</div>
	</div>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
  
  









	<jsp:include page="Footer.jsp"/>

<!-- END MAIN -->
</div>


</body>
</html>