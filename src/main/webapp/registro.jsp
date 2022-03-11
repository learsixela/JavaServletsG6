<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Registro::</title>
</head>
<body>
	<div class="p-5 bg-primary text-white text-center">
		<h1>Mi primer servlet</h1>
		<p>Rutas y Formularios</p>
	</div>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Dinamic Web Project</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="/AAJavaG6Servlet">Home</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="registro">Registro</a></li>
					<li class="nav-item"><a class="nav-link" href="login">Login</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container mt-5">
		<c:if test="${msgError != null }">
			<div class="alert alert-danger" role="alert">
				<c:out value="${msgError}"></c:out>
			</div>
		</c:if>
		
		<h1>Formulario de Registro</h1>
		<form action="registrarUsuario" method=post>
			<label for="nombre" class="form-label">Nombre:</label> <input
				type="text" class="form-control" id="nombre" name="nombre"
				placeholder="Ingresar nombre"> <br> <label
				for="apellido" class="form-label">Apellido:</label> <input
				type="text" class="form-control" id="apellido" name="apellido"
				placeholder="Ingresar apellido"> <br> <label
				for="correo" class="form-label">Correo:</label> <input type="email"
				class="form-control" id="correo" name="correo"
				placeholder="Ingresar correo"> <br> <label
				for="password" class="form-label">Password:</label> <input
				type="password" class="form-control" id="password" name="password"
				placeholder="Ingresar password"> <br> <br> <label>Elija
				su sexo: </label><br> <input type="radio" class="form-check-input"
				id="femenino" name="genero" value="1"> <label for="femenino"
				class="form-check-label">Femenino</label> <br> <input
				type="radio" class="form-check-input" id="masculino" name="genero"
				value="2"> <label for="masculino" class="form-check-label">Masculino</label>
			<br> <input type="radio" class="form-check-input" id="nose"
				name="genero" value="3"> <label for="nose"
				class="form-check-label">No Se</label> <br> <br>
			<button type="submit" class="btn btn-primary mb-3">Registrar</button>
		</form>
	</div>
	<div class="mt-5 p-4 bg-dark text-white text-center">
		<p>Full Stack Java G6</p>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>
</html>