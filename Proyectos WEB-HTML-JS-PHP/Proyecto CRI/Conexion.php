<?php
    $host     = 'localhost';
    $username = 'root';
    $password = 'root';
    $dbname   ='cri';

    $conn = new mysqli($host, $username, $password, $dbname);
    
    if(!$conn){
        die("No se pudo conectar a la base de datos.". $conn->error);
    }
?>    