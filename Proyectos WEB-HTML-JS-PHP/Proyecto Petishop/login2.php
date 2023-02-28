

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/all.css">
	<title>Inicio de sesión</title>
</head>
<body>
	<div class="container col-xs-12 col-sm-12 col-md-8 col-lg-6">
		<div class="row justify-content-center align-items-center vh-100">
	
<div class="card border-success mb-3" style="max-width: 22rem;">
  <div class="card-header bg-transparent border-success">Inicio de sesión</div>
  <div class="card-body text-danger">
    
<form action="sesion.php" method="POST">
<div class="row">
<div class="col-4">
<label for="usuario">Usuario</label>
</div>

<div class="col-8">
<div class="input-group mb-3">
  	<span class="input-group-text" id="basic-addon1">
  	<i class="fa fa-user text-danger"></i>
  	</span>
  	<input type="text" name="user" class="form-control" placeholder="Usuario" 	aria-label="Usuario" aria-describedby="basic-addon1">
	</div>
  </div>
  </div>



  <div class="row mt-2">
<div class="col-4">
	<label for="password">Contraseña</label>
</div>
<div class="col-8">

<div class="input-group mb-3">


  	<span class="input-group-text" id="basic-addon2">
  	<i class="fa fa-lock text-danger" ></i>
  	</span>
  	<input type="text" name="pass" class="form-control" placeholder="Contraseña" 	aria-label="Contraseña" aria-describedby="basic-addon2">
	</div>


</div>
</div>
</div>
  <div class="card-footer bg-transparent border-success">
  	
<div class="row">
<div class="col text-center">

<input class="btn btn-danger btn-sm" type="submit" id="inicio" name="inicio" value="Iniciar Sesión">

</div>

  </div>
</div>
</div>
</div>
</form>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>