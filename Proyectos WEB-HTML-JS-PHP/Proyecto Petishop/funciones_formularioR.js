
var c="";

var aa="";
var bb="";
var cc="";
$(document).ready(function(){
	cargarTabla();
	cargarTabla2();

});

function cargarTabla () {
	$.ajax({
		url: 'formularioReporteF.php',
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





function cargarTabla2() {
	$.ajax({
		url: 'formularioReporteF.php',
		type: 'POST',
		dataType: 'html',
		data: {opc: 'consulta2'},
	})
	.done(function(res) {
		$("#contenedor2").html(res);
		

	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
}

function cargarTablaE() {
	$.ajax({
		url: 'formularioVinculacionF.php',
		type: 'POST',
		dataType: 'html',
		data: {opc: 'consulta2'},
	})
	.done(function(res) {
		$("#contenedor2").html(res);

	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
}

function cargarTabla3() {
	$.ajax({
		url: 'formularioVinculacionF.php',
		type: 'POST',
		dataType: 'html',
		data: {opc: 'listar'},
	})
	.done(function(res) {
		$(".filtro").html(res)
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
}


function cargarEventos() {
	$.ajax({
		url: 'formularioVinculacionF.php',
		type: 'POST',
		dataType: 'html',
		data: {opc: 'listarEventos'},
	})
	.done(function(res) {
		$("#filtroEvento").html(res)
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
}

function crea(s) {
	var v=(s[s.selectedIndex].value); // get value
	var b=(s[s.selectedIndex].value); // get value

	var ide= (s[s.selectedIndex].id); // get id

	var x=  $(s).closest("tr").find("td:nth-child(1)").text();

	var array = b.split(",");

	//alert(v[0]);//obtiene index o id del aspirante

	var ideA=v[0];
	var emialA= array[6];
	var claveE=x;


	  aa=ideA;
	  bb=emialA;
	  cc=claveE;

	  /*
	  alert(aa);
	  alert(bb);
	  alert(cc);

*/

  }

  function asignar(){

	$.ajax({
		url: 'formularioVinculacionF.php',
		type: 'POST',
		dataType: 'html',
		data: {opc: 'asignar',

		id:aa,
		cve_eve: cc,
		email_asp: bb,
	
	},
	})
	.done(function(res) {
		cargarTabla2();
		swal("Exito", "Vinculación realizada!", "success");

	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});


  }


  
  function remover(s){
	var w=  $(s).closest("tr").find("td:nth-child(1)").text();
	var h=  $(s).closest("tr").find("td:nth-child(3)").text();

	
	$.ajax({
		url: 'formularioVinculacionF.php',
		type: 'POST',
		dataType: 'html',
		data: {opc: 'eliminar',

		id:h,
		cve_eve: w,


	
	},
	})
	.done(function(res) {
		cargarTabla2();

	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});


  }

  function filtrarStatus(){
	// Declare variables
	var input, filter, table, tr, td,tds, i, cellValue;
	input = document.getElementById("filtro");
	filter = parseInt(input.value);
	table = document.getElementById("tb");
	tr = table.getElementsByTagName("tr");
	
	var uno, dos, tres, cuatro, cinco, seis, s, ocho, nueve, diez, once, doce;
	
	
	
	if(input.value=="Pospuesto"){
	
	
	
	// Loop through all table rows, and hide those who don't match the search query
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[6];
		uno = tr[i].getElementsByTagName("td")[5];
		dos = tr[i].getElementsByTagName("td")[4];
		tres = tr[i].getElementsByTagName("td")[3];
		cuatro = tr[i].getElementsByTagName("td")[2];
		cinco = tr[i].getElementsByTagName("td")[1];
		seis = tr[i].getElementsByTagName("td")[0];
		s = tr[i].getElementsByTagName("td")[7];
		ocho = tr[i].getElementsByTagName("td")[8];
		nueve = tr[i].getElementsByTagName("td")[9];
		diez = tr[i].getElementsByTagName("td")[10];
		once = tr[i].getElementsByTagName("td")[11];
		doce = tr[i].getElementsByTagName("td")[12];
	
	
	
		if (s) {
		  cellValue = s.innerText;
	

		 if (cellValue == "Pospuesto") {
			  tr[i].style.display = "";
	
	
	
	
		  } 
	
	
	
		  else {
			tr[i].style.display = "none";
	
	
		  }
	
	
	
	
		}
		}
	
	}
	
	
	
	if(input.value=="Activo"){
	
	
	
	// Loop through all table rows, and hide those who don't match the search query
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[6];
		uno = tr[i].getElementsByTagName("td")[5];
		dos = tr[i].getElementsByTagName("td")[4];
		tres = tr[i].getElementsByTagName("td")[3];
		cuatro = tr[i].getElementsByTagName("td")[2];
		cinco = tr[i].getElementsByTagName("td")[1];
		seis = tr[i].getElementsByTagName("td")[0];
		s = tr[i].getElementsByTagName("td")[7];
		ocho = tr[i].getElementsByTagName("td")[8];
		nueve = tr[i].getElementsByTagName("td")[9];
		diez = tr[i].getElementsByTagName("td")[10];
		once = tr[i].getElementsByTagName("td")[11];
		doce = tr[i].getElementsByTagName("td")[12];
	
	
	
		if (s) {
		  cellValue = s.innerText;
	
		 if (cellValue == "Activo") {
			  tr[i].style.display = "";
	
	
	
	
		  } 
	
	
	
		  else {
			tr[i].style.display = "none";
	
	
		  }
	
	
	
	
		}
		}
	
	}
	
	
	
	
	
	if(input.value=="Eliminado"){
	
	
	
	// Loop through all table rows, and hide those who don't match the search query
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[6];
		uno = tr[i].getElementsByTagName("td")[5];
		dos = tr[i].getElementsByTagName("td")[4];
		tres = tr[i].getElementsByTagName("td")[3];
		cuatro = tr[i].getElementsByTagName("td")[2];
		cinco = tr[i].getElementsByTagName("td")[1];
		seis = tr[i].getElementsByTagName("td")[0];
		s = tr[i].getElementsByTagName("td")[7];
		ocho = tr[i].getElementsByTagName("td")[8];
		nueve = tr[i].getElementsByTagName("td")[9];
		diez = tr[i].getElementsByTagName("td")[10];
		once = tr[i].getElementsByTagName("td")[11];
		doce = tr[i].getElementsByTagName("td")[12];
	
	
	
		if (s) {
		  cellValue = s.innerText;
	
		 if (cellValue == "Eliminado") {
			  tr[i].style.display = "";
	
	
	
	
		  } 
	
	
	
		  else {
			tr[i].style.display = "none";
	
	
		  }
	
	
	
	
		}
		}
	
	}
	
	
	
	if(input.value=="Cancelado"){
	
	
	
	// Loop through all table rows, and hide those who don't match the search query
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[6];
		uno = tr[i].getElementsByTagName("td")[5];
		dos = tr[i].getElementsByTagName("td")[4];
		tres = tr[i].getElementsByTagName("td")[3];
		cuatro = tr[i].getElementsByTagName("td")[2];
		cinco = tr[i].getElementsByTagName("td")[1];
		seis = tr[i].getElementsByTagName("td")[0];
		s = tr[i].getElementsByTagName("td")[7];
		ocho = tr[i].getElementsByTagName("td")[8];
		nueve = tr[i].getElementsByTagName("td")[9];
		diez = tr[i].getElementsByTagName("td")[10];
		once = tr[i].getElementsByTagName("td")[11];
		doce = tr[i].getElementsByTagName("td")[12];
	
	
	
		if (s) {
		  cellValue = s.innerText;
	
		 if (cellValue == "Cancelado") {
	
	
			tr[i].style.display = "";
	
	
	
	
		  } 
	
	
	
		  else {
			tr[i].style.display = "none";
	
	
		  }
	
	
	
	
		}
		}
	
	}
	
	
	
	
	
	
	
		 }