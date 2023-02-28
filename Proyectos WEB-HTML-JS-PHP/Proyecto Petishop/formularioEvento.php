<?php
header('Access-Control-Allow-Origin: *');
// Initialize the session
session_start();
 
// Check if the user is logged in, if not then redirect him to login page
if(!isset($_SESSION["loggedin"]) || $_SESSION["loggedin"] !== true){
    header("location: index.php");
    exit;
}
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eventos</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/all.css">
    <link rel="stylesheet" type="text/css" href="css/estilos3.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="css/datetimepicker.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment-with-locales.min.js" integrity="sha512-LGXaggshOkD/at6PFNcp2V2unf9LzFq6LE+sChH7ceMTDP0g2kn6Vxwgg7wkPP7AAtX+lmPqPdxB47A0Nz0cMQ==" crossorigin="anonymous"></script>
    <script type="text/javascript" src="js/datetimepicker.js"></script>
 <!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
 <!-- Font Awesome CSS -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

 <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
 <link href='https://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext' rel='stylesheet' type='text/css'> 

 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>  
    
    <script src="funciones_formularioE.js"></script>


 <!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
 <!-- Font Awesome CSS -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

 <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
 <link href='https://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext' rel='stylesheet' type='text/css'> 


 <script type="text/javascript">
$(document).ready(function(){
$(".containerME").css({display: 'none'});

$(".containerRE").css({display: 'none'});
$(".containerDE").css({display: 'none'});

$(".container2").css({display: 'block'});


});


</script>

    <style>

.main{
            margin-top: 70px;
       }
       .form-group{
           margin-bottom: 15px;
       }
       
       
       

       select, select::-webkit-input-placeholder{

        font-size: 15px;
        padding-top: 10px;
       }



       input,
       input::-webkit-input-placeholder {
           font-size: 11px;
           padding-top: 3px;
       }
       
       .main-loginRE{
            background-color: #e0211a;
           /* shadows and rounded borders */
           -moz-border-radius: 5px;
           -webkit-border-radius: 5px;
           border-radius: 5px;
           -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
           -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
           box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
       
       }
       
       label{
           margin-bottom: 15px;
           font-size:18px;
       }
       .main-center{
            margin-top: 30px;
            margin: 0 auto;
            max-width: 330px;
           padding: 40px 40px;
       
       }
       
       .login-button{
           margin-top: 5px;
       }
       
       .login-register{
           font-size: 12px;
           text-align: center;
           text-decoration:underline;
           color:#5CB85C;
           font-weight:bold;
       }

       .iconbk{
           background-color:#060606;

       }
       

       .main-loginDE{
            background-color: #711aeb;
           /* shadows and rounded borders */
           -moz-border-radius: 5px;
           -webkit-border-radius: 5px;
           border-radius: 5px;
           -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
           -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
           box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
       
       }


       
       .main-loginME{
            background-color: #7dec16;
           /* shadows and rounded borders */
           -moz-border-radius: 5px;
           -webkit-border-radius: 5px;
           border-radius: 5px;
           -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
           -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
           box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
       
       }



       .main-loginRA{
        background-color: #e0211a;
       /* shadows and rounded borders */
       -moz-border-radius: 5px;
       -webkit-border-radius: 5px;
       border-radius: 5px;
       -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
       -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
       box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
   
   }

       .main-loginDA{
        background-color: #711aeb;
       /* shadows and rounded borders */
       -moz-border-radius: 5px;
       -webkit-border-radius: 5px;
       border-radius: 5px;
       -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
       -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
       box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
   
   }


   
   .main-loginMA{
        background-color: #7dec16;
       /* shadows and rounded borders */
       -moz-border-radius: 5px;
       -webkit-border-radius: 5px;
       border-radius: 5px;
       -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
       -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
       box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
   
   }


   a {
    text-decoration: none;
    text-transform: uppercase;
    font-size: 30px;
}
a span {
    padding: 15px;
    transition: .5s;
    position: relative;
}
a span:nth-child(1) {
    color: #fff;
    background: #262626;
}
a span:nth-child(2) {
    color: #fff;
    background: #ff3636;
}
a span:nth-child(1):before {
    content: attr(data-attr);
    position: absolute;
    top: 0;
    left: 0;
    background: #ff3636;
    padding: 15px;
    transition: 0.5S;
    transform-origin: top;
    transform: rotateX(90deg) translateY(-50%);
}
a:hover span:nth-child(1):before {
    transform: rotateX(0deg) translateY(0%);
} 
a span:nth-child(2):before {
    content: attr(data-attr);
    position: absolute;
    top: 0;
    left: 0;
    background: #262626;
    padding: 15px;
    transition: 0.5S;
    transform-origin: bottom;
    transform: rotateX(90deg) translateY(50%);
}
a:hover span:nth-child(2):before {
    transform: rotateX(0deg) translateY(0%);
} 
a  span:nth-child(1):after {
  content: attr(data-attr);
  padding: 15px;
  position: absolute;
  top: 0;
  left: 0;
  background: #262626;
  transform-origin: bottom;
  transform: rotateX(0deg) translateY(0%);
  transition: 0.5s;
}
a:hover span:nth-child(1):after {
  transform: rotateX(90deg) translateY(50%);
}
a span:nth-child(2):after {
    content: attr(data-attr);
    position: absolute;
    top: 0;
    left: 0;
    background: #ff3636;
    padding: 15px;
    transition: 0.5S;
    transform-origin: top;
    transform: rotateX(0deg) translateY(0%);
}
a:hover span:nth-child(2):after {
    transform: rotateX(90deg) translateY(-50%);
} 


#fecha{
height: 30px;
width: 220px;
font-size: 15px;
padding-top: 10px;
}

</style>

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
					<form  autocomplete="off" class="form-horizontal" id="frm1" method="POST" action="javascript:insertar();">
						

						<div class="form-group">
							<label style="color:black;" for="nombre" class="cols-sm-2 control-label">Nombre de evento:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon iconbk"><i class="fa fa-tag" aria-hidden="true"></i></span>
									<input required style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="nombre" id="nombre"  placeholder="Escribe el nombre del evento"/>
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
									<input  required type="datetime-local" step="1"  min="<?php echo date('Y-m-d'); ?> ng-model="UIcontroller.JobDataModel.datetime" ng-model-options="{ getterSetter: true }" value="<?php echo date('YYYY:MM:DD HH:mm:ss')?>" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;"  required  class="form-control" name="inicio" id="inicio"  placeholder="Escribe la fecha de inicio"/>
								</div>
							</div>
						</div>

  



                        <div class="form-group">
							<label style="color:black;" for="fin" class="cols-sm-2 control-label">Fecha fin:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon iconbk"><i class="fa fa-calendar-o" aria-hidden="true"></i></span>
									<input required type="datetime-local" step="1"  ng-model="UIcontroller.JobDataModel.datetime" ng-model-options="{ getterSetter: true }" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" class="form-control" name="fin" id="fin" required  placeholder="Escribe la fecha de terminación"/>
								</div>
							</div>
						</div>

                        
                        <div class="form-group">
							<label style="color:black;" for="cupo" class="cols-sm-2 control-label">Cupo máximo:</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon iconbk"><i class="fa fa-sort-numeric-desc" aria-hidden="true"></i></span>
									<input required style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="number" class="form-control" name="cupo" id="cupo"  placeholder="Escribe el cupo máximo"/>
								</div>
							</div>
						</div>





                        <div class="form-group">
                        <label style="color:black;" for="descripcion" class="cols-sm-2 control-label">Descripción(Opcional):</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-leanpub" aria-hidden="true"></i></span>
                                <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="descripcion" id="descripcion"  placeholder="Escribe la descripción"/>
                            </div>
                        </div>
                    </div>
                      

						<div class="form-group ">
							<button type="submit" class="btn btn-danger btn-lg btn-block login-button">Registrar Evento</button>
						</div>

                        <div class="form-group ">
							<button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:regresarR()">Regresar</button>
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
                <form class="form-horizontal" id="frm2" method="post" action="javascript:modificar();">
                    
	
                <div class="form-group">
                        <label style="color:black;" for="nombreD" class="cols-sm-2 control-label">Id:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-tag" aria-hidden="true"></i></span>
                                <input disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="idD" id="idD"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label style="color:black;" for="nombreD" class="cols-sm-2 control-label">Nombre de evento:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-tag" aria-hidden="true"></i></span>
                                <input disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="nombreD" id="nombreD"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label style="color:black;" for="ponenteD" class="cols-sm-2 control-label">Ponente(Opcional):</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-male" aria-hidden="true"></i></span>
                                <input disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="ponenteD" id="ponenteD"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    
              

                    
                    <div class="form-group">
                        <label style="color:black;" for="inicioD" class="cols-sm-2 control-label">Fecha inicio:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                <input disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="inicioD" id="inicioD"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label style="color:black;" for="finD" class="cols-sm-2 control-label">Fecha fin:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-calendar-o" aria-hidden="true"></i></span>
                                <input disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="finD" id="finD"  placeholder=""/>
                            </div>
                        </div>
                    </div>

                    
                    <div class="form-group">
                        <label style="color:black;" for="cupoD" class="cols-sm-2 control-label">Cupo máximo:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-sort-numeric-desc" aria-hidden="true"></i></span>
                                <input disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="cupoD" id="cupoD"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label style="color:black;" for="descripcionD" class="cols-sm-2 control-label">Descripción(Opcional):</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-leanpub" aria-hidden="true"></i></span>
                                <input disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="descripcionD" id="descripcionD"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group ">
                        <button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:regresarD()">Regresar</button>
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
            <form class="form-horizontal" id="frm3" method="post" action="javascript:modificar();">

	
            <div class="form-group">
                        <label style="color:black;" for="idM" class="cols-sm-2 control-label">Id:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-tag" aria-hidden="true"></i></span>
                                <input  disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="idM" id="idM"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label style="color:black;" for="nombreM" class="cols-sm-2 control-label">Nombre de evento:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-tag" aria-hidden="true"></i></span>
                                <input  required style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="nombreM" id="nombreM"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label style="color:black;" for="ponenteM" class="cols-sm-2 control-label">Ponente(Opcional):</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-male" aria-hidden="true"></i></span>
                                <input  style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="ponenteM" id="ponenteM"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    
              

                    
                    <div class="form-group">
                        <label style="color:black;" for="inicioM" class="cols-sm-2 control-label">Fecha inicio:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                <input  required type="datetime-local" step="1"  min="<?php echo date('Y-m-d'); ?> ng-model="UIcontroller.JobDataModel.datetime" ng-model-options="{ getterSetter: true }" value="<?php echo date('YYYY:MM:DD HH:mm:ss')?>" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;"  required  class="form-control" name="inicioM" id="inicioM"/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label style="color:black;" for="finM" class="cols-sm-2 control-label">Fecha fin:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-calendar-o" aria-hidden="true"></i></span>
                                <input  required type="datetime-local" step="1"  min="<?php echo date('Y-m-d'); ?> ng-model="UIcontroller.JobDataModel.datetime" ng-model-options="{ getterSetter: true }" value="<?php echo date('YYYY:MM:DD HH:mm:ss')?>" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;"  required  class="form-control" name="finM" id="finM"  />
                            </div>
                        </div>
                    </div>

                    
                    <div class="form-group">
                        <label style="color:black;" for="cupoM" class="cols-sm-2 control-label">Cupo máximo:</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-sort-numeric-desc" aria-hidden="true"></i></span>
                                <input required  style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="number" class="form-control" name="cupoM" id="cupoM"  placeholder=""/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label style="color:black;" for="descripcionM" class="cols-sm-2 control-label">Descripción(Opcional):</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon iconbk"><i class="fa fa-leanpub" aria-hidden="true"></i></span>
                                <input   style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="descripcionM" id="descripcionM"  placeholder=""/>
                            </div>
                        </div>
                    </div>

                <div class="form-group ">
                    <button type="submit" class="btn btn-danger btn-lg btn-block login-button"">Modificar</button>
                </div>
            
                <div class="form-group ">
                    <button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:regresarM()">Regresar</button>
                </div>
            
            </form>
        </div>
    </div>
</div>
</div>



<div class="center">
    <a href="home.php"><span data-attr="Exit">Exit</span><span data-attr="Exit">Exit</span></a>
</div>

<legend id="head2" style="font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif; color: rgb(255, 255, 255); font-size: 40px;" class="text-center header">Tabla de datos de los eventos</legend>

<div class="consult">



    
    <label for="nombre" style="font-style:oblique; font-size: 20px; color: blueviolet;">Nombre</label>&nbsp;


    <input  type="text" name="nombreT" id="nombreT" style= "  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif; font-size: 13px; color: rgb(226, 52, 43);" placeholder="Nombre">&nbsp;
    
    <input style="display:none" required type="datetime-local" step="1"  min="<?php echo date('Y-m-d'); ?> ng-model="UIcontroller.JobDataModel.datetime" ng-model-options="{ getterSetter: true }" value="<?php echo date('YYYY:MM:DD HH:mm:ss')?>" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;"  required  class="form-control" name="fecha" id="fecha"  placeholder="Escribe la fecha de inicio"/>




    <select class="dropdown" name="" onchange="cambiar();" id="filtro2" style="text-align: center; " >
<option >Consultar por:</option>    

<option  value="Nombre"  >Nombre</option>    
<option value="Ponente">Ponente</option>
    <option value="Inicio">F.Inicio</option>
    <option value="Fin">F.Fin</option>
   

</select>&nbsp;&nbsp;
    
    <button  id="btnBuscar" onclick="buscar();">Consultar</button>&nbsp;&nbsp;

   <!-- onchange='filtrar();'-->

 
<select  class="dropdown" name="" onchange="javascript:filtrar();" id="filtro" style="text-align: center; " >
<option >Filtrar por:</option>    

<option  value="Eliminado"  >Eliminado</option>    
<option value="Activo">Activo</option>
    <option value="Pospuesto">Pospuesto</option>
    <option value="Cancelado">Cancelado</option>
    <option value="Terminado">Terminado</option>
    <option value="Todo">Todo</option>


</select>&nbsp;&nbsp;

<button  id="btnBuscar" onclick="filtrar();">Filtrar</button>&nbsp;&nbsp;


    <button  id="btnRegistrar" onclick="detallarR();">Nuevo registro</button>&nbsp;&nbsp;
    <button  id="btnTodo" onclick="cargarTabla();">Mostrar todo</button>&nbsp;&nbsp;


 
</div>
<div class="container2" >

    <br>
    <br>

<div id="contenedor"></div>

</div>


<div id="mg"></div>
</body>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script>
    
  var today = new Date().toISOString().slice(0, 16);

  


document.getElementsByName("inicio")[0].min = today;


document.getElementsByName("fin")[0].min = today;



document.getElementsByName("inicioM")[0].min = today;


document.getElementsByName("finM")[0].min = today;



</script>
</html>