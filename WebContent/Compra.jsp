<!DOCTYPE html>
<%@page import="Entidad.Repuestos"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
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
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
	<style>
		ul, li{
			list-style: none;
			margin: 0px;
			padding: 0px;
			cursor: pointer;
		}
		section#cart ul{
			height: 200px;			
			overflow: auto;
			background-color: #cccccc;
		}
	</style>
	<script>
		function addEvent(element, event, delegate ) {
			if (typeof (window.event) != 'undefined' && element.attachEvent)
				element.attachEvent('on' + event, delegate);
			else 
				element.addEventListener(event, delegate, false);
		}
		
		addEvent(document, 'readystatechange', function() {
			if ( document.readyState !== "complete" ) 
				return true;
				
			var items = document.querySelectorAll("section.products ul li");
			var cart = document.querySelectorAll("#cart ul")[0];
			
			function updateCart(){
				var total = 0.0;
				var cart_items = document.querySelectorAll("#cart ul li")
				for (var i = 0; i < cart_items.length; i++) {
					var cart_item = cart_items[i];
					var quantity = cart_item.getAttribute('data-quantity');
					var price = cart_item.getAttribute('data-price');
					
					var sub_total = parseFloat(quantity * parseFloat(price));
					cart_item.querySelectorAll("span.sub-total")[0].innerHTML = " = " + sub_total.toFixed(2);
					
					total += sub_total;
				}
				
				document.querySelectorAll("#cart span.total")[0].innerHTML = total.toFixed(2);
			}
			
			function addCartItem(item, id) {
				var clone = item.cloneNode(true);
				clone.setAttribute('data-id', id);
				clone.setAttribute('data-quantity', 1);
				clone.removeAttribute('id');
				
				var fragment = document.createElement('span');
				fragment.setAttribute('class', 'quantity');
				fragment.innerHTML = ' x 1';
				clone.appendChild(fragment);	
				
				fragment = document.createElement('span');
				fragment.setAttribute('class', 'sub-total');
				clone.appendChild(fragment);					
				cart.appendChild(clone);
			}
			
			function updateCartItem(item){
				var quantity = item.getAttribute('data-quantity');
				quantity = parseInt(quantity) + 1
				item.setAttribute('data-quantity', quantity);
				var span = item.querySelectorAll('span.quantity');
				span[0].innerHTML = ' x ' + quantity;
			}
			
			function onDrop(event){			
				if(event.preventDefault) event.preventDefault();
				if (event.stopPropagation) event.stopPropagation();
				else event.cancelBubble = true;
				
				var id = event.dataTransfer.getData("Text");
				var item = document.getElementById(id);			
							
				var exists = document.querySelectorAll("#cart ul li[data-id='" + id + "']");
				
				if(exists.length > 0){
					updateCartItem(exists[0]);
				} else {
					addCartItem(item, id);
				}
				
				updateCart();
				
				return false;
			}
			
			function onDragOver(event){
				if(event.preventDefault) event.preventDefault();
				if (event.stopPropagation) event.stopPropagation();
				else event.cancelBubble = true;
				return false;
			}

			addEvent(cart, 'drop', onDrop);
			addEvent(cart, 'dragover', onDragOver);
			
			function onDrag(event){
				event.dataTransfer.effectAllowed = "move";
				event.dataTransfer.dropEffect = "move";
				var target = event.target || event.srcElement;
				var success = event.dataTransfer.setData('Text', target.id);
			}
				
			
			for (var i = 0; i < items.length; i++) {
				var item = items[i];
				item.setAttribute("draggable", "true");
				addEvent(item, 'dragstart', onDrag);
			};
		});
	</script>
</head>
<body>
  	<%
		List<Repuestos> listaR = new ArrayList<Repuestos>();
		if (request.getAttribute("listaRep") != null) {
			listaR = (List<Repuestos>) request.getAttribute("listaRep");
		}
	%>
	<jsp:include page="Header.jsp"/>
	<jsp:include page="MenuLateral.jsp"/>
	<div style="position:absolute;right: 0; top: 40px; left: 250px; bottom: 0; right: 0;" class="container">
    <div id="page">	
		<section id="cart" class="shopping-cart">
			<h1>Shopping Cart</h1>
			<ul>
			</ul>
			<span> TOTAL </span>
			<span class="total">0.00</span>
		</section>
		<section id="products" class="products">
			<h1>Product List</h1>
			<ul>
				<%
	for(Repuestos r : listaR)
	{
		%>
		
			
			<li style="border-style: double;" id=<%=r.getId()%> data-price=<%=r.getPrecio()%>>
			<span><%=r.getNombre()%></span>
			<span><%=r.getStock()%></span>
			<span>Precio</span>
			<span><%=r.getPrecio()%></span>
			</li>
			
			
			
		
		<%
	}
%>
			
			</ul>
		</section>
	</div> 	
	</div>
	<jsp:include page="Footer.jsp"/>
	
</body>
</html>
