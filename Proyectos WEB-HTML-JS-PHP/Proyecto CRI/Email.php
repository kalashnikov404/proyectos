<?php 


header('Access-Control-Allow-Origin: *');

$cnn = new mysqli("localhost","root","root","cri");

if ($cnn->connect_errno) {
	echo "Ocurrio un error";
	exit();
} else {

    //$ejec = $cnn->query(INSERT INTO personas VALUES (NULL, ""));

    switch ($_POST['opc']) {

        
        case 'consulta':
            $consul = $cnn->query("SELECT contrasena_usuario FROM usuario  WHERE email_usuario='".$_POST["email_usuario"]."'");
            $cad="";
			while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
                $cad ="<input type=disabled' id='keyy' name='keyy' value='$ren[contrasena_usuario]'>";

							
			}
			


			echo $cad;
			/*echo "<pre>";
			var_dump($ren);
			echo "</pre>";*/
			break;
        
        
        }




		
}
?>
