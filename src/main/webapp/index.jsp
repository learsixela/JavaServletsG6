<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>Home::</title>
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
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="registro">Registro</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="login">Login</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container mt-5">
		<div class="row">
			<div class="col-sm-4">
				<h3 class="mt-4">Some Links</h3>
				<p>Lorem ipsum dolor sit ame.</p>
				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-link active" href="#">Active</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
				<hr class="d-sm-none">
			</div>
			<div class="col-sm-8">
				<h2>Creacion Servlet</h2>
				<h5>Como crear Servlet, Mar 8, 2022</h5>
				<div class="fakeimg">Fake Image</div>
				<p>Pasos a seguir..</p>
				<p>Con el proyecto seleccionado, ejecuta File -> New -> Servlet.
					A continuaci??n, presiona Next -> Next, activa la casilla Generate
					web.xml deployment descriptor para generar el fichero web.xml por
					si en un futuro queremos a??adir configuraciones relacionadas con
					nuestro proyecto web. Pulsa Finish.</p>

				<h2 class="mt-5">Creacion JSP</h2>
				<h5>Como crear JSP, Mar 8, 2022</h5>
				<div class="fakeimg">Fake Image</div>
				<p>Pasos a seguir..</p>
				<p>Con el proyecto seleccionado,posicionado en src/main/webapp,
					ejecuta New -> JSP FILE. En la apntalla desplegada escribe el
					nombre del archivo con la extension jsp. Pulsa Finish.</p>
			</div>
		</div>
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