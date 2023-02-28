<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/all.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

 <!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
 <!-- Font Awesome CSS -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

 <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
 <link href='https://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext' rel='stylesheet' type='text/css'> 


    
    <link rel="stylesheet" type="text/css" href="css/estilos.css">


</head>
<body>


   <!--form de evento-->

        <div class="containerRE">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 style="color:#1404f4; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;"  class="title">Registro de eventos</h1>
	               		<hr />
	               	</div>
	            </div> 
				<div class="main-loginRE main-center">
					<form class="form-horizontal" id="frm1" method="post" action="#">
						
						<div class="form-group">
							<label style="color:black;" for="nombre" class="cols-sm-2 control-label">Nombre de evento:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon iconbk"><i class="fa fa-tag" aria-hidden="true"></i></span>
									<input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="nombre" id="nombre"  placeholder="Escribe el nombre del evento"/>
								</div>
							</div>
						</div>


                        <div class="form-group">
							<label style="color:black;" for="ponente" class="cols-sm-2 control-label">Ponente(Opcional):</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon iconbk"><i class="fa fa-male" aria-hidden="true"></i></span>
									<input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="ponente" id="ponente"  placeholder="Escribe el nombre del ponente"/>
								</div>
							</div>
						</div>


                        
                  

                        
                        <div class="form-group">
							<label style="color:black;" for="inicio" class="cols-sm-2 control-label">Fecha inicio:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon iconbk"><i class="fa fa-calendar" aria-hidden="true"></i></span>
									<input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="date"  required min=<?php $hoy=date("Y-m-d"); echo $hoy;?>  class="form-control" name="inicio" id="inicio"  placeholder="Escribe la fecha de inicio"/>
								</div>
							</div>
						</div>


                        <div class="form-group">
							<label style="color:black;" for="fin" class="cols-sm-2 control-label">Fecha fin:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon iconbk"><i class="fa fa-calendar-o" aria-hidden="true"></i></span>
									<input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="date" class="form-control" name="fin" id="fin" required min=<?php $hoy=date("Y-m-d"); echo $hoy;?>  placeholder="Escribe la fecha de terminación"/>
								</div>
							</div>
						</div>

                        
                        <div class="form-group">
							<label style="color:black;" for="cupo" class="cols-sm-2 control-label">Cupo máximo:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon iconbk"><i class="fa fa-sort-numeric-desc" aria-hidden="true"></i></span>
									<input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="cupo" id="cupo"  placeholder="Escribe el cupo máximo"/>
								</div>
							</div>
						</div>





                        <div class="form-group">
                        <label style="color:black;" for="descripcion" class="cols-sm-2 control-label">Descripción(Opcional):</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-leanpub" aria-hidden="true"></i></span>
                                <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="descripcionR" id="descripcionR"  placeholder="Escribe la descripción"/>
                            </div>
                        </div>
                    </div>
                      

						<div class="form-group ">
							<button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:registrar()">Registrar Evento</button>
						</div>

                        <div class="form-group ">
							<button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:regresar()">Regresar</button>
						</div>
					
					</form>
				</div>
			</div>
		</div>
    </div>




   
    <div class="containerDE">
        <div class="row main">
            <div class="panel-heading">
               <div class="panel-title text-center">
                       <h1 f style="color:#09ec2f; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;" class="title">Detalle de eventos</h1>
                       <hr />
                   </div>
            </div> 
            <div class="main-loginDE main-center">
                <form class="form-horizontal" id="frm" method="post" action="#">
                    
	
                    <div class="form-group">
                        <label style="color:black;" for="nombreD" class="cols-sm-2 control-label">Nombre de evento:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-tag" aria-hidden="true"></i></span>
                                <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="nombreD" id="nombreD"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label style="color:black;" for="ponenteD" class="cols-sm-2 control-label">Ponente(Opcional):</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-male" aria-hidden="true"></i></span>
                                <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="ponenteD" id="ponenteD"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    
              

                    
                    <div class="form-group">
                        <label style="color:black;" for="inicioD" class="cols-sm-2 control-label">Fecha inicio:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="inicioD" id="inicioD"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label style="color:black;" for="finD" class="cols-sm-2 control-label">Fecha fin:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-calendar-o" aria-hidden="true"></i></span>
                                <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="finD" id="finD"  placeholder=""/>
                            </div>
                        </div>
                    </div>

                    
                    <div class="form-group">
                        <label style="color:black;" for="cupoD" class="cols-sm-2 control-label">Cupo máximo:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-sort-numeric-desc" aria-hidden="true"></i></span>
                                <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="cupoD" id="cupoD"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label style="color:black;" for="descripcionD" class="cols-sm-2 control-label">Descripción(Opcional):</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-leanpub" aria-hidden="true"></i></span>
                                <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="descripcionD" id="descripcionD"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group ">
                        <button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:regresar2()">Regresar</button>
                    </div>
                
                </form>
            </div>
        </div>
    </div>
</div>



   
<div class="containerME">
    <div class="row main">
        <div class="panel-heading">
           <div class="panel-title text-center">
                   <h1  style="color:#e0211a; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;" class="title">Modificacion de eventos</h1>
                   <hr />
               </div>
        </div> 
        <div class="main-loginME main-center">
            <form class="form-horizontal" id="frm2" method="post" action="#">
                
                <div class="form-group">
                    <label style="color:black;" for="nombreM" class="cols-sm-2 control-label">Nombre de evento:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-tag" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="nombreM" id="nombreM"  placeholder=""/>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label style="color:black;" for="ponenteM" class="cols-sm-2 control-label">Ponente(Opcional):</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-male" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="ponenteM" id="ponenteM"  placeholder=""/>
                        </div>
                    </div>
                </div>


                
          

                
                <div class="form-group">
                    <label style="color:black;" for="inicioM" class="cols-sm-2 control-label">Fecha inicio:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="date" required min=<?php $hoy=date("Y-m-d"); echo $hoy;?>  class="form-control" name="inicioM" id="inicioM"  placeholder=""/>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label style="color:black;" for="finM" class="cols-sm-2 control-label">Fecha fin:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-calendar-o" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="date" required min=<?php $hoy=date("Y-m-d"); echo $hoy;?>  class="form-control" name="finM" id="finM"  placeholder=""/>
                        </div>
                    </div>
                </div>

                
                <div class="form-group">
                    <label style="color:black;" for="cupoM" class="cols-sm-2 control-label">Cupo máximo:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-sort-numeric-desc" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="cupoM" id="cupoM"  placeholder=""/>
                        </div>
                    </div>
                </div>



                <div class="form-group">
                        <label style="color:black;" for="descripcionM" class="cols-sm-2 control-label">Descripción(Opcional):</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-leanpub" aria-hidden="true"></i></span>
                                <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="descripcionM" id="descripcionM"  placeholder="Escribe la descripción"/>
                            </div>
                        </div>
                    </div>

                <div class="form-group ">
                    <button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:modificarB()">Modificar</button>
                </div>
            
                <div class="form-group ">
                    <button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:regresar3()">Regresar</button>
                </div>
            
            </form>
        </div>
    </div>
</div>
</div>




<!--form de estudiante-->


<div class="containerRA">
    <div class="row main">
        <div class="panel-heading">
           <div class="panel-title text-center">
                   <h1 style="color:#1404f4; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;"  class="title">Registro de Aspirantes</h1>
                   <hr />
               </div>
        </div> 
        <div class="main-loginRA main-center">
            <form class="form-horizontal" id="frm1" method="post" action="#">
                
                <div class="form-group">
                    <label style="color:black;" for="nombre" class="cols-sm-2 control-label">Nombre:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="nombre" id="nombre"  placeholder="Escribe el nombre"/>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label style="color:black;" for="paterno" class="cols-sm-2 control-label">Apellido Paterno:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-male" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="paterno" id="paterno"  placeholder="Escribe el 1er apellido"/>
                        </div>
                    </div>
                </div>


                
                <div class="form-group">
                    <label style="color:black;" for="materno" class="cols-sm-2 control-label">Apellido Materno:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-female" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="materno" id="materno"  placeholder="Escribe el 2do apellido"/>
                        </div>
                    </div>
                </div>


                
                <div class="form-group">
                    <label style="color:black;" for="direccion" class="cols-sm-2 control-label">Direccion:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-map-marker" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="direccion" id="direccion"  placeholder="Escribe la direccion"/>
                        </div>
                    </div>
                </div>



                
                <div class="form-group">
                    <label style="color:black;" for="telefono" class="cols-sm-2 control-label">Telefono:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-phone" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="telefono" id="telefono"  placeholder="Escribe el telefono"/>
                        </div>
                    </div>
                </div>



                
                <div class="form-group">
                    <label style="color:black;" for="ciudad" class="cols-sm-2 control-label">Ciudad:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-building" aria-hidden="true"></i></span>
                            <input  style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="ciudad" id="ciudad"  placeholder="Escribe la ciudad"/>
                        </div>
                    </div>
                </div>


                
                <div class="form-group">
                    <label style="color:black;" for="cp" class="cols-sm-2 control-label">Codigo Postal:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-location-arrow" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="cp" id="cp"  placeholder="Escribe el codigo postal"/>
                        </div>
                    </div>
                </div>

                <div class="form-group ">
                    <button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:registrar()">Registrar Persona</button>
                </div>

                <div class="form-group ">
                    <button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:regresar()">Regresar</button>
                </div>
            
            </form>
        </div>
    </div>
</div>
</div>





<div class="containerDA">
<div class="row main">
    <div class="panel-heading">
       <div class="panel-title text-center">
               <h1 f style="color:#09ec2f; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;" class="title">Detalle de Aspirantes</h1>
               <hr />
           </div>
    </div> 
    <div class="main-loginDA main-center">
        <form class="form-horizontal" id="frm" method="post" action="#">
            

            <div class="form-group">
                <label style="color:black;" for="nombre" class="cols-sm-2 control-label">Id:</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon iconbk"><i class="fa fa-key" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;"  disabled name="id" id="idD" disabled; placeholder=""/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label style="color:black;" for="nombre" class="cols-sm-2 control-label">Nombre:</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon iconbk"><i class="fa fa-user" aria-hidden="true"></i></span>
                        <input type="text" class="form-control"  style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;"disabled name="nombre" id="nombreD"  placeholder="Escribe el nombre"/>
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label style="color:black;" for="paterno" class="cols-sm-2 control-label">Apellido Paterno:</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon iconbk"><i class="fa fa-male" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" disabled name="paterno" id="paternoD" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;"  placeholder="Escribe el 1er apellido"/>
                    </div>
                </div>
            </div>


            
            <div class="form-group">
                <label style="color:black;" for="materno" class="cols-sm-2 control-label">Apellido Materno:</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon iconbk"><i class="fa fa-female" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" disabled name="materno" id="maternoD"  placeholder="Escribe el 2do apellido"/>
                    </div>
                </div>
            </div>


            
            <div class="form-group">
                <label style="color:black;" for="direccion" class="cols-sm-2 control-label">Direccion:</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon iconbk"><i class="fa fa-map-marker" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" disabled name="direccion" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" id="direccionD"  placeholder="Escribe la direccion"/>
                    </div>
                </div>
            </div>



            
            <div class="form-group">
                <label style="color:black;" for="telefono" class="cols-sm-2 control-label">Telefono:</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon iconbk"><i class="fa fa-phone" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" disabled name="telefono" id="telefonoD" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" placeholder="Escribe el telefono"/>
                    </div>
                </div>
            </div>



            
            <div class="form-group">
                <label style="color:black;" for="ciudad" class="cols-sm-2 control-label">Ciudad:</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon iconbk"><i class="fa fa-building" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" disabled name="ciudad" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" id="ciudadD"  placeholder="Escribe la ciudad"/>
                    </div>
                </div>
            </div>


            
            <div class="form-group">
                <label style="color:black;" for="cp" class="cols-sm-2 control-label">Codigo Postal:</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon iconbk"><i class="fa fa-location-arrow" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" disabled name="cp" id="cpD" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;"   placeholder="Escribe el codigo postal"/>
                    </div>
                </div>
            </div>

          

            <div class="form-group ">
                <button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:regresar2()">Regresar</button>
            </div>
        
        </form>
    </div>
</div>
</div>
</div>


<div class="containerMA">
<div class="row main">
<div class="panel-heading">
   <div class="panel-title text-center">
           <h1  style="color:#e0211a; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;" class="title">Modificacion de Aspirantes</h1>
           <hr />
       </div>
</div> 
<div class="main-loginMA main-center">
    <form class="form-horizontal" id="frm2" method="post" action="#">
        


        <div class="form-group">
            <label style="color:black;" for="nombre" class="cols-sm-2 control-label">Nombre:</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon iconbk"><i class="fa fa-key" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #0f07ee; font-size: 18px;" name="id" id="idM"  placeholder="Escribe el nombre"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label style="color:black;" for="nombre" class="cols-sm-2 control-label">Nombre:</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon iconbk"><i class="fa fa-user" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #0f07ee; font-size: 18px;" name="nombre" id="nombreM"  placeholder="Escribe el nombre"/>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label style="color:black;" for="paterno" class="cols-sm-2 control-label">Apellido Paterno:</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon iconbk"><i class="fa fa-male" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" name="paterno" id="paternoM" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #0f07ee; font-size: 18px;" placeholder="Escribe el 1er apellido"/>
                </div>
            </div>
        </div>


        
        <div class="form-group">
            <label style="color:black;" for="materno" class="cols-sm-2 control-label">Apellido Materno:</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon iconbk"><i class="fa fa-female" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" name="materno" id="maternoM" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #0f07ee; font-size: 18px;" placeholder="Escribe el 2do apellido"/>
                </div>
            </div>
        </div>


        
        <div class="form-group">
            <label style="color:black;" for="direccion" class="cols-sm-2 control-label">Direccion:</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon iconbk"><i class="fa fa-map-marker" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" name="direccion" id="direccionM"  style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #0f07ee; font-size: 18px;" placeholder="Escribe la direccion"/>
                </div>
            </div>
        </div>



        
        <div class="form-group">
            <label style="color:black;" for="telefono" class="cols-sm-2 control-label">Telefono:</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon iconbk"><i class="fa fa-phone" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" name="telefono" id="telefonoM"  style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #0f07ee; font-size: 18px;" placeholder="Escribe el telefono"/>
                </div>
            </div>
        </div>



        
        <div class="form-group">
            <label style="color:black;" for="ciudad" class="cols-sm-2 control-label">Ciudad:</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon iconbk"><i class="fa fa-building" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" name="ciudad" id="ciudadM" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #0f07ee; font-size: 18px;"  placeholder="Escribe la ciudad"/>
                </div>
            </div>
        </div>


        
        <div class="form-group">
            <label style="color:black;" for="cp" class="cols-sm-2 control-label">Codigo Postal:</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon iconbk"><i class="fa fa-location-arrow" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" name="cp" id="cpM"  style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #0f07ee; font-size: 18px;" placeholder="Escribe el codigo postal"/>
                </div>
            </div>
        </div>

      

        <div class="form-group ">
            <button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:modificarB()">Modificar</button>
        </div>
    
        <div class="form-group ">
            <button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:regresar3()">Regresar</button>
        </div>
    
    </form>
</div>
</div>
</div>
</div>





      <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</body>
<script>

</script>
</html>