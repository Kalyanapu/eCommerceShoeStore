<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>${pageinfo}-SportyShoesBigSale</title>
<meta name=viewport content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/boostrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

	<div class="container">


		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand href="#">SportyShoesBigSale</a>

				</div>

				<ul class="nav navbar-nav">
					<li><a href="home">HOME</a></li>


					<li><a href="<c:url value="/login"/>">LOGIN</a></li>
					<li><a href="<c:url value="/register"/>">REGISTER</a></li>
					<li><a href="<c:url value="/contactus"/>">CONTACT US</a></li>
					<li><a href="<c:url value="/About US"/>">About US</a></li>
					<li><a href="<c:url value="/product"/>">Manage Product</a>
					<li><a href="<c:url value="/Manager Category"/>">Manage
							Category</a>
					<li><a href="<c:url value="/productDisplay"/>">PRODUCT
							CATALOG </a>
					<li><a href="<c:url value="/cart"/>">CART</a>
				</ul>
			</div>
		</nav>
	</div>

</body>



</html>