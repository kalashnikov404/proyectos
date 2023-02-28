
  
function validarFormulario(form){




    var regEmail=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/g;  
    var regTarjeta=/^\d{16}$/;                                       
    var regNombre = /\d+$/g;    
    var regPrecio=/^-?\d*\.?\d*$/;   
    var regUsuario=/[^a-zA-Z0-9_-]/; 
    var regPassword=/[^a-zA-Z0-9_-]/;   


    var username =form.username.value;
    var password =form.password.value;
    
    

    


    
    if (username == "" || regEmail.test(username)) {

        alert("Error: Debes ingresar un username");

        document.getElementById("username").style.background = 'red';

    }





    
    if (password == "" || regPassword.test(password)) {

        alert("Error: Debes ingresar un password");

        document.getElementById("password").style.background = 'red';

    }


else








}
