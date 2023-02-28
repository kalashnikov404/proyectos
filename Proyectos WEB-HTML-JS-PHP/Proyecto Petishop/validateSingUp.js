


function validarFormulario() {

var frm= document.getElementById('form-login');




    var nombre =frm.elements["nombre"];
    var paterno =frm.elements["paterno"];
    var materno =frm.elements["materno"];
    var pais =frm.elements["pais"];
    var password =frm.elements["password"];
    var cp =frm.elements["cp"];
    var fecha =frm.elements["fecha"];

    var email =frm.elements["usuario"];


    var estado =frm.elements["estado"];
    var colonia =frm.elements["cp"];
    var ciudad =frm.elements["cp"];
    var calle =frm.elements["cp"];
    var municipio =frm.elements["cp"];


  
    var regEmail=/^([A-Za-z]|[0-9])+$/;  
    var regCP=/^\d{5}$/;                                       
    var regNombre = /\d+$/g;    
    var regPassword=/[^a-zA-Z0-9_-]/;   
    var regUsuario=/[^a-zA-Z0-9_-]/;   

   


    // Javascript reGex for Name validation


    if (nombre == "" ) {

        alert("Error: Debes ingresar un nombre");

        document.getElementById("nombre").style.background = 'red';
    }



     if (paterno == "") {

        alert("Error: Debes ingresar un apellido paterno");

        document.getElementById("paterno").style.background = 'red';

    }



    
     if (materno == "") {
        alert("Error: Debes ingresar un apellido materno");


        document.getElementById("materno").style.background = 'red';

    }

     
   
     if (email == "") {


        alert("Error: Debes ingresar un email de usuario");




        document.getElementById("usuario").style.background = 'red';

    }
      
     if (password == "") {

        alert("Error: Debes ingresar un password");




        document.getElementById("password").style.background = 'red';

    }

    

     if (password == "" || !regPassword.test(password)) {

        alert("Error: Debes ingresar un password correcto");



        document.getElementById("password").style.background = 'red';


    }



    

     if(password.length <6){
        
        alert("Error: Debes ingresar un password mayor a 6 caracteres");


        document.getElementById("password").style.background = 'red';


    }
   
     if (cp== "") {



        alert("Error: Debes ingresar un codigo postal");




        document.getElementById("cp").style.background = 'red';

    }


    if(!document.querySelector('input[name="genero"]:checked')) {
        
        alert('Error: Debes seleccionar un genero');

        document.getElementById("genero").style.background = 'red';

        
        


        }


    if (estado == "" ) {

        alert("Error: Debes ingresar un estado");



        document.getElementById("estado").style.background = 'red';


    }



    if (ciudad == "" ) {

        alert("Error: Debes ingresar una ciudad");



        document.getElementById("ciudad").style.background = 'red';


    }


    if (colonia == "" ) {


        alert("Error: Debes ingresar una colonia");


        document.getElementById("colonia").style.background = 'red';


    }


    
    if (calle == "" ) {


        alert("Error: Debes ingresar una calle");

        document.getElementById("calle").style.background = 'red';


    }


    if(estado.value=='Selecciona un estado') { 


        alert("Error: Debes seleccionar un estado");


        document.getElementById("estado").style.background = 'red';

    }



    

    if(municipio.value=='Selecciona un municipio') { 


        alert("Error: Debes seleccionar un municipio");


        document.getElementById("municipio").style.background = 'red';

    }

    if(pais.value=='Selecciona un pais') { 


        alert("Error: Debes seleccionar un pais");


        document.getElementById("pais").style.background = 'red';

    }

    
    if (!fecha.value ) {


        alert("Error: Debes seleccionar una fecha de nacimiento");

        document.getElementById("fecha").style.background = 'red';


    }


    

else
$('#form-login').reset()

$('#form-login').submit()

}



