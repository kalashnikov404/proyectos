
var c="";

$(document).ready(function(){
    $(".containerDA").css({display: 'none'});

	cargarTabla();

});

function cargarTabla () {
	$.ajax({
		url: 'formularioProductoF.php',
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





    function filtrarProducto () {



        if(document.querySelector("#nombreP").value==''){

            alert('Error: Debes ingresar una categoria de producto');

            return true;
        }

        else
        var f = document.querySelector("#nombreP").value.toLowerCase();



                        $.ajax({
                                url: 'formularioProductoF.php',
                            type: 'POST',
                            dataType: 'html',
                            data: {
                                opc: "filtrar",
                                tipo_pro: f,
                                
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
                    
            




    function buscarProducto () {


        

        if(document.querySelector("#nombreT").value==''){

            alert('Error: Debes ingresar un nombre de producto');

            return true;
        }
        var x= document.getElementById("nombreT").value.toLowerCase();

        $.ajax({
                    url: 'formularioProductoF.php',
                type: 'POST',
                dataType: 'html',
                data: {
                    opc: "buscar",
                    nombre_pro: x,
                    
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
        


function registrarProducto(form) {




    var nombre =form.nombre.value;
    var codigo =form.codigo.value;
    var tipo =form.tipo.value;
    var existencia =form.existencia.value;
    var descripcion =form.descripcion.value;
    var imagen =form.imagen.value;
    var precio =form.precio.value;
    var garantia =form.garantia.value;
    var promocion =form.promocion.value;



  
    var regEmail=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/g;  
    var regCP=/^\d{5}$/;                                       
    var regNombre = /\d+$/g;    
    var regPrecio=/^-?\d*\.?\d*$/;   
    var regUsuario=/[^a-zA-Z0-9_-]/;   



    // Javascript reGex for Name validation


    if (nombre == "" || regNombre.test(nombre)) {

        alert("Error: Debes ingresar un nombre");

        document.getElementById("nombre").style.background = 'red';
    }

    if (precio == "" || !regPrecio.test(precio)) {

        alert("Error: Debes ingresar el precio");

        document.getElementById("precio").style.background = 'red';

    }




     if (codigo == "" || !regPrecio.test(codigo) ) {

        alert("Error: Debes ingresar el codigo");

        document.getElementById("codigo").style.background = 'red';

    }



    if (tipo == "" ) {

        alert("Error: Debes ingresar el codigo");

        document.getElementById("tipo").style.background = 'red';

    }



    if (existencia == "" || !regPrecio.test(existencia)) {

        alert("Error: Debes ingresar la existencia");

        document.getElementById("existencia").style.background = 'red';

    }


    if (descripcion == "") {

        alert("Error: Debes ingresar una descripcion");

        document.getElementById("descripcion").style.background = 'red';

    }



    if (promocion == "") {

        alert("Error: Debes ingresar una promocion");

        document.getElementById("promocion").style.background = 'red';

    }




    if (garantia == "") {

        alert("Error: Debes ingresar una garantia");

        document.getElementById("garantia").style.background = 'red';

    }


    
    if (imagen == "") {

        alert("Error: Debes ingresar una imagen");

        document.getElementById("imagen").style.background = 'red';

    }


else


	var f = document.querySelector("#frm1");
	var img= f.imagen.value.replaceAll("C:", "")


   $.ajax({
	   url: 'formularioProductoF.php',
	   type: 'POST',
	   dataType: 'HTML',
	   data: {
		   opc: "registrar",
		   
		  nombre_pro:f.nombre.value,
		   codigo_pro:f.codigo.value,
		   tipo_pro:f.tipo.value,
		   existencia_pro:f.existencia.value,
		   descripcion_pro:f.descripcion.value,
		   imagen_pro:img,
		   precio_pro:f.precio.value,
		   garantia_pro:f.garantia.value,
		   promocion_pro:f.promocion.value,


		   success: function (data) {
		$("#contenedor").html(data);
		Swal.fire({
			icon: 'success',
			type: 'success',
			title: '¡Producto registrado exitosamente',
			text: 'Exito!',
			showConfirmButton: false,
			timer: 2000
		  })	
		  
		  
		  document.getElementById("frm1").reset();

	}

},
error: function () {
	Swal.fire({
		type: 'error',
		title: 'Error al registrar',
		text: 'Error: Verifica los datos e intenta nuevamente',
		showConfirmButton: false,
		timer: 2000
	  })
	}



})
	
}


function eliminar (id) {
    var x=  $(id).closest("tr").find("td:nth-child(1)").text();

    let confirmAction = confirm("¿Estás seguro que deseas eliminar este producto?");
    if (confirmAction) {
   

   $.ajax({
       url: 'formularioProductoF.php',
       type: 'POST',
       dataType: 'html',
       data: {
           opc: 'eliminar',
           cve_pro: x,
       },
   })
   .done(function(res) {
       cargarTabla();
       swal("Exito", "Usuario eliminado!", "success");
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


function modificarProducto() {

	var f = document.querySelector("#frm2");
	var n=parseInt(c);

   $.ajax({
	   url: 'formularioProductoF.php',
	   type: 'POST',
	   dataType: 'html',
	   data: {
		   opc: 'modificar',
		   cve_pro:n,
		   nombre_pro:f.nombre.value,
		  codigo_pro:f.codigo.value,
		  tipo_pro:f.tipo.value,
		   existencia_pro:f.existencia.value,
		   descripcion_pro:f.descripcion.value,
		   precio_pro:f.precio.value,
		   garantia_pro:f.garantia.value,
		   promocion_pro:f.promocion.value,
		 

		

		   success: function (data) {

			$("#contenedor").html(data);
			swal("Exito", "Producto modificado!", "success");
	
	
		}
	
	},
	error: function () {
		swal ( "Oops" ,  "¡Ocurrio un error!" ,  "error" )
	}

})



   
}
  
function detallarModificar(elm) {
   
	var id = $(elm).closest("tr").find("td:nth-child(1)").text();
	c=id;

	var nombre = $(elm).closest("tr").find("td:nth-child(2)").text();
	var codigo= $(elm).closest("tr").find("td:nth-child(3)").text();
	var tipo= $(elm).closest("tr").find("td:nth-child(4)").text();
	var existencia= $(elm).closest("tr").find("td:nth-child(5)").text();
	var descripcion= $(elm).closest("tr").find("td:nth-child(6)").text();

	var precio = $(elm).closest("tr").find("td:nth-child(8)").text();
	var garantia= $(elm).closest("tr").find("td:nth-child(9)").text();
    var promocion= $(elm).closest("tr").find("td:nth-child(10)").text();



	document.getElementById("id").value=id;
	document.getElementById("nombre").value=nombre;
	document.getElementById("codigo").value=codigo;
	document.getElementById("tipo").value=tipo;
	document.getElementById("existencia").value=existencia;
	document.getElementById("descripcion").value=descripcion;
	document.getElementById("precio").value=precio;
	document.getElementById("garantia").value=garantia;
	document.getElementById("promocion").value=promocion;
	




	$(".containerDA").css({display: 'block'});
        
    $(".container2").css({display: 'none'});
    $(".consult").css({display: 'none'});
	$("#contenedor").css({display: 'none'});
	$("#head2").css({display: 'none'});

	$(".center").css({display: 'none'});

    $(".cart").css({display: 'none'});

    $(".img").css({display: 'none'});

}
      
function regresarR() {
	cargarTabla();

	$(".containerDA").css({display: 'none'});
	
	$(".container2").css({display: 'block'});
    $(".consult").css({display: 'block'});
	$("#contenedor").css({display: 'block'});
	$("#head2").css({display: 'block'});
	$(".center").css({display: 'block'});

  }







