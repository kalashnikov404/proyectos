
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
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/all.css">
    <link rel="stylesheet" type="text/css" href="css/estilos2.css">


    <script src="validateDevolucion.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

 <!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
 <!-- Font Awesome CSS -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

 <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
 <link href='https://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext' rel='stylesheet' type='text/css'> 

 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>  
    
    <script src="funciones_formularioV.js"></script>

<link rel="stylesheet" href="style.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>



 <!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
 <!-- Font Awesome CSS -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

 <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
 <link href='https://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext' rel='stylesheet' type='text/css'> 

<style>

.main{
            margin-top: 70px;
       }
       .form-group{
           margin-bottom: 15px;
       }
       
       
       

       select, select::-webkit-input-placeholder{

        font-size: 15px;
        padding-top: 10px;
       }



       input,
       input::-webkit-input-placeholder {
           font-size: 11px;
           padding-top: 3px;
       }
       
       .main-loginRE{
            background-color: #e0211a;
           /* shadows and rounded borders */
           -moz-border-radius: 5px;
           -webkit-border-radius: 5px;
           border-radius: 5px;
           -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
           -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
           box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
       
       }
       
       label{
           margin-bottom: 15px;
           font-size:18px;
       }
       .main-center{
            margin-top: 30px;
            margin: 0 auto;
            max-width: 330px;
           padding: 40px 40px;
       
       }
       
       .login-button{
           margin-top: 5px;
       }
       
       .login-register{
           font-size: 12px;
           text-align: center;
           text-decoration:underline;
           color:#5CB85C;
           font-weight:bold;
       }

       .iconbk{
           background-color:#060606;

       }
       

   a {
    text-decoration: none;
    text-transform: uppercase;
    font-size: 30px;
}
a span {
    padding: 15px;
    transition: .5s;
    position: relative;
}
a span:nth-child(1) {
    color: #fff;
    background: #262626;
}
a span:nth-child(2) {
    color: #fff;
    background: #ff3636;
}
a span:nth-child(1):before {
    content: attr(data-attr);
    position: absolute;
    top: 0;
    left: 0;
    background: #ff3636;
    padding: 15px;
    transition: 0.5S;
    transform-origin: top;
    transform: rotateX(90deg) translateY(-50%);
}
a:hover span:nth-child(1):before {
    transform: rotateX(0deg) translateY(0%);
} 
a span:nth-child(2):before {
    content: attr(data-attr);
    position: absolute;
    top: 0;
    left: 0;
    background: #262626;
    padding: 15px;
    transition: 0.5S;
    transform-origin: bottom;
    transform: rotateX(90deg) translateY(50%);
}
a:hover span:nth-child(2):before {
    transform: rotateX(0deg) translateY(0%);
} 
a  span:nth-child(1):after {
  content: attr(data-attr);
  padding: 15px;
  position: absolute;
  top: 0;
  left: 0;
  background: #262626;
  transform-origin: bottom;
  transform: rotateX(0deg) translateY(0%);
  transition: 0.5s;
}
a:hover span:nth-child(1):after {
  transform: rotateX(90deg) translateY(50%);
}
a span:nth-child(2):after {
    content: attr(data-attr);
    position: absolute;
    top: 0;
    left: 0;
    background: #ff3636;
    padding: 15px;
    transition: 0.5S;
    transform-origin: top;
    transform: rotateX(0deg) translateY(0%);
}
a:hover span:nth-child(2):after {
    transform: rotateX(90deg) translateY(-50%);
} 



#form-login{

position: absolute;
  top: 20%;
  left: 50%;
  transform: translate(-50%, -50%);
}

</style>
    


</head>


<body>




<div class="center">
    <a href="home.php"><span data-attr="Exit">Exit</span><span data-attr="Exit">Exit</span></a>
</div>




<legend id="head2" style="font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif; color: rgb(255, 255, 255); font-size: 40px;" class="text-center header">Tabla de datos de las ventas</legend>


<!--form de estudiante-->
<div class="xd">



<div class="py-5 text-center">
  <img class="d-block mx-auto mb-4" src="imagenes/new3.png" alt="" width="300" height="95">
  <h2>Devoluciones</h2>

</div>

   
  <div class="col-md-7 col-lg-8">
    <form  id="form-login" method="post" autocomplete="off" action="javascript:devolverP();">
      <div class="row g-3">
        

        <div class="col-12">
          <label for="username" class="form-label">Nombre</label>
          <div class="input-group has-validation">
            <span class="input-group-text">@</span>
            <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Marco" >
       
          </div>
        </div>

        <div class="col-12">
          <label for="email" class="form-label">Email</label>
          <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com">
         
        </div>

        <div class="col-12">
          <label for="address" class="form-label">Motivo</label>
          <input type="text" class="form-control" id="motivo" name="motivo"  placeholder="Defecto de fabrica" >
          
        </div>




    

      <hr class="my-4">



      <button class="w-100 btn btn-primary btn-lg"  type="submit">Devolver</button>
    </form>
  </div>
</div>

</div>


<div class="consult">



 
</div>
<div class="container2" >

    <br>
    <br>

<div id="contenedor"></div>

</div>

<input type="text" style="display: none;" class="form-control" id="cook" name="cook"  placeholder="Defecto de fabrica" >

<div id="mg"></div>
</body>
<script src="https://kit.fontawesome.com/651bb91b75.js" crossorigin="anonymous"></script>
<script src="jquery-1.7.2.min.js"></script>
    <script src="cart.js"></script>
    <script src="https://kit.fontawesome.com/651bb91b75.js" crossorigin="anonymous"></script>

<script src="validateDevolucion.js"></script>





</html>