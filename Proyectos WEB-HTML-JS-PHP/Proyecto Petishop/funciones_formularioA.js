
var c="";

$(document).ready(function(){
	cargarTabla();
});

function cargarTabla () {
	$.ajax({
		url: 'formularioAspiranteF.php',
		type: 'POST',
		dataType: 'html',
		data: {opc: 'consulta'},
	})
	.done(function(res) {
		$("#contenedor").html(res)
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
}

function enviar () {
	var f = document.querySelector("#form-guardar");

	console.log(f.nombre.value);
	console.log(f.edad.value);
	console.log(f.sexo.value);

	$.ajax({
		url: 'formulario.php',
		type: 'POST',
		dataType: 'HTML',
		data: {
			opc: "alta",
			nombre: f.nombre.value,
			edad: f.edad.value,
			sexo: f.sexo.value,
		},
	})
	.done(function(res) {
		$("#contenedor").html(res);
		if (parseInt(res) > 0) {
			cargarTabla();
		}else{
			alert("Ocurrio un error");
		}
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
	
}


function eliminar (id) {




	 var x=  $(id).closest("tr").find("td:nth-child(1)").text();


	  


	 let confirmAction = confirm("¿Estás seguro que deseas eliminar este aspirante?");
	 if (confirmAction) {
	

	$.ajax({
		url: 'formularioAspiranteF.php',
		type: 'POST',
		dataType: 'html',
		data: {
			opc: 'eliminar',
			id: x
		},
	})
	.done(function(res) {
		
		console.log("success");
		swal("Exito", "¡Aspirante eliminado!", "success");
				cargarTabla();
	})
	.fail(function() {

		swal ( "Oops" ,  "¡Ocurrio un error!" ,  "error" )
	})
	.always(function() {
		console.log("complete");
	});

	 }else{
		swal("¡Eliminación cancelada!");

	 }



	
}


function modificar() {






	var f = document.querySelector("#frm3");

	var n=parseInt(c);


	//var x=  $(id).closest("tr").find("td:nth-child(1)").text();
	/*

	console.log(f.claveM.value);
	console.log(f.nombreM.value);
	console.log(f.paternoM.value);

*/
   $.ajax({
	   url: 'formularioAspiranteF.php',
	   type: 'POST',
	   dataType: 'html',
	   data: {
		   opc: 'modificar',
		   
		   cve_asp:f.claveM.value,
		  nombre_asp:f.nombreM.value,
		   paterno_asp:f.paternoM.value,
		   materno_asp:f.maternoM.value,
		   edad_asp:f.edadM.value,
		   sexo_asp:f.sexoM.value,
		   email_asp:f.correoM.value,
		   id:n,


		   success: function (data) {
			$("#contenedor").html(data);
			swal("Exito", "¡Aspirante modificado!", "success");
	
	
		}
	
	},
	error: function () {
		swal ( "Oops" ,  "¡Ocurrio un error!" ,  "error" )
	}

})



   
}





function registrar() {

	var f = document.querySelector("#frm1");

	//var n=parseInt(c);


	//var x=  $(id).closest("tr").find("td:nth-child(1)").text();
	/*\

	console.log(f.claveM.value);
	console.log(f.nombreM.value);
	console.log(f.paternoM.value);

*/


   $.ajax({
	   url: 'formularioAspiranteF.php',
	   type: 'POST',
	   dataType: 'HTML',
	   data: {
		   opc: "subir",
		   
		   cve_asp:f.claveR.value,
		  nombre_asp:f.nombreR.value,
		   paterno_asp:f.paternoR.value,
		   materno_asp:f.maternoR.value,
		   edad_asp:f.edadR.value,
		   sexo_asp:f.sexoR.value,
		   email_asp:f.correoR.value,
		   




		   success: function (data) {
		$("#contenedor").html(data);
		swal("Exito", "¡Aspirante registrado!", "success");


	}

},
error: function () {
	swal ( "Oops" ,  "¡Ocurrio un error!" ,  "error" )
}



})
	
   


}

      
function regresarD() {
	$(".containerDA").css({display: 'none'});
	
	$(".container2").css({display: 'block'});
    $(".consult").css({display: 'block'});
	$("#contenedor").css({display: 'block'});
	$("#head2").css({display: 'block'});
	$(".center").css({display: 'block'});


  }

function detallar (elm) {
   
	var id=  $(elm).closest("tr").find("td:nth-child(1)").text();
	var cve=  $(elm).closest("tr").find("td:nth-child(2)").text();
c=id;


	var nombre=  $(elm).closest("tr").find("td:nth-child(3)").text();
	var paterno=  $(elm).closest("tr").find("td:nth-child(4)").text();
	var materno=  $(elm).closest("tr").find("td:nth-child(5)").text();
	var edad=  $(elm).closest("tr").find("td:nth-child(6)").text();
	var sexo=  $(elm).closest("tr").find("td:nth-child(7)").text();
	var email=  $(elm).closest("tr").find("td:nth-child(8)").text();



	 document.getElementById("idD").value=id;
	 document.getElementById("claveD").value=cve;


	 	document.getElementById("nombreD").value=nombre;
	 document.getElementById("paternoD").value=paterno;
	document.getElementById("maternoD").value=materno;

	document.getElementById("edadD").value=edad;
	document.getElementById("sexoD").value=sexo;

//select.options[select.selectedIndex].value=sexo;

		document.getElementById("correoD").value=email;



	$(".containerDA").css({display: 'block'});
        
    $(".container2").css({display: 'none'});
    $(".consult").css({display: 'none'});
	$("#contenedor").css({display: 'none'});
	$("#head2").css({display: 'none'});

	$(".center").css({display: 'none'});


	
}


function detallar2 (elm) {
   
	
	var id=  $(elm).closest("tr").find("td:nth-child(1)").text();
	var cve=  $(elm).closest("tr").find("td:nth-child(2)").text();

	c=id;


	var nombre=  $(elm).closest("tr").find("td:nth-child(3)").text();
	var paterno=  $(elm).closest("tr").find("td:nth-child(4)").text();
	var materno=  $(elm).closest("tr").find("td:nth-child(5)").text();
	var edad=  $(elm).closest("tr").find("td:nth-child(6)").text();
	var sexo=  $(elm).closest("tr").find("td:nth-child(7)").text();
	var email=  $(elm).closest("tr").find("td:nth-child(8)").text();



	 document.getElementById("idM").value=id;
	 document.getElementById("claveM").value=cve;


	 	document.getElementById("nombreM").value=nombre;
	 document.getElementById("paternoM").value=paterno;
	document.getElementById("maternoM").value=materno;

	document.getElementById("edadM").value=edad;
	document.getElementById("sexoM").value=sexo;


		document.getElementById("correoM").value=email;




	$(".containerMA").css({display: 'block'});
        
    $(".container2").css({display: 'none'});
    $(".consult").css({display: 'none'});
	$("#contenedor").css({display: 'none'});
	$("#head2").css({display: 'none'});

	$(".center").css({display: 'none'});


	
}
      
function regresarM() {
	cargarTabla();

	$(".containerMA").css({display: 'none'});
	
	$(".container2").css({display: 'block'});
    $(".consult").css({display: 'block'});
	$("#contenedor").css({display: 'block'});
	$("#head2").css({display: 'block'});

	$(".center").css({display: 'block'});

  }


  
function detallar3 () {
   
	

	$(".containerRA").css({display: 'block'});
        
    $(".container2").css({display: 'none'});
    $(".consult").css({display: 'none'});
	$("#contenedor").css({display: 'none'});
	$("#head2").css({display: 'none'});

	$(".center").css({display: 'none'});


	
}
      
function regresarR() {
	cargarTabla();

	$(".containerRA").css({display: 'none'});
	
	$(".container2").css({display: 'block'});
    $(".consult").css({display: 'block'});
	$("#contenedor").css({display: 'block'});
	$("#head2").css({display: 'block'});
	$(".center").css({display: 'block'});

  }
