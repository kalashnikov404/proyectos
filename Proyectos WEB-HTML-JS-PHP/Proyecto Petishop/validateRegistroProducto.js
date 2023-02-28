



function validarFormulario() {
    var frm= document.getElementById('frm1');


    var nombre =frm.nombre.value;
    var codigo =frm.codigo.value;
    var tipo =frm.tipo.value;
    var existencia =frm.existencia.value;
    var descripcion =frm.descripcion.value;
    var image =frm.imagen.value;
    var precio =frm.precio.value;
    var garantia =frm.garantia.value;
    var promocion =frm.promocion.value;



  
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

        alert("Error: Debes ingresar una image");

        document.getElementById("image").style.background = 'red';

    }


else

$('#frm1').submit()

}


