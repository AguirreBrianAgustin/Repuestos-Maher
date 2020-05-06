<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<title>Registrarse</title>
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
</style>
<head>
<title>Registrarse</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"
	type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	type="text/javascript"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function showHidePsw() {
		var x = document.getElementById("pw");
		if (x.type === "password") {
			x.type = "text";
		} else {
			x.type = "password";
		}
	}
</script>
<style type="text/css">
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

.carousel-inner img {
	width: 100%;
}

#footer {
	max-height: 56px;
}
</style>
</head>



<body>

	<jsp:include page="Header.jsp"/>

<div class="container">
		<br> <br> <br>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4 align-middle">
				<h2>Registrarse</h2>
				<form action="Serveletlogin" method="post">

					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text">Nombre de usuario:</label>
						</div>
						<input id="nombre" type="text" class="form-control" name="nombre"
							required pattern="^(?!\s*$).+">
						<div class="input-group-append">
							<button class="btn btn-outline-primary" type="button"
								data-toggle="collapse" data-target="#collapseMsjNombre"
								aria-expanded="false" aria-controls="collapseMsjNombre">?</button>
						</div>
					</div>

					<div class="collapse mb-3" id="collapseMsjNombre">
						<div class="card card-body">El nombre debe contener letras.</div>
					</div>

					

			<div class="input-group mb-3">
		<div class="input-group-prepend">
			<label class="input-group-text">Permiso:</label>
		</div>
	<select name="permiso">
      <option value=1>Activado</option>
      <option value=0>Desactivado</option>
      </select>
			<div class="input-group-append">
					<button class="btn btn-outline-primary" type="button"
						data-toggle="collapse" data-target="#collapseMsjLocalidad2"
						aria-expanded="false" aria-controls="collapseMsjLocalidad2">?</button>
				</div>
	</div>
		

		

	<div class="collapse mb-3" id="collapseMsjLocalidad2">
		<div class="card card-body">La direccion debe contener numeros y letras.</div>
	</div>

	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<label class="input-group-text">Permiso:</label>
		</div>
	<select name="estado">
      <option value=1>Activado</option>
      <option value=0>Desactivado</option>
      </select>
			<div class="input-group-append">
					<button class="btn btn-outline-primary" type="button"
						data-toggle="collapse" data-target="#collapseMsjLocalidad"
						aria-expanded="false" aria-controls="collapseMsjLocalidad">?</button>
				</div>
	</div>


	<div class="collapse mb-3" id="collapseMsjLocalidad">
		<div class="card card-body">La localidad  debe contener numeros y letras.</div>
	</div>

	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<label class="input-group-text">Contraseña:</label>
		</div>

		<input id="pw" type="password" class="form-control" name="pw" required
			pattern="^(?!\s*$).+">
		<button type="button" class="btn btn-light btn-sm"
			onclick="showHidePsw()">mostrar/ocultar</button>
	</div>
	<div></div>

	<div class="collapse mb-3" id="collapseMsjContraseña2">
		<div class="card card-body">La contraseña  debe contener numeros y letras.
</div>
	</div>

	<br>
	<button type="submit" name="btnAgregarUsuario" class="btn btn-primary">Enviar</button>
	
	</form>
	<br>
	<% 
	if(request.getAttribute("estadoUsuario")!=null)
	{
			if(((Boolean)request.getAttribute("estadoUsuario"))==true)
			{
				
				%>
				<h4 class="text-primary">Se agrego el nuevo usuario</h4>
				
				<%
			
			}
			else
			{
				%>
				<h4 class="text-primary">No se agrego el usuario</h4>
				
				<%
			}
	}
 %>
	</div>
	</div>
	</div>
	<br>


	<jsp:include page="Footer.jsp"/>

<!-- END MAIN -->
</div>


</body>
</html>