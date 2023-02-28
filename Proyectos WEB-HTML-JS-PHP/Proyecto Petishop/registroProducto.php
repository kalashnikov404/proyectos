
<?php
// Initialize the session
session_start();
 
// Check if the user is logged in, if not then redirect him to login page
if(!isset($_SESSION["loggedin"]) || $_SESSION["loggedin"] !== true){
    header("location: index.php");
    exit;
}


require_once 'conexion.php';
require_once 'data.php';

$error="";


$nombre=$codigo=$tipo=$existencia=$descripcion=$imagen=$precio=$garantia=$promocion="";

if(isset($_POST['nombre'])){

	if($_POST['nombre']=="" || $_POST['codigo']==""  || $_POST['tipo']=="" || 
    $_POST['existencia'] =="" || $_POST['descripcion'] =="" 
	|| $_POST['precio'] =="" || $_POST['garantia'] =="" || $_POST['promocion'] ==""
	|| $_POST['img'] ==""){

		echo $error="Por favor verifica los datos";
}else{
$nombre = htmlentities($_POST['nombre']);
$codigo = htmlentities($_POST['codigo']);
$tipo = htmlentities($_POST['tipo']);
$existencia = htmlentities($_POST['existencia']);
$descripcion = htmlentities($_POST['descripcion']);
$img = htmlentities($_POST['img']);
$precio = htmlentities($_POST['precio']);
$garantia = htmlentities($_POST['garantia']);
$promocion = htmlentities($_POST['promocion']);

$cn=new Conexion($host, $user,$pwd,$db,$port);
$cn->conectar();

$qry ="select *from producto where codigo='".$_POST['codigo']."'";
$result = $cn->getDatos($qry);

if(count($result)>0){
	echo $error="EL producto ya existe";
}else{

//add user
$qry="INSERT INTO producto VALUES (NULL, '".$_POST["nombre"]."', '".$_POST["codigo"]."',
 '".$_POST["tipo"]."' ,'".$_POST["existencia"]."','".$_POST["descripcion"]."','".$_POST["img"]."'
 ,'".$_POST["precio"]."', '".$_POST["garantia"]."' 
 ,'".$_POST["promocion"]."', 'activo')";

 $image=$_FILES['imagen'];


 move_uploaded_file($image['tmp_name'],"files/".$image['name']);


 
$res=$cn->instruccion($qry);

if($res){

	echo "<script>

	alert('Producto registrado con exito');
	


</script>"; 

}else{
	$error="Error al registrar el producto";
}

}

}

}



echo <<<_PRO

<!DOCTYPE html>
<html>
    
<head>
	<title>Registro de productos</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/all.css">



	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>

	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>




<script src="funciones_formularioP.js"></script>

<style>

@import url('https://fonts.googleapis.com/css?family=Abel|Abril+Fatface|Alegreya|Arima+Madurai|Dancing+Script|Dosis|Merriweather|Oleo+Script|Overlock|PT+Serif|Pacifico|Playball|Playfair+Display|Share|Unica+One|Vibur');

    	/* Coded with love by Mutiullah Samim */
	

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
			height: 600px;
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

    


</style>

</head>
<!--Coded with love by Mutiullah Samim-->
<body>




<div class="center">
      <a href="formularioProducto.php"><span data-attr="Exit">Exit</span><span data-attr="Exit">Exit</span></a>
  </div>


	<div class="container h-100">

<br>


		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="imagenes/final.png" class="brand_logo" alt="Logo">
						<br><br>

						<p style="color:black">Registro de productos</p>

					</div>
					


				</div>

				<br><br>
				<br><br>
				

				<div class="d-flex justify-content-center form_container">
					<form  enctype="multipart/form-data"  id="frm1" method="post" autocomplete="off" >$error
					
						
	
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-tag" ></i></span>
							</div>
							<input type="text" name="nombre" id="nombre" class="form-control input_pass" value="$nombre" placeholder="Nombre">
				
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-barcode" ></i></span>
							</div>
							<input type="number" name="codigo" id="codigo" class="form-control input_pass" value="$codigo" placeholder="Codigo de barras">
				
						</div>


						



						
						
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-sort-alpha-desc" ></i></span>
							</div>
							<input type="text" name="tipo" id="tipo" class="form-control input_pass" value="$tipo" placeholder="Tipo">
						
							<div class="input-group-append">

							
								<span class="input-group-text"><i  class="fa fa-sort-amount-desc" ></i></span>
							
						
						
  </div>
  <input type="number"  name="existencia" id="existencia" class="form-control input_pass" value="$existencia" placeholder="Existencia">

						
						</div>



						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-commenting" ></i></span>
							</div>
							<input type="text" name="descripcion" id="descripcion" class="form-control input_pass" value="$descripcion" placeholder="Descripcion">
					
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-image" ></i></span>
							</div>
							<input type="file" name="imagen" id="imagen" class="form-control input_pass"  accept=".jpg,.jpeg,.png"  value="$imagen" placeholder="Imagen">
				
						</div>

						
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-usd" ></i></span>
							</div>
							<input type="number" name="precio" id="precio" class="form-control input_pass" value="$precio" placeholder="Precio">
					
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-calendar-check" ></i></span>
							</div>
							<input type="text" name="garantia" id="garantia" class="form-control input_pass" value="$garantia" placeholder="Garantia">
					
						</div>
				
					
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i  class="fa fa-clock" ></i></span>
							</div>
							<input type="text" name="promocion" id="promocion" class="form-control input_pass" value="$promocion" placeholder="Promocion">
					
							<input type="text" style="display:none;" name="img" id="img">


						</div>







							<div class="d-flex justify-content-center mt-3 login_container">
				 	<button type="submit"   onclick='validarFormulario();' style=" background: #30415D; color:white;" name="upload" id="upload" class="btn login_btn">Registrar producto</button>

				   </div>





				   <div class="d-flex justify-content-center mt-3 login_container">
				 	<button type="reset"  style=" background: #30415D; color:white;" id="limpiar" name="button" class="btn login_btn">Limpiar</button>

				   </div>
                


					</form>
				</div>





		
			
			</div>
		</div>
	</div>



</body>
<script src="validateRegistroProducto.js"></script>


<script>

$('#imagen').change(function(){
	var value =$(this).val();
	

	 document.getElementById("img").value=value.substr(12);



   })
</script>



</html>



_PRO;


?>
	

	
