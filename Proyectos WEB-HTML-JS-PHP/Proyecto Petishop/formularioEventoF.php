<?php 




$cnn = new mysqli("itzitacuaro.edu.mx","itzitacu_usereq1","ypP.In8?rDN9","itzitacu_eq1");

if ($cnn->connect_errno) {
	echo "Ocurrio un error";
	exit();
}else{


	switch ($_POST['opc']) {

		case 'subir':
			$ejec = $cnn->query("INSERT INTO evento VALUES (NULL, '".$_POST["nombre_eve"]."', '".$_POST["ponente_eve"]."' ,'".$_POST["inicial_eve"]."','".$_POST["final_eve"]."', '".$_POST["cupo_eve"]."' , '".$_POST["descripcion_eve"]."', 'Activo', NULL)");
			echo $cnn->insert_id;
			break;

           


		case 'consulta':
			$consul = $cnn->query("SELECT * FROM evento ");
			$cad ="<table class='responstable' id='tabla' border='1'>
            <tbody id='tb'>

            <tr style='text-transform:uppercase;'>
			    <th>Id &nbsp</th>
                <th> &nbsp Nombre  &nbsp</th>
                 <th>&nbsp Ponente</th>
                 <th>F.Inicio  &nbsp</th>
                 <th>F.Fin  &nbsp</th>
                 <th>Cupo  &nbsp</th>
                 <th>&nbsp Descripcion  &nbsp</th>
                 <th>Status  &nbsp</th>
                 <th>Motivo  &nbsp</th>

                 <th></th>
                 <th></th>
                 <th></th>
				 <th></th>
                 <th></th>
                 <th></th>
				 <th></th>
                 <th></th>
                 <th></th>


            </tr>";


			while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
				$cad.="<tr class='centro'>

                            <td >$ren[cve_eve]</td>
							<td>$ren[nombre_eve]</td>
							<td>$ren[ponente_eve]</td>
							<td>$ren[inicial_eve]</td>
                            <td>$ren[final_eve]</td>
							<td>$ren[cupo_eve]</td>
							<td>$ren[descripcion_eve]</td>
                            <td class'filtro'>$ren[status_eve]</td>
                            <td>$ren[motivo_eve]</td>


							<td><button onclick='javascript:detallar2(this);'>Detalles</button></td>

							<td><button onclick='javascript:detallar3(this);'>Modificar</button></td>
							<td><button onclick='javascript:eliminar(this);'>Eliminar</button><td>
							<td><button onclick='javascript:posponer(this);'>Posponer</button><td>
							<td><button onclick='javascript:cancelar(this);'>Cancelar</button><td>
							<td><button onclick='javascript:reactivar(this);'>Reactivar</button><td>

							</tr>";
			}
			$cad.="</table>";
			$cad.="</tbody>";


			echo $cad;
			/*echo "<pre>";
			var_dump($ren);
			echo "</pre>";*/
			break;


		case 'modificar':
			$cnn->query("update evento set nombre_eve='".$_POST["nombre_eve"]."', ponente_eve='".$_POST["ponente_eve"]."'
			, inicial_eve='".$_POST["inicial_eve"]."' , final_eve='".$_POST["final_eve"]."', cupo_eve='".$_POST["cupo_eve"]."', 
			descripcion_eve='".$_POST["descripcion_eve"]."' WHERE cve_eve='".$_POST["cve_eve"]."'");
			//echo "Modificacion exitosa";
		break;

		case 'posponer':
			$cnn->query("update evento set status_eve='Pospuesto' WHERE cve_eve='".$_POST["cve_eve"]."'");
			//echo "Eliminacion exitosa";

		break;

		case 'reactivar':
			$cnn->query("update evento set status_eve='Reactivado' WHERE cve_eve='".$_POST["cve_eve"]."'");
			//echo "Eliminacion exitosa";

		break;

		case 'cancelar':
			$cnn->query("update evento set status_eve='Cancelado' WHERE cve_eve='".$_POST["cve_eve"]."'");
			//echo "Eliminacion exitosa";

		break;

		case 'eliminar':
			$cnn->query("update evento set status_eve='Eliminado' WHERE cve_eve='".$_POST["cve_eve"]."'");
			//echo "Eliminacion exitosa";

		break;


	}
	//<input type='button' value='Eliminar' onclick='javascript:eliminar($ren[cve_asp]);'>

}
?>



