<?php
	require ('Conexion.php');
	
	$id_persona = $_POST['id_persona'];
	
	$queryM = "SELECT id_persona, YEAR(CURDATE())-YEAR(nacimiento_persona) as edad, genero_persona, temp1d_persona, temp2e_persona from persona where id_persona = '$id_persona'";
	$resultadoM = $mysqli->query($queryM);
	
	$html= "";
	
	while($rowM = $resultadoM->fetch_assoc())
	{
	
		$html.="<li>
		<label class='form-label'> 
			DIAGNOSTICO
			<span class='form-required'> * </span>
		</label>


		
		<div class='form-input'>
			<input type='text' value='".$rowM['temp1d_persona']."' name='diagnosticoPaciente' id='diagnosticoPaciente' disabled>
		</div>
	</li>

	
	<li>
		<label class='form-label'>
		   IDENTFICADOR
		   <span class='form-required'> * </span>
		</label>
		<div class='form-input dob'>
			<span class='form-sub-label'>
				
			<input type='text' class='year'  value='".$rowM['edad']."' name='edadPaciente' id='edadPaciente'  disabled>
				<label class='form-sub-label1'> EDAD </label>								</span>
			<span class='form-sub-label'>
			<input type='text' class='year' value='".$rowM['genero_persona']."' name='generoPaciente'  id='generoPaciente'  disabled>
				<label class='form-sub-label1'> GENERO </label>
			</span>


			<span class='form-sub-label'>
				<input type='text' class='year'  value='".$rowM['temp2e_persona']."' name='expedientePaciente' id='expedientePaciente' disabled>
				<label class='form-sub-label1'> N° EXPEDIENTE </label>
			</span>
		</div>
	</li>";
	
	}
	
	echo $html;




?>