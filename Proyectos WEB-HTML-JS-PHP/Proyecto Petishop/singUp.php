<?php
require_once 'conexion.php';
require_once 'data.php';

$error="";

$nombre=$materno=$paterno=$password=$usuario=$genero=
$pais=$fecha=$ciudad=$colonia=$estado=$cp=$calle=$municipio=$fem=$mas="";

if(isset($_POST['nombre'])){

	if($_POST['password']=="" || $_POST['usuario']==""  || $_POST['nombre']=="" || 
$_POST['paterno'] =="" || $_POST['materno'] =="" ||  $_POST['genero']==""
|| $_POST['pais'] =="" || $_POST['pais'] =="Selecciona un pais" ||  $_POST['estado'] =="Selecciona un estado" || $_POST['estado'] =="" || $_POST['ciudad'] =="" || $_POST['colonia']  ==""  
|| $_POST['fecha']  =="" || $_POST['calle'] =="" || $_POST['cp'] =="" || $_POST['municipio'] =="Selecciona un municipio" || $_POST['municipio'] =="" ){

	echo $error="* Por favor verifica los datos";
	echo "<br>"; 

}else{
$nombre = htmlentities($_POST['nombre']);
$materno = htmlentities($_POST['materno']);
$paterno = htmlentities($_POST['paterno']);
$genero = htmlentities($_POST['genero']);
$password = htmlentities($_POST['password']);
$usuario = htmlentities($_POST['usuario']);
$fecha = htmlentities($_POST['fecha']);
$ciudad = htmlentities($_POST['ciudad']);
$colonia = htmlentities($_POST['colonia']);
$cp = htmlentities($_POST['cp']);
$calle = htmlentities($_POST['calle']);


$estado = htmlentities($_POST['estado']);
$municipio = htmlentities($_POST['municipio']);
$pais = htmlentities($_POST['pais']);



if($genero=='M'){	
	$mas="checked";
}else{
$fem="checked";
}
$cn=new Conexion($host, $user,$pwd,$db,$port);
$cn->conectar();

$qry ="select *from usuario where usuario='".$_POST['usuario']."'";
$result = $cn->getDatos($qry);

if(count($result)>0){
	$error="* El usuario ya existe";
	echo "<br>"; 

}else{

//add user
$qry="INSERT INTO usuario VALUES (NULL, '".$_POST["usuario"]."', '".$_POST["password"]."',
 '".$_POST["nombre"]."' ,'".$_POST["paterno"]."','".$_POST["materno"]."','".$_POST["genero"]."'
 ,'".$_POST["fecha"]."', '".$_POST["paisR"]."' 
 , '".$_POST["estadoE"]."',  '".$_POST["ciudad"]."'
 ,'".$_POST["colonia"]."','".$_POST["cp"]."'
 ,'".$_POST["calle"]."','".$_POST["municipioE"]."', 'activo')";



$res=$cn->instruccion($qry);

if($res){

	echo "<script>
	alert('Usuario registrado con exito');
</script>"; 

}else{
	echo $error="Error al registrar el usuario";
}

}

}

}




echo <<<_USU




<!DOCTYPE html>
<html>
    
<head>


	<meta charset="utf-8">
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta http-equiv="content-type" content="application/json; charset=utf-8" />

	<title>Sing Up</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/all.css">

	<script src="funciones_formularioU.js"></script>


	<script src="sweetalert2.all.min.js"></script>

<style>

@import url('https://fonts.googleapis.com/css?family=Abel|Abril+Fatface|Alegreya|Arima+Madurai|Dancing+Script|Dosis|Merriweather|Oleo+Script|Overlock|PT+Serif|Pacifico|Playball|Playfair+Display|Share|Unica+One|Vibur');

	

        body {
    background-image: linear-gradient(-225deg, #E3FDF5 0%, #fe0457 100%);
background-image: linear-gradient(to top, #a8edea 0%, #d8634b 100%);
background-attachment: fixed;
  background-repeat: no-repeat;

    font-family: 'Vibur', cursive;
/*   the main font */
    font-family: 'Abel', sans-serif;
opacity: .95;
/* background-image: linear-gradient(to top, #d9afd9 0%, #97d9e1 100%); */
margin: 0;
			padding: 0;
			height: 100%;
}

		html {
			margin: 0;
			padding: 0;
			height: 100%;
			background: #60a3bc !important;
		}




		.user_card {
			height: 700px;
			width: 500px;
			margin-top: auto;
			margin-bottom: auto;
			position: relative;
			display: flex;
			justify-content: center;
			flex-direction: column;
			padding: 10px;
			

			background: #CF6766;


			border-radius: 5px;

		}
		.brand_logo_container {
			position: absolute;
			height: 170px;
			width: 170px;
			top: -75px;
			border-radius: 50%;
			background: #8EAEBD;
			padding: 10px;
			text-align: center;
		}
		.brand_logo {
			height: 150px;
			width: 150px;
			border-radius: 50%;
			border: 2px solid white;
		}
		.form_container {
			margin-top: 100px;
		}
		.login_btn {
			width: 100%;
			color: white !important;
		}
		.login_btn:focus {
			box-shadow: none !important;
			outline: 0px !important;
		}
		.login_container {
			padding: 0 2rem;
		}
		.input-group-text {
			background: #30415D !important;
			color: white !important;
			border: 0 !important;
			border-radius: 0.25rem 0 0 0.25rem !important;
		}
		.input_user,
		.input_pass:focus {
			box-shadow: none !important;
			outline: 0px !important;
		}
		.custom-checkbox .custom-control-input:checked~.custom-control-label::before {
			background-color: #30415D !important;
		}
</style>

</head>
<!--Coded with love by Mutiullah Samim-->
<body>
	<div class="container h-100">

<br><br>
<br>


		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="imagenes/userP.png" class="brand_logo" alt="Logo">
						<br><br>

						<p style="color:black">Creación de nuevo usuario</p>

					</div>
					


				</div>

				<br><br>
				<br><br>
				<br><br>
				<br><br>

				
				<div class="d-flex justify-content-center form_container">
					<form  id="form-login" method="post" autocomplete="off" >$error
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-user-circle"></i></span>
							</div>
							<input type="text" name="usuario" id="usuario" class="form-control input_user" value="$usuario" placeholder="User@UserName.com">
						
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-key"></i></span>
							</div>
							<input type="password" name="password" id="password" class="form-control input_pass" value="$password" placeholder="Password">
						
						</div>

						


						
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-tag" ></i></span>
							</div>
							<input type="text" name="nombre"  id="nombre" class="form-control input_pass" value="$nombre" placeholder="Nombre">
				
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-male" ></i></span>
							</div>
							<input type="text" name="paterno" id="paterno"  class="form-control input_pass" value="$paterno" placeholder="Paterno">
				
						</div>


						



						
						
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-female" ></i></span>
							</div>
							<input type="text" name="materno"  id="materno" class="form-control input_pass" value="$materno" placeholder="Materno">
						
							<div class="input-group-append">

							
								<span class="input-group-text"><i  class="fa fa-mars" ></i></span>
							
						
						
  </div>
  <input type="text" disabled name="materno" class="form-control input_pass" value="" id="genero" placeholder="Sexo">

  <fieldset id="group1">

<input type="radio" value="M" name="genero" id="masculino" name="group1" $mas>Hombre
<input type="radio" value="F"  name="genero" id="femenino" name="group1" $fem>Mujer
</fieldset>
						
						</div>



						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-birthday-cake" ></i></span>
							</div>
							<input type="date" name="fecha" id="fecha" class="form-control input_pass" value="$fecha" placeholder="Nacimiento">
					
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-globe" ></i></span>
							</div>
				
							<select name="pais" id="pais" value="$pais" class="form-control input_pass">
						
							<option value="Selecciona un pais">Selecciona un pais</option>

							<option value="Mexico">Mexico</option>
							<option value="Ecuador">Ecuador</option>
							<option value="Usa">Usa</option>


							</select>


						</div>

						
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-street-view" ></i></span>
							</div>
					
							<select name="estado" id="estado" value="$estado" class="form-control input_pass">
						
							<option value="Selecciona un estado">Selecciona un estado</option>

							<option value="Mexico">Mexico</option>
							<option value="Ecuador">Ecuador</option>
							<option value="Usa">Usa</option>


							</select>



							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-building" ></i></span>
							</div>
							<input type="text" name="ciudad" id="ciudad" class="form-control input_pass" value="$ciudad" placeholder="Ciudad">
					
						</div>
				
					
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-road" ></i></span>
							</div>
							<input type="text" name="colonia" id="colonia" class="form-control input_pass" value="$colonia" placeholder="Colonia">
					
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-map-marker" ></i></span>
							</div>
							<input  type="number" maxlength="5" min="5" oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" name="cp" id="cp" class="form-control input_pass" value="$cp" placeholder="CP">
					
						</div>



						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-home" ></i></span>
							</div>
							<input type="text" name="calle" id="calle" class="form-control input_pass" value="$calle" placeholder="Calle">
						
							<div class="input-group-append">
							<span class="input-group-text"><i  class="fa fa-street-view" ></i></span>
						</div>
							<select name="municipio" id="municipio" value="$municipio" class="form-control input_pass">
						
							<option value="Selecciona un municipio">Selecciona un municipio</option>



							</select>
						


							<input type="text" name="estadoE" id="estadoE" class="form-control input_pass"  style='display:none;'> 
							<input type="text" name="municipioE" id="municipioE" class="form-control input_pass"   style='display:none;'>
							<input type="text" name="paisR" id="paisR" class="form-control input_pass"   style='display:none;'>

							</div>



							<div class="d-flex justify-content-center mt-3 login_container">
				 	<button type="submit"  style=" background: #30415D; color:white;" name="enviar" id="enviar" onclick='validarFormulario();' class="btn login_btn">Sign Up</button>
				   </div>
				
				   <div class="d-flex justify-content-center mt-3 login_container">
					<button type="reset"  style=" background: #30415D; color:white;" id="reset"  class="btn login_btn">Limpiar</button>
				  </div>
				
				
				
				</div>





			</form>


			

		
				<div class="mt-4">
					<div class="d-flex justify-content-center links">
					¿Ya tienes una cuenta? <a  style="text-decoration:none; font-style: oblique;"href="index.php" class="ml-2">Login</a>
					</div>
					
				</div>
			</div>
		</div>
	</div>

	
	
	<script src="validateSingUp.js">
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>

	<script src="funciones_formularioU.js"></script>
	

	<script>

	$('#estado').on('change', function (e) {
		var optionSelected = $("option:selected", this);
		var valueSelected = this.value;
		
		var x= document.getElementById("estadoE").value=valueSelected;

	});


	
	
	</script>



	<script>

	$('#municipio').on('change', function (e) {
		var optionSelected = $("option:selected", this);
		var valueSelected = this.value;
	document.getElementById("municipioE").value=valueSelected;



alert(x);


	});

	</script>


	<script>

	$('#pais').on('change', function (e) {
		var optionSelected = $("option:selected", this);
		var valueSelected = this.value;
		document.getElementById("paisR").value=valueSelected;



	});
	
	
	</script>


<script>



</body>



</html>

_USU;
?>
