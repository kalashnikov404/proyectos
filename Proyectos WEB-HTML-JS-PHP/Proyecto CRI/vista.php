<?php
require_once "config.php";
require_once "app_top.php";

$conn = new mysqli($host, $user, $pass,$db,$port);
if($conn->connect_error){die("fatal error");}

$query = "SELECT persona.id_persona, numero_expediente, nombre_persona, paterno_persona, materno_persona, tipo_paciente, nombre_diagnostico from persona join paciente on persona.id_persona = paciente.id_persona join expediente on paciente.id_expediente = expediente.id_expediente join diagnostico on expediente.id_diagnostico = diagnostico.id_diagnostico";
$result = $conn->query($query);
$lineas = $result->num_rows;
echo <<<_tablat
<table class="table table-striped">
<thead>
    <tr>
    <th scope="col">No. Expediente</th>
    <th scope="col">Nombre</th>
    <th scope="col">Diagnostico inicial</th>
    <th scope="col">Tipo</th>
    <th scope="col">Acciones</th>
    </tr>
</thead>
<tbody>
_tablat;

for($i = 0; $i < $lineas; $i++){
    $row=$result->fetch_array(MYSQLI_ASSOC);
    echo "<tr>";
    echo "<td>".$row['numero_expediente']."</td>";
    echo "<td>".$row['nombre_persona'].' '.$row['paterno_persona'].' '.$row['materno_persona']."</td>";
    echo "<td>".$row['nombre_diagnostico']."</td>";
    echo "<td>".$row['tipo_paciente']."</td>";
    echo "<td><button class='btn btn-info' onClick='digitalizar(".$row['id_persona'].")'>Digitalizar</button></td>";
    echo "</tr>";
}

echo <<<_tablab
</tbody>
    </table>
_tablab;

echo "<script src='js/main.js'></script>";
require_once "app_down.php";

?>