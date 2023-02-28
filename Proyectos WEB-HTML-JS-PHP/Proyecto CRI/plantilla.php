<?php




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

	<link rel="stylesheet" href="FormEditarExpediente.css">
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

	


		<div class="container" id="container"   style="background: #435d7d;">
	
	


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
	








</body>
</html>