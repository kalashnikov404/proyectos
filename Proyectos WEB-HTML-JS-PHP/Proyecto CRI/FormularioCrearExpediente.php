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



/*
*Queries para llenar combos
*
*/
$query = "SELECT id_estado, estado FROM t_estado ORDER BY estado";
	$resultado=$mysqli->query($query);

	$query3 = "SELECT id_estado, estado FROM t_estado ORDER BY estado";
	$resultado3=$mysqli->query($query3);

	$query2 = "SELECT tratante.id_tratante 
	 as idTratante, especialidad_tratante, nombre_persona,
	  paterno_persona, materno_persona, cedula_tratante FROM persona, 
	  tratante WHERE persona.id_persona=tratante.id_persona";
	$resultado2=$mysqli->query($query2);


	$query4 = "select id_persona, nombre_persona, paterno_persona, materno_persona, nacimiento_persona from persona order by nombre_persona";
	$resultado4=$mysqli->query($query4);


	$query5 = "SELECT tratante.id_tratante  as idTratante, especialidad_tratante, nombre_persona, paterno_persona, materno_persona, cedula_tratante FROM persona, tratante WHERE persona.id_persona=tratante.id_persona";
	$resultado5=$mysqli->query($query5);



?>




<!DOCTYPE html>
<html lang="en">
<head>
	<!-- Meta tags -->
	<title>Formulario Expediente</title>
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

	<script src="js/FuncionCrearExpediente.js"></script>
	

	<script>
			$(document).ready(function(){
				$("#cbx_estado").change(function () {
 
					$('#cbx_localidad').find('option').remove().end().append('<option value="whatever"></option>').val('whatever');
					
					$("#cbx_estado option:selected").each(function () {
						id_estado = $(this).val();
						$.post("GetMunicipio.php", { id_estado: id_estado }, function(data){
							$("#cbx_municipio").html(data);
						});            
					});
				})
			});
			
			$(document).ready(function(){
				$("#cbx_municipio").change(function () {
					$("#cbx_municipio option:selected").each(function () {
						id_municipio = $(this).val();
						$.post("GetLocalidad.php", { id_municipio: id_municipio }, function(data){
							$("#cbx_localidad").html(data);
						});            
					});
				})
			});


			$(document).ready(function(){
				$("#cbx_estado2").change(function () {
 
					$('#cbx_localidad2').find('option').remove().end().append('<option value="whatever"></option>').val('whatever');
					
					$("#cbx_estado2 option:selected").each(function () {
						id_estado = $(this).val();
						$.post("GetMunicipio.php", { id_estado: id_estado }, function(data){
							$("#cbx_municipio2").html(data);
						});            
					});
				})
			});
			
			$(document).ready(function(){
				$("#cbx_municipio2").change(function () {
					$("#cbx_municipio2 option:selected").each(function () {
						id_municipio = $(this).val();
						$.post("GetLocalidad.php", { id_municipio: id_municipio }, function(data){
							$("#cbx_localidad2").html(data);
						});            
					});
				})
			});

			$(document).ready(function(){
				$("#cbx_personaPaciente").change(function () {
					$("#cbx_personaPaciente option:selected").each(function () {
						id_persona = $(this).val();
						$.post("GetPersona.php", { id_persona: id_persona }, function(data, data1){
							
							$("#identificadorPaciente").html(data);



						});            
					});
				})
			});

		


		
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
    <a href="GestionarExpediente.php"><span data-attr="Regresar">Regresar</span><span data-attr="Regresar">Regresar</span></a>
</div>
	<div class="heading">

		<h1 stye>Formatos para abrir expediente</h1>

		<select id="select-formato" onchange="handleSelectChange(event)">
								<option value="0">Selecciona un formato</option>
								<option value="1">Formato de hoja frontal</option>
								<option value="2">Formato de hoja consentimiento</option>

							</select>

	</div>

	


		<div class="container" id="container"  style="background: #435d7d; display: none;">
	
	


		<div class="heading">
				<h2>SISTEMA INTEGRAL PARA EL DESARROLLO INTEGRAL DE LA FAMILIA</h2>
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
								<input type="text" name="nombrePersona" placeholder="Ingresa el nombre" required >
							</div>
						</li>

						<ul class="field-list">
						
						<li>
							<label class="form-label"> 
								APELLIDO PATERNO  
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="paternoPersona" placeholder="Ingresa el apellido paterno" required >
							</div>
						</li>

						<ul class="field-list">
						<li>
							<label class="form-label"> 
								APELLIDO MATERNO 
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="maternoPersona" placeholder="Ingresa el apellido materno" required >
							</div>
						</li>

						<ul class="field-list">
						<li>
							<label class="form-label"> 
								No. DE EXPEDIENTE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" id="temporalExpediente" placeholder="Ingresa el numero de expediente" required >
							</div>
						</li>



						<li>
							<label class="form-label">
							   SEXO
							   <span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<select class="form-dropdown" name="generoPersona" required>
									<option value="" style="text-align: center;"">Selecciona un genero</option>
									<option value="Masculino"> Masculino </option>
									<option value="Femenino"> Femenino </option>
								</select>
							</div>
						<li>

					


						<li>
							<label class="form-label">
							   EDAD
							   <span class="form-required"> * </span>
							</label>
							<div class="form-input dob">
								<span class="form-sub-label">
									<select name="dia" id="dia" class="day">
										<option>&nbsp;</option>
										<option value="01"> 1 </option>
										<option value="02"> 2 </option>
										<option value="03"> 3 </option>
										<option value="04"> 4 </option>
										<option value="05"> 5 </option>
										<option value="06"> 6 </option>
										<option value="07"> 7 </option>
										<option value="08"> 8 </option>
										<option value="09"> 9 </option>
										<option value="10"> 10 </option>
										<option value="11"> 11 </option>
										<option value="12"> 12 </option>
										<option value="13"> 13 </option>
										<option value="14"> 14 </option>
										<option value="15"> 15 </option>
										<option value="16"> 16 </option>
										<option value="17"> 17 </option>
										<option value="18"> 18 </option>
										<option value="19"> 19 </option>
										<option value="20"> 20 </option>
										<option value="21"> 21 </option>
										<option value="22"> 22 </option>
										<option value="23"> 23 </option>
										<option value="24"> 24 </option>
										<option value="25"> 25 </option>
										<option value="26"> 26 </option>
										<option value="27"> 27 </option>
										<option value="28"> 28 </option>
										<option value="29"> 29 </option>
										<option value="30"> 30 </option>
										<option value="31"> 31 </option>
									</select>
									<label class="form-sub-label1"> Día </label>
								</span>
								<span class="form-sub-label">
									<select name="mes" id="mes">
										<option>&nbsp;</option>
										<option value="01"> Enero </option>
										<option value="02"> Febrero </option>
										<option value="03"> Marzo </option>
										<option value="04"> Abril </option>
										<option value="05"> Mayo </option>
										<option value="06"> Junio </option>
										<option value="07"> Julio </option>
										<option value="08"> Agosto </option>
										<option value="09"> Septiembre </option>
										<option value="10"> Octubre </option>
										<option value="11"> Noviembre </option>
										<option value="12"> Diciembre </option>
									 </select>
									<label class="form-sub-label1"> MES </label>
								</span>
								<span class="form-sub-label">
									<input type="text" class="year" name="año" id="año" placeholder="Ingresa el año" maxlength="4" required>
									<label class="form-sub-label1"> AÑO </label>
								</span>

									
				
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
					

							<div><select  name="cbx_tratante" id="cbx_tratante">
				<option style="text-align: center;" value="0">Selecciona un tratante</option>
				<?php while($row2 = $resultado2->fetch_assoc()) { ?>
					<option style="text-align: center;" value="<?php echo $row2['idTratante']; ?>"><?php echo $row2['especialidad_tratante'], '&nbsp;', $row2['nombre_persona'], '&nbsp;', $row2['paterno_persona'], '&nbsp;', $row2['materno_persona'], '&nbsp;',$row2['cedula_tratante']; ?></option>
				<?php } ?>
			</select></div>


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
					<input type="submit" value="Guardar">
				</form>	
			</div>
		</div>
	
		<div class="container2" id="container2" style="background: #435d7d;  display: none; " >
			<div class="heading">
				<h2>UNIDAD DE ASISTENCIA E INTEGRACION SOCIAL<br>
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
							<input type="text" name="temporalPaciente1" id="temporalPaciente1" placeholder=" " required>

						</li>


						<p align="justify">por mi propio derecho o en representación del (la) menor o persona con discapcidad; 									
							<input type="text" name="temporalPaciente2" id="temporalPaciente2" placeholder=" " required>
						expreso mi amplio CONSENTIMIENTO para recibir la valoración y el tratamiento Médico o Fisioterapéutico necesario en mi
						persona o representado (a), toda vez que el tratante explique lo relacionado con el padecimento, el tipo de tratamiento
						que recibiré y/o recibirá mi representado, las secuelas y los posibles riesgos que se pudieran presentar como consecuencia
						del padecimiento y del tratamiento fisioterapéutico, asimismo autorizo al personal de salud para la atención de eventualidades
						y urgencias derivadas del mismo.</p>

						
<div class="agile-form">	
				<form action="/" method="post">
					<ul class="field-list">
							<h4 align="center">USUARIO</h4>
							<br>

							
							<li>
						

						
	
							<div><select  name="cbx_personaPaciente" id="cbx_personaPaciente">
				<option style="text-align: center;" value="0">Selecciona uno de los usuarios predefinidos anteriormente</option>
				<?php while($row4= $resultado4->fetch_assoc()) { ?>
					<option style="text-align: center;" value="<?php 
						echo $row4['id_persona']; ?>"><?php echo "Nombre:", $row4['nombre_persona'] , '&nbsp;',$row4['paterno_persona'], '&nbsp;', $row4['materno_persona'], '&nbsp;', '⇜⇜⇜⇝⇝⇝⇝', '&nbsp;', "Fecha de nacimiento:",$row4['nacimiento_persona']; ?></option>
				<?php } ?>
			</select></div>


							
							</li>

<div id="identificadorPaciente">
	
</div>

							

						<label class="form-label" style="text-align='center'">
							  DOMICILIO
							</label>		
					
						<form id="combo" name="combo"  method="POST">
			<div>ESTADO : <select  name="cbx_estado" id="cbx_estado">
				<option style="text-align: center;" value="0">Selecciona un estado</option>
				<?php while($row = $resultado->fetch_assoc()) { ?>
					<option style="text-align: center;" value="<?php echo $row['id_estado']; ?>"><?php echo $row['estado']; ?></option>
				<?php } ?>
			</select></div>
			
			<br />
			
			<div>MUNICIPIO/CIUDAD : <select  name="cbx_municipio" id="cbx_municipio"></select></div>
			
			<br />
			

		
		
		
		</form>

		<input type="hidden" name="estadoPaciente" id="estadoPaciente" value="">
<input type="hidden" name="municipioPaciente" id="municipioPaciente" value="">



		<li>
							<label class="form-label"> 
								LOCALIDAD
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="localidadDomicilio"  id="localidadDomicilio" placeholder="Ingresa la localidad" required >
							</div>
						</li>
		
		
		
		<li>
							<label class="form-label"> 
								CALLE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="calleDomicilio" id="calleDomicilio" placeholder="Ingresa el numero de expediente" required >
							</div>
						</li>


						<li>
							<label class="form-label"> 
								COLONIA
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="coloniaDomicilio" id="coloniaDomicilio" placeholder="Ingresa el numero de expediente" required >
							</div>
						</li>



		<li>
							<label class="form-label"> 
								CODIGO POSTAL
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="cpDomicilio" id="cpDomicilio" placeholder="Ingresa el numero de expediente" required >
							</div>
						</li>

						<li>
							<label class="form-label"> 
								TELEFONO
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="telefonoPaciente" id="telefonoPaciente" placeholder="Ingresa el numero de telefono" maxlength="10" required >
							</div>
						</li>


						<li>
							<label class="form-label"> 
								CURP
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="curpPaciente" id="curpPaciente" placeholder="Ingresa el numero de telefono" maxlength="10" required >
							</div>
						</li>


						
						<li>
							<label class="form-label"> 
								INE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="inePaciente" id="inePaciente" placeholder="Ingresa el numero de telefono" maxlength="10" required >
							</div>
					
						</li>
						<br>

						<h4 align="center">TRATANTE</h4>
						<li>
							<label class="form-label">
							   NOMBRE Y NUMERO DE CEDULA
							   <span class="form-required"> * </span>
							</label>
					

							<div><select  name="cbx_tratante2" id="cbx_tratante2">
				<option style="text-align: center;" value="0">Selecciona un tratante</option>
				<?php while($row5 = $resultado5->fetch_assoc()) { ?>
					<option style="text-align: center;" value="<?php echo $row5['idTratante']; ?>"><?php echo $row5['especialidad_tratante'], '&nbsp;', $row5['nombre_persona'], '&nbsp;', $row5['paterno_persona'], '&nbsp;', $row5['materno_persona'], '&nbsp;',$row5['cedula_tratante']; ?></option>
				
					<?php } ?>
			</select></div>

			




						</li>


<br>
						<h4 align="center">RESPONSABLE</h4>


						<li>
							<label class="form-label"> 
								NOMBRE DEL RESPONSABLE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="nombreResponsable" id="nombreResponsable" placeholder="Ingresa el numero de telefono" maxlength="10" required >
							</div>
						</li>
	



						
						<li>
							<label class="form-label">
							   IDENTFICADOR
							   <span class="form-required"> * </span>
							</label>
							<div class="form-input dob">
								<span class="form-sub-label">
									
								<input type="text" class="year" name="edadResponsable" id ="edadResponsable" maxlength="4" required>
									<label class="form-sub-label1"> EDAD </label>								</span>
								
									<span class="form-sub-label">
									<select class="form-dropdown" name="generoResponsable" required>
									<option value="" style="text-align: center;">Selecciona</option>
									<option value="Masculino"> Masculino </option>
									<option value="Femenino"> Femenino </option>
								</select>									
								<label class="form-sub-label1"> GENERO </label>
							
							
								</span>
								
								
								
								<span class="form-sub-label">
									<input type="text" class="year" name="numeroExpedienteResponsable" id="numeroExpedienteResponsable" placeholder="OPCIONAL" maxlength="4" required>
									<label class="form-sub-label1"> N° EXPEDIENTE </label>

								</span>
							</div>
						</li>

						
					
						<form id="combo2" name="combo2"  method="POST">
			<div>ESTADO : <select  name="cbx_estado2" id="cbx_estado2">
				<option style="text-align: center;" value="0">Selecciona un estado</option>
				<?php while($row3 = $resultado3->fetch_assoc()) { ?>
					<option style="text-align: center;" value="<?php echo $row3['id_estado']; ?>"><?php echo $row3['estado']; ?></option>
				<?php } ?>
			</select></div>
			
			<br />
			
			<div>MUNICIPIO : <select  name="cbx_municipio2" id="cbx_municipio2"></select></div>
			
			<br>

		
		
		</form>

<input type="hidden" name="estadoResponsable" id="estadoResponsable" value="">
<input type="hidden" name="municipioResponsable" id="municipioResponsable" value="">


	
		<li>
							<label class="form-label"> 
								LOCALIDAD
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="localidadResponsable" id="localidadResponsable" placeholder="Ingresa la localidad" required >
							</div>
						</li>

		<li>
							<label class="form-label"> 
								CALLE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="calleResponsable" id="calleResponsable" placeholder="Ingresa el numero de expediente" required >
							</div>
						</li>


						<li>
							<label class="form-label"> 
								COLONIA
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="coloniaResponsable" id="coloniaResponsable" placeholder="Ingresa el numero de expediente" required >
							</div>
						</li>



		<li>
							<label class="form-label"> 
								CODIGO POSTAL
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="cpResponsable" id="cpResponsable" placeholder="Ingresa el numero de expediente" required >
							</div>
						</li>

						<li>
							<label class="form-label"> 
								TELEFONO
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="telefonoResponsable" id="telefonoResponsable" placeholder="Ingresa el numero de telefono" maxlength="10" required >
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
								<input type="text" name="nombreTestigo" id="nombreTestigo"  placeholder="Ingresa el nombre" maxlength="10" required >
							</div>
						</li>

						<li>
							<label class="form-label">
							   IDENTFICADOR
							   <span class="form-required"> * </span>
							</label>
							<div class="form-input dob">
								<span class="form-sub-label">
									
								<input type="text" class="year" name="edadTestigo" id="edadTestigo"   required>
									<label class="form-sub-label1"> EDAD </label>								</span>
								<span class="form-sub-label">
								<select class="form-dropdown" name="generoTestigo" required>
									<option value="" style="text-align: center;">Selecciona</option>
									<option value="Masculino"> Masculino </option>
									<option value="Femenino"> Femenino </option>
								</select>		
								<label class="form-sub-label1"> GENERO </label>
								</span>
								<span class="form-sub-label">
									<input type="text" class="year" name="telefonoTestigo"  id="telefonoTestigo" placeholder="" maxlength="4" required>
									<label class="form-sub-label1"> TELEFONO </label>
								</span>
							</div>
						</li>
					
					</ul>
					<input type="submit" value="Guardar">



				</form>	
			</div>
		</div>


		</div>












<script>


function handleSelectChange(event) {
	var c1 = document.getElementById('container');
	var c2 = document.getElementById('container2');

var selectElement = event.target;
var v = selectElement.value;

if(v=="0"){
	
	c1.style.display = 'none'; //or
	c2.style.display = 'none'; //or

}


if(v=="1"){
	
	c1.style.display = 'block'; //or
	c2.style.display = 'none'; //or

}
if(v=="2"){
	c1.style.display = 'none'; //or

	c2.style.display = 'block'; //or



}
}

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
	

function getValue(){
var x=Document.getElementById("dia").value;
var y=Document.getElementById("mes").value;
var z=Document.getElementById("año").value;

alert(x+y+z);
}


document.getElementById("cbx_estado").addEventListener("change", myFunction);

function myFunction() 
{
	var xx = document.getElementById("cbx_estado");
	var i = xx.selectedIndex;




  var x = document.getElementById("estadoPaciente").innerText=xx.options[i].text;
}


document.getElementById("cbx_municipio").addEventListener("change", myFunction2);

function myFunction2() 
{
	var xx = document.getElementById("cbx_municipio");
	var i = xx.selectedIndex;


	

  var x = document.getElementById("municipioPaciente").innerText=xx.options[i].text;
}




document.getElementById("cbx_estado2").addEventListener("change", myFunction3);

////////////////////////////
function myFunction3() 
{
	var xx = document.getElementById("cbx_estado2");
	var i = xx.selectedIndex;




  var x = document.getElementById("estadoResponsable").innerText=xx.options[i].text;
}


document.getElementById("cbx_municipio2").addEventListener("change", myFunction4);

function myFunction4() 
{
	var xx = document.getElementById("cbx_municipio2");
	var i = xx.selectedIndex;


	

  var x = document.getElementById("municipioResponsable").innerText=xx.options[i].text;
}



</script>
</body>
</html>