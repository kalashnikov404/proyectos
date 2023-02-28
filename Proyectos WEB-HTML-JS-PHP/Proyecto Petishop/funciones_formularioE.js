
var c="";

$(document).ready(function(){
	cargarTabla();

});

function cargarTabla () {
	$.ajax({
		url: 'formularioEventoF.php',
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

function dx () {
	var f = document.querySelector("#frm1");


	$.ajax({
		url: 'formulario.php',
		type: 'POST',
		dataType: 'HTML',
		data: {
			opc: "alta",
			cve_eve: f.clave.value,
			nombre_eve: f.nombre.value,
			ponente_eve: f.ponente.value,
            inicial_eve: f.inicio.value,
            final_eve: f.fin.value,

            cupo_eve:f.cupo.value,
            descripcion_eve:f.descripcion.value,
            status_eve_eve:f.status.value,

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


function eliminar (elm) {

	 var x=  $(elm).closest("tr").find("td:nth-child(1)").text();


	 let confirmAction = confirm("¿Estás seguro que deseas eliminar este evento?");
	 if (confirmAction) {
	

	$.ajax({
		url: 'formularioEventoF.php',
		type: 'POST',
		dataType: 'html',
		data: {
			opc: 'eliminar',
			cve_eve: x,
		},
	})
	.done(function(res) {
		
		console.log("success");
		swal("Exito", "Evento eliminado!", "success");
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



function posponer (elm) {

	var x=  $(elm).closest("tr").find("td:nth-child(1)").text();


	let confirmAction = confirm("¿Estás seguro que deseas posponer este evento?");
	if (confirmAction) {
   

   $.ajax({
	   url: 'formularioEventoF.php',
	   type: 'POST',
	   dataType: 'html',
	   data: {
		   opc: 'posponer',
		   cve_eve: x,
	   },
   })
   .done(function(res) {
	   
	   console.log("success");
	   swal("Exito", "Evento Pospuesto!", "success");
			   cargarTabla();
   })
   .fail(function() {

	   swal ( "Oops" ,  "¡Ocurrio un error!" ,  "error" )
   })
   .always(function() {
	   console.log("complete");
   });

	}else{
	   swal("Pospuesto cancelado!");

	}



   
}

function cancelar (elm) {

	var x=  $(elm).closest("tr").find("td:nth-child(1)").text();


	let confirmAction = confirm("¿Estás seguro que deseas cancelar este evento?");
	if (confirmAction) {
   

   $.ajax({
	   url: 'formularioEventoF.php',
	   type: 'POST',
	   dataType: 'html',
	   data: {
		   opc: 'cancelar',
		   cve_eve: x,
	   },
   })
   .done(function(res) {
	   
	   console.log("success");
	   swal("Exito", "Evento cancelado!", "success");
			   cargarTabla();
   })
   .fail(function() {

	   swal ( "Oops" ,  "¡Ocurrio un error!" ,  "error" )
   })
   .always(function() {
	   console.log("complete");
   });

	}else{
	   swal("Cancelación cancelada!");

	}



   
}

function reactivar (elm) {

	var x=  $(elm).closest("tr").find("td:nth-child(1)").text();


	let confirmAction = confirm("¿Estás seguro que deseas posponer reactivar este evento?");
	if (confirmAction) {
   

   $.ajax({
	   url: 'formularioEventoF.php',
	   type: 'POST',
	   dataType: 'html',
	   data: {
		   opc: 'reactivar',
		   cve_eve: x,
	   },
   })
   .done(function(res) {
	   
	   console.log("success");
	   swal("Exito", "Evento reactivado!", "success");
			   cargarTabla();
   })
   .fail(function() {

	   swal ( "Oops" ,  "¡Ocurrio un error!" ,  "error" )
   })
   .always(function() {
	   console.log("complete");
   });

	}else{
	   swal("Reactivacion cancelada!");

	}



   
}


function modificar() {

	var f = document.querySelector("#frm3");

	var n=parseInt(c);



	var f1= f.inicioM.value;
	var f2= f.finM.value;
	

	let stringToAdd = " ";

	f1 = f1.replace( 'T','');
	f2 = f2.replace( 'T','');
	
	
	var x=addStr(f1, 10, stringToAdd)
	var y= addStr(f2, 10, stringToAdd)

   $.ajax({
	   url: 'formularioEventoF.php',
	   type: 'POST',
	   dataType: 'HTML',
	   data: {
		   opc: 'modificar',
		  
           nombre_eve: f.nombreM.value,
           ponente_eve: f.ponenteM.value,
           inicial_eve: x,
           final_eve: y,
           cupo_eve:f.cupoM.value,
           descripcion_eve:f.descripcionM.value,
		cve_eve:n,	  
		 success: function (data) {

			swal("Exito", "Evento modificado!", "success");


	}

},
error: function () {
	swal ( "Oops" ,  "¡Ocurrio un error!" ,  "error" )
}



})
	
   


}


function addStr(str, index, stringToAdd){
	return str.substring(0, index) + stringToAdd + str.substring(index, str.length);
  }
  



  function insertar () {

	var f = document.querySelector("#frm1");
	let stringToAdd = " ";


var f1= f.inicio.value;
var f2= f.fin.value;



f1 = f1.replace( 'T','');
f2 = f2.replace( 'T','');


var x=addStr(f1, 10, stringToAdd)
var y= addStr(f2, 10, stringToAdd)



   $.ajax({
	   url: 'formularioEventoF.php',
	   type: 'POST',
	   dataType: 'HTML',
	   data: {
		   opc: "subir",
		   
           nombre_eve: f.nombre.value,
           ponente_eve: f.ponente.value,
           inicial_eve: x,
           final_eve: y,
           cupo_eve:f.cupo.value,
           descripcion_eve:f.descripcion.value,
		   success: function (data) {
			$("#contenedor").html(data);

			swal("Exito", "Evento registrado!", "success");


	}

},
error: function () {
	swal ( "Oops" ,  "¡Ocurrio un error!" ,  "error" )
}



})
	
   


}





function filtrar() {
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



if(input.value=="Todo"){



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
  
		   if (cellValue == "Todo") {
				tr[i].style.display = "none";
  
  
  
  
			} 
	
	 
	
			else {

				
				cargarTabla();
	
			}
	
	
	
	
		  }
		  }


}
}





function registrar() {

	var f = document.querySelector("#frm1");
	let stringToAdd = " ";


var f1= f.inicio.value;
var f2= f.fin.value;


const arr = ['T', '', ''];
f1 = f1.replace( 'T','');
f2 = f2.replace( 'T','');

var x=addStr(f1, 10, stringToAdd)
var y= addStr(f2, 10, stringToAdd)



   $.ajax({
	   url: 'formularioEventoF.php',
	   type: 'POST',
	   dataType: 'HTML',
	   data: {
		   opc: "subir",
		   
           nombre_eve: f.nombre.value,
           ponente_eve: f.ponente.value,
           inicial_eve: x,
           final_eve: y,
           cupo_eve:f.cupo.value,
           descripcion_eve:f.descripcion.value,

		   success: function (data) {
			$("#contenedor").html(data);

			swal("Exito", "Evento registrado!", "success");


	}

},
error: function () {
	swal ( "Oops" ,  "¡Ocurrio un error!" ,  "error" )
}



})
	
   


}




      
function regresarD() {
	$(".containerDE").css({display: 'none'});
	
	$(".container2").css({display: 'block'});
    $(".consult").css({display: 'block'});
	$("#contenedor").css({display: 'block'});
	$("#head2").css({display: 'block'});
	$(".center").css({display: 'block'});


  }



function detallar3 (elm) {
   
	var id=  $(elm).closest("tr").find("td:nth-child(1)").text();

c=id;

	var cve=  $(elm).closest("tr").find("td:nth-child(2)").text();



	var nombre=  $(elm).closest("tr").find("td:nth-child(3)").text();
	var paterno=  $(elm).closest("tr").find("td:nth-child(4)").text();
	var materno=  $(elm).closest("tr").find("td:nth-child(5)").text();
	var edad=  $(elm).closest("tr").find("td:nth-child(6)").text();
	var sexo=  $(elm).closest("tr").find("td:nth-child(7)").text();
	var email=  $(elm).closest("tr").find("td:nth-child(8)").text();




	document.getElementById("idM").value=id;

	 document.getElementById("nombreM").value=cve;
	 document.getElementById("ponenteM").value=nombre;


	 	document.getElementById("inicioM").value=paterno;
	 document.getElementById("finM").value=materno;
	document.getElementById("cupoM").value=edad;

	document.getElementById("descripcionM").value=sexo;



	$(".containerME").css({display: 'block'});
        
    $(".container2").css({display: 'none'});
    $(".consult").css({display: 'none'});
	$("#contenedor").css({display: 'none'});
	$("#head2").css({display: 'none'});

	$(".center").css({display: 'none'});


	
}
    


function detallar2 (elm) {
   
	var id=  $(elm).closest("tr").find("td:nth-child(1)").text();

c=id;

	var cve=  $(elm).closest("tr").find("td:nth-child(2)").text();



	var nombre=  $(elm).closest("tr").find("td:nth-child(3)").text();
	var paterno=  $(elm).closest("tr").find("td:nth-child(4)").text();
	var materno=  $(elm).closest("tr").find("td:nth-child(5)").text();
	var edad=  $(elm).closest("tr").find("td:nth-child(6)").text();
	var sexo=  $(elm).closest("tr").find("td:nth-child(7)").text();
	var email=  $(elm).closest("tr").find("td:nth-child(8)").text();




	document.getElementById("idD").value=id;

	 document.getElementById("nombreD").value=cve;
	 document.getElementById("ponenteD").value=nombre;


	 	document.getElementById("inicioD").value=paterno;
	 document.getElementById("finD").value=materno;
	document.getElementById("cupoD").value=edad;

	document.getElementById("descripcionD").value=sexo;



	$(".containerDE").css({display: 'block'});
        
    $(".container2").css({display: 'none'});
    $(".consult").css({display: 'none'});
	$("#contenedor").css({display: 'none'});
	$("#head2").css({display: 'none'});

	$(".center").css({display: 'none'});


	
}


  
function detallarR () {
   
	

	$(".containerRE").css({display: 'block'});
        
    $(".container2").css({display: 'none'});
    $(".consult").css({display: 'none'});
	$("#contenedor").css({display: 'none'});
	$("#head2").css({display: 'none'});

	$(".center").css({display: 'none'});


	
}
      

    

function regresarR() {
	cargarTabla();

	$(".containerRE").css({display: 'none'});
	
	$(".container2").css({display: 'block'});
    $(".consult").css({display: 'block'});
	$("#contenedor").css({display: 'block'});
	$("#head2").css({display: 'block'});
	$(".center").css({display: 'block'});

  }

  function regresarM() {
	cargarTabla();

	$(".containerME").css({display: 'none'});
	
	$(".container2").css({display: 'block'});
    $(".consult").css({display: 'block'});
	$("#contenedor").css({display: 'block'});
	$("#head2").css({display: 'block'});
	$(".center").css({display: 'block'});

  }


function buscar() {
 // Declare variables
 var input, filter, table, tr, td,tds, i, cellValue, campo, f;
 input = document.getElementById("filtro2");
 filter = parseInt(input.value);
 table = document.getElementById("tb");
 campo = document.getElementById("nombreT").value;
 f = document.getElementById("fecha").value;


 tr = table.getElementsByTagName("tr");

 var uno, dos, tres, cuatro, cinco, seis, s, ocho, nueve, diez, once, doce;




 
if(input.value=="Nombre"){



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



	 if (cinco) {
	   cellValue = cinco.innerText;

	  if (cellValue == campo) {
		   tr[i].style.display = "";




	   } 



	   else {
		 tr[i].style.display = "none";


	   }




	 }
	 }

}



 
if(input.value=="Ponente"){



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
   
   
   
		if (cuatro) {
		  cellValue = cuatro.innerText;
   
		 if (cellValue == campo) {
			  tr[i].style.display = "";
   
   
   
   
		  } 
   
   
   
		  else {
			tr[i].style.display = "none";
   
   
		  }
   
   
   
   
		}
		}
   
   }


   if(input.value=="Inicio"){



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
   
   
   
		if (tres) {



		  cellValue = tres.innerText;
   
		 if (cellValue == f) {
			  tr[i].style.display = "";
   
   
   
   
		  } 
   
   
   
		  else {
			tr[i].style.display = "none";
   
   
		  }
   
   
   
   
		}
		}
   
   }



   
   if(input.value=="Fin"){



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
   
   
   
		if (dos) {
		  cellValue = dos.innerText;
   
		 if (dos == f) {
			  tr[i].style.display = "";
   
   
   
   
		  } 
   
   
   
		  else {
			tr[i].style.display = "none";
   
   
		  }
   
   
   
   
		}
		}
   
   }



  }


  function cambiar() { 

 // Declare variables
 var input, filter, table, tr, td,tds, i, cellValue, campo, f;
 input = document.getElementById("filtro2");
 filter = parseInt(input.value);
 table = document.getElementById("tb");
 campo = document.getElementById("nombreT");
 f = document.getElementById("fecha");


 tr = table.getElementsByTagName("tr");

 var uno, dos, tres, cuatro, cinco, seis, s, ocho, nueve, diez, once, doce;



 
 
 
 if(input.value=="Ponente" || input.value=="Nombre" ){


	campo.style.display="block";
	f.style.display="none";

 }

else{


	campo.style.display="none";
	f.style.display="block";


 }



   }


   
   