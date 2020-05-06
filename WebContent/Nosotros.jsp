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
</style>
<body background="">

	<jsp:include page="Header.jsp"/>
	<jsp:include page="MenuLateral.jsp"/>
    

<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main" style="margin-left:250px">

  <div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container">
      <h1 style="border-style: groove;" class="w3-text-teal">Repuestos Maher</h1>
      <p class="p-3 mb-2 bg-info text-white"> Pagina orientada a la venta de repuestos vehiculares de la marca Volkswagen</p>
 Somos los numeros 1 en la venta de productos en zona norte.
    </div>

  </div>
  <iframe style="position:relative; top:40%; left:00% ;" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3289.879147324629!2d-58.62646358505743!3d-34.4552155571622!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x95bca48d22673f87%3A0x8775d1ae9173ba5c!2sSecretar%C3%ADa%20de%20Extensi%C3%B3n%20Universitaria%20U.T.N.%20F.R.G.P!5e0!3m2!1ses-419!2sar!4v1583340133368!5m2!1ses-419!2sar" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
  
  

 







	<jsp:include page="Footer.jsp"/>

<!-- END MAIN -->
</div>


</body>
</html>