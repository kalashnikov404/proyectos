<?php




class Conexion{

    private $host;
    private $user;
    private $pwd;
    private $db;
    private $port;
    private $conn;
    

function __construct($host, $user, $pwd, $db, $port){
$this->host=$host;
$this->user=$user;
$this->pwd=$pwd;
$this->db=$db;
$this->port=$port;


}




function conectar(){
   
   $this->conn=new mysqli($this->host, $this->user,$this->pwd,$this->db,$this->port);
   // $this->conn = new mysqli('127.0.0.1', 'root','root','petishop', '3306');
    
    
    if($this->conn->connect_error) die ("");
}


function consulta($qry){

    $c = $this->conn;
    $result = $c->query($qry);
    if(!$result)die("Error en consulta");

    return $result;
}



function getDatos($qry){
    $data = array();

$result=mysqli_query($this->conn, $qry);
$error= mysqli_error($this->conn);

if(empty($error)){
if(mysqli_num_rows($result)>0){

while($row =mysqli_fetch_assoc($result)){

array_push($data, $row);

}    
}
}else{
echo "";
}

return $data;
}


function instruccion($qry){
    $result = mysqli_query($this->conn, $qry);
    $error = mysqli_error($this->conn);

if(empty($error)){

return 'ok';



}else{
    return "Ocurrio un error";
}


}




function cerrar(){
    mysqli_close($this->conn);
}






}

?>