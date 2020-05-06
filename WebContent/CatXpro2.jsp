<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Entidad.Repuestos"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>Hsasaome</title>
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
<style type="text/css">
html {
	position: relative;
	min-height: 100%;
}

.container {
	width: auto;
	max-width: 800px;
}

#footer {
	max-height: 56px;
}

body {
	font-family: Arial;
	margin: 0;
}

* {
	box-sizing: border-box;
}

img {
	vertical-align: middle;
}

.container {
	position: relative;
}

.mySlides {
	display: none;
}

.cursor {
	cursor: pointer;
}

/*5columnas*/
.column {
	float: left;
	width: 25%;
}

.demo {
	opacity: 0.6;
}

.active, .demo:hover {
	opacity: 1;
}


.zoom {
	-webkit-transition: all 0.35s ease-in-out;
	-moz-transition: all 0.35s ease-in-out;
	transition: all 0.35s ease-in-out;
	cursor: -webkit-zoom-in;
	cursor: -moz-zoom-in;
	cursor: zoom-in;
}

.zoom:hover, .zoom:active, .zoom:focus {
	-ms-transform: scale(1.3);
	-moz-transform: scale(1.3);
	-webkit-transform: scale(1.3);
	-o-transform: scale(1.3);
	transform: scale1.52);
	position: relative;
	z-index: 100;
}

.DivName {
	cursor: pointer
}
li {
	display:inline-block
}
.left {
	float:left
}
.right {
	float:right
}
	<%
		List<Repuestos> listaR = new ArrayList<Repuestos>();
		if (request.getAttribute("listaRep") != null) {
			listaR = (List<Repuestos>) request.getAttribute("listaRep");
		}
	%>
</style>
</head>
<body>

	<jsp:include page="Header.jsp" />
	<%
		if (request.getAttribute("ProductoSelected") != null) {
			int idProducto = (int) request.getAttribute("ProductoSelected");
			System.out.println("OTRA VEZ MUESTRO EL IDPRODUCTO"+idProducto);
			Repuestos producto = new Repuestos();
			//ProductoClass datos = new ProductoClass();
			//producto = datos.obtenerProducto_id(idProducto);
			if (!producto.equals(null)) {
	%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-4 text-left mt-5">
				<br>
				<br>
				<br>
				<%
	for(Repuestos r : listaR)
	{
		%>
				<form action="ServletCarro" method="post">
					<input type="hidden" name="idProducto" value="<%=producto.getId()%>">
					<h2 class="mb4"><%=producto.getNombre()%></h2>
					<p class="text-justify mb4"><%=producto.getDescripcion()%></p>
					<p class="mb4">Precio: <%=producto.getPrecio()%>$</p>
					<p class="mb4">Stock: <%=producto.getStock()%></p>
					<label for="customRange">Cantidad a comprar: </label>
			  		<input type="number" name="cant" class="d-inline custom-range slider" step="1" style="max-width:80px;" min="1" max="<%= producto.getStock() %>" required>
					<br>
					<button type="submit" name="btnCarroAgregar" class="btn btn-primary btn-sm mt-3">Agregar al carro</button>
				</form>
				<%	}
%>
			</div>
			
			</div>
		</div>
	<br><br><br><br><br><br><br>
	<%
		}
		}
	%>

	<script type="text/javascript">
		var slideIndex = 1;
		showSlides(slideIndex);

		function plusSlides(n) {
			showSlides(slideIndex += n);
		}

		function currentSlide(n) {
			showSlides(slideIndex = n);
		}

		function showSlides(n) {
			var i;
			var slides = document.getElementsByClassName("mySlides");
			var dots = document.getElementsByClassName("demo");
			var captionText = document.getElementById("caption");
			if (n > slides.length) {
				slideIndex = 1
			}
			if (n < 1) {
				slideIndex = slides.length
			}
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			for (i = 0; i < dots.length; i++) {
				dots[i].className = dots[i].className.replace(" active", "");
			}
			slides[slideIndex - 1].style.display = "block";
			dots[slideIndex - 1].className += " active";
			captionText.innerHTML = dots[slideIndex - 1]alt;
		}
	
		(function() {
			  var numberFields = document.querySelectorAll("input[type=number]"),
			    len = numberFields.length,
			    numberField = null;

			  for (var i = 0; i < len; i++) {
			    numberField = numberFields[i];
			    numberField.onclick = function() {
			      this.setAttribute("step", ".5");
			    };
			    numberField.onkeyup = function(e) {
			      if (e.keyCode === 38 || e.keyCode === 40) {
			        this.setAttribute("step", ".01");
			      }
			    };
			  }
			}());
	</script>
	<jsp:include page="Footer.jsp" />
</body>
</html>