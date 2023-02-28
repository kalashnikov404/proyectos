
function validarFormulario(){

    var frm= document.getElementById('form-login');



    var regEmail=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/g;  
    var regTarjeta=/^\d{16}$/;                                       
    var regNombre = /\d+$/g;    
    var regPrecio=/^-?\d*\.?\d*$/;   
    var regUsuario=/[^a-zA-Z0-9_-]/; 
    var regPassword=/[^a-zA-Z0-9_-]/;   


    var email =frm.email.value;
    var password =frm.password.value;
    var password2 =frm.password2.value;



    

    if (email == "") {


        alert("Error: Debes ingresar un email de usuario");




        document.getElementById("email").style.background = 'red';

    }



    
    if (password == "") {

        alert("Error: Debes ingresar un password");

        document.getElementById("password").style.background = 'red';

    }




    if (password2 == "" || !password==password2) {

        alert("Error: Debes ingresar el mismo password");

        document.getElementById("password2").style.background = 'red';

    }








else

$('#form-login').submit()






}
