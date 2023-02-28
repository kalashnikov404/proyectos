<?php

if(isset($_SESSION["loggedin"]) && $_SESSION["loggedin"] === true){
    header("location: Home.php");
    exit;
}
 


$cnn = new mysqli("localhost","root","root","cri");

require_once "conexion.php";
 
$emailuser = $password = $username= $u=$remail= $pass="";
$error="";


$username_err = $emailuser_err = $password_err = $login_err = $remail_err="";

if ($_SERVER["REQUEST_METHOD"] == "POST") {

	if (empty(trim($_POST["username"]))) {
		echo $username_err = "* Por favor ingresa el usuario o email de usuario.";
		echo "<br>";
	} else {
		$username = trim($_POST["username"]);
		$emailuser = trim($_POST["username"]);
		$email = "";


	}

	if (empty(trim($_POST["password"]))) {
		echo $password_err = "* Por favor ingresa el password. <br>";
		echo "<br>";
	} else {
		$password = trim($_POST["password"]);



	}

}
	
    
          

    
    
        

        

					?>
<!DOCTYPE HTML>
<html lang="es">

<head>
	<title>CRI Zitácuaro</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content="Triple Forms Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
	<link href="images/fav.ico" rel="shortcut icon" type="images/x-icon" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>


	<!-- Meta tag Keywords -->

	<!-- css files -->
	<link rel="stylesheet" href="css/Index.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->

	<!-- web-fonts -->
	<link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext"
	 rel="stylesheet">
	<!-- //web-fonts -->
</head>
<body>
	
	<div class="main-bg">
		<!-- title -->
		<h1 class="title" >Inicio de sesión</h1>
		<!-- //title -->
		<div class="sub-main-w3">
			<div class="image-style">

			</div>
			<div class="vertical-tab">
				<div id="section1" class="section-w3ls">
					<input type="radio" name="sections" id="option1" checked>
					<label for="option1" class="icon-left-w3pvt"><span class="fa fa-user-circle" aria-hidden="true"></span>Inicar sesión</label>
					<article>
						<form id="formInicio" method="post" autocomplete="off">
							<h3 class="legend">Introduce tus credenciales</h3>
							<div class="input">
								<span class="fa fa-user" aria-hidden="true"></span>
								<input type="text" placeholder="Email" name="username" id="username" required />
							</div>
							<div class="input">
								<span class="fa fa-key" aria-hidden="true"></span>
								<input type="password" placeholder="Password" name="password" id="password" required />
								<i  class="fa fa-eye" aria-hidden="true"  type="button" id="eye"></i>

							
							</div>
							<button type="submit" class="btn submit" id="btn-login">Ingresar</button>
							<a href="#" class="bottom-text-w3ls">¿Olvidaste la contraseña?</a>
						</form>
					</article>
				</div>
			
				<div id="section3" class="section-w3ls">
					<input type="radio" name="sections" id="option3">
					<label for="option3" class="icon-left-w3pvt"><span class="fa fa-lock" aria-hidden="true"></span>¿Olvidaste la contraseña?</label>
					<article>

						<form id="form" method="POST" action="javascript:buscarUsuario();">
							<h3 class="legend last">Restablecer contraseña</h3>
							<p class="para-style-2"><strong>¿Necesitas ayuda?</strong></p>
							<p class="para-style">Ingresa tu email para recibir tu contraseña</p>

							<div class="input">
								<span class="fa fa-envelope" aria-hidden="true"></span>
								<input type="email" placeholder="Email" name="email" id="email" />
							</div>
							<div id="contenedor" style="display:none">
							</div>
							<button type="submit" class="btn submit last-btn" id="btn-reset">Restablecer contraseña</button>

						</form>
					</article>
				</div>

				
			</div>
			<!-- //vertical tabs -->
			<div class="clear"></div>
		</div>

		<?php


if(isset($_POST["username"]) && isset($_POST["password"])){
	// Prepare a select statement
	$sql = "SELECT id_usuario, nombre_usuario, contrasena_usuario, email_usuario FROM usuario WHERE    email_usuario = '$emailuser' AND contrasena_usuario= '$password' OR nombre_usuario = '$username'  AND contrasena_usuario= '$password' ";
	$sql2=" SELECT email_usuario from usuario where nombre_usuario= '$username' OR email_usuario='$emailuser'";

		$result = mysqli_query($cnn,$sql) or die("Problemas al iniciar".mysqli_error($cnn));
		$result2 = mysqli_query($cnn,$sql2) or die("Problemas al iniciar".mysqli_error($cnn));

	

		$rows = mysqli_num_rows($result);
		$rows2 = mysqli_num_rows($result2);

			if($rows == 1){  
				
				
				$res = mysqli_fetch_array($result2);

				$usemail = $res['email_usuario'];
				
										  // Password is correct, so start a new session
						session_start();
						
						// Store data in session variables
						$_SESSION["loggedin"] = true;
						$_SESSION["id"] = $id;
						$_SESSION["username"] = $usemail;   

				   
						
						header("location: Home.php");
					} else{
					   

						echo "<script >
						

						
						Swal.fire({
							icon: 'error',
							title: 'Oops... ocurrio un error',
							text: '¡Tu usuario no existe o es incorrecto!',
							footer: '<a>¡Verifica e intentalo nuevamente!</a>'
						  })


													  </script>";


					}
				}
		?>
		
		<!-- copyright -->
		<div  class="copyright">
			<h2 style="color: black;">&copy; 2023 Todos los derechos reservados | Desarrollado por
				<a  target="_blank">CRI ZITÁCUARO</a>
			</h2>
		</div>
	</div>

	<script src="js/FuncionEmail.js"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<script>
	function show() {
    var p = document.getElementById('password');
    p.setAttribute('type', 'text');
}

function hide() {
    var p = document.getElementById('password');
    p.setAttribute('type', 'password');
}

var pwShown = 0;

document.getElementById("eye").addEventListener("click", function () {
    if (pwShown == 0) {
        pwShown = 1;
        show();
    } else {
        pwShown = 0;
        hide();
    }
}, false);
</script>


<script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/@emailjs/browser@3/dist/email.min.js">
</script>
<script type="text/javascript">
   (function(){
      emailjs.init("service_k0in8ln");
   })();
</script>

<script type="text/javascript">
   (function(){
      emailjs.init("h1ONTOy8HEW_BEJMc");
   })();
</script>





</body>

</html>