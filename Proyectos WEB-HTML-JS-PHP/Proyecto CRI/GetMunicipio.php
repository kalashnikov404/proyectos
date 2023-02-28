<?php
	require ('Conexion.php');
	
	$id_estado = $_POST['id_estado'];
	
	$queryM = "SELECT id_municipio, municipio FROM t_municipio WHERE id_estado = '$id_estado' ORDER BY municipio";
	$resultadoM = $mysqli->query($queryM);
	
	$html= "<option  style='text-align: center;'value='0'>Selecciona un municipio</option>";
	
	while($rowM = $resultadoM->fetch_assoc())
	{
		$html.= "<option  style='text-align: center;' value='".$rowM['id_municipio']."'>".$rowM['municipio']."</option>";
	}
	
	echo $html;
?>