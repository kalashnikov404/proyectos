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
    <title>PetiShop</title>
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
  text-decoration: none;

}

#demotext {
color: rgb(255, 255, 255);
text-shadow: rgb(255, 255, 255) 0px 0px 5px, rgb(255, 255, 255) 0px 0px 10px, rgb(255, 255, 255) 0px 0px 15px, rgb(255, 45, 149) 0px 0px 20px, rgb(255, 45, 149) 0px 0px 30px, rgb(255, 45, 149) 0px 0px 40px, rgb(255, 45, 149) 0px 0px 50px, rgb(255, 45, 149) 0px 0px 75px;
--darkreader-inline-color: #e8e6e3;
--darkreader-inline-bgimage: none;
}

.header{
  background:  #CF6766;
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
  background: #30415D !important;
  border-radius: 5px !important;

height: 70px !important;
width: 80px !important;


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
  padding: 4px 10px;
}

ul li .qr{
    display: none;
  }

.close {
  transition: 0.4s;
  color: #ffffff;
  font-size: 20px;
  text-decoration: none;
  padding: 4px 8px;
}
.close:hover {
  background-color: #ffffff;
  color: #729FEB;
  padding: 4px 8px;
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

#header{
	margin: auto;
	width: 500px;
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
  background-image: url("imagenes/back.png");
  height: 100vh;
  background-position: center;
  background-size: cover;
}

    
li:hover > a .fa-caret-down {
  display:none;
}

#up_arrow {
  position:relative;
  width:20px;
  height:20px;
  left:42%;
  top:-10px;
  background-color:aliceblue;
  transform:rotate(45deg);
}

#header > nav > ul > .dropdown:hover {
  border-bottom:none;
}
#header > nav > ul > .drop:hover >  .dd
{
  display:block;
}
.drop:hover > a .fa-caret-down {
  display:none;
}


#up_arrow  > ul {
  position:absolute;

  display:none;
 
}


ul
{
    font-family: Arial, Verdana;
    font-size: 14px;
    margin: 0;
    padding: 0;
    list-style: none;
}

ul li
{
    display: block;
    position: relative;
    float: left;
}

li ul
{
  
    display: none;
}

ul li a 
{
    display: block;
    text-decoration: none;
    color: #ffffff;
    border-top: 1px solid #ffffff;
    padding: 5px 10px 5px 10px;
    margin-left: 1px;
    white-space: nowrap;
}

li:hover ul 
{
    display: block;
    position: absolute;
}

li:hover li
{
    float: none;
    font-size: 11px;
}

li:hover a 
{
    background: #617F8A;
}

li:hover li a:hover 
{
    background: #95A9B1;
}



</style>

  </head>
  <body >


    <div class="header">
<nav>
      <input type="checkbox" id="check" />
      <label for="check" class="checkbtn">
        <i class="fas fa-bars" id="openbtn"></i>
      </label>

      <div  class="logo" style="font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif"> <img src="imagenes/header.png" height="80px" width="200px"">  </div>
      <ul class="nav">
       
      
      
      
      <li><a href="#" class="active">Home</a></li>
      <li><a class="link-3" href="formularioUsuario.php">Usuarios&nbsp</a></li>





        <li><a class="link-3" href="formularioVenta.php">Ventas&nbsp;</a>
      
      
      
      </li>
        <li><a class="link-3" href="formularioProducto.php">Productos&nbsp;<i class="fa fa-caret-down"></i> </a>
        <ul >
       
        <li><a href="promociones.php">Promociones</a></li>
        </ul>
      
      </li>
      



        <li><a   class="close" <?php echo htmlspecialchars($_SESSION["username"]); ?> href="logout.php">Cerrar sesión</a></li>

      </ul>
      


      </nav>

    </div>

    <div class="main">
    <div id="demotext" style="font-family: cursive; font-size:20px; font-weight: bold; color:#031424;"">Hola, <b style="font-weight: bold; color:#031424"><?php echo htmlspecialchars($_SESSION["username"]); ?></b></div>

    </div>
  </body>
</html>