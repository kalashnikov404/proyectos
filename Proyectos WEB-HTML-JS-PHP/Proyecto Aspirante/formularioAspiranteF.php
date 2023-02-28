<?php 


header('Access-Control-Allow-Origin: *');

/*echo "<h1>Orlando</h1>";
echo "<pre>";
var_dump($_POST);
echo "</pre>";*/

$cnn = new mysqli("itzitacuaro.edu.mx","itzitacu_usereq1","ypP.In8?rDN9","itzitacu_eq1");

if ($cnn->connect_errno) {
	echo "Ocurrio un error";
	exit();
}else{

	//$ejec = $cnn->query(INSERT INTO personas VALUES (NULL, ""));

	switch ($_POST['opc']) {

		case 'subir':
			$ejec = $cnn->query("INSERT INTO aspirante VALUES (NULL, '".$_POST["cve_asp"]."', '".$_POST["nombre_asp"]."', '".$_POST["paterno_asp"]."' ,'".$_POST["materno_asp"]."','".$_POST["edad_asp"]."', '".$_POST["sexo_asp"]."' , '".$_POST["email_asp"]."', 1)");
			echo $cnn->insert_id;
			break;

		case 'consulta':
			$consul = $cnn->query("SELECT * FROM aspirante  where status_asp='1'");
			$cad ="<table class='responstable' id='tabla' border='1'>
            <tbody id='tb'>

            <tr style='text-transform:uppercase;'>
			<th>Id &nbsp</th>
                <th>Clave</th>
                 <th>&nbsp Nombre</th>
                 <th>Paterno</th>
                 <th>Materno </th>
                 <th>Edad</th>
                 <th>&nbsp Sexo</th>
                 <th>Email</th>
                 <th></th>
                 <th></th>
                 <th></th>

            </tr>";


			while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
				$cad.="<tr class='centro'>
				<td >$ren[id]</td>

                            <td >$ren[cve_asp]</td>
							<td>$ren[nombre_asp]</td>
							<td>$ren[paterno_asp]</td>
							<td>$ren[materno_asp]</td>
                            <td>$ren[edad_asp]</td>
							<td>$ren[sexo_asp]</td>
							<td>$ren[email_asp]</td>

							<td><button onclick='javascript:detallar(this);'>Detalles</button></td>

							<td><button onclick='javascript:detallar2(this);'>Modificar</button></td>
							<td><button onclick='javascript:eliminar(this);'>Eliminar</button></td>


						</tr>";
			}
			$cad.="</table>";
			$cad.="</tbody>";


			echo $cad;
			/*echo "<pre>";
			var_dump($ren);
			echo "</pre>";*/
			break;

		case 'eliminar':
			$cnn->query("update aspirante set status_asp=0 WHERE id='".$_POST["id"]."'");
			echo "Eliminacion exitosa";

		break;

		case 'modificar':
			$cnn->query("update aspirante set cve_asp='".$_POST["cve_asp"]."', nombre_asp='".$_POST["nombre_asp"]."'
			, paterno_asp='".$_POST["paterno_asp"]."' , materno_asp='".$_POST["materno_asp"]."',
			edad_asp='".$_POST["edad_asp"]."', sexo_asp='".$_POST["sexo_asp"]."' 
			, email_asp='".$_POST["email_asp"]."' WHERE id='".$_POST["id"]."'");



			//echo "Eliminacion exitosa";
		break;



/*
		case 'eliminar2':
			$cnn->query("DELETE FROM aspirante WHERE id='".$_POST["id"]."'");
			echo "Eliminacion exitosa";
			break;
			*/

	}
	//<input type='button' value='Eliminar' onclick='javascript:eliminar($ren[cve_asp]);'>

}
?>



