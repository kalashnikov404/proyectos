
<?php
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
    <title>Usuarios</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/all.css">
    <link rel="stylesheet" type="text/css" href="css/estilos2.css">



    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

 <!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
 <!-- Font Awesome CSS -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

 <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
 <link href='https://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext' rel='stylesheet' type='text/css'> 

 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>  
    
    <script src="funciones_formularioA.js"></script>
<script type="text/javascript">

$(document).ready(function(){
$(".containerMA").css({display: 'none'});

$(".containerRA").css({display: 'none'});
$(".containerDA").css({display: 'none'});

$(".container2").css({display: 'block'});

});

</script>




 <!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
 <!-- Font Awesome CSS -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

 <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
 <link href='https://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext' rel='stylesheet' type='text/css'> 

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

</style>
    


</head>
<body>

    

<!--form de estudiante-->


<div class="containerRA" >
    <div class="row main">
        <div class="panel-heading">
           <div class="panel-title text-center">
                   <h1 style="color:#1404f4; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;"  class="title">Registro de Aspirantes</h1>
                   <hr />

               </div>
        </div> 
        <div class="main-loginRA main-center">
            <form class="form-horizontal" autocomplete="off"  id="frm1" method="POST" action="javascript:registrar();" accept-charset="utf-8">
                



            <div class="form-group">
                    <label style="color:black;" for="clave" class="cols-sm-2 control-label">Clave(Opcional):</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-id-card" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="claveR" id="claveR"  placeholder="Escribe la clave"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label style="color:black;" for="nombre" class="cols-sm-2 control-label">Nombre:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user" aria-hidden="true"></i></span>
                            <input  required style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="nombreR" id="nombreR"  placeholder="Escribe el nombre"/>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label style="color:black;" for="paterno" class="cols-sm-2 control-label">Apellido Paterno:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-male" aria-hidden="true"></i></span>
                            <input required style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="paternoR" id="paternoR"  placeholder="Escribe el 1er apellido"/>
                        </div>
                    </div>
                </div>


                
                <div class="form-group">
                    <label style="color:black;" for="materno" class="cols-sm-2 control-label">Apellido Materno:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-female" aria-hidden="true"></i></span>
                            <input required style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="maternoR" id="maternoR"  placeholder="Escribe el 2do apellido"/>
                        </div>
                    </div>
                </div>



                
                <div class="form-group">
                    <label style="color:black;" for="telefono" class="cols-sm-2 control-label">Edad:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-birthday-cake" aria-hidden="true"></i></span>
                            <input required style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="edadR" id="edadR"  placeholder="Escribe la edad"/>
                        </div>
                    </div>
                </div>
                

                   
                <div class="form-group">
                    <label style="color:black;" for="telefono" class="cols-sm-2 control-label">Sexo:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-mars" aria-hidden="true"></i></span>

                            <select required name="sexoR" id="sexoR">
    <option value="M">Masculino</option>
    <option value="F">Femenino</option>

</select>
                        </div>
                    </div>
                </div>
                

                  
                <div class="form-group">
                    <label style="color:black;" for="correo" class="cols-sm-2 control-label">Correo(Opcional):</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-envelope" aria-hidden="true"></i></span>
                            <input  style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="email" class="form-control" name="correoR" id="correoR"  placeholder="Escribe el sexo"/>
                        </div>
                    </div>
                </div>
                

                <div class="form-group ">
                    <button type="submit" class="btn btn-danger btn-lg btn-block login-button" >Registrar Aspirante</button>
                </div>

                <div class="form-group ">
                    <button type="button" class="btn btn-danger btn-lg btn-block login-button" onclick="javascript:regresarR()">Regresar</button>
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
        <form class="form-horizontal" id="frm2" method="post" >
            

            <div class="form-group">
                <label style="color:black;" for="nombre" class="cols-sm-2 control-label">Id:</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon iconbk"><i class="fa fa-key" aria-hidden="true"></i></span>
                        <input disabled type="text" class="form-control" style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;"  disabled name="idD" id="idD" disabled; placeholder=""/>
                    </div>
                </div>
            </div>
           

            <div class="form-group">
                    <label style="color:black;" for="clave" class="cols-sm-2 control-label">Clave(Opcional):</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-id-card" aria-hidden="true"></i></span>
                            <input disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="claveD" id="claveD"  placeholder=""/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label style="color:black;" for="nombre" class="cols-sm-2 control-label">Nombre:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user" aria-hidden="true"></i></span>
                            <input disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="nombreD" id="nombreD"  placeholder=""/>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label style="color:black;" for="paterno" class="cols-sm-2 control-label">Apellido Paterno:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-male" aria-hidden="true"></i></span>
                            <input disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="paternoD" id="paternoD"  placeholder=""/>
                        </div>
                    </div>
                </div>


                
                <div class="form-group">
                    <label style="color:black;" for="materno" class="cols-sm-2 control-label">Apellido Materno:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-female" aria-hidden="true"></i></span>
                            <input disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="maternoD" id="maternoD"  placeholder=""/>
                        </div>
                    </div>
                </div>



                
                <div class="form-group">
                    <label style="color:black;" for="telefono" class="cols-sm-2 control-label">Edad:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-birthday-cake" aria-hidden="true"></i></span>
                            <input disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="edadD" id="edadD"  placeholder=""/>
                        </div>
                    </div>
                </div>
                

                   
                <div class="form-group">
                    <label style="color:black;" for="telefono" class="cols-sm-2 control-label">Sexo:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-mars" aria-hidden="true"></i></span>

                            <select disabled name="sexoD" id="sexoD">
    <option value="M">Masculino</option>
    <option value="F">Femenino</option>

</select>
                        </div>
                    </div>
                </div>
                

                  
                <div class="form-group">
                    <label style="color:black;" for="correo" class="cols-sm-2 control-label">Correo:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-envelope" aria-hidden="true"></i></span>
                            <input disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="email" class="form-control" name="correoD" id="correoD"  placeholder=""/>
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


<div class="containerMA">
<div class="row main">
<div class="panel-heading">
   <div class="panel-title text-center">
           <h1  style="color:#e0211a; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;" class="title">Modificacion de Aspirantes</h1>
           <hr />
       </div>
</div> 
<div class="main-loginMA main-center">
    <form class="form-horizontal" id="frm3"  action="javascript:modificar();" method="post" >
        


        <div class="form-group">
            <label style="color:black;" for="nombre" class="cols-sm-2 control-label">Id:</label>
            <div class="cols-sm-10">
                <div class="input-group">
                    <span class="input-group-addon iconbk"><i class="fa fa-key" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" disabled style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #0f07ee; font-size: 18px;" name="idM" id="idM"  placeholder="Escribe el nombre"/>
                </div>
            </div>
        </div>


        <div class="form-group">
                    <label style="color:black;" for="clave" class="cols-sm-2 control-label">Clave(Opcional):</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-key" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="claveM" id="claveM"  placeholder="Escribe la clave"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label style="color:black;" for="nombre" class="cols-sm-2 control-label">Nombre:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-user" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="nombreM" id="nombreM"  placeholder="Escribe el nombre"/>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label style="color:black;" for="paterno" class="cols-sm-2 control-label">Apellido Paterno:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-male" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="paternoM" id="paternoM"  placeholder="Escribe el 1er apellido"/>
                        </div>
                    </div>
                </div>


                
                <div class="form-group">
                    <label style="color:black;" for="materno" class="cols-sm-2 control-label">Apellido Materno:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-female" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="maternoM" id="maternoM"  placeholder="Escribe el 2do apellido"/>
                        </div>
                    </div>
                </div>



                
                <div class="form-group">
                    <label style="color:black;" for="telefono" class="cols-sm-2 control-label">Edad:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-birthday-cake" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="text" class="form-control" name="edadM" id="edadM"  placeholder="Escribe la edad"/>
                        </div>
                    </div>
                </div>
                

                   
                <div class="form-group">
                    <label style="color:black;" for="sexo" class="cols-sm-2 control-label">Sexo:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-mars" aria-hidden="true"></i></span>

<select name="sexoM" id="sexoM">
    <option value="M">Masculino</option>
    <option value="F">Femenino</option>

</select>
                        </div>
                    </div>
                </div>
                

                  
                <div class="form-group">
                    <label style="color:black;" for="correo" class="cols-sm-2 control-label">Correo:</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon iconbk"><i class="fa fa-envelope" aria-hidden="true"></i></span>
                            <input style="font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; color: #e0211a; font-size: 18px;" type="email" class="form-control" name="correoM" id="correoM"  placeholder="Escribe el correo"/>
                        </div>
                    </div>
                </div>
                

        <div class="form-group ">
            <button class="btn btn-danger btn-lg btn-block login-button" type="submit"">Modificar</button>
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

<legend id="head2" style="font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif; color: rgb(255, 255, 255); font-size: 40px;" class="text-center header">Tabla de datos de los usuarios</legend>

<div class="consult">



    
    <label for="nombre" style="font-style:oblique; font-size: 20px; color: blueviolet;">Nombre</label>&nbsp;


    <input  type="text" name="nombreT" id="nombreT" style= "  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif; font-size: 13px; color: rgb(226, 52, 43);" placeholder="Nombre">&nbsp;

    <button  id="btnBuscar" onclick="consultar();">Buscar</button>&nbsp;
 


 
</div>
<div class="container2" >

    <br>
    <br>

<div id="contenedor"></div>

</div>


<div id="mg"></div>
</body>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</html>