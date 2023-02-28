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
                $consul = $cnn->query("SELECT evento.cve_eve,  nombre_eve, inicial_eve, final_eve, aspirante.id, aspirante.email_asp, nombre_asp, status_eve, motivo_eve, cupo_eve
                FROM evento
                INNER JOIN evento_aspirante 
                   ON  evento.cve_eve = evento_aspirante.cve_eve
                    
                     INNER JOIN aspirante 
                   ON  aspirante.id = evento_aspirante.id;");
                $cad ="<table class='responstable' id='tabla' border='1'>
                <tbody id='tb'>
    
                <tr  style='text-transform:uppercase;'>
        
                <th>Clave de evento &nbsp</th>

                     <th>&nbsp Nombre de evento</th>
                     <th>&nbsp Id</th>

                     <th>&nbsp Aspirante</th>

                     <th>Inicial</th>
                     <th>Final</th>
                     <th>Email</th>
                     <th>Status</th>
                     <th>Motivo</th>

                     <th>Cupo</th>

                
    
    
                </tr>
                
                
            ";
    
    
                while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
                    $cad.="<tr class='centro'>
    
                                <td >$ren[cve_eve]</td>

                                <td>$ren[nombre_eve]</td>
                                <td >$ren[id]</td>

                                <td>$ren[nombre_asp]</td>

                                <td>$ren[inicial_eve]</td>
                                <td>$ren[final_eve]</td>
                                <td>$ren[email_asp]</td>
                                <td>$ren[status_eve]</td>

                                <td>$ren[motivo_eve]</td>
                                <td>$ren[cupo_eve]</td>

                    
    
                                
                                
                    
    
                            </tr>";
    
    
                            
                }
    
                
    
                $cad.="</table>";
                $cad.="</tbody>";
    
    
                echo $cad;
                /*echo "<pre>";
                var_dump($ren);
                echo "</pre>";*/
                break;



            case 'consulta2':
                $consul = $cnn->query("SELECT evento.cve_eve,  nombre_eve, inicial_eve, final_eve, aspirante.id, aspirante.email_asp, nombre_asp, asistencia_eveasp,  fasistencia_eveasp,paterno_asp
                FROM evento
                INNER JOIN evento_aspirante 
                   ON  evento.cve_eve = evento_aspirante.cve_eve
                    
                     INNER JOIN aspirante 
                   ON  aspirante.id = evento_aspirante.id;");
                $cad ="<table class='responstable' id='tabla' border='1'>
                <tbody id='tb'>
    
                <tr  style='text-transform:uppercase;'>
        
                <th>Clave de evento &nbsp</th>
                     <th>&nbsp Nombre de evento</th>
                     <th>&nbsp Id</th>

                     <th>&nbsp Aspirante</th>
                     <th>&nbsp Apellido</th>


                     <th>Inicial</th>
                     <th>Final</th>
                     <th>Email</th>
                     <th>Asistencia</th>
                     <th>F.Asistencia</th>


                
    
    
                </tr>
                
                
            ";
    
    
                while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
                    $cad.="<tr class='centro'>
    
                                <td >$ren[cve_eve]</td>

                                <td>$ren[nombre_eve]</td>
                                <td >$ren[id]</td>

                                <td>$ren[nombre_asp]</td>
                                <td>$ren[paterno_asp]</td>


                                <td>$ren[inicial_eve]</td>
                                <td>$ren[final_eve]</td>
                                <td>$ren[email_asp]</td>
                                <td>$ren[asistencia_eveasp]</td>
                                <td>$ren[fasistencia_eveasp]</td>


                    
    
                                
                                
                    
    
                            </tr>";
    
    
                            
                }
    
                
    
                $cad.="</table>";
                $cad.="</tbody>";
    
    
                echo $cad;
                /*echo "<pre>";
                var_dump($ren);
                echo "</pre>";*/
                break;

		
        /*        case 'eliminar':
			$cnn->query("update aspirante set status_asp=0 WHERE id='".$_POST["id"]."'");
			echo "Eliminacion exitosa";

		break;
*/




            case 'listar':
                $consul = $cnn->query("SELECT * FROM aspirante  where status_asp='1'");
                $cad ="<select >";

$x="";
                while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
                    $x++;
                    $cad.="<option id='$x'>
                    $ren[id],
                    $ren[cve_asp],
                     $ren[nombre_asp], 
                     $ren[paterno_asp], 
                     $ren[materno_asp],
                     $ren[edad_asp],
                     $ren[email_asp]

                
                            </option>";
    
    
                            
                }
    
                        $cad.="</select>";
    
    
                echo $cad;
    
                break;


		case 'modificar':
			$cnn->query("update aspirante set cve_asp='".$_POST["cve_asp"]."', nombre_asp='".$_POST["nombre_asp"]."'
			, paterno_asp='".$_POST["paterno_asp"]."' , materno_asp='".$_POST["materno_asp"]."',
			edad_asp='".$_POST["edad_asp"]."', sexo_asp='".$_POST["sexo_asp"]."' 
			, email_asp='".$_POST["email_asp"]."' WHERE id='".$_POST["id"]."'");



			//echo "Eliminacion exitosa";
		break;


	

        case 'asignar':
            $ejec = $cnn->query("INSERT INTO evento_aspirante VALUES (NULL, '".$_POST["id"]."', '".$_POST["cve_eve"]."', '".$_POST["email_asp"]."', 'NULL')");
			echo $cnn->insert_id;


            break;


            case 'eliminar':
                $cnn->query("DELETE FROM evento_aspirante where cve_eve ='".$_POST["cve_eve"]."' &&  id = '".$_POST["id"]."'");

                break;




                case 'listarEventos':
                    $consul = $cnn->query("SELECT * FROM evento");
                    $cad ="<select >";

                    $cad .="<option >Todos</option>";



    
    $x="";
                    while($ren = $consul->fetch_array(MYSQLI_ASSOC)){
                        $x++;
                        $cad.="<option id='$x'>
                      
                         $ren[cve_eve],

                        $ren[nombre_eve],


                        $ren[inicial_eve],
                        $ren[final_eve]



                     </option>";
        
        
                                
                    }
        
                            $cad.="</select>";
        
        
                    echo $cad;
        
                    break;
        

	}
	//<input type='button' value='Eliminar' onclick='javascript:eliminar($ren[cve_asp]);'>

}
?>



