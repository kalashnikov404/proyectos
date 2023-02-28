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
	<title>Previsualizar Paciente</title>
	<meta name="keywords" content="Formulario expediente" />
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- stylesheets -->
	<link rel="stylesheet" href="css/font-awesome.css">
	<link href="images/fav.ico" rel="shortcut icon" type="images/x-icon" />

	<link rel="stylesheet" href="css/FormEditarExpediente.css">
	<!-- google fonts  -->
	<link href="//fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Josefin+Sans:300,400,400i,700" rel="stylesheet">	
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

	<script src="js/FuncionCrearExpediente.js"></script>
	



		
		</script>
<style>

body{
	background: #3E8DA8;
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

.container {
                left: 0px;
                display: inline-block;
                text-align: center;
                margin: 3rem;
  padding: 2rem 2rem;
  text-align: center;
}

.container2{
    display: inline-block;
              
    vertical-align: middle;
    padding: 1rem 1rem;
    margin: 18rem;

            }

#select-formato{
 
	background-color: white;
color: black;

	font-size: 1em;
    border-radius: 40px;
    padding: auto;
	cursor: pointer;
 width: 320px;
    height: 50px;

	text-align: center;



	
}
</style>


</head>
<body>



	<div class="w3ls-banner">



<div class="center">
    <a href="GestionarExpediente.php"><span data-attr="Regresar">Regresar</span><span data-attr="Regresar">Regresar</span></a>
</div>
	<div class="heading">

		<h1 stye>Formatos para abrir expediente</h1>
        <br>
		<h1 stye>Vista preliminar de paciente</h1>


	</div>

	


		<div class="container" id="container"  style="background: #ffffff">
	
	


		<div class="heading">
				<h2 style="color:black;" >SISTEMA INTEGRAL PARA EL DESARROLLO INTEGRAL DE LA FAMILIA</h2>
				<p>HOJA FRONTAL</p>
			</div>
			<div class="agile-form">
				<form action="javascript:crearHojaFrontal();" id="formPersona" method="post">
					<ul class="field-list">
						<li>
							<label class="form-label"> 
								NOMBRE DEL PACIENTE 
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="nombrePersona"  >
							</div>
						</li>

						<ul class="field-list">
						<li>
							<label class="form-label"> 
								APELLIDO PATERNO  
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="paternoPersona"  >
							</div>
						</li>

						<ul class="field-list">
						<li>
							<label class="form-label"> 
								APELLIDO MATERNO 
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="maternoPersona" >
							</div>
						</li>

						<ul class="field-list">
						<li>
							<label class="form-label"> 
								No. DE EXPEDIENTE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" id="temporalExpediente" >
							</div>
						</li>



                        <li>
							<label class="form-label"> 
								SEXO
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" id="temporalExpediente"  >
							</div>
						</li>
					


                        <li>
							<label class="form-label"> 
								EDAD
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" id="temporalExpediente" >
							</div>
						</li>
									
				
							</div>
						</li>
						
							<p>
							  UNIDAD DE REHABILITACIÓN: <b>CRI ZITÁCUARO</b>
						</p>

						<li> 
								<p id="f"></p>

							

						</li>
						
                        <li>
							<label class="form-label"> 
								NOMBRE Y NUMERO DE CEDULA
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" id="temporalExpediente"  >
							</div>
						</li>




						<li> 
							<label class="form-label1">
								DIAGNÓSTICO FISIOTERAPEUTICO
							</label>
							<div class="form-input2">
								<textarea rows="5" cols="20" name="temporalDiagnostico" id="temporalDiagnostico"></textarea>
							
							</div>

						</li>
						
					</ul>
                    <input type="submit" value="Digitalizar">

				</form>	
			</div>
		</div>
	
		<div class="container2" id="container2" style="background: #ffffff" >
			<div class="heading">
				<h2 style="color:black;">UNIDAD DE ASISTENCIA E INTEGRACION SOCIAL<br>
					DIRECCION GENERAL DE REHABILITACION<br>
					DIRECCION DE REHABILITACION<br>
					CRI ZITACUARO
				</h2>
				<p id="fec"> </p>
			</div>
			<div class="agile-form">
				<form action="javascript:crearHojaConsentimiento();"  id="formPaciente" method="post">
					<ul class="field-list">
						<li>
						<label class="form-label">
							   Yo
							   <span class="form-required"> * </span>
							</label>
							<input type="text" name="temporalPaciente1" id="temporalPaciente1" >

						</li>


						<p align="justify">por mi propio derecho o en representación del (la) menor o persona con discapcidad; 									
							<input type="text" name="temporalPaciente2" id="temporalPaciente2" >
						expreso mi amplio CONSENTIMIENTO para recibir la valoración y el tratamiento Médico o Fisioterapéutico necesario en mi
						persona o representado (a), toda vez que el tratante explique lo relacionado con el padecimento, el tipo de tratamiento
						que recibiré y/o recibirá mi representado, las secuelas y los posibles riesgos que se pudieran presentar como consecuencia
						del padecimiento y del tratamiento fisioterapéutico, asimismo autorizo al personal de salud para la atención de eventualidades
						y urgencias derivadas del mismo.</p>

						
                        <br>
<div class="agile-form">	
				<form action="/" method="post">
					<ul class="field-list">

							<h4 align="center">USUARIO</h4>
							<br>

							
                            <li>
		<label class='form-label'> 
			DIAGNOSTICO
			<span class='form-required'> * </span>
		</label>


		
		<div class='form-input'>
			<input type='text' name='diagnosticoPaciente' id='diagnosticoPaciente' disabled>
		</div>
	</li>

	
	<li>
		<label class='form-label'>
		   IDENTFICADOR
		   <span class='form-required'> * </span>
		</label>
		<div class='form-input dob'>
			<span class='form-sub-label'>
				
			<input type='text' class='year'  name='edadPaciente' id='edadPaciente'  disabled>
				<label class='form-sub-label1'> EDAD </label>								</span>
			
            
                <span class='form-sub-label'>
			
                <input type='text' class='year'  name='edadPaciente' id='edadPaciente'  disabled>

                <label class='form-sub-label1'> GENERO </label>
			</span>
				


			<span class='form-sub-label'>
				<input type='text' class='year' name='expedientePaciente' id='expedientePaciente' disabled>
				<label class='form-sub-label1'> N° EXPEDIENTE </label>
			</span>
		</div>
	</li>

<div id="identificadorPaciente">
	
</div>

							

						<label class="form-label" style="text-align='center'">
							  DOMICILIO
							</label>		
					
                            <li>
							<label class="form-label"> 
								ESTADO
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" id="temporalExpediente"  >
							</div>
						</li>


                        <li>
							<label class="form-label"> 
								MUNICIPIO/CIUDAD
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" id="temporalExpediente"  >
							</div>
						</li>

		<input type="hidden" name="estadoPaciente" id="estadoPaciente" value="">
<input type="hidden" name="municipioPaciente" id="municipioPaciente" value="">



		<li>
							<label class="form-label"> 
								LOCALIDAD
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="localidadDomicilio"  id="localidadDomicilio"  >
							</div>
						</li>
		
		
		
		<li>
							<label class="form-label"> 
								CALLE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="calleDomicilio" id="calleDomicilio" >
							</div>
						</li>


						<li>
							<label class="form-label"> 
								COLONIA
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="coloniaDomicilio" id="coloniaDomicilio" >
							</div>
						</li>



		<li>
							<label class="form-label"> 
								CODIGO POSTAL
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="cpDomicilio" id="cpDomicilio" >
							</div>
						</li>

						<li>
							<label class="form-label"> 
								TELEFONO
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="telefonoPaciente" id="telefonoPaciente"  >
							</div>
						</li>


						<li>
							<label class="form-label"> 
								CURP
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="curpPaciente" id="curpPaciente"   >
							</div>
						</li>


						
						<li>
							<label class="form-label"> 
								INE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="inePaciente" id="inePaciente"  >
							</div>
						</li>
						<br>

						<h4 align="center">TRATANTE</h4>
						

                        <li>
							<label class="form-label"> 
								NOMBRE Y NUMERO DE CEDULA
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" id="temporalExpediente"  >
							</div>
						</li>


<br>
						<h4 align="center">RESPONSABLE</h4>


						<li>
							<label class="form-label"> 
								NOMBRE DEL RESPONSABLE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="nombreResponsable" id="nombreResponsable"   >
							</div>
						</li>
	



						<li>
		<label class='form-label'> 
			DIAGNOSTICO
			<span class='form-required'> * </span>
		</label>


		
		<div class='form-input'>
			<input type='text' name='diagnosticoPaciente' id='diagnosticoPaciente' disabled>
		</div>
	</li>

	
	<li>
		<label class='form-label'>
		   IDENTFICADOR
		   <span class='form-required'> * </span>
		</label>
		
        <div class='form-input dob'>
			
        <span class='form-sub-label'>
				
			<input type='text' class='year'  name='edadPaciente' id='edadPaciente'  >
				<label class='form-sub-label1'> EDAD </label>								
            </span>
			

                <span class='form-sub-label'>

			<input type='text' class='year' name='generoPaciente'  id='generoPaciente'  >
				<label class='form-sub-label1'> GENERO </label>
			</span>


			<span class='form-sub-label'>
				<input type='text' class='year' name='expedientePaciente' id='expedientePaciente'>
				<label class='form-sub-label1'> N° EXPEDIENTE </label>
			</span>
            
		</div>
	</li>

						
                        <li>
							<label class="form-label"> 
								ESTADO
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" id="temporalExpediente"  >
							</div>
						</li>

                        <li>
							<label class="form-label"> 
								MUNICIPIO/CIUDAD
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" id="temporalExpediente"  >
							</div>
						</li>

		
		
		</form>

<input type="hidden" name="estadoResponsable" id="estadoResponsable" value="">
<input type="hidden" name="municipioResponsable" id="municipioResponsable" value="">


	
		<li>
							<label class="form-label"> 
								LOCALIDAD
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="localidadResponsable" id="localidadResponsable"  >
							</div>
						</li>

		<li>
							<label class="form-label"> 
								CALLE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="calleResponsable" id="calleResponsable" >
							</div>
						</li>


						<li>
							<label class="form-label"> 
								COLONIA
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="coloniaResponsable" id="coloniaResponsable" >
							</div>
						</li>



		<li>
							<label class="form-label"> 
								CODIGO POSTAL
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="cpResponsable" id="cpResponsable" >
							</div>
						</li>

						<li>
							<label class="form-label"> 
								TELEFONO
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="telefonoResponsable" id="telefonoResponsable" >
							</div>
						</li>

						<br>
						<h4 align="center">TESTIGO</h4>

						
						<li>
							<label class="form-label"> 
								NOMBRE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="nombreTestigo" id="nombreTestigo" >
							</div>
						</li>

						<li>
							<label class="form-label">
							   IDENTFICADOR
							   <span class="form-required"> * </span>
							</label>
							<div class="form-input dob">
								<span class="form-sub-label">
									
								<input type="text" class="year" name="edadTestigo" id="edadTestigo"   >
									<label class="form-sub-label1"> EDAD </label>								</span>
								
                                    <span class="form-sub-label">
							
                                    <input type="text" class="year" name="edadTestigo" id="edadTestigo"   >
                                
                                
								<label class="form-sub-label1"> GENERO </label>
								
                            
                            </span>
								<span class="form-sub-label">
									<input type="text" class="year" name="telefonoTestigo"  id="telefonoTestigo" >
									<label class="form-sub-label1"> TELEFONO </label>
								</span>
							</div>
						</li>
					
					</ul>
					<input type="submit" value="Digitalizar">



				</form>	
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