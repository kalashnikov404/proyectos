

<?php


header('Access-Control-Allow-Origin: *');
// Initialize the session
session_start();
 
// Check if the user is logged in, if not then redirect him to login page
if(!isset($_SESSION["loggedin"]) || $_SESSION["loggedin"] !== true){
    header("location: index.php");
    exit;
}







?>



<!DOCTYPE html>
<html>


<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Lector QR</title>
	<link rel="stylesheet" href="">
    <link rel="stylesheet" type="text/css" href="css/estilos2.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


 <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
 <link href='https://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext' rel='stylesheet' type='text/css'> 

 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>  
    
	

<style>

@media (min-width:320px){
 
	.col-lg-9{
		width: 55% ;
		height: 50;
  border-radius: 5px;
  text-align: center;
  }

}



/* Responsive Mobile section */
@media (min-width:480px) {


	.col-lg-9{
  width: 65% ;
  height: 50;

  border-radius: 5px;

  text-align: center;
	}
}
</style>


</head>
<body>
<button  onclick="window.location.href='home.php'" type="button" style=" height: 40px; width: 70px;">Volver</button>

	<div class="container">
		<div class="container-fluid">
			<div class="row justify-content-center align-items-center vh-100">
			<legend  id="head2" style="text-align:center; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif; color: rgb(255, 255, 255); font-size: 40px;" class="text-center header">Lector de datos QR</legend>
				<div class="col-lg-9" style="text-align: center;">
					<video id="previsualizacion" class="p-1 border" ></video>
				</div>
				<p id="resultado"></p>
			</div>
		</div>
	</div>
	<script src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>

	<script type="text/javascript">


		var scanner = new Instascan.Scanner({ //funcion de escaner en tiempo real, se importa la libreria
			video: document.getElementById('previsualizacion'),//obtiene el codigo leido en el video
			scanPeriod: 5,//analiza cada cuadro
			mirror: true //	esto es para como se visualiza
		});

	


		Instascan.Camera.getCameras().then(function (cameras) {
            //If a camera is detected
            if (cameras.length > 0) {
                //If the user has a rear/back camera
                if (cameras[1]) {
                    //use that by default
                    scanner.start(cameras[1]);
                } else {
                    //else use front camera
                    scanner.start(cameras[0]);
                }
            } else {
                //if no cameras are detected give error
                console.error('No se encontro camara.');
            }
        }).catch(function (e) {
            console.error(e);
			alert('Error'+e);

        });   


		scanner.addListener('scan',function(respuesta){ //evento donde escucha si la funcion se ha ejecutado
			console.log('contenido '+respuesta);
			
			
/*
    var final =JSON.stringify(respuesta) ;

    var nuevo = JSON.parse(final);
*/

//alert(respuesta);
var obj = JSON.parse(respuesta); 

	var values = Object.keys(obj).map(function (key) { return obj[key]; });

var final =JSON.stringify(values) ;


var array1 = final.split(',');

var a=array1;


var y = a.at(0);
var z = a.at(1);
var w = a.at(2);


y= y.replaceAll('[', '');
w= w.replaceAll(/['"]+/g, '');

//alert(y+z+w);


asignar(y,z,w);
		});

function asignar(a,b,c){

$.ajax({
	url: 'formularioVinculacionF.php',
	type: 'POST',
	dataType: 'html',
	data: {opc: 'checked',

	id:a,
	cve_eve: b,
	email_asp: c,

},
})
.done(function(res) {

	swal("Exito", "Asistencia realizada!", "success");
})
.fail(function() {
	console.log("error");
})
.always(function() {
	console.log("complete");
});

		}


	</script>
</body>
</html>