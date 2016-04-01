<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="MIW. Spring 4 MVC">
<meta name="author" content="J.Bernal">
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/css/carousel.css' />" rel="stylesheet" />
<title>Spring 4 MVC. Home</title>
</head>
<body>
	<div class="navbar-wrapper">
		<div class="container">
			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span
								class="icon-bar"></span><span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Spring MVC</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">Home</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">Usuario<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li class="dropdown-header">CRUD</li>
									<li><a href="<c:url value='/user-list'/>">Listar</a></li>
									<li><a href="<c:url value="/create-user"/>">Crear</a></li>
								</ul></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<c:forEach items="${themes}" var="theme">
								<li><a class="btn btn-default btn-xs"
									href="<c:url value="create-theme?theme=${theme}"/>">${theme}</a></li>;
							</c:forEach>
						</ul>
					</div>
				</div>
			</nav>

		</div>
	</div>

	<!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide"
					src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
					alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Empezar con Spring MVC</h1>
						<p>Se realiza una petici�n al dispatcher, este delega en el
							controlador. El controlador traslada a la capa de negocio la
							petici�n y obtiene los resultados. Prepara los datos de
							presentaci�n sobre el objeto Model y devuelve el control al
							dispatcher. El dispatcher, solicita al ViewResolver que resuelva
							la vista a presentar y le da el control a la vista. La vista los
							presenta a partir de los datos del objeto Model</p>
						<p>
							<a class="btn btn-lg btn-primary"
								href="<c:url value="/greeting"/>" role="button">Probar</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide"
					src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Listar usuarios</h1>
						<p>Muestra una tabla con la lista completa de usuarios</p>
						<p>
							<a class="btn btn-lg btn-primary"
								href="<c:url value="/user-list"/>" role="button">Probar</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide"
					src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
					alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Crear usuario</h1>
						<p>Saca un formulario para crear un nuevo usuario</p>
						<p>
							<a class="btn btn-lg btn-primary"
								href="<c:url value="/create-user"/>" role="button">probar</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Anterior</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Pr�ximo</span>
		</a>
		<footer>
			<p>&nbsp;&nbsp;&copy; UPM-MIW --- ${now}</p>
		</footer>
	</div>
	<!-- ============================= -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="<c:url value='/static/js/bootstrap.js' />"></script>
</body>
</html>