<?php
require_once "config/config.php";
require_once "vendor/autoload.php";
\PhpOffice\PhpWord\Settings::setZipClass(\PhpOffice\PhpWord\Settings::PCLZIP);
//use PhpOffice\PhpWord\Settings;
//Settings::loadConfig();
//Settings::setZipClass(Settings::PCLZIP);

$idpersona = $_POST['id_persona'];

$conn = new mysqli($host, $user, $pass,$db,$port);
if($conn->connect_error){die("fatal error");}

$query = "SELECT * from persona join paciente on persona.id_persona = paciente.id_persona join diagnostico on paciente.id_diagnostico = diagnostico.id_diagnostico join expediente on paciente.id_expediente = expediente.id_expediente where persona.id_persona = ".$idpersona; // GROUP by numero_expediente
$result = $conn->query($query);
$row=$result->fetch_array(MYSQLI_ASSOC);

// Manejo de plantilla
$templateWord = new \PhpOffice\PhpWord\TemplateProcessor('prueba.docx');

$numero_expediente = $row['numero_expediente'];
$nombre = $row['nombre_persona']." ".$row['paterno_persona']." ".$row['materno_persona'];

// Asignamos valores a la plantilla
$templateWord->setValue('numero_expediente', $numero_expediente);
$templateWord->setValue('nombre', $nombre);

$templateWord->saveAs('paciente.docx');

header("Content-Description: File Transfer");
header("Content-Disposition; attachment; filename=Paciente.docx; charset=iso-8859-1");
header("Content-Type: application/vnd.openxmlformats-officedocument.wordprocessingml.document");
readfile('paciente.docx');
//echo file_get_contents('Paciente.docx');
?>