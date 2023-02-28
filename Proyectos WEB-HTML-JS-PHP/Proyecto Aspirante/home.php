<?php
// Initialize the session
session_start();
 
// Check if the user is logged in, if not then redirect him to login page
if(!isset($_SESSION["loggedin"]) || $_SESSION["loggedin"] !== true){
    header("location: index.php");
    exit;
}
?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Administrador escolar</title>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    

<style type="text/css"> 

/* #FF155C
#7DA4AC
*/

@import url(https://fonts.googleapis.com/css?family=Raleway);

        /* styles for browsers larger than 960px; */


        *{
  margin: 0;
  padding: 0;
  text-decoration: none;
  list-style: none;
  box-sizing: border-box;
}



.header{
  background:  #FF5E5E;
  width: 100%;
  height: 80px;
padding: 0 60px;
}

.logo{
  color: #f2f2f2;
  font-size: 25px;
  font-weight: bold;
  display: inline-block;
  line-height: 80px;
}
.active{
  background: #8080FF;
  border-radius: 5px;
}

ul{
  display: inline-block;
  position: absolute;
  right: 0;
  line-height: 80px;
  padding: 0 60px;
  font-family: sCambria, Cochin, Georgia, Times, 'Times New Roman', serif;

}


.link-3 {
  transition: 0.4s;
  color: #ffffff;
  font-size: 20px;
  text-decoration: none;
  padding: 0 10px;
  margin: 0 10px;
}
.link-3:hover {
  background-color: #ffffff;
  color: #729FEB;
  padding: 24px 10px;
}

ul li .qr{
    display: none;
  }

.close {
  transition: 0.4s;
  color: #ffffff;
  font-size: 20px;
  text-decoration: none;
  padding: 0 10px;
  margin: 0 10px;
}
.close:hover {
  background-color: #ffffff;
  color: #729FEB;
  padding: 24px 10px;
}


.qr {
  transition: 0.4s;
  color: #ffffff;
  font-size: 20px;
  text-decoration: none;
  padding: 0 10px;
  margin: 0 10px;
}
.qr:hover {
  background-color: #ffffff;
  color: #729FEB;
  padding: 24px 10px;
}


ul li{
  display: inline-block;
}

ul li a{
  text-decoration: none;
  color: #ffffff;
  font-size: 18px;
  margin-right: 10px;
  padding: 10px 20px;
}



/*  mobile icon bars */
#check{
  display: none;
}

.checkbtn{
  font-size: 30px;
  color: #ffffff;
  position: absolute;
  right: 20px;
  top: 20px;
  display: none;
}

/* main content section */
.main{
  background-image: url("imagenes/fondo.jpg");
  height: 100vh;
  background-position: center;
  background-size: cover;
}

    




    @media(max-width:758px) {
  .header{
    padding: 0 0px;
  }


  .main{
  height: 130vh;

}

  ul{
    position: absolute;
    top:80px;
    right: 0;
    background: #FF8080;
    width: 100%;
    height: 140%;
    text-align: center;
    left: -100%;
    transition: 0.8s;

    font-family: sCambria, Cochin, Georgia, Times, 'Times New Roman', serif;

  }

  ul li .link-3{
    display: none;
  }


  ul li .qr{
    display: block;
  }

  ul li .qr a:hover{
    color: #FF155C;
  border-radius: 5px;

  }

  .checkbtn{
    display: block;
  }

  #check:checked ~ ul
{
  left: 0;
}


}



</style>

  </head>
  <body >


    <div class="header">

      <input type="checkbox" id="check" />
      <label for="check" class="checkbtn">
        <i class="fas fa-bars" id="openbtn"></i>
      </label>

      <div  class="logo" style="font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif">Administrador</div>
      <ul>
        <li><a href="#" class="active">Home</a></li>
        <li><a class="link-3" href="formularioEvento.php">Eventos</a></li>
        <li><a class="link-3" href="formularioAspirante.php">Aspirantes</a></li>
        <li><a class="link-3" href="formularioVinculacion.php">Vinculación</a></li>

        <li><a class="link-3" href="formularioReporte.php">Reportes</a></li>
        <li><a  class="qr"  href="funcionQR.php">Scanner</a></li>


        <li><a class="close" <?php echo htmlspecialchars($_SESSION["username"]); ?> href="logout.php">Cerrar sesión</a></li>

      </ul>

    </div>

    <div class="main">
    <div style="font-family: cursive; font-size:16px;">Hola, <b><?php echo htmlspecialchars($_SESSION["username"]); ?></b></div>

    </div>
  </body>
</html>