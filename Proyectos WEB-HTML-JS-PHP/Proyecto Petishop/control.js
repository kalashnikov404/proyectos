function $(id){
	return document.getElementById(id);
}


//crear una etiqueta, un input y un boton
function crearElementos(){
	var lbl = document.createElement("label");
	var txt = document.createTextNode("Usuario:");
			lbl.appendChild(txt);
	//<label>Usuario:</label>
	
	var npt = document.createElement("input");
			npt.setAttribute("type", "text");
			npt.setAttribute("placeholder", "Usuario");
			npt.setAttribute("id", "usuario");
			npt.removeAttribute("id");
	//<input type='text' placeholder='usuario' id='usuario' >

	var btn = document.createElement("button");
	var btx = document.createTextNode("Siguiente");
			btn.setAttribute("type", "button");
			btn.id = "boton_siguiente";
			btn.classList.add('ejemplo');
			btn.classList.add('ejemplo2');
			btn.classList.remove('ejemplo2');
			btn.appendChild(btx);
			btn.addEventListener('click', ocultar);



	var div = $("contenedor");
			console.log(div);

	div.appendChild(lbl);
	div.appendChild(npt)
	div.appendChild(btn);

}

function ocultar(){
	$("contenedor").style.display = 'none';
	$("contenedor_2").style.display = 'block';
}

function mostrar(){
	$("contenedor").style.display = 'block';
	$("contenedor_2").style.display = 'none';
}


function elementos_2(){
	var rad = document.createElement("input");
			rad.setAttribute("type", "radio");
			rad.setAttribute("name", "opciones");

	var lbl = document.createElement("label");
	var txt = document.createTextNode("Opción uno");
			lbl.appendChild(txt);

	var rad2 = document.createElement("input");
			rad2.setAttribute("type", "radio");
			rad2.setAttribute("name", "opciones");

	var lbl2 = document.createElement("label");
	var txt2 = document.createTextNode("Opción dos");
			lbl2.appendChild(txt2);

	var btn = document.createElement("button");
	var btx = document.createTextNode("Regresar");
			btn.setAttribute("type", "button");
			btn.id = "boton_siguiente";
			btn.appendChild(btx);
			btn.addEventListener('click', mostrar);

	var div = $("contenedor_2");
			div.appendChild(rad);
			div.appendChild(lbl);
			div.appendChild(rad2);
			div.appendChild(lbl2);
			div.appendChild(btn);
}

function cambiar_color(){
	$("boton_siguiente").style.color = "black";
}

function eliminar_boton(idBoton){
	var btn = $(idBoton);
			btn.remove();
}


crearElementos();
elementos_2();