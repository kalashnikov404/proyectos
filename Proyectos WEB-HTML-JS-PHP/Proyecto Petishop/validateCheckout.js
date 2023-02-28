
  
function validarFormulario(form){




    var regEmail=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/g;  
    var regTarjeta=/^\d{16}$/;                                       
    var regNombre = /\d+$/g;    
    var regPrecio=/^-?\d*\.?\d*$/;   
    var regUsuario=/[^a-zA-Z0-9_-]/; 


    var nombre =form.nombre.value;
    var apellido =form.apellido.value;
    var email =form.email.value;
    var direccion =form.direccion.value;
    var pais =form.pais.value;
    var estado =form.estado.value;
    var cp =form.cp.value;
    var same =form.same.value;
    var save =form.save.value;

    var credit =form.credit.value;
    var debit =form.debit.value;
    var paypal =form.paypal.value;

    var numeroT =form.numeroT.value;
    var nombreT =form.nombreT.value;
    var expiracion =form.expiracion.value;
    var ccv =form.ccv.value;

    


    
    if (nombre == "" || regNombre.test(nombre)) {

        alert("Error: Debes ingresar una image");

        document.getElementById("nombre").style.background = 'red';

    }





    
    if (apellido == "" || regNombre.test(apellido)) {

        alert("Error: Debes ingresar una apellido");

        document.getElementById("apellido").style.background = 'red';

    }


    if (email == "" || !regEmail.test(email)) {


        alert("Error: Debes ingresar un email de usuario");




        document.getElementById("email").style.background = 'red';

    }




    if (pais == "" ) {

        alert("Error: Debes ingresar una pais");

        document.getElementById("pais").style.background = 'red';

    }



    if (estado == "") {

        alert("Error: Debes ingresar una estado");

        document.getElementById("estado").style.background = 'red';

    }



    if (cp == "" || !regPrecio.test(cp)  ) {

        alert("Error: Debes ingresar un codigo postal");

        document.getElementById("cp").style.background = 'red';

    }




    if (nombreT == "") {

        alert("Error: Debes ingresar un nombre de la tarjeta");

        document.getElementById("nombreT").style.background = 'red';

    }



    if (numeroT == "" || !regPrecio.test(numeroT) ) {

        alert("Error: Debes ingresar un numero de tarjeta");

        document.getElementById("numeroT").style.background = 'red';

    }

    

    if (expiracion == "") {

        alert("Error: Debes ingresar la fecha de expiracion");

        document.getElementById("expiracion").style.background = 'red';

    }



    if (direccion == "") {

        alert("Error: Debes ingresar la fecha de expiracion");

        document.getElementById("direccion").style.background = 'red';

    }
    

    if (ccv == "" || !regPrecio.test(ccv)) {

        alert("Error: Debes ingresar el ccv");

        document.getElementById("ccv").style.background = 'red';

    }



else


alert("Compra exitosa");







}
