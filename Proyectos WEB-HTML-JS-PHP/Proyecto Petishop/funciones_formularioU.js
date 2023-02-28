
var c="";

$(document).ready(function(){
	cargarTabla();
	cargarMunicipios();
	cargarEstados();

});

function cargarTabla () {
	$.ajax({
		url: 'formularioUsuarioF.php',
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



function limpiar(){


document.getElementById("nombreT").value='';



}

function buscarNombre () {

var x= document.getElementById("nombreT").value.toLowerCase();

	$.ajax({
		url: 'formularioUsuarioF.php',
		type: 'POST',
		dataType: 'html',
		data: {
			opc: "buscar",
			nombre_usu: x,
			
		},

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


function cargarMunicipios() {
	$.ajax({
		url: 'formularioUsuarioF.php',
		type: 'POST',
		dataType: 'html',
		data: {opc: 'listarMunicipio'},
	})
	.done(function(res) {
		$("#municipio").html(res)
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
}




function cargarEstados() {
	$.ajax({
		url: 'formularioUsuarioF.php',
		type: 'POST',
		dataType: 'html',
		data: {opc: 'listarEstado'},
	})
	.done(function(res) {
		$("#estado").html(res)
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

	 let confirmAction = confirm("¿Estás seguro que deseas eliminar este producto?");
	 if (confirmAction) {
	

	$.ajax({
		url: 'formularioUsuarioF.php',
		type: 'POST',
		dataType: 'html',
		data: {
			opc: 'eliminar',
			cve_pro: x,
		},
	})
	.done(function(res) {
		cargarTabla();
		swal("Exito", "Producto eliminado!", "success");
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


function modificarUsuario() {

	var f = document.querySelector("#frm3");
	var n=parseInt(c);

   $.ajax({
	   url: 'formularioUsuarioF.php',
	   type: 'POST',
	   dataType: 'html',
	   data: {
		   opc: 'modificar',
		   cve_usu:n,
		   email_usu:f.email.value,
		  password_usu:f.password.value,
		  nombre_usu:f.nombre.value,
		   paterno_usu:f.paterno.value,
		   materno_usu:f.materno.value,
		   genero_usu:f.sexo.value,
		   nacimiento_usu:f.edad.value,
		   pais_usu:f.paisM.value,
		   estado_usu:f.estadoM.value,
		   ciudad_usu:f.ciudad.value,
		   colonia_usu:f.colonia.value,
		   cp_usu:f.codigo.value,
		   calle_usu:f.calle.value,
		   municipio_usu:f.municipioM.value,


		

		   success: function (data) {

			$("#contenedor").html(data);
			swal("Exito", "Usuario modificado!", "success");
	
	
		}
	
	},
	error: function () {
		swal ( "Oops" ,  "¡Ocurrio un error!" ,  "error" )
	}

})



   
}





function registrarUsuario() {

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






	var nombre=  $(elm).closest("tr").find("td:nth-child(3)").text();
	var paterno=  $(elm).closest("tr").find("td:nth-child(4)").text();
	var materno=  $(elm).closest("tr").find("td:nth-child(5)").text();
	var edad=  $(elm).closest("tr").find("td:nth-child(6)").text();
	var sexo=  $(elm).closest("tr").find("td:nth-child(7)").text();
	var email=  $(elm).closest("tr").find("td:nth-child(8)").text();



	 document.getElementById("idM").value=id;


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
      
function regresarModificar() {
	cargarTabla();

	$(".containerMA").css({display: 'none'});
	
	$(".container2").css({display: 'block'});
    $(".consult").css({display: 'block'});
	$("#contenedor").css({display: 'block'});
	$("#head2").css({display: 'block'});

	$(".center").css({display: 'block'});

  }


  
function detallarModificar(elm) {
   
	var id = $(elm).closest("tr").find("td:nth-child(1)").text();
	c=id;

	var usuario = $(elm).closest("tr").find("td:nth-child(2)").text();
	var password= $(elm).closest("tr").find("td:nth-child(3)").text();
	var nombre= $(elm).closest("tr").find("td:nth-child(4)").text();
	var paterno= $(elm).closest("tr").find("td:nth-child(5)").text();
	var materno= $(elm).closest("tr").find("td:nth-child(6)").text();
	var sexo= $(elm).closest("tr").find("td:nth-child(7)").text();


	var fecha = $(elm).closest("tr").find("td:nth-child(8)").text();
	var pais= $(elm).closest("tr").find("td:nth-child(9)").text();
	var estado= $(elm).closest("tr").find("td:nth-child(10)").text();
	var ciudad= $(elm).closest("tr").find("td:nth-child(11)").text();
	var colonia= $(elm).closest("tr").find("td:nth-child(12)").text();
	var cp = $(elm).closest("tr").find("td:nth-child(13)").text();


	var calle= $(elm).closest("tr").find("td:nth-child(14)").text();
	var municipio= $(elm).closest("tr").find("td:nth-child(15)").text();


	document.getElementById("idM").value=id;
	document.getElementById("email").value=usuario;
	document.getElementById("password").value=password;
	document.getElementById("nombre").value=nombre;
	document.getElementById("paterno").value=paterno;
	document.getElementById("materno").value=materno;
	document.getElementById("sexo").value=sexo;

	document.getElementById("edad").value=fecha;
	document.getElementById("paisM").value=pais;
	document.getElementById("estadoM").value=estado;
	document.getElementById("ciudad").value=ciudad;
	document.getElementById("colonia").value=colonia;
	document.getElementById("codigo").value=cp;
	document.getElementById("calle").value=calle;
	document.getElementById("municipioM").value=municipio;





	$(".containerMA").css({display: 'block'});
        
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
