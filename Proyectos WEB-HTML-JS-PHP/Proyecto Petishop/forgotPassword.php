
<?php

$cnn = new mysqli("localhost","root","root","petishop");

require_once "conexion.php";

require_once 'data.php';


$username = $password = $password2= "";
$username_err = $password_err = $password2_err= $login_err = "";

if($_SERVER["REQUEST_METHOD"] == "POST"){

if(empty(trim($_POST["username"]))){
	echo $username_err = "* Por favor ingresa el usuario.";
	echo "<br>"; 

} else{
	$username = trim($_POST["username"]);

  


}

if(empty(trim($_POST["password"]))){
	echo $password_err = "* Por favor ingresa el password.";
	echo "<br>"; 

} else{
	$password = trim($_POST["password"]);



}


if(empty(trim($_POST["password2"]))){
	echo $password_err = "* Por favor ingresa la confirmacion de password.";
	echo "<br>"; 

} else{
	$password = trim($_POST["password2"]);



}

if(empty($username_err) && empty($password_err) && empty($password2_err)){
	// Prepare a select statement
	$sql = "SELECT cve_usu, email_usu, password_usu FROM usuario WHERE email_usu = '$username'";


		$result = mysqli_query($cnn,$sql) or die("Problemas al acceder".mysqli_error($cnn));
		$rows = mysqli_num_rows($result);
			
			if($rows == 1){            
				$sql = "UPDATE usuario SET password_usu = '".$_POST["password2"]."' WHERE email_usu = '".$_POST["username"]."'";

				$result = mysqli_query($cnn,$sql) or die("Problemas al actualizar usuario".mysqli_error($cnn));

			echo '<script>
			alert("Password actualizado");
			</script>';
			
			} else{
                           
				echo '<script>
			alert("Error al actualizar, verifica los campos");
			</script>';


			}
		}


}



echo <<<_PAS

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
    <html lang="en">
		<meta charset="utf-8">
<head>
	<title>Sing Up</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/all.css">
	<script src="validatePassword.js"></script>

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
			height: 550px;
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
						<img src="imagenes/forgot.png" class="brand_logo" alt="Logo">
						<br><br>

						<p style="color:black">Actualizar contraseña olvidada</p>

					</div>
					


				</div>

				<br><br>
				<br><br>
				<br><br>
				<br><br>

				
				<div class="d-flex justify-content-center form_container">
					<form id="form-login" method="post" autocomplete="off" >
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-user-circle"></i></span>
							</div>
							<input type="text" name="username" id="username" class="form-control input_user" value="" placeholder="@UserName">
						
						
						
						</div>

						

                        <div class="input-group mb-3">
                        <div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-key"></i></span>
							</div>
							<input type="password" name="password"  id="password" class="form-control input_pass" value="" placeholder="Password">
						
						</div>


                        <div class="input-group mb-3">
                        <div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-key"></i></span>
							</div>
							<input type="password" name="password2" id="password2" class="form-control input_pass" value="" placeholder="Confirm Password">
						
						</div>





							<div class="d-flex justify-content-center mt-3 login_container">
				 	<button type="submit"  style=" background: #30415D; color:white;" onclick='validarFormulario();' name="button" class="btn login_btn">Update</button>
				   </div>



				   <div class="d-flex justify-content-center mt-3 login_container">
				   <button type="reset"  style=" background: #30415D; color:white;" name="button" class="btn login_btn">Limpiar</button>
				 </div>


					</form>
				</div>



		
				<div class="mt-4">
					<div class="d-flex justify-content-center links">
					¿Ya tienes una cuenta? <a  style="text-decoration:none; font-style: oblique;"href="index.php" class="ml-2">Login</a>
					</div>
					
				</div>
			</div>
		</div>
	</div>

</body>

	<script src="validatePassword.js"></script>
</html>





_PAS;

?>
