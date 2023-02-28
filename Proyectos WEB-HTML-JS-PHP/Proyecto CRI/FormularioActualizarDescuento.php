<?php

// Initialize the session
session_start();
 
// Check if the user is logged in, if not then redirect him to login page
if(!isset($_SESSION["loggedin"]) || $_SESSION["loggedin"] !== true){
    header("location: Index.php");
    exit;
}




//servidor, usuario de base de datos, contraseña del usuario, nombre de base de datos


$mysqli = new mysqli("localhost","root","root","cri"); 
if(mysqli_connect_errno()){
	echo 'Conexion Fallida : ', mysqli_connect_error();
	exit();
}else


?>




<!DOCTYPE html>
<html lang="en">
<head>
	<!-- Meta tags -->
	<title>Formulario Descuento</title>
	<meta name="keywords" content="Formulario expediente" />
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- stylesheets -->
	<link rel="stylesheet" href="css/font-awesome.css">
	<link href="images/fav.ico" rel="shortcut icon" type="images/x-icon" />

	<link rel="stylesheet" href="css/Form.css">
	<!-- google fonts  -->
	<link href="//fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Josefin+Sans:300,400,400i,700" rel="stylesheet">	
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

	<script src="js/FuncionCrearDescuento.js"></script>
	
		</script>
<style>

body{
	background: #3E8DA8;
}
input[type="text"], textarea, select
{
    font-size:18px;
	 font-family: monospace;
	 text-align: center;
}


a {
    text-decoration: none;
    text-transform: uppercase;
    font-size: 18px;
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
    background: #F8F225;
}
a span:nth-child(1):before {
    content: attr(data-attr);
    position: absolute;
    top: 0;
    left: 0;
    background: #F8F225;
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
    background: #F8F225;
    padding: 15px;
    transition: 0.5S;
    transform-origin: top;
    transform: rotateX(0deg) translateY(0%);
}
a:hover span:nth-child(2):after {
    transform: rotateX(90deg) translateY(-50%);
} 

.container .container2{
	display:inline-block;
  vertical-align: top;

}



#select-formato{
 
	background-color: white;
color: black;

	font-size: 18px !important;
    border-radius: 40px;
    padding: auto;
	cursor: pointer;
 width: 329px;
    height: 50px;

	text-align: center;



	
}




</style>


</head>
<body>



	<div class="w3ls-banner">



<div class="center">
    <a href="GestionarDescuento.php"><span data-attr="Regresar">Regresar</span><span data-attr="Regresar">Regresar</span></a>
</div>
	<div class="heading">

		<h1 stye>Formatos para crear un descuento</h1>



	</div>

	


		<div class="container" id="container"  style="background: #c27e7c;">
	
	


		<div class="heading">
				<h2>FORMATO PARA LA APLICACION DE UN DESCUENTO</h2>
			</div>
			<div class="agile-form">
				<form action="javascript:crearHojaFrontal();" id="formPersona" method="post">
					<ul class="field-list">
					
                    <li>
							<label class="form-label">
							   PACIENTE
							   <span class="form-required"> * </span>
							</label>
					

							<div><select  name="cbx_tratante" id="cbx_tratante">
				<option style="text-align: center;" value="0">Selecciona un paciente</option>
				
			</select></div>


						</li>

                    
                    <li>
							<label class="form-label"> 
								NOMBRE DEL PACIENTE 
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="nombrePersona" placeholder="Ingresa el nombre" required >
							</div>
						</li>

						<ul class="field-list">
						<li>
							<label class="form-label"> 
								TIPO DE DESCUENTO  
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="descuento" id="descuento"  placeholder="Ingresa el tipo de descuento" required >
							</div>
						</li>

						<ul class="field-list">
						<li>
							<label class="form-label"> 
								MOTIVO
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="motivo" id="motivo" placeholder="Ingresa el motivo" required >
							</div>
						</li>

						<ul class="field-list">
						<li>
							<label class="form-label"> 
                            CONCURRENCIA
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="concurrencia" id="concurrencia" placeholder="Ingresa el tipo de concurrencia" required >
							</div>
						</li>

					


						

						<li> 
								<p id="fec"></p>

							

						</li>
						
					



						<li> 
							<label class="form-label1">
								NOTA
							</label>
							<div class="form-input2">
								<textarea rows="5" cols="20" name="temporalDiagnostico" id="temporalDiagnostico"></textarea>
							
							</div>

						</li>
						
					</ul>
					<input type="submit" value="Guardar">
				</form>	
			</div>
		</div>
        
    </div>

		</div>












<script>


	

$(document).ready(function(){
    
	const date = new Date();

let day = date.getDate();
let month = (date.getMonth() + 1).toString().padStart(2, "0");
let year = date.getFullYear();

// This arrangement can be altered based on how we want the date's format to appear.
let currentDate = `${day}-${month}-${year}`;

document.getElementById("f").innerText="FECHA: " + currentDate;


const monthNames = ["ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO",
  "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"
];

const d = new Date();
//document.write("The current month is " monthNames[d.getMonth()]+ );
document.getElementById("fec").innerText="H.ZITACUARO MICHOACAN, MEXICO A" + " "+  day  + " "+ "DE" + " " + monthNames[d.getMonth()] + " "+ "DE" + " " + year ;

}); 
</script>
  
<script>
	



</script>
</body>
</html>