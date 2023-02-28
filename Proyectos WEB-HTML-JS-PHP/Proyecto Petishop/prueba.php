<?php

$cnn=new mysqli("localhost", "root", "root", "web");
if($cnn->connect_errno){
    echo "Ocurrio un error al conectar con la base de datos" . $cnn->connect_error;
    exit();
}else{
   // echo "Conexion exitosa";
   $ejec=$cnn->query("INSERT INTO persona VALUES(NUll, 'Rodrigo', '22', 'M',NOW())");

echo("insertado con exito");

   }




?>