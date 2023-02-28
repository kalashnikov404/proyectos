<?php
 
if(isset($_SESSION["loggedin"]) && $_SESSION["loggedin"] === true){
    header("location: home.php");
    exit;
}
 
//$con=mysqli_connect("itzitacuaro.edu.mx","itzitacu_usereq1","ypP.In8?rDN9","itzitacu_eq1");


$cnn = new mysqli("localhost","root","root","petishop");

require_once "conexion.php";
 
$username = $password = "";
$username_err = $password_err = $login_err = "";
 
if($_SERVER["REQUEST_METHOD"] == "POST"){
 
    if(empty(trim($_POST["username"]))){
        echo  $username_err = "* Por favor ingresa el usuario.";
        echo "<br>"; 
    } else{
        $username = trim($_POST["username"]);

      


    }
    
    if(empty(trim($_POST["password"]))){
        echo $password_err = "* Por favor ingresa el password. <br>";
        echo "<br>"; 
    } else{
        $password = trim($_POST["password"]);


    
    }
    
    if(empty($username_err) && empty($password_err)){
        // Prepare a select statement
        $sql = "SELECT cve_usu, email_usu, password_usu FROM usuario WHERE email_usu = '$username' && password_usu= '$password'  ";


            $result = mysqli_query($cnn,$sql) or die("Problemas al iniciar".mysqli_error($cnn));
            $rows = mysqli_num_rows($result);
                
                if($rows == 1){                    
                    
                                              // Password is correct, so start a new session
                            session_start();
                            
                            // Store data in session variables
                            $_SESSION["loggedin"] = true;
                            $_SESSION["id"] = $id;
                            $_SESSION["username"] = $username;     
                       
                            
                            header("location: home.php");
                        } else{
                           
                            echo '<div id="msg"><h3>Usuario o Password incorrecto.</h3></div>
                            ';


                        }
                    }
          

        }
    
    
        

        

?>
 

 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/login.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/all.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  
  
    <title>Login</title>


<style>
@import url('https://fonts.googleapis.com/css?family=Abel|Abril+Fatface|Alegreya|Arima+Madurai|Dancing+Script|Dosis|Merriweather|Oleo+Script|Overlock|PT+Serif|Pacifico|Playball|Playfair+Display|Share|Unica+One|Vibur');


/* Responsive Mobile section */
@media screen and (max-width:360px){
  


/* End body rules */

/* Start form  attributes */
form {
    width: 250px;
    min-height: 300px;
    height: auto;
    border-radius: 5px;
    margin: 2% auto;
    box-shadow: 0 9px 50px hsla(20, 67%, 75%, 0.31);
    padding: 2%;
    background-image: linear-gradient(-225deg, #E3FDF5 50%, #fa246f 50%);
}
/* form Container */

/* the header form form */
header {
    margin: 2% auto 10% auto;
    text-align: center;
}
/* Login title form form */
header h2 {
    font-size: 250%;
    font-family: 'Playfair Display', serif;
    color: #3e403f;
}
/*  A welcome message or an explanation of the login form */
header p {letter-spacing: 0.02em;}


}
</style>

</head>
<body>

 

<div class="overlay">
<!-- LOGN IN FORM by Omar Dsoky -->
<form form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]) ?>" method="post" autocomplete="off"  ">
   <!--   con = Container  for items in the form-->
   <div class="con">
   <!--     Start  header Content  -->
   <header class="head-form">
      <h2 style="color:black">Inicio de sesión</h2>

      <img src="imagenes/login.png" height="150px" width="180px" center>
      <!--     A welcome message or an explanation of the login form -->
      <p style="color:black">Inicia sesión usando un usuario y contraseña</p>
   </header>
   <!--     End  header Content  -->
   <br>
   <div class="field-set">
     
      <!--   user name -->
         <span style=" background: #30415D;" class="input-item">
           <i style="color: white;" class="fa fa-user-circle"></i>
         </span>
        <!--   user name Input-->
         <input class="form-input" id="user" type="text" placeholder="@UserName"  name="username" class="form-control <?php echo (!empty($username_err)) ? 'is-invalid' : ''; ?>" value="<?php echo $username; ?>">
         <span class="invalid-feedback"><?php echo $username_err; ?></span>

      <br>
     
           <!--   Password -->
     
      <span style=" background: #30415D;" class="input-item">
        <i style="color: white;" class="fa fa-key"></i>
       </span>
      <!--   Password Input-->
      <input class="form-input" id="password" type="password" placeholder="Password"  name="password"  class="form-control <?php echo (!empty($password_err)) ? 'is-invalid' : ''; ?>">
      <span class="invalid-feedback"><?php echo $password_err; ?></span>

<!--      Show/hide password  -->
     <span>
        <i  class="fa fa-eye" aria-hidden="true"  type="button" id="eye"></i>
     </span>
     
     
      <br>
<!--        buttons -->
<!--      button LogIn -->
      <button  style=" background: #30415D; color:white;" class="log-in" id="btnLogin" type="submit" >Iniciar sesión </button>
   </div>
  
<!
     
<div class="mt-4">
					<div class="d-flex justify-content-center links">
                    ¿No tienes una cuenta? <a style="text-decoration:none; font-style: oblique;" href="singUp.php" class="ml-2">&nbsp;Sign Up</a>
					</div>
					<div class="d-flex justify-content-center links">
						<a style="text-decoration:none; font-style: oblique;"  href="forgotPassword.php">¿Olvidaste tu contraseña?</a>
					</div>
				</div>
			</div>
		</div>


<!--   End Conrainer  -->
  </div>
  
  <!-- End Form -->
</form>
</div>
</body>
<script src="js/login.js"></script>







</script>

</html>