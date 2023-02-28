<?php
// Initialize the session
session_start();
 
// Check if the user is logged in, if not then redirect him to login page
if(!isset($_SESSION["loggedin"]) || $_SESSION["loggedin"] !== true){
    header("location: Index.php");
    exit;
}



if(htmlspecialchars($_SESSION["username"])=='area.caja@cri.zitacuaro.mx'){


  echo '<script>
  alert("xd");
 
</script>';
}

?>



<!DOCTYPE html>
<html lang="es" dir="ltr">
  <head >
    <meta charset="UTF-8">
    <title>Home </title>
    <link rel="stylesheet" href="css/Home.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link href="images/fav.ico" rel="shortcut icon" type="images/x-icon" />
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

    </head>
<body>

<?php




if(htmlspecialchars($_SESSION["username"])=='area.recepcion@cri.zitacuaro.mx'){


  echo '<script>
  $(document).ready(function(){
    $("#area-social").remove();
    $("#area-directivo").remove();
    $("#area-doctor").remove();


}); 


</script>';

}


if(htmlspecialchars($_SESSION["username"])=='area.directivo@cri.zitacuaro.mx'){


  echo '<script>
  $(document).ready(function(){
    $("#area-recepcion").remove();
    $("#area-social").remove();
    $("#area-doctor").remove();


}); 






</script>';

}




if(htmlspecialchars($_SESSION["username"])=='area.trabajo.social@cri.zitacuaro.mx'){


  echo '<script>
  $(document).ready(function(){
    $("#area-recepcion").remove();
    $("#area-directivo").remove();
    $("#area-doctor").remove();


}); 


</script>';

}



if(htmlspecialchars($_SESSION["username"])=='area.directivo@cri.zitacuaro.mx'){


  echo '<script>
  $(document).ready(function(){
    $("#area-social").remove();
    $("#area-doctor").remove();
    $("#area-recepcion").remove();


}); 


</script>';

}


if(htmlspecialchars($_SESSION["username"])=='area.doctor@cri.zitacuaro.mx'){


  echo '<script>
  $(document).ready(function(){
    $("#area-social").remove();
    $("#area-directivo").remove();
    $("#area-recepcion").remove();


}); 


</script>';

}


?>


  <nav>
    <div class="navbar">
      <i class='bx bx-menu'></i>
      <div class="logo"><img src="images/header.png " style="height:60px; width:120px;"  class="logo-image"  alt=""></div>
      <div class="nav-links">
        <div class="sidebar-logo">
          <span class="logo-name"></span>
          <i class='bx bx-x' ></i>
        </div>
        <ul class="links">
          <li><a href="#">INICIO</a></li>
        

              
          <li id="area-social">
            <a href="#">Trabajo Social</a>
            <i class='bx bxs-chevron-down htmlcss-arrow arrow  '></i>
            <ul class="htmlCss-sub-menu sub-menu">
           
             
             
              <li class="more">
                <span><a href="#">Expediente</a>
                <i class='bx bxs-chevron-right arrow more-arrow'></i>
              </span>
                <ul class="more-sub-menu sub-menu">
                  <li><a href="#">Gestionar expediente</a></li>
               
                </ul>
              </li>



            <li class="more">
                <span><a href="#">Cita</a>
                <i class='bx bxs-chevron-right arrow more-arrow'></i>
              </span>
                <ul class="more-sub-menu sub-menu">
                  <li><a href="GestionarCita.php">Gestionar cita</a></li>
         
                </ul>
              </li>
            

              <li class="more">
                <span><a href="#">Reporte</a>
                <i class='bx bxs-chevron-right arrow more-arrow'></i>
              </span>
                <ul class="more-sub-menu sub-menu">
                  <li><a href="GestionarReporte.php">Gestionar reporte</a></li>
               
                </ul>
              </li>


              </ul>
          </li>         


          <li id="area-recepcion">
            <a href="#">Recepcion</a>
            <i class='bx bxs-chevron-down htmlcss-arrow arrow  '></i>
            <ul class="htmlCss-sub-menu sub-menu">
            
              <li class="more">
                <span><a href="#">Citas</a>
                <i class='bx bxs-chevron-right arrow more-arrow'></i>
              </span>
                <ul class="more-sub-menu sub-menu">
                  <li><a href="#">Gestionar citas</a></li>
                </ul>
              </li>
              
         
            
            <li class="more">
              <span><a href="#">Expediente</a>
              <i class='bx bxs-chevron-right arrow more-arrow'></i>
            </span>
              <ul class="more-sub-menu sub-menu">
                <li><a href="GestionarExpediente.php">Gestionar expediente abierto</a></li>
              </ul>
            </li>
          
          </ul>
          </li>
         



          <li id="area-doctor">
            <a href="#">Doctor especialista</a>
            <i class='bx bxs-chevron-down htmlcss-arrow arrow  '></i>
            <ul class="htmlCss-sub-menu sub-menu">
            
              <li class="more">
                <span><a href="#">Historial clínico</a>
                <i class='bx bxs-chevron-right arrow more-arrow'></i>
              </span>
                <ul class="more-sub-menu sub-menu">
                <li><a href="#">Crear historial clínico</a></li>
                  <li><a href="#">Consultar clínico</a></li>
                  <li><a href="#">Actualizar clínico</a></li>



                </ul>
              </li>
              
         
            
            <li class="more">
              <span><a href="#">Expediente</a>
              <i class='bx bxs-chevron-right arrow more-arrow'></i>
            </span>
              <ul class="more-sub-menu sub-menu">
                <li><a href="#">Consultar expediente</a></li>
              </ul>
            </li>
          



            <li class="more">
              <span><a href="#">Notas de valoración</a>
              <i class='bx bxs-chevron-right arrow more-arrow'></i>
            </span>
              <ul class="more-sub-menu sub-menu">
                <li><a href="#">Crear notas de valoración</a></li>
                <li><a href="#">Consultar notas de valoración</a></li>
                <li><a href="#">Actualizar notas de valoración</a></li>



              </ul>
            </li>
          



            <li class="more">
              <span><a href="#">Hoja de fisioterapia</a>
              <i class='bx bxs-chevron-right arrow more-arrow'></i>
            </span>
              <ul class="more-sub-menu sub-menu">
                <li><a href="#">Crear hoja de fisioterapia</a></li>
                <li><a href="#">Consultar hoja de fisioterapia</a></li>
                <li><a href="#">Actualizar hoja de fisioterapia</a></li>

              </ul>
            </li>
          

            <li class="more">
              <span><a href="#">Horario</a>
              <i class='bx bxs-chevron-right arrow more-arrow'></i>
            </span>
              <ul class="more-sub-menu sub-menu">
                <li><a href="#">Consultar horario</a></li>

              </ul>
            </li>
          


            </ul>
            </li>

            <li id='area-directivo'>
            <a href="#">Directivo</a>
            <i class='bx bxs-chevron-down htmlcss-arrow arrow  '></i>
            <ul class="htmlCss-sub-menu sub-menu">
            
              <li class="more">
                <span><a href="#">Descuento</a>
                <i class='bx bxs-chevron-right arrow more-arrow'></i>
              </span>
                <ul class="more-sub-menu sub-menu">
                <li><a href="GestionarDescuento.php">Gestionar descuento</a></li>
                 

                </ul>
              </li>
              
         
            
            <li class="more">
              <span><a href="#">Reporte</a>
              <i class='bx bxs-chevron-right arrow more-arrow'></i>
            </span>
              <ul class="more-sub-menu sub-menu">
                <li><a href="GestionarReporte.php">Gestionar reporte</a></li>
              </ul>
            </li>
          
          </ul>
          </li>
         

            

        
          </li>







          <li><a   class="close" <?php echo htmlspecialchars($_SESSION["username"]); ?> href="Logout.php">CERRAR SESIÓN</a></li>

        </ul>
      </div>
      <div class="search-box">
        <i class='bx bx-search'></i>
        <div class="input-box">
          <input type="text" placeholder="Search...">
        </div>
      </div>
    </div>
  </nav>
  <div class="space">

  <div class="image-style">
  <div id="demotext" style="font-family: cursive; font-size:20px; font-weight: bold; color:#031424;">Bienvenido, <b style="font-weight: bold; color:#031424"><?php echo htmlspecialchars($_SESSION["username"]); ?></b></div>

</div>
  </div>
 

  <script src="js/Home.js"></script>


</body>



</html>
