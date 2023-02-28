function validarUsuario(usuario){
param = "usu="+usuario;
var request = new XMLHttpRequest();

request.open("POST", "valida_usu.php", true);
request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
request.setRequestHeader("Content-lenght", "param.lenght");
request.setRequestHeader("Conection", "close");

request.onreadystatechange=function(){
if(this.readyState==4){
if(this.status==200){
if(this.responseText !=null){
document.getElementById("msj").innerHTML=this.responseText;
}
}else{
	alert("Error de comunicacion: La informacion no se recibio")
}
}else{
	alert("Error de comunicacion " + this.statusText);
}
}

}
