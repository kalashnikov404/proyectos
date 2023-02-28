<?php 
$f2="n0.gif";
$f3="n0.gif";
$f4="n0.gif";



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
			$ejec = $cnn->query("INSERT INTO venta VALUES (NULL, '".$_POST["cve_asp"]."', '".$_POST["nombre_asp"]."', '".$_POST["paterno_asp"]."' ,'".$_POST["materno_asp"]."','".$_POST["edad_asp"]."', '".$_POST["sexo_asp"]."' , '".$_POST["email_asp"]."', 1)");
			echo $cnn->insert_id;
			break;

		case 'consulta':

            $consul = $cnn->query("SELECT venta.cve_ven, venta.fecha_ven, total_ven, pago_ven, cantidad_ven, status_ven, email_usu, codigo_pro, cve_prov
			FROM venta INNER JOIN detalle_venta ON venta.cve_detven=detalle_venta.cve_detven  
			INNER JOIN detalle_proveedorproducto ON venta.num_provpro=detalle_proveedorproducto.num_provpro;");


			$cad ="<table class='responstable' id='tabla' border='1' >
            <tbody id='tb'>

            <tr style='font-style: oblique;'>
			    <th style='text-align:center; vertical-align:middle'>Id venta &nbsp</th>
                <th style='text-align:center; vertical-align:middle'>Fecha &nbsp</th>
                <th style='text-align:center; vertical-align:middle'>Total &nbsp</th>

                 <th style='text-align:center; vertical-align:middle'>Pago</th>
                 <th style='text-align:center; vertical-align:middle'>Cantidad </th>
                 <th style='text-align:center; vertical-align:middle'>Status </th>


                 <th style='text-align:center; vertical-align:middle'>Email </th>
                 <th style='text-align:center; vertical-align:middle'>Codigo de barras</th>
				 <th style='text-align:center; vertical-align:middle'>Id proveedor</th>
				
				 <th style='text-align:center; vertical-align:middle'></th>



            </tr>";


			while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
				$cad.="<tr class='centro'>

                            <td >$ren[cve_ven]</td>
                            <td>$ren[fecha_ven]</td>
                            <td>$$ren[total_ven]</td>

							<td>$ren[pago_ven]</td>
							<td>$ren[cantidad_ven]</td>
							<td>$ren[status_ven]</td>

							<td>$ren[email_usu]</td>



                        	<td>$ren[codigo_pro]</td>

							<td>$ren[cve_prov]</td>
							
							<td><button id='dev' onclick='detallarDevolucion(this);'>Devolver</button></td>


                    
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


		case 'devolucion':
			$cnn->query("update venta set motivo_ven='".$_POST["motivo_ven"]."', 
			status_ven='Devuelto' WHERE cve_ven='".$_POST["cve_ven"]."'");



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



