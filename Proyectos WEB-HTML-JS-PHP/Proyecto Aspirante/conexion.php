<?php
/* Database credentials. Assuming you are running MySQL
server with default setting (user 'root' with no password) */
define('DB_SERVER', 'itzitacuaro.edu.mx');
define('DB_USERNAME', 'itzitacu_usereq1');
define('DB_PASSWORD', 'ypP.In8?rDN9');
define('DB_NAME', 'itzitacu_eq1');
 
/* Attempt to connect to MySQL database */
$link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
 
// Check connection
if($link === false){
    die("ERROR: No se pudo conectar a la base de datos. " . mysqli_connect_error());
}
?>