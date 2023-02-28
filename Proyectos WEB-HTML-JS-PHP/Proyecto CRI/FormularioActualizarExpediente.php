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

$somevar = $_GET["uid"]; //puts the uid varialbe into $somevar

$query4 = "SELECT id_persona, nombre_persona, paterno_persona, materno_persona,
 temp2e_persona, genero_persona,  nacimiento_persona AS edad_persona, temp1d_persona from
 persona where id_persona='$somevar'";
	$resultado4=$mysqli->query($query4);


	$query5 = "SELECT pa.temp1_paciente as nombrePaciente, pa.temp2_paciente AS nombrePaciente2, 
	p.temp1d_persona AS diagnosico, 
	p.nombre_persona as nombre, p.paterno_persona as paterno, p.materno_persona as materno 
	,TIMESTAMPDIFF(YEAR, p.nacimiento_persona, 
		CURDATE()) AS edad_persona,
		 p.genero_persona AS genero , temp2e_persona AS expe,
		p.telefono_persona AS telefono , p.curp_persona AS curp, p.ine_persona AS ine,
		d.id_domicilio as idDomicilioP, d.estado_domicilio AS estado, d.municipio_domicilio AS municipio, 
		d.localidad_domicilio AS localidad,
		d.calle_domicilio AS calle , d.cp_domicilio AS cp , d.colonia_domicilio AS colonia
		 , DATE_FORMAT(e.fecha_creacion_expediente ,'%H:%i:%s') AS hora, 
		 DATE_FORMAT(e.fecha_creacion_expediente ,'%Y-%m-%d') AS fecha
		 FROM expediente e ,persona p,
		paciente pa, domicilio d
		 where p.id_persona='$somevar' AND p.id_persona=pa.id_persona
		 AND e.id_expediente=pa.id_expediente
		 AND d.id_domicilio=pa.id_domicilio order BY p.id_persona  ;";
		 
	   $resultado5=$mysqli->query($query5);


	   $query6 = "select temp3c_persona from persona where id_persona='$somevar'";
	   $resultado6=$mysqli->query($query6);

	    $row6= $resultado6->fetch_assoc();
		//echo  $row6['temp3c_persona'];
		$idTratante= implode(" ", $row6);
		$idTratante= (int)$idTratante;


		$query7= "Select especialidad_tratante, nombre_persona, 
		paterno_persona, materno_persona, 
		cedula_tratante FROM persona, tratante
		 WHERE persona.id_persona=tratante.id_persona AND tratante.id_tratante ='$idTratante'";
		   $resultado7=$mysqli->query($query7);

	   /*
		$query8= "Select especialidad_tratante, nombre_persona, 
		paterno_persona, materno_persona, 
		cedula_tratante FROM persona, tratante
		 WHERE persona.id_persona=tratante.id_persona AND tratante.id_tratante ='$idTratante'";
		   $resultado8=$mysqli->query($query8);
*/
	
		   $query8 = "SELECT tratante.id_tratante 
		   as idTratante, especialidad_tratante, nombre_persona,
			paterno_persona, materno_persona, cedula_tratante FROM persona, 
			tratante WHERE persona.id_persona=tratante.id_persona AND tratante.id_tratante='$idTratante'	
	  ";
		   $resultado8=$mysqli->query($query8);

		$query12="  SELECT tratante.id_tratante 
		as idTratante, especialidad_tratante, nombre_persona,
		 paterno_persona, materno_persona, cedula_tratante FROM persona, 
		 tratante WHERE persona.id_persona=tratante.id_persona";
		   $resultado12=$mysqli->query($query12);




		$query9="select  responsable.nombre_responsable AS nombre, responsable.edad_responsable AS edad,
		responsable.genero_responsable AS genero, responsable.numero_expediente_responsable AS expediente,
		responsable.telefono_responsable AS telefono, domicilio.id_domicilio as idDomicilioR, domicilio.estado_domicilio AS estado,
		domicilio.municipio_domicilio AS municipio, domicilio.localidad_domicilio AS localidad, 
		domicilio.calle_domicilio AS calle , domicilio.colonia_domicilio AS colonia, domicilio.cp_domicilio as cp
		  from responsable, paciente, persona, domicilio where
		   responsable.id_responsable=paciente.id_responsable AND 
		   responsable.id_domicilio=domicilio.id_domicilio ANd
			persona.id_persona=paciente.id_persona and persona.id_persona='$somevar'";
			$resultado9=$mysqli->query($query9);


			$query10="SELECT  testigo.nombre_testigo, testigo.edad_testigo, testigo.genero_testigo,
			testigo.telefono_testigo from testigo, paciente, 
			persona WHERE testigo.id_testigo=paciente.id_testigo AND
			persona.id_persona=paciente.id_persona AND persona.id_persona='$somevar'";
				$resultado10=$mysqli->query($query10);
	

				$query11="SELECT genero_persona from persona where persona.id_persona='$somevar'";
				$resultado11=$mysqli->query($query11);
		

?>
 



<!DOCTYPE html>
<html lang="en">
<head>
	<!-- Meta tags -->
	<title>Actualizar Paciente</title>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>  

	<script src="js/FuncionCrearExpediente.js"></script>
	



		
		</script>
<style>

option:first-child
{
    color: blue;
}

body{
	background: #3E8DA8;
}
#container:hover, #container2:hover{

	cursor: pointer;
}



select,
select option {
  color: #000000;
}

select:invalid,
select option[value=""] {
  color: #999999;
  text-align: center;
}


input[type="text"], textarea, select
{
    font-size:18px;
	 font-family: monospace;
	 color: black;
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
		<h1 stye>Vista preliminar para actualizar paciente</h1>


	</div>

	


		<div class="container" id="container"  style="background: #c27e7c">
	
	
	

		<div class="heading">
				<h2 style="color:black;" >SISTEMA INTEGRAL PARA EL DESARROLLO INTEGRAL DE LA FAMILIA</h2>
				<p>HOJA FRONTAL</p>
			</div>
			<div class="agile-form">
			<form action="javascript:actualizarHojaFrontal();" id="formPersona" method="post">
					
			
			<ul class="field-list">


						<li>
							<label class="form-label"> 
								NOMBRE DEL PACIENTE 
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
							<?php while($row4= $resultado4->fetch_assoc()) { ?>	
								<input type="hidden" name="clavePersona" id="clavePersona" value="<?php 
						echo $row4['id_persona']; ?>">

								<input type="text" name="nombrePersona" id="nombrePersona" value="<?php 
						echo $row4['nombre_persona']; ?>" >

							</div>
						</li>

						<ul class="field-list">
						<li>
							<label class="form-label"> 
								APELLIDO PATERNO  
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="paternoPersona" id="paternoPersona" value="<?php 
						echo $row4['paterno_persona']; ?>"> 
							</div>
						</li>

						
						<li>
							<label class="form-label"> 
								APELLIDO MATERNO 
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="maternoPersona" id="maternoPersona" value="<?php 
						echo $row4['materno_persona']; ?>">
							</div>
						</li>
						
						
						<li>
							<label class="form-label"> 
								No. DE EXPEDIENTE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" id="temporalExpediente" value="<?php 
						echo $row4['temp2e_persona']; ?>">
							</div>
						</li>





						<li>

						<label class="form-label"> 
						SEXO:
						<span class="form-required"> * </span>
							</label>
	
						
						<div class="form-input">
					<select  name="generoPersona" id="generoPersona">
					<?php while($row11= $resultado11->fetch_assoc()) { ?>

				<option style="text-align: center;" value="<?php echo $row11['genero_persona']; ?>">
				<?php echo $row11['genero_persona']; ?></option>
				<?php } ?>

					<option value="">Selecciona una nueva opcion</option>


				<option style="text-align: center;" 
					value="Masculino">Masculino</option>
					
					<option style="text-align: center;" 
					value="Femenino">Femenino</option>
					
						
					</select></div>


						</li>


                      

                      
                        <li>
							<label class="form-label"> 
								EDAD
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="edadFrontal" id="edadFrontal" value="<?php 
						echo $row4['edad_persona']; ?>">
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
	<?php while($row8 = $resultado8->fetch_assoc()) { ?>

				<option style="text-align: center;" 	value="<?php echo $row8['idTratante']; ?>">
					<?php echo $row8['especialidad_tratante'], 
					'&nbsp;', $row8['nombre_persona'], '&nbsp;',
					 $row8['paterno_persona'], '&nbsp;', $row8['materno_persona'], 
					 '&nbsp;',$row8['cedula_tratante']; ?></option>
				<?php } ?>

					<option value="">Selecciona una nueva opcion</option>

				<?php while($row12 = $resultado12->fetch_assoc()) { ?>

				<option style="text-align: center;" 
					value="<?php echo $row12['idTratante']; ?>">
					<?php echo $row12['especialidad_tratante'], 
					'&nbsp;', $row12['nombre_persona'], '&nbsp;',
					 $row12['paterno_persona'], '&nbsp;', $row12['materno_persona'], 
					 '&nbsp;',$row12['cedula_tratante']; ?></option>
				<?php } ?>
			</select></div>
</li>




						<li> 
							<label class="form-label1">
								DIAGNÓSTICO FISIOTERAPEUTICO
							</label>
							<div class="form-input2">
								<textarea rows="5" cols="20" name="temporalDiagnostico"  id="temporalDiagnostico"><?php 
						echo $row4['temp1d_persona']; ?></textarea>
							
							</div>

						</li>
						
					</ul>
                    <input type="submit" value="Actualizar">
					<?php } ?>

				</form>	
			</div>
		</div>
	
		<div class="container2" id="container2" style="background: #c27e7c" >
			<div class="heading">
	
			<h2 style="color:black;">UNIDAD DE ASISTENCIA E INTEGRACION SOCIAL<br>
					DIRECCION GENERAL DE REHABILITACION<br>
					DIRECCION DE REHABILITACION<br>
					CRI ZITACUARO
				</h2>

		

			


			</div>
			<div class="agile-form">
			<?php while($row5= $resultado5->fetch_assoc()) { ?>	
	
			<form action="javascript:actualizarHojaConsentimiento();"  id="formPaciente" method="post">

				<ul class="field-list">
				<h4 align="center">H. ZITACUARO MICHOACAN, MEXICO A <?php 
						echo $row5['fecha']; ?></h4>
				<li>
				<label class="form-label">HORA:<?php 
						echo $row5['hora']; ?> 
				</label>


				</li>
				
				<li>
						<label class="form-label">
							   Yo
							   <span class="form-required"> * </span>
							</label>
							<input type="text" name="temporalPaciente1"  id="temporalPaciente1" value="<?php 
						echo $row5['nombrePaciente']; ?>">

						</li>


						<p align="justify">por mi propio derecho o en representación del (la) menor o persona con discapcidad; 									
							<input type="text" name="temporalPaciente2"  id="temporalPaciente2"  value="<?php 
						echo $row5['nombrePaciente2']; ?>">
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
			NOMBRE
			<span class='form-required'> * </span>
		</label>
		
		<div class='form-input'>
			<input type='text' name='diagnosticoPaciente' id='diagnosticoPaciente'  disabled  
			value="<?php echo $row5['nombre'],'&nbsp;'. $row5['paterno'] , '&nbsp;', $row5['materno'];?>">
		</div>
	</li>


							
                            <li>
		<label class='form-label'> 
			DIAGNOSTICO
			<span class='form-required'> * </span>
		</label>


		
		<div class='form-input'>
			<input type='text' name='diagnosticoPaciente' id='diagnosticoPaciente' disabled value="<?php 
						echo $row5['diagnosico']; ?>">
		</div>
	</li>

	
	<li>
		<label class='form-label'>
		   IDENTFICADOR
		   <span class='form-required'> * </span>
		</label>
		<div class='form-input dob'>
			<span class='form-sub-label'>
				
			<input type='text' class='year'  name='edadPaciente' id='edadPaciente'  disabled  value="<?php 
						echo $row5['edad_persona']; ?>">
				<label class='form-sub-label1'> EDAD </label>								</span>
			
            
                <span class='form-sub-label'>
			
                <input type='text' class='year'  name='edadPaciente' id='edadPaciente'  disabled  value="<?php 
						echo $row5['genero']; ?>">

                <label class='form-sub-label1'> GENERO </label>
			</span>
				


			<span class='form-sub-label'>
				<input type='text' class='year' name='expedientePaciente' id='expedientePaciente' disabled  value="<?php 
						echo $row5['expe']; ?>">
				<label class='form-sub-label1'> N° EXPEDIENTE </label>
			</span>
		</div>
	</li>

<div id="identificadorPaciente">
	
</div>

							

<h4 align="center">DOMICILIO</h4>
	
					<input type="hidden" id="idDomicilioPaciente"
					 name="idDomicilioPaciente"  value="<?php 
						echo $row5['idDomicilioP']; ?>">


                            <li>
							<label class="form-label"> 
								ESTADO
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" id="temporalExpediente" disabled  value="<?php 
						echo $row5['estado']; ?>">
							</div>
						</li>


                        <li>
							<label class="form-label"> 
								MUNICIPIO/CIUDAD
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" id="temporalExpediente" disabled  value="<?php 
						echo $row5['municipio']; ?>"> 
							</div>
						</li>

		

		<li>
							<label class="form-label"> 
								LOCALIDAD
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="localidadDomicilio"  id="localidadDomicilio" disabled value="<?php 
						echo $row5['localidad']; ?>"> 
							</div>
						</li>
		
		
		
		<li>
							<label class="form-label"> 
								CALLE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="calleDomicilio" id="calleDomicilio" disabled value="<?php 
						echo $row5['calle']; ?>">
							</div>
						</li>


						<li>
							<label class="form-label"> 
								COLONIA
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="coloniaDomicilio" id="coloniaDomicilio" disabled  value="<?php 
						echo $row5['colonia']; ?>">
							</div>
						</li>



		<li>
							<label class="form-label"> 
								CODIGO POSTAL
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="cpDomicilio" id="cpDomicilio" disabled value="<?php 
						echo $row5['cp']; ?>" >
							</div>
						</li>

						<li>
							<label class="form-label"> 
								TELEFONO
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="telefonoPaciente" id="telefonoPaciente" disabled  value="<?php 
						echo $row5['telefono']; ?>">
							</div>
						</li>


						<li>
							<label class="form-label"> 
								CURP
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="curpPaciente" id="curpPaciente" disabled  value="<?php 
						echo $row5['curp']; ?>" >
							</div>
						</li>


						
						<li>
							<label class="form-label"> 
								INE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="inePaciente" id="inePaciente" disabled  value="<?php 
						echo $row5['ine']; ?>">
							</div>
						</li>
						<br>

						<?php } ?>

						<h4 align="center">TRATANTE</h4>
						


						<?php while($row7= $resultado7->fetch_assoc()) { ?>	

                        <li>
							<label class="form-label"> 
								NOMBRE Y NUMERO DE CEDULA
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" disabled id="temporalExpediente" 
								 value="<?php echo $row7['especialidad_tratante'], 
								 '&nbsp;', $row7['nombre_persona'], '&nbsp;',
								  $row7['paterno_persona'], '&nbsp;'
								  , $row7['materno_persona'], '&nbsp;'
								  ,$row7['cedula_tratante']; ?>">
							</div>
						</li>

						<?php } ?>

<br>
						<h4 align="center">RESPONSABLE</h4>



						<?php while($row9= $resultado9->fetch_assoc()) { ?>	

						<li>
							<label class="form-label"> 
								NOMBRE DEL RESPONSABLE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="nombreResponsable" disabled id="nombreResponsable"   value="<?php 
						echo $row9['nombre']; ?>">
							</div>
						</li>
	


	
	<li>
		<label class='form-label'>
		   IDENTFICADOR
		   <span class='form-required'> * </span>
		</label>
		
        <div class='form-input dob'>
			
        <span class='form-sub-label'>
				
			<input type='text' class='year'  name='edadPaciente' id='edadPaciente' disabled value="<?php 
						echo $row9['edad']; ?>"> 
				<label class='form-sub-label1'> EDAD </label>								
            </span>
			

                <span class='form-sub-label'>

			<input type='text' class='year' name='generoPaciente'  id='generoPaciente' disabled value="<?php 
						echo $row9['genero']; ?>"> 
				<label class='form-sub-label1'> GENERO </label>
			</span>


			<span class='form-sub-label'>
				<input type='text' class='year' name='expedientePaciente'  disabled id='expedientePaciente' value="<?php 
						echo $row9['expediente']; ?>">
				<label class='form-sub-label1'> N° EXPEDIENTE </label>
			</span>
            
		</div>
	</li>

						
                        <li>
						<input type="hidden" id="idDomicilioResponsable"
					 name="idDomicilioResponsable"  value="<?php 
						echo $row9['idDomicilioR']; ?>">


							<label class="form-label"> 
								ESTADO
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente" disabled id="temporalExpediente"  value="<?php 
						echo $row9['estado']; ?>">
							</div>
						</li>

                        <li>
							<label class="form-label"> 
								MUNICIPIO/CIUDAD
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="temporalExpediente"  disabled id="temporalExpediente"  value="<?php 
						echo $row9['municipio']; ?>">
							</div>
						</li>

		
		
		</form>


	
		<li>
							<label class="form-label"> 
								LOCALIDAD
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="localidadResponsable" disabled id="localidadResponsable"  value="<?php 
						echo $row9['localidad']; ?>">
							</div>
						</li>

		<li>
							<label class="form-label"> 
								CALLE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="calleResponsable" disabled id="calleResponsable" value="<?php 
						echo $row9['calle']; ?>">
							</div>
						</li>


						<li>
							<label class="form-label"> 
								COLONIA
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="coloniaResponsable" disabled id="coloniaResponsable" value="<?php 
						echo $row9['colonia']; ?>">
							</div>
						</li>



		<li>
							<label class="form-label"> 
								CODIGO POSTAL
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="cpResponsable" disabled id="cpResponsable" value="<?php 
						echo $row9['cp']; ?>">
							</div>
						</li>

						<li>
							<label class="form-label"> 
								TELEFONO
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="telefonoResponsable" disabled id="telefonoResponsable" value="<?php 
						echo $row9['telefono']; ?>">
							</div>
						</li>
						<?php } ?>

						<br>
						<h4 align="center">TESTIGO</h4>

						<?php while($row10= $resultado10->fetch_assoc()) { ?>	

						<li>
							<label class="form-label"> 
								NOMBRE
								<span class="form-required"> * </span>
							</label>
							<div class="form-input">
								<input type="text" name="nombreTestigo" id="nombreTestigo" disabled value="<?php 
						echo $row10['nombre_testigo']; ?>">
							</div>
						</li>

						
						<li>
							<label class="form-label">
							   IDENTFICADOR
							   <span class="form-required"> * </span>
							</label>
							<div class="form-input dob">
								<span class="form-sub-label">
									
								<input type="text" class="year" name="edadTestigo" disabled id="edadTestigo"   value="<?php 
						echo $row10['edad_testigo']; ?>">
									<label class="form-sub-label1"> EDAD </label>							
									</span>
								
                                    <span class="form-sub-label">
							
                                    <input type="text" class="year" name="edadTestigo" disabled id="edadTestigo"   value="<?php 
						echo $row10['genero_testigo']; ?>"> 
                                
                                
								<label class="form-sub-label1"> GENERO </label>
								
                            
                            </span>
								<span class="form-sub-label">
									<input type="text" class="year" name="telefonoTestigo"  disabled id="telefonoTestigo"  value="<?php 
						echo $row10['telefono_testigo']; ?>">
									<label class="form-sub-label1"> TELEFONO </label>
								</span>
							</div>
						</li>
						<?php } ?>

					</ul>
					<input type="submit" value="Actualizar">

					


				</form>	
			</div>
		</div>


		</div>












<script>



</script>
  

</body>
</html>