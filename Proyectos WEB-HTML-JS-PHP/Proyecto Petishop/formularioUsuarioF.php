<?php 


header('Access-Control-Allow-Origin: *');

/*echo "<h1>Orlando</h1>";
echo "<pre>";
var_dump($_POST);
echo "</pre>";*/

$cnn = new mysqli("localhost","root","root","petishop");

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
			$consul = $cnn->query("SELECT * FROM usuario where status_usu='activo'");
			$cad ="<table class='responstable' id='tabla' border='1' >
            <tbody id='tb'>

            <tr style='font-style: oblique;'>
			    <th style='text-align:center; vertical-align:middle'>Id &nbsp</th>
                <th style='text-align:center; vertical-align:middle'>Email &nbsp</th>
                <th style='text-align:center; vertical-align:middle'>Password &nbsp</th>

                <th style='text-align:center; vertical-align:middle'>Nombre</th>
                 <th style='text-align:center; vertical-align:middle'>Paterno</th>
                 <th style='text-align:center; vertical-align:middle'>Materno </th>
                 <th style='text-align:center; vertical-align:middle'>&nbsp Genero</th>
                 <th style='text-align:center; vertical-align:middle'>Nacimiento</th>
                 <th style='text-align:center; vertical-align:middle'>Pais</th>
                 <th style='text-align:center; vertical-align:middle'>Estado</th>
                 <th style='text-align:center; vertical-align:middle'>Ciudad</th>
                 <th style='text-align:center; vertical-align:middle'>Colonia</th>
                 <th style='text-align:center; vertical-align:middle'>Cp</th>
                 <th style='text-align:center; vertical-align:middle'>Calle</th>
				 <th style='text-align:center; vertical-align:middle'>Municipio</th>
                 <th style='text-align:center; vertical-align:middle'></th>
                 <th style='text-align:center; vertical-align:middle'></th>


            </tr>";


			while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
				$cad.="<tr class='centro'>

                            <td >$ren[cve_usu]</td>
                            <td>$ren[email_usu]</td>
                            <td>$ren[password_usu]</td>

							<td>$ren[nombre_usu]</td>
							<td>$ren[paterno_usu]</td>
							<td>$ren[materno_usu]</td>
                            <td>$ren[genero_usu]</td>
                            <td>$ren[nacimiento_usu]</td>
                            <td>$ren[pais_usu]</td>
                            <td>$ren[estado_usu]</td>
                            <td>$ren[ciudad_usu]</td>
                            <td>$ren[colonia_usu]</td>
                            <td>$ren[cp_usu]</td>
                            <td>$ren[calle_usu]</td>
							<td>$ren[municipio_usu]</td>

                            <td><button onclick='eliminar(this);'>Eliminar</button></td>
                            <td><button onclick='detallarModificar(this);'>Modificar</button></td>



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
				$cnn->query("update usuario set status_usu='inactivo' where cve_usu='".$_POST["cve_usu"]."'");
				echo "Eliminacion exitosa";
		break;


			
		case 'listarMunicipio':
			$consul = $cnn->query("SELECT nombre FROM municipios");
			$cad ="<select name='municipio' id='municipio' >";
			$cad .="<option>Selecciona un municipio</option>";
			while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
				$cad.="<option value='$ren[nombre]'>
				 $ren[nombre]
			 </option>";	
			}
					$cad.="</select>";
			echo $cad;

			break;



			
		case 'listarEstado':
			$consul = $cnn->query("SELECT nombre FROM estados");
			$cad ="<select name='estado' id='estado' >";
			$cad .="<option>Selecciona un estado</option>";
			while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
				$cad.="<option value='$ren[nombre]'>
				 $ren[nombre]
			 </option>";	
			}
					$cad.="</select>";
			echo $cad;

			break;


		case 'modificar':
			$cnn->query("update usuario set email_usu='".$_POST["email_usu"]."'
			, password_usu='".$_POST["password_usu"]."', nombre_usu='".$_POST["nombre_usu"]."' , paterno_usu='".$_POST["paterno_usu"]."',
			materno_usu='".$_POST["materno_usu"]."', genero_usu='".$_POST["genero_usu"]."' 
			, nacimiento_usu='".$_POST["nacimiento_usu"]."' , pais_usu='".$_POST["pais_usu"]."'
			, estado_usu='".$_POST["estado_usu"]."' , ciudad_usu='".$_POST["ciudad_usu"]."',  colonia_usu='".$_POST["colonia_usu"]."',   
			cp_usu='".$_POST["cp_usu"]."', calle_usu='".$_POST["calle_usu"]."' , municipio_usu='".$_POST["municipio_usu"]."' WHERE cve_usu='".$_POST["cve_usu"]."'");



			//echo "Eliminacion exitosa";
		break;


		case 'buscar':
			$consul = $cnn->query("SELECT * FROM usuario where nombre_usu='".$_POST["nombre_usu"]."'");
			$cad ="<table class='responstable' id='tabla' border='1' >
            <tbody id='tb'>

            <tr style='font-style: oblique;'>
			    <th style='text-align:center; vertical-align:middle'>Id &nbsp</th>
                <th style='text-align:center; vertical-align:middle'>Email &nbsp</th>
                <th style='text-align:center; vertical-align:middle'>Password &nbsp</th>

                <th style='text-align:center; vertical-align:middle'>Nombre</th>
                 <th style='text-align:center; vertical-align:middle'>Paterno</th>
                 <th style='text-align:center; vertical-align:middle'>Materno </th>
                 <th style='text-align:center; vertical-align:middle'>&nbsp Genero</th>
                 <th style='text-align:center; vertical-align:middle'>Nacimiento</th>
                 <th style='text-align:center; vertical-align:middle'>Pais</th>
                 <th style='text-align:center; vertical-align:middle'>Estado</th>
                 <th style='text-align:center; vertical-align:middle'>Ciudad</th>
                 <th style='text-align:center; vertical-align:middle'>Colonia</th>
                 <th style='text-align:center; vertical-align:middle'>Cp</th>
                 <th style='text-align:center; vertical-align:middle'>Calle</th>
				 <th style='text-align:center; vertical-align:middle'>Municipio</th>
                 <th style='text-align:center; vertical-align:middle'></th>
                 <th style='text-align:center; vertical-align:middle'></th>


            </tr>";


			while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
				$cad.="<tr class='centro'>

                            <td >$ren[cve_usu]</td>
                            <td>$ren[email_usu]</td>
                            <td>$ren[password_usu]</td>

							<td>$ren[nombre_usu]</td>
							<td>$ren[paterno_usu]</td>
							<td>$ren[materno_usu]</td>
                            <td>$ren[genero_usu]</td>
                            <td>$ren[nacimiento_usu]</td>
                            <td>$ren[pais_usu]</td>
                            <td>$ren[estado_usu]</td>
                            <td>$ren[ciudad_usu]</td>
                            <td>$ren[colonia_usu]</td>
                            <td>$ren[cp_usu]</td>
                            <td>$ren[calle_usu]</td>
							<td>$ren[municipio_usu]</td>

                            <td><button onclick='eliminar(this);'>Eliminar</button></td>
                            <td><button onclick='detallarModificar(this);'>Modificar</button></td>



						</tr>";
			}
			$cad.="</table>";
			$cad.="</tbody>";


			echo $cad;
			/*echo "<pre>";
			var_dump($ren);
			echo "</pre>";*/
			break;
	}
	//<input type='button' value='Eliminar' onclick='javascript:eliminar($ren[cve_asp]);'>

}
?>



