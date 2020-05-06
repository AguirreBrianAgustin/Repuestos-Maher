<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"
	type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	type="text/javascript"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	type="text/javascript"></script>

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
<body>

	<jsp:include page="Header.jsp"/>


<!-- Sidebar -->

<style type="text/css">
/* Sticky footer */
html {
	position: relative;
	min-height: 100%;
}

.container  .text-muted {
	width: auto;
	max-width: 680px;
	padding: 0 15px;
	margin: 20px 0;
}

#footer {
	max-height: 56px;
}
</style>
</head>
<body id="main">

	  <% if(session.getAttribute("Session_permiso")== null){ %>

	<div class="container">
		<br>
		<br>
		<br>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h2>Entrar</h2>
				<form action="Serveletlogin" method="post">
					<label for="email">Email:</label>
					<div class="input-group">
						<input id="email" type="text" class="form-control" name="email"
							required placeholder="Enter email" value="aasd@gmail.com" pattern="[A-Za-z]{3-45}">
					</div>

					<label for="pw">Password:</label>
					<div class="input-group">
						<input id="pw" type="password" class="form-control"
							name="pw" required placeholder="Enter password"
							value="a" pattern="^(?!\s*$).+">
						<button type="button" class="btn btn-default btn-sm"
							onclick="showHidePsw()">mostrar/ocultar</button>
							
			<!--<button onclick="location.href = 'www.yoursite.com';" id="myButton" class="float-left submit-button" >Home</button>-->
							
							
					</div>
					<br>

					<div>
						
					</div>
					<br>
					
					<button  type="submit" class="btn btn-primary mb-2" name="btnEntrarbd">Enviar</button>
					<%} %>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
				</form>
			</div>
		
		</div>
	</div>
	  <% 
	if(request.getAttribute("estadologin")!=null)
	{    %><% 
			if(((Boolean)request.getAttribute("estadologin"))==true)
			{
				%>
				<h1 style="position: absolute; top:57%; left:42.5%" class="p-3 mb-2 bg-info text-white">Inicio correcto</h1>
				<%
				
			}
			else
			{
%>               <h1 style="position: absolute; top:57%; left:32%" class="p-3 mb-2 bg-info text-white">Error no existe en la base de datos</h1>
			
				<%
				
			}
	}
 %>

  
  


<div class="footer">
  <p>Todos los derechos reservados</p>
</div>

<!-- END MAIN -->






</body>
</html>
</body>
</html>