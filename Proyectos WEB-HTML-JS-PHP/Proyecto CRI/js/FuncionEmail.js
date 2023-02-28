function enviarPassword(){
    const btn = document.getElementById('btn-reset');

    document.getElementById('form')
     .addEventListener('submit', function(event) {
       event.preventDefault();
    
       btn.value = 'Sending...';
    
       const serviceID = 'default_service';
       const templateID = 'template_a9ovnab';
    
       emailjs.sendForm(serviceID, templateID, this)
        .then(() => {
          btn.value = 'Send Email';

		  Swal.fire({
			icon: 'success',
			title: 'Exito: Tu contraseña ha sido enviada',
			showConfirmButton: false,
			timer: 1500
		  })

        }, (err) => {
          btn.value = 'Send Email';
          alert(JSON.stringify(err));
        });
    });
        
    
}




function buscarUsuario () {
	var f = document.querySelector("#form");
	var e = document.querySelector("#email");
    var frm= document.getElementById('form');

  

	$.ajax({
		url: 'Email.php',
		type: 'POST',
		dataType: 'HTML',
		data: {
			opc: "consulta",
			email_usuario: f.email.value,
			

		},
	})
	.done(function(res) {


		if(res.toString().length>1){
	     
		$("#contenedor").html(res);

enviarPassword();


	}else{
		Swal.fire({
			icon: 'error',
			title: 'Oops... ocurrio un error',
			text: '¡Tu usuario no existe o es incorrecto!',
			footer: '<a href="">¡Verifica e intentalo nuevamente!</a>'
		  })
	
	}
   

})
   
	
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});

}