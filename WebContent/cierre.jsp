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
      <br>
      <br>
      <br>
             <h3 style="border-style: groove;" class="text-light bg-dark">Para cerrar el usuario conectado presione  cerrar.
      
<% if(session.getAttribute("Session_email")!= null){ %>
				<form action="salida" method="get"   style="margin-top: 5px; margin-bottom: 0px;">
 <!-- <a><button class="btn btn-primary mb-2" style="margin-top: 5px; margin-bottom: 0px;" type="button" name="btnEntrar">Desloguear</button></a> -->		
		
			  <button  type="submit" class="btn btn-primary mb-2" name="btnEntrar" >cerrar</button>
			  <form/>
			<%} 
			else
			{ %>
			<!-- <button  type="submit" class="btn btn-primary mb-2" name="btnEntrar" disabled >cerrar</button> -->
			
			<%} %>
			</h3>
    </div>

 
