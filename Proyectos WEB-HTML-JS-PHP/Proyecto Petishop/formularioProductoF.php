<?php 
$f2="n0.gif";
$f3="n0.gif";
$f4="n0.gif";



header('Access-Control-Allow-Origin: *');

$cnn = new mysqli("localhost","root","root","petishop");

if ($cnn->connect_errno) {
	echo "Ocurrio un error";
	exit();
}else{

	//$ejec = $cnn->query(INSERT INTO personas VALUES (NULL, ""));

	switch ($_POST['opc']) {

		case 'registrar':
			$ejec = $cnn->query("INSERT INTO producto VALUES (NULL, '".$_POST["nombre_pro"]."', '".$_POST["codigo_pro"]."' ,'".$_POST["tipo_pro"]."','".$_POST["existencia_pro"]."', '".$_POST["descripcion_pro"]."' , '".$_POST["imagen_pro"]."',   '".$_POST["precio_pro"]."', '".$_POST["garantia_pro"]."', '".$_POST["promocion_pro"]."')");
			echo $cnn->insert_id;
			break;

		case 'consulta':
			$consul = $cnn->query("SELECT * FROM producto where status_pro='activo'");
			$cad ="<table class='responstable' id='tabla' border='1' >
            <tbody id='tb'>

            <tr style='font-style: oblique;'>
			    <th style='text-align:center; vertical-align:middle'>Id &nbsp</th>
                <th style='text-align:center; vertical-align:middle'>Nombre &nbsp</th>
                <th style='text-align:center; vertical-align:middle'>Codigo &nbsp</th>

                 <th style='text-align:center; vertical-align:middle'>Categoria</th>
                 <th style='text-align:center; vertical-align:middle'>Existencia </th>
                 <th style='text-align:center; vertical-align:middle'>&nbsp Descripcion</th>
                 <th style='text-align:center; vertical-align:middle'>Imagen</th>
				 <th style='text-align:center; vertical-align:middle'>Precio</th>
				 <th style='text-align:center; vertical-align:middle'>Garantia</th>
				 <th style='text-align:center; vertical-align:middle'>Promocion</th>
				 <th style='text-align:center; vertical-align:middle'>  </th>
				 <th style='text-align:center; vertical-align:middle'>  </th>


				 <th style='text-align:center; vertical-align:middle'>  </th>



            </tr>";


			while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
				$cad.="<tr class='centro'>

                            <td >$ren[cve_pro]</td>
                            <td>$ren[nombre_pro]</td>
                            <td>$ren[codigo_pro]</td>

							<td>$ren[tipo_pro]</td>
							<td>$ren[existencia_pro]</td>
							<td>$ren[descripcion_pro]</td>
                        
                            <td><img src='files/$ren[imagen_pro]' style='height:150px; width:150px;'></td>
							<td>$ren[precio_pro]</td>
							<td>$ren[garantia_pro]</td>
							<td>$ren[promocion_pro]</td>

							<td><button onclick='eliminar(this);'>Eliminar</button></td>
                            <td><button onclick='detallarModificar(this);'>Modificar</button></td>

							<td>
							<div class='page-wrapper'>
							  <button class='addtocart' onclick='javascript:add();'>
								Add to cart
								<span class='cart-item'></span>
							  </button>
							</div></td>
							</td>
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
			$cnn->query("update producto set nombre_pro='".$_POST["nombre_pro"]."'
			, codigo_pro='".$_POST["codigo_pro"]."' , tipo_pro='".$_POST["tipo_pro"]."',
			existencia_pro='".$_POST["existencia_pro"]."', descripcion_pro='".$_POST["descripcion_pro"]."' 
			, precio_pro='".$_POST["precio_pro"]."' , garantia_pro='".$_POST["garantia_pro"]."',promocion_pro='".$_POST["promocion_pro"]."'  WHERE cve_pro='".$_POST["cve_pro"]."'");



			//echo "Eliminacion exitosa";
		break;



		case 'buscar':
			
			$consul = $cnn->query("SELECT * FROM producto where nombre_pro='".$_POST["nombre_pro"]."'");
			$cad ="<table class='responstable' id='tabla' border='1' >
            <tbody id='tb'>

            <tr style='font-style: oblique;'>
			    <th style='text-align:center; vertical-align:middle'>Id &nbsp</th>
                <th style='text-align:center; vertical-align:middle'>Nombre &nbsp</th>
                <th style='text-align:center; vertical-align:middle'>Codigo &nbsp</th>

                 <th style='text-align:center; vertical-align:middle'>Tipo</th>
                 <th style='text-align:center; vertical-align:middle'>Existencia </th>
                 <th style='text-align:center; vertical-align:middle'>&nbsp Descripcion</th>
                 <th style='text-align:center; vertical-align:middle'>Imagen</th>
				 <th style='text-align:center; vertical-align:middle'>Precio</th>
				 <th style='text-align:center; vertical-align:middle'>Garantia</th>
				 <th style='text-align:center; vertical-align:middle'>Promocion</th>
				 <th style='text-align:center; vertical-align:middle'>  </th>
				 <th style='text-align:center; vertical-align:middle'>  </th>


				 <th style='text-align:center; vertical-align:middle'>  </th>



            </tr>";


			while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
				$cad.="<tr class='centro'>

                            <td >$ren[cve_pro]</td>
                            <td>$ren[nombre_pro]</td>
                            <td>$ren[codigo_pro]</td>

							<td>$ren[tipo_pro]</td>
							<td>$ren[existencia_pro]</td>
							<td>$ren[descripcion_pro]</td>
                        
                            <td><img src='files/$ren[imagen_pro]' style='height:150px; width:150px;'></td>
							<td>$ren[precio_pro]</td>
							<td>$ren[garantia_pro]</td>
							<td>$ren[promocion_pro]</td>

							<td><button onclick='eliminar(this);'>Eliminar</button></td>
                            <td><button onclick='detallarModificar(this);'>Modificar</button></td>

							<td>
							<div class='page-wrapper'>
							  <button class='addtocart' onclick='javascript:add();'>
								Add to cart
								<span class='cart-item'></span>
							  </button>
							</div></td>
							</td>
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
				$cnn->query("update producto set status_pro='inactivo' where cve_pro='".$_POST["cve_pro"]."'");
				echo "Eliminacion exitosa";
		break;


		case 'filtrar':
			$consul = $cnn->query("SELECT * FROM producto where tipo_pro='".$_POST["tipo_pro"]."'");
			$cad ="<table class='responstable' id='tabla' border='1' >
            <tbody id='tb'>

            <tr style='font-style: oblique;'>
			    <th style='text-align:center; vertical-align:middle'>Id &nbsp</th>
                <th style='text-align:center; vertical-align:middle'>Nombre &nbsp</th>
                <th style='text-align:center; vertical-align:middle'>Codigo &nbsp</th>

                 <th style='text-align:center; vertical-align:middle'>Categoria</th>
                 <th style='text-align:center; vertical-align:middle'>Existencia </th>
                 <th style='text-align:center; vertical-align:middle'>&nbsp Descripcion</th>
                 <th style='text-align:center; vertical-align:middle'>Imagen</th>
				 <th style='text-align:center; vertical-align:middle'>Precio</th>
				 <th style='text-align:center; vertical-align:middle'>Garantia</th>
				 <th style='text-align:center; vertical-align:middle'>Promocion</th>
				 <th style='text-align:center; vertical-align:middle'>  </th>
				 <th style='text-align:center; vertical-align:middle'>  </th>


				 <th style='text-align:center; vertical-align:middle'>  </th>



            </tr>";


			while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
				$cad.="<tr class='centro'>

                            <td >$ren[cve_pro]</td>
                            <td>$ren[nombre_pro]</td>
                            <td>$ren[codigo_pro]</td>

							<td>$ren[tipo_pro]</td>
							<td>$ren[existencia_pro]</td>
							<td>$ren[descripcion_pro]</td>
                        
                            <td><img src='files/$ren[imagen_pro]' style='height:150px; width:150px;'></td>
							<td>$ren[precio_pro]</td>
							<td>$ren[garantia_pro]</td>
							<td>$ren[promocion_pro]</td>

							<td><button onclick='eliminar(this);'>Eliminar</button></td>
                            <td><button onclick='detallarModificar(this);'>Modificar</button></td>

							<td>
							<div class='page-wrapper'>
							  <button class='addtocart' onclick='javascript:add();'>
								Add to cart
								<span class='cart-item'></span>
							  </button>
							</div></td>
							</td>
						</tr>";
			}
			$cad.="</table>";
			$cad.="</tbody>";


			echo $cad;
			/*echo "<pre>";
			var_dump($ren);
			echo "</pre>";*/
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



