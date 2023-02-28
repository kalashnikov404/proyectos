var f = document.querySelector("#formPersona");

function cargarTabla () {
	$.ajax({
		url: 'FuncionCrearExpediente.php',
		type: 'POST',
		dataType: 'html',
		data: {opc: 'consultar2'},
	})
	.done(function(res) {

		
		$("#container").html(res)
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
}



function crearHojaConsentimiento(){

	

	var f = document.querySelector("#formPaciente");
	 

	var f2 =document.getElementById("cbx_estado");
	var f22 =document.getElementById("cbx_municipio");
	var f3= document.getElementById("cbx_estado2");
	var f33= document.getElementById("cbx_municipio2");



	var text2= f2.options[f2.selectedIndex].text;
	var text22= f22.options[f22.selectedIndex].text;

	var text3= f3.options[f3.selectedIndex].text;
	var text33= f33.options[f33.selectedIndex].text;

	alert(text2, text22, text3, text33);

	$.ajax({
		url: 'FuncionCrearExpediente.php',
		type: 'POST',
		dataType: 'html',
		data: {opc: 'crearHojaConsentimiento',

		//campos diagnostico

		//campos persona(update)
		curp_persona: f.curpPaciente.value,
		telefono_persona: f.telefonoPaciente.value,
		ine_persona: f.inePaciente.value,
		id_persona: f.cbx_personaPaciente.value,

		//campos domicilio paciente
		estado_domicilio: text2,
		municipio_domicilio:text22,



		localidad_domicilio: f.localidadDomicilio.value,
		calle_domicilio: f.calleDomicilio.value,
		cp_domicilio: f.cpDomicilio.value,
		colonia_domicilio: f.coloniaDomicilio.value,

		//campos domicilio responsable
		estado_domicilio:text3,

		
		municipio_domicilio: text33,
		
		localidad_domicilio: f.localidadResponsable.value,
		calle_domicilio: f.calleResponsable.value,
		cp_domicilio: f.cpResponsable.value,
		colonia_domicilio: f.coloniaResponsable.value,

		//campos responsable
		nombre_responsable: f.nombreResponsable.value,
		edad_responsable: f.edadResponsable.value,
		genero_responsable: f.generoResponsable.value,
		numero_expediente_responsable: f.numeroExpedienteResponsable.value,
		telefono_responsable: f.telefonoResponsable.value,


		//campos testigo
		nombre_testigo:f.nombreTestigo.value,
		edad_testigo: f.edadTestigo.value,
		genero_testigo:f.generoTestigo.value,
		telefono_testigo:f.telefonoTestigo.value,

		nombre_diagnostico:f.diagnosticoPaciente.value,


		//campos expediente
		numero_expediente: expedientePaciente.value,
		id_tratante: cbx_tratante2.value,

		//Campos para paciente
		temp1_paciente:f.temporalPaciente1.value,
		temp2_paciente:f.temporalPaciente2.value,
		


	
	},


})
.done(function(res) {

		alert(res);
		
		
		
		//document.getElementById("formPersona").reset();
		Swal.fire({
			icon: 'success',
			title: '¡Expediente: Formato consentimiento creado con exito!',
			showConfirmButton: false,
			timer: 1500


		  })
		
		//document.getElementById("formPaciente").reset();

//if(parseInt(res)>1){

	/*
	Swal.fire({
		icon: 'success',
		title: '¡Expediente: Formato de consentimiento creado con exito!',
		showConfirmButton: false,
		timer: 1500


	  })

}else

alert("Ocurrio un erro: " + res);
*/
		
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});


  }




  function crearHojaFrontal(){
	var x=document.getElementById("dia").value;
	var y=document.getElementById("mes").value;
	var z=document.getElementById("año").value;
	var fecha= z+"-"+y+"-"+x;

	

	var f = document.querySelector("#formPersona");


	$.ajax({
		url: 'FuncionCrearExpediente.php',
		type: 'POST',
		dataType: 'html',
		data: {opc: 'crearHojaFrontal',

		nombre_persona:f.nombrePersona.value,
		paterno_persona:f.paternoPersona.value,
		materno_persona:f.maternoPersona.value,
		nacimiento_persona:fecha,
		genero_persona:f.generoPersona.value,
		temp1d_persona:f.temporalDiagnostico.value,
		temp2e_persona:f.temporalExpediente.value,
		temp3c_persona:f.cbx_tratante.value,



	
	},
	})
	.done(function(res) {

		document.getElementById("formPersona").reset();
		Swal.fire({
			icon: 'success',
			title: '¡Expediente: Formato frontal creado con exito!',
			showConfirmButton: false,
			timer: 1500


		  })
		  window.location.reload(true);

	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});


  }



  

  function actualizarHojaFrontal(){

	var f = document.querySelector("#formPersona");
	var clave=parseInt(f.clavePersona.value);

	$.ajax({
		url: 'FuncionCrearExpediente.php',
		type: 'POST',
		dataType: 'html',
		data: {opc: 'actualizarHojaFrontal',

		id_persona:clave,

		nombre_persona:f.nombrePersona.value,
		paterno_persona:f.paternoPersona.value,
		materno_persona:f.maternoPersona.value,
		nacimiento_persona:f.edadFrontal.value,
		genero_persona:f.generoPersona.value,
		temp1d_persona:f.temporalDiagnostico.value,
		temp2e_persona:f.temporalExpediente.value,
		temp3c_persona:f.cbx_tratante.value,


	},
	
	})
	.done(function(res) {

		  swal({
			title: "Exito!",
			text: "¡Expediente: Formato frontal actualizado con exito!",
			type: "success"
		}).then(function() {
			window.location.reload(true);
		});


	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});


  }


	
  