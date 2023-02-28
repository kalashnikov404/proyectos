<?php 


header('Access-Control-Allow-Origin: *');

/*echo "<h1>Orlando</h1>";
echo "<pre>";
var_dump($_POST);
echo "</pre>";*/

$cnn = new mysqli("localhost","root","root","cri");

if ($cnn->connect_errno) {
	echo "Ocurrio un error";
	exit();
} else {

    //$ejec = $cnn->query(INSERT INTO personas VALUES (NULL, ""));

    switch ($_POST['opc']) {

        case 'crear':
            $ejec = $cnn->query("INSERT INTO aspirante VALUES (NULL, '" . $_POST["cve_asp"] . "', '" . $_POST["nombre_asp"] . "', '" . $_POST["paterno_asp"] . "' ,'" . $_POST["materno_asp"] . "','" . $_POST["edad_asp"] . "', '" . $_POST["sexo_asp"] . "' , '" . $_POST["email_asp"] . "', 1)");
            echo $cnn->insert_id;
            break;

        case 'consultar':
            $consul = $cnn->query("SELECT * FROM aspirante  where status_asp='1'");
            $cad = "<table class='responstable' id='tabla' border='1'>
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


            while ($ren = $consul->fetch_array(MYSQLI_ASSOC)) {
                $cad .= "<tr class='centro'>
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
            $cad .= "</table>";
            $cad .= "</tbody>";


            echo $cad;
            /*echo "<pre>";
            var_dump($ren);
            echo "</pre>";*/
            break;

            case 'consultar2':
                $consul = $cnn->query("select p.id_persona, p.curp_persona, p.nombre_persona, p.paterno_persona, 
                p.materno_persona, 
                TIMESTAMPDIFF(YEAR, p.nacimiento_persona, curdate()) as edad_persona, 
                p.genero_persona, e.numero_expediente, e.fecha_creacion_expediente, 
                p.temp1d_persona from persona p, 
                expediente e, paciente pa where e.id_expediente=pa.id_expediente 
                 && pa.id_persona=p.id_persona order by p.nombre_persona; ");
                $cad = "<table class='table table-striped table-hover'>
                <thead>
                    <tr>
                    <th>ID</th>

                        <th>NOMBRE</th>
                        <th>A.PATERNO</th>
                        <th>A.MATERNO</th>
                        <th>EDAD</th>
                        <th>SEXO</th>
                        <th>N. EXP</th>
                        <th>DIAGNOSTICO</th>
                        <th>CURP</th>
                        <th>FECHA ALTA</th>

                        <th>ACCIONES</th>

                    </tr>
                </thead>";
    
                while ($ren = $consul->fetch_array(MYSQLI_ASSOC)) {
                    $cad .= "<tr>
                    <td>$ren[id_persona]</td>

                                <td>$ren[nombre_persona]</td>
                                <td>$ren[paterno_persona]</td>
                                <td>$ren[materno_persona]</td>
                                <td>$ren[edad_persona]</td>
                                <td>$ren[genero_persona]</td>

                                <td>$ren[numero_expediente]</td>
                                <td>$ren[temp1d_persona]</td>
                                <td>$ren[curp_persona]</td>
                                <td height=20px >$ren[fecha_creacion_expediente]</td>

                             
    
                                <td>
                            <a  onclick='javascript:actualizarExpediente(this);' class='edit' data-toggle='modal'><i class='material-icons' data-toggle='tooltip' title='Editar'>&#xE254;</i></a>
                            <a  onclick='javascript:visualizarExpediente(this);' class='delete' data-toggle='modal'><i  class='fa fa-eye' data-toggle='tooltip' title='Ver'></i></a>
                            <a  onclick='javascript:digitalizarExpediente(this);' class='print' data-toggle='modal'><i  class='fa fa-print' data-toggle='tooltip' title='Digitalizar'></i></a>


                        </td>
    

                        
    
                            </tr>";
                }
                $cad .= "</table>";
                $cad .= "</tbody>";
    
    
                echo $cad;
                /*echo "<pre>";
                var_dump($ren);
                echo "</pre>";*/
                break;

        case 'actualizar':
            $cnn->query("update aspirante 
            set cve_asp='" . $_POST["cve_asp"] . "', nombre_asp='" . $_POST["nombre_asp"] . "'
			, paterno_asp='" . $_POST["paterno_asp"] . "' , materno_asp='" . $_POST["materno_asp"] . "',
			edad_asp='" . $_POST["edad_asp"] . "', sexo_asp='" . $_POST["sexo_asp"] . "' 
			, email_asp='" . $_POST["email_asp"] . "' WHERE id='" . $_POST["id"] . "'");



            //echo "Eliminacion exitosa";
            break;


       



            case 'crearHojaFrontal':
                $ejec = $cnn->query("INSERT INTO 
                persona VALUES (NULL, 
                '" . $_POST["nombre_persona"] . "',
                 '" . $_POST["paterno_persona"] . "', 
                 '" . $_POST["materno_persona"] . "' ,
                 '" . $_POST["nacimiento_persona"] . "',
                 '" . $_POST["genero_persona"] . "', 
                 null, null, null,
                  '" . $_POST["temp1d_persona"] . "', 
                  '" . $_POST["temp2e_persona"] . "', 
                  '" . $_POST["temp3c_persona"] . "'  )");
                echo $cnn->insert_id;
                break;


                case 'modificar':
                    $cnn->query("update aspirante 
                    set cve_asp='".$_POST["cve_asp"]."', 
                    nombre_asp='".$_POST["nombre_asp"]."',
                     paterno_asp='".$_POST["paterno_asp"]."' , 
                     materno_asp='".$_POST["materno_asp"]."',
                    edad_asp='".$_POST["edad_asp"]."', 
                    sexo_asp='".$_POST["sexo_asp"]."' 
                    , email_asp='".$_POST["email_asp"]."' WHERE id='".$_POST["id"]."'");
        
        
        

                case 'actualizarHojaFrontal':
                    $cnn->query("update persona 
                    
                    set 
                    nombre_persona= '" . $_POST["nombre_persona"] . "', 
                    paterno_persona='" . $_POST["paterno_persona"] . "' ,
                     materno_persona='" . $_POST["materno_persona"] . "' ,
                     nacimiento_persona='" . $_POST["nacimiento_persona"] . "',
                    genero_persona='" . $_POST["genero_persona"] . "',
                     temp1d_persona='" . $_POST["temp1d_persona"] . "' ,
                      temp2e_persona='" . $_POST["temp2e_persona"] . "',
                      temp3c_persona='" . $_POST["temp3c_persona"] . "'



                       WHERE id_persona='" . $_POST["id_persona"] . "'");
                       break;
        

                       case 'actualizarHojaConsentimiento':
                        $cnn->query("update persona 
                        
                        set 
                        nombre_persona= '" . $_POST["nombre_persona"] . "', 
                        paterno_persona='" . $_POST["paterno_persona"] . "' ,
                         materno_persona='" . $_POST["materno_persona"] . "' ,
                         nacimiento_persona='" . $_POST["nacimiento_persona"] . "',
                        genero_persona='" . $_POST["genero_persona"] . "',
                         temp1d_persona='" . $_POST["temp1d_persona"] . "' ,
                          temp2e_persona='" . $_POST["temp2e_persona"] . "',
                          temp3c_persona='" . $_POST["temp3c_persona"] . "'
    
    
    
                           WHERE id_persona='" . $_POST["id_persona"] . "'");
                           break;

//me quede en el diagnostico en el procedimiento


                case 'prueba2':
                    $ejec = $cnn->query("call sp_prueba('" . $_POST["nombre_diagnostico"] . "',  )");
                    echo $cnn->insert_id;
                    break;
    

                    case 'crearHojaConsentimiento':
                        $ejec = $cnn->query("call sp_crearHojaConsentimiento( 
                        '" . $_POST["curp_persona"] . "',
                        '" . $_POST["telefono_persona"] . "',
                        '" . $_POST["ine_persona"] . "',
                        '" . $_POST["id_persona"] . "',

                        '" . $_POST["estado_domicilio"] . "',
                        '" . $_POST["municipio_domicilio"] . "',
                        '" . $_POST["localidad_domicilio"] . "',
                        '" . $_POST["calle_domicilio"] . "',
                        '" . $_POST["cp_domicilio"] . "', 
                        '" . $_POST["colonia_domicilio"] . "', 

                        '" . $_POST["estado_domicilio"] . "',
                        '" . $_POST["municipio_domicilio"] . "',
                        '" . $_POST["localidad_domicilio"] . "',
                        '" . $_POST["calle_domicilio"] . "',
                        '" . $_POST["cp_domicilio"] . "', 
                        '" . $_POST["colonia_domicilio"] . "', 

                        '" . $_POST["nombre_responsable"] . "',
                        '" . $_POST["edad_responsable"] . "',
                        '" . $_POST["genero_responsable"] . "',
                        '" . $_POST["numero_expediente_responsable"] . "',
                        '" . $_POST["telefono_responsable"] . "', 



                     

                        '" . $_POST["nombre_testigo"] . "',
                        '" . $_POST["edad_testigo"] . "',
                        '" . $_POST["genero_testigo"] . "',
                        '" . $_POST["telefono_testigo"] . "',

                        '" . $_POST["nombre_diagnostico"] . "',

                        '" . $_POST["numero_expediente"] . "',
                        '" . $_POST["id_tratante"] . "',



                        '" . $_POST["temp1_paciente"] . "',
                        '" . $_POST["temp2_paciente"] . "'


                          )");


                        echo $cnn->insert_id;
                        break;



    }
}
?>