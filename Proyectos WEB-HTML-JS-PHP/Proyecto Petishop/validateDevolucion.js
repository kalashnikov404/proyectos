
var aux='';

    $(document).ready(function(){
        $(".xd").css({display: 'none'});

    
    });
    

function validarFormulario(form){




    var regEmail=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/g;  
    var regTarjeta=/^\d{16}$/;                                       
    var regNombre = /\d+$/g;    
    var regPrecio=/^-?\d*\.?\d*$/;   
    var regUsuario=/[^a-zA-Z0-9_-]/; 


    var nombre =form.nombre.value;
    var email =form.email.value;
    var motivo =form.motivo.value;



    


    
    if (nombre == "" || !regNombre.test(nombre)) {

        alert("Error: Debes ingresar un nombre");

        document.getElementById("nombre").style.background = 'red';

    }





    if (email == "" || !regEmail.test(email)) {


        alert("Error: Debes ingresar un email de usuario");




        document.getElementById("email").style.background = 'red';

    }



    
    if (motivo == "" || !regNombre.test(motivo)) {

        alert("Error: Debes ingresar un motivo");

        document.getElementById("motivo").style.background = 'red';

    }



else


alert("Devolucion exitosa");







}



function detallarDevolucion(elm) {
   
	
	var email = $(elm).closest("tr").find("td:nth-child(7)").text();
	var auxx = $(elm).closest("tr").find("td:nth-child(1)").text();

	document.getElementById("cook").value=auxx;
    document.getElementById("email").value=email;



	$(".xd").css({display: 'block'});
        
    $(".container2").css({display: 'none'});
    $(".consult").css({display: 'none'});
	$("#contenedor").css({display: 'none'});
	$("#head2").css({display: 'none'});



	
}






function devolverP() {


    var b = document.getElementById("cook").value;
    var d = document.getElementById("motivo").value;


   $.ajax({
	   url: 'formularioVentaF.php',
	   type: 'POST',
	   dataType: 'html',
	   data: {
		   opc: 'devolucion',
		   cve_ven:b,
           motivo_ven:d,


		   success: function (data) {

			$("#contenedor").html(data);
			swal("Exito", "Devolucion realizada!", "success");
	
	
		}
	
	},
	error: function () {
		swal ( "Oops" ,  "¡Ocurrio un error!" ,  "error" )
	}

})



   
}