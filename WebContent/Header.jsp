<%@page import="Entidad.Categorias"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!-- Navbar -->
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<div class="w3-top">

  <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
    <a href= "Home.jsp" class="w3-bar-item w3-button w3-theme-l1">Home</a>
    
    <!-- Links -->
		

		
					
					
				
    
    
    <a href="Nosotros.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Nosotros</a>
     <% if(session.getAttribute("Session_permiso")!= null){ 
    	%>
    <a href="ServletCategorias?Param=Listarx2"  class="w3-bar-item w3-button w3-hide-small w3-hover-white">Categorias</a>
    <%} %>
    <!--  <a href="Carro.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Carro</a>-->
     <% if(session.getAttribute("Session_permiso")== null){ %>
   <a href="login.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Login</a>
    <% }
     
    %>
      <% if(session.getAttribute("Session_permiso")!= null){ 
    	%>
    <a href="Carro2.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Compra</a>
     <% }
      %>
      <a href="cierre.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white">                        
    
    <% if(session.getAttribute("Session_email")!= null){ %>
				
				<p class="text-warning"><%= session.getAttribute("Session_email") %></p>
			<%} 
			else
			{ %>
			
			<%} %>
			
			</a>
			
			
			
			 
  </div>
</div>