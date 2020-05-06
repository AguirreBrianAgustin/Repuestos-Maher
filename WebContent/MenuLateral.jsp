<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<!-- Sidebar -->
<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
    <i class="fa fa-remove"></i>
  </a>
  <h4 class="w3-bar-item"><b>Menu</b></h4>
  <!--  <a class="w3-bar-item w3-button w3-hover-black" href="Productos.jsp">Productos</a>-->
  
  
        <button class="w3-button w3-block w3-left-align" onclick="myAccFunc2()">
  Productos <i class="fa fa-caret-down"></i>
  </button>
  <div id="demoProd" class="w3-hide w3-white w3-card">
    <a href="ServletProductos?Param=Listar" class="w3-bar-item w3-button">Listar</a>

	  
	 <% if(session.getAttribute("Session_permiso")!= null){ 
    	if(session.getAttribute("Session_permiso").equals("1")){
    	%>
    	<a href="ServletProductos?Param=Agregar" class="w3-bar-item w3-button">Agregra</a>
    <a href="ServletProductos?Param=Eliminar" class="w3-bar-item w3-button">Eliminar</a>
  	<a href="ServletProductos?Param=Modificar" class="w3-bar-item w3-button">Modificar</a>
    	
    <% 	
    		
    	} 
      
      }%>
    
  </div>
  
  <!---------------------------->
  <!---------------------------->
  <!---------------------------->
  <!-- Menu acordeon clientes -->
    <button class="w3-button w3-block w3-left-align" onclick="myAccFunc()">
  Clientes <i class="fa fa-caret-down"></i>
  </button>
   <% if(session.getAttribute("Session_permiso")!= null){ 
    	if(session.getAttribute("Session_permiso").equals("1")){
    	%>
  <div id="demoAcc" class="w3-hide w3-white w3-card">
    <a href="ServletClientes?Param=Listar" class="w3-bar-item w3-button">Listar</a>
     
    	
    	<a href="ServletClientes?Param=Agregar" class="w3-bar-item w3-button">Agregra</a>
    <a href="ServletClientes?Param=Eliminar" class="w3-bar-item w3-button">Eliminar</a>
  	<a href="ServletClientes?Param=Modificar" class="w3-bar-item w3-button">Modificar</a>
    	
    	<% 	
    		
    	} 
      
      }%>
      
    
  </div>
  <!-- Menu acordeon clientes -->
  <!---------------------------->
  <!---------------------------->
  <!---------------------------->
  <!---------------------------->
      <button class="w3-button w3-block w3-left-align" onclick="myAccFunc3()">
  Proveedores <i class="fa fa-caret-down"></i>
  </button>
   <% if(session.getAttribute("Session_permiso")!= null){ 
    	if(session.getAttribute("Session_permiso").equals("1")){
    	%>
  <div id="demoProv" class="w3-hide w3-white w3-card">
    <a href="ServletProveedores?Param=Listar" class="w3-bar-item w3-button">Listar</a>
    
    
    <a href="ProveedoresAgregar.jsp" class="w3-bar-item w3-button">Agregra</a>
    <a href="ServletProveedores?Param=Eliminar" class="w3-bar-item w3-button">Eliminar</a>
  	<a href="ServletProveedores?Param=Modificar" class="w3-bar-item w3-button">Modificar</a>
  	
  	
  	<% 	
    		
    	} 
      
      }%>
  </div>
  
        <button class="w3-button w3-block w3-left-align" onclick="myAccFunc4()">
  Modelo <i class="fa fa-caret-down"></i>
  </button>
  <div id="demoMarc" class="w3-hide w3-white w3-card">
    <a href="ServletMarcas?Param=Listar" class="w3-bar-item w3-button">Listar</a>
    
      <% if(session.getAttribute("Session_permiso")!= null){ 
    	if(session.getAttribute("Session_permiso").equals("1")){
    	%>
    	
    <a href="ServletMarcas?Param=Agregar"  class="w3-bar-item w3-button">Agregra</a>
    <a href="ServletMarcas?Param=Eliminar" class="w3-bar-item w3-button">Eliminar</a>
  	<a href="ServletMarcas?Param=Modificar" class="w3-bar-item w3-button">Modificar</a>
  	
  		<% 	
    		
    	} 
      
      }%>
  </div>
  
        <button class="w3-button w3-block w3-left-align" onclick="myAccFunc5()">
  Categorias <i class="fa fa-caret-down"></i>
  </button>
   <% if(session.getAttribute("Session_permiso")!= null){ 
    	if(session.getAttribute("Session_permiso").equals("1")){
    	%>
  <div id="demoCat" class="w3-hide w3-white w3-card">
    <a href="ServletCategorias?Param=Listar" class="w3-bar-item w3-button">Listar</a>
    
    
    <a href="CategoriasAgregar.jsp" class="w3-bar-item w3-button">Agregra</a>
    <a href="ServletCategorias?Param=Eliminar" class="w3-bar-item w3-button">Eliminar</a>
  	<a href="ServletCategorias?Param=Modificar" class="w3-bar-item w3-button">Modificar</a>
  	
  	<% 	
    		
    	} 
      
      }%>
  </div>
  

  
          <button class="w3-button w3-block w3-left-align" onclick="myAccFunc6()">
  Reportes <i class="fa fa-caret-down"></i>
  </button>
  <div id="demoRep" class="w3-hide w3-white w3-card">
   
     <% if(session.getAttribute("Session_permiso")!= null){ 
    	if(session.getAttribute("Session_permiso").equals("1")){
    	%>
     <a href="ServeltFacturas?Param=Listar" class="w3-bar-item w3-button">Listar ventas</a>
    <a href="ServeltdetalleFactura?Param=Listar" class="w3-bar-item w3-button">Listar detalle de ventas</a>
        <a href="FacturaListarXfecha.jsp" class="w3-bar-item w3-button">Listar por fecha</a>
            <a href="FacturaListarXpre.jsp" class="w3-bar-item w3-button">Listar por precio</a>
            	
  	<% 	
    		
    	} 
      
      }%>
  </div>
  
      
      <button class="w3-button w3-block w3-left-align" onclick="myAccFunc7()">
  Usuario <i class="fa fa-caret-down"></i>
  </button>
  <div id="demoLog" class="w3-hide w3-white w3-card">
   
     <% if(session.getAttribute("Session_permiso")!= null){ 
    	 %>
    	 <a href="ActualizarContra.jsp" class="w3-bar-item w3-button">Actualizar contraseña</a>
    	 <%
    	if(session.getAttribute("Session_permiso").equals("1")){
    	%>
     <a href="Serveletlogin?Param=Listar" class="w3-bar-item w3-button">Eliminar/Alta</a>
   
        <a href="Agregar.jsp" class="w3-bar-item w3-button">Nuevo Usuario</a>
            	
  	<% 	
    		
    	} 
      
      }%>
  </div>
  <!--<a class="w3-bar-item w3-button w3-hover-black" href="Proveedores.jsp">Nuestros proveedores</a>-->
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>




<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
    overlayBg.style.display = "none";
  } else {
    mySidebar.style.display = 'block';
    overlayBg.style.display = "block";
  }
}

// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}
</script>


<script>


function myDropFunc() {
	  var x = document.getElementById("demoAcc");
	  if (x.className.indexOf("w3-show") == -1) {
	    x.className += " w3-show";
	    x.previousElementSibling.className += " w3-green";
	  } else { 
	    x.className = x.className.replace(" w3-show", "");
	    x.previousElementSibling.className = 
	    x.previousElementSibling.className.replace(" w3-green", "");
	  }
	}

function myAccFunc() {
  var x = document.getElementById("demoAcc");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
    x.previousElementSibling.className += " w3-green";
  } else { 
    x.className = x.className.replace(" w3-show", "");
    x.previousElementSibling.className = 
    x.previousElementSibling.className.replace(" w3-green", "");
  }
}



function myAccFunc2() {
	  var x = document.getElementById("demoProd");
	  if (x.className.indexOf("w3-show") == -1) {
	    x.className += " w3-show";
	    x.previousElementSibling.className += " w3-green";
	  } else { 
	    x.className = x.className.replace(" w3-show", "");
	    x.previousElementSibling.className = 
	    x.previousElementSibling.className.replace(" w3-green", "");
	  }
	}


	
	function myAccFunc3() {
		  var x = document.getElementById("demoProv");
		  if (x.className.indexOf("w3-show") == -1) {
		    x.className += " w3-show";
		    x.previousElementSibling.className += " w3-green";
		  } else { 
		    x.className = x.className.replace(" w3-show", "");
		    x.previousElementSibling.className = 
		    x.previousElementSibling.className.replace(" w3-green", "");
		  }
		}
	
	function myAccFunc4() {
		  var x = document.getElementById("demoMarc");
		  if (x.className.indexOf("w3-show") == -1) {
		    x.className += " w3-show";
		    x.previousElementSibling.className += " w3-green";
		  } else { 
		    x.className = x.className.replace(" w3-show", "");
		    x.previousElementSibling.className = 
		    x.previousElementSibling.className.replace(" w3-green", "");
		  }
		}
	
	function myAccFunc5() {
		  var x = document.getElementById("demoCat");
		  if (x.className.indexOf("w3-show") == -1) {
		    x.className += " w3-show";
		    x.previousElementSibling.className += " w3-green";
		  } else { 
		    x.className = x.className.replace(" w3-show", "");
		    x.previousElementSibling.className = 
		    x.previousElementSibling.className.replace(" w3-green", "");
		  }
		}
	
	function myAccFunc6() {
		  var x = document.getElementById("demoRep");
		  if (x.className.indexOf("w3-show") == -1) {
		    x.className += " w3-show";
		    x.previousElementSibling.className += " w3-green";
		  } else { 
		    x.className = x.className.replace(" w3-show", "");
		    x.previousElementSibling.className = 
		    x.previousElementSibling.className.replace(" w3-green", "");
		  }
		}

	function myAccFunc7() {
		  var x = document.getElementById("demoLog");
		  if (x.className.indexOf("w3-show") == -1) {
		    x.className += " w3-show";
		    x.previousElementSibling.className += " w3-green";
		  } else { 
		    x.className = x.className.replace(" w3-show", "");
		    x.previousElementSibling.className = 
		    x.previousElementSibling.className.replace(" w3-green", "");
		  }
		}
	


</script>






</body>
</html>