<?php
require_once "config/config.php";
require_once "vendor/autoload.php";

$idpersona = $_GET['id_persona'];

$conn = new mysqli($host, $user, $pass,$db,$port);
if($conn->connect_error){die("fatal error");}

// Query para obtener los datos de paciente(diagnostico, expediente, persona, domicilio), su responsable(domicilio) y su testigo
$query = "SELECT nombre_persona, paterno_persona, materno_persona, genero_persona, nacimiento_persona, 
telefono_persona, curp_persona, ine_persona, YEAR(CURDATE())-YEAR(nacimiento_persona) + IF(DATE_FORMAT(CURDATE(),'%m-%d') > DATE_FORMAT(nacimiento_persona,'%m-%d'), 0 , -1 ) AS edad, 
escolaridad_paciente, estado_civil_paciente, tipo_paciente, 
calle_domicilio, colonia_domicilio, cp_domicilio, nombre_diagnostico, numero_expediente, 
date_format(fecha_creacion_expediente, '%d-%m-%Y') as fechaCreacion, time(fecha_creacion_expediente) as horaCreacion, day(date(fecha_creacion_expediente)) as diaCreacion, ELT(MONTH(date(fecha_creacion_expediente)), 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre') as mesCreacion, tratante.id_persona as id_per_tratante, cedula_tratante, especialidad_tratante, nombre_responsable, numero_expediente_responsable, edad_responsable, genero_responsable, telefono_responsable, responsable.id_domicilio as domicilioresponsable, nombre_testigo, edad_testigo, genero_testigo, telefono_testigo from persona 
join paciente on persona.id_persona = paciente.id_persona join domicilio on paciente.id_domicilio = domicilio.id_domicilio join expediente on paciente.id_expediente = expediente.id_expediente join diagnostico on expediente.id_diagnostico = diagnostico.id_diagnostico join tratante on expediente.id_tratante = tratante.id_tratante join responsable on paciente.id_responsable = responsable.id_responsable join testigo on paciente.id_testigo = testigo.id_testigo where persona.id_persona = ".$idpersona;
$result = $conn->query($query);
$row=$result->fetch_array(MYSQLI_ASSOC);

// Query para obtener datos del tratante
$idPerTratante = $row['id_per_tratante'];
$query_trat = "SELECT nombre_persona, paterno_persona, materno_persona from persona where id_persona = ".$idPerTratante;
$result_trat = $conn->query($query_trat);
$row_t=$result_trat->fetch_array(MYSQLI_ASSOC);

// Query para obtener datos del domicilio de responsable
$id_domicilio_responsable = $row['domicilioresponsable'];
$query_dom = "SELECT calle_domicilio, colonia_domicilio, cp_domicilio from domicilio where id_domicilio = ".$id_domicilio_responsable;
$result_dom = $conn->query($query_dom);
$row_dom=$result_dom->fetch_array(MYSQLI_ASSOC);

// Manejo de plantilla
$templateWord = new \PhpOffice\PhpWord\TemplateProcessor('prueba.docx');

// Datos de paciente
$numero_expediente = $row['numero_expediente'];
$nombre = $row['nombre_persona']." ".$row['paterno_persona']." ".$row['materno_persona'];
$edad = $row['edad'];
$genero = $row['genero_persona'];
$fechaCreacion = $row['fechaCreacion'];
$horaCreacion = $row['horaCreacion'];
$diaCreacion = $row['diaCreacion'];
$mesCreacion = $row['mesCreacion'];
$diagnostico = $row['nombre_diagnostico'];
$telefono = $row['telefono_persona'];
$curp = $row['curp_persona'];
$ine = $row['ine_persona'];
$calle = $row['calle_domicilio'];
$colonia = $row['colonia_domicilio'];
$codigopostal = $row['cp_domicilio'];

// Datos tratante
$tratante = $row['especialidad_tratante']." ".$row_t['nombre_persona']." ".$row_t['paterno_persona']." ".$row_t['materno_persona'];
$cedula_profesional = $row['cedula_tratante'];

// Datos responsable
$nombre_responsable = $row['nombre_responsable'];
$expediente_responsable = $row['numero_expediente_responsable'];
$edad_responsable = $row['edad_responsable'];
$genero_responsable = $row['genero_responsable'];
$telefono_responsable = $row['telefono_responsable'];
$calle_responsable = $row_dom['calle_domicilio'];
$colonia_responsable = $row_dom['colonia_domicilio'];
$codigopostal_responsable = $row_dom['cp_domicilio'];

// Datos testigo 
$nombre_testigo = $row['nombre_testigo'];
$edad_testigo = $row['edad_testigo'];
$genero_testigo = $row['genero_testigo'];
$telefono_testigo = $row['telefono_testigo'];

$templateWord->setValues([
    'numero_expediente' => $numero_expediente,
    'nombre' => $nombre,
    'edad'=> $edad,
    'genero' => $genero,
    'fecha_c' => $fechaCreacion,
    'hora_fechac' => $horaCreacion, 
    'dia_fechac' => $diaCreacion,
    'mes_fechac' => $mesCreacion,
    'diagnostico' => $diagnostico, 
    'telefono' => $telefono,
    'curp_persona' => $curp,
    'ine_persona' => $ine,
    'calle' => $calle,
    'colonia' => $colonia,
    'codigopostal' => $codigopostal,
    'tratante' => $tratante,
    'cedula_profesional' => $cedula_profesional,
    'nombre_responsable' => $nombre_responsable,
    'expediente_responsable' => $expediente_responsable,
    'edad_responsable' => $edad_responsable,
    'genero_responsable' => $genero_responsable,
    'calle_responsable' => $calle_responsable,
    'colonia_responsable' => $colonia_responsable,
    'codigo_responsable' => $codigopostal_responsable,
    'telefono_responsable' => $telefono_responsable,
    'nombre_testigo' => $nombre_testigo,
    'edad_testigo' => $edad_testigo,
    'genero_testigo' => $genero_testigo,
    'telefono_testigo' => $telefono_testigo
]);

// Guardamos el documento con los datos
$path_save=str_replace("/", "_", $numero_expediente).'-'.$nombre.'.docx';
$templateWord->saveAs($path_save);

header("Content-Description: File Transfer");
header('Content-Disposition: attachment; filename="'.$path_save.'"');
header('Content-Type: application/octet-stream'); //application/vnd.openxmlformats-officedocument.wordprocessingml.document
header('Content-Transfer-Encoding: binary');
header('Cache-Control: must-revalidate, post-check=0, pre-check=0');
header('Expires: 0');
header("Content-Lenght: ".filesize($path_save));
readfile($path_save);
unlink($path_save);
?>