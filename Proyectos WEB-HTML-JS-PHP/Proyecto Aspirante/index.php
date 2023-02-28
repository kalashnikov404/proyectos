<?php
// Initialize the session
session_start();
 
// Check if the user is already logged in, if yes then redirect him to welcome page
if(isset($_SESSION["loggedin"]) && $_SESSION["loggedin"] === true){
    header("location: home.php");
    exit;
}
 
//$con=mysqli_connect("itzitacuaro.edu.mx","itzitacu_usereq1","ypP.In8?rDN9","itzitacu_eq1");


$cnn = new mysqli("itzitacuaro.edu.mx","itzitacu_usereq1","ypP.In8?rDN9","itzitacu_eq1");

// Include config file
require_once "conexion.php";
 
// Define variables and initialize with empty values
$username = $password = "";
$username_err = $password_err = $login_err = "";
 
// Processing form data when form is submitted
if($_SERVER["REQUEST_METHOD"] == "POST"){
 
    // Check if username is empty
    if(empty(trim($_POST["username"]))){
        $username_err = "Por favor ingresa el usuario.";
    } else{
        $username = trim($_POST["username"]);

      


    }
    
    // Check if password is empty
    if(empty(trim($_POST["password"]))){
        $password_err = "Por favor ingresa el password.";
    } else{
        $password = trim($_POST["password"]);


    
    }
    
    // Validate credentials
    if(empty($username_err) && empty($password_err)){
        // Prepare a select statement
        $sql = "SELECT id, username, password FROM usuario WHERE username = '$username' && password= '$password'  ";


            $result = mysqli_query($cnn,$sql) or die("Problemas al insertar".mysqli_error($cnn));
            $rows = mysqli_num_rows($result);
                
                // Check if username exists, if yes then verify password
                if($rows == 1){                    
                    // Bind result variables
                    
                                              // Password is correct, so start a new session
                            session_start();
                            
                            // Store data in session variables
                            $_SESSION["loggedin"] = true;
                            $_SESSION["id"] = $id;
                            $_SESSION["username"] = $username;     
                       
                            
                            // Redirect user to welcome page
                            header("location: home.php");
                        } else{
                           
                            echo '<div id="msg"><h3>Usuario o Password incorrecto.</h3></div>
                            ';


                        }
                    }
          

            // Close statement
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
<form form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post" autocomplete="off">
   <!--   con = Container  for items in the form-->
   <div class="con">
   <!--     Start  header Content  -->
   <header class="head-form">
      <h2>Inicio de sesión</h2>

      <img src="imagenes/user.png" height="150px" width="180px" center>
      <!--     A welcome message or an explanation of the login form -->
      <p>Inicia sesión usando un usuario y contraseña</p>
   </header>
   <!--     End  header Content  -->
   <br>
   <div class="field-set">
     
      <!--   user name -->
         <span class="input-item">
           <i class="fa fa-user-circle"></i>
         </span>
        <!--   user name Input-->
         <input class="form-input" id="txt-input" type="text" placeholder="@UserName" required name="username" class="form-control <?php echo (!empty($username_err)) ? 'is-invalid' : ''; ?>" value="<?php echo $username; ?>">
         <span class="invalid-feedback"><?php echo $username_err; ?></span>

      <br>
     
           <!--   Password -->
     
      <span class="input-item">
        <i class="fa fa-key"></i>
       </span>
      <!--   Password Input-->
      <input class="form-input" type="password" placeholder="Password" id="pwd"  name="password" required class="form-control <?php echo (!empty($password_err)) ? 'is-invalid' : ''; ?>">
      <span class="invalid-feedback"><?php echo $password_err; ?></span>

<!--      Show/hide password  -->
     <span>
        <i class="fa fa-eye" aria-hidden="true"  type="button" id="eye"></i>
     </span>
     
     
      <br>
<!--        buttons -->
<!--      button LogIn -->
      <button class="log-in" type="submit" >Iniciar sesión </button>
   </div>
  
<!
     
<!--   End Conrainer  -->
  </div>
  
  <!-- End Form -->
</form>
</div>
</body>
<script src="js/login.js"></script>

</html>