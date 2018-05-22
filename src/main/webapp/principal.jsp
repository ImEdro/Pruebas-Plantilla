<%-- 
    Document   : principal
    Created on : 9/04/2018, 12:45:59 AM
    Author     : william
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/css/now-ui-dashboard.css" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="assets/demo/demo.css" rel="stylesheet" />
        <link rel="apple-touch-icon" sizes="76x76" href="./img/apple-icon.png">
        <link rel="icon" type="image/png" href="./img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Principal</title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
        <!-- CSS Files -->
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/now-ui-kit.css" rel="stylesheet" />
        <link href="css/bootstrap.min_1.css" rel="stylesheet" />
        <link href="css/now-ui-kit_1.css" rel="stylesheet" />
        <link href="css/chats.css" rel="stylesheet" />
        <!-- Canonical SEO -->
        <link rel="canonical" href="https://www.creative-tim.com/product/now-ui-kit" />
        <!--  Social tags      -->
        <meta name="keywords" content="bootstrap 4, bootstrap 4 uit kit, bootstrap 4 kit, now ui, now ui kit, creative tim, html kit, html css template, web template, bootstrap, bootstrap 4, css3 template, frontend, responsive bootstrap template, bootstrap ui kit, responsive ui kit">
        <meta name="description" content="Start your development with a beautiful Bootstrap 4 UI kit. It is yours Free.">
        <!-- Schema.org markup for Google+ -->
        <meta itemprop="name" content="Now UI Kit by Creative Tim">
        <meta itemprop="description" content="Start your development with a beautiful Bootstrap 4 UI kit. It is yours Free.">
        <meta itemprop="image" content="http://s3.amazonaws.com/creativetim_bucket/products/56/original/opt_nuk_thumbnail.jpg">
        <!-- Open Graph data -->
        <meta property="fb:app_id" content="655968634437471">
        <meta property="og:title" content="Now UI Kit by Creative Tim" />
        <meta property="og:type" content="article" />
        <meta property="og:url" content="http://demos.creative-tim.com/now-ui-kit/index.html" />
        <meta property="og:image" content="http://s3.amazonaws.com/creativetim_bucket/products/56/original/opt_nuk_thumbnail.jpg" />
        <meta property="og:description" content="Start your development with a beautiful Bootstrap 4 UI kit. It is yours Free." />
        <meta property="og:site_name" content="Creative Tim" />
    </head>
    <body class="index-page sidebar-collapse">

        <%  if (session.getAttribute("sessionNombre") == null) {
                response.sendRedirect("index.jsp");
            }%>            
        <div class="sidebar" data-color="orange">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
            -->

            <div class="sidebar-wrapper">
                <ul class="nav">
                    <li>
                        <br>
                        <br>
                    </li>
                    <li> 
                        <a onclick=" AgregarAmigo($('#buscaru').val())">
                            <input id="buscaru" name="search" type="text" class="form-control" placeholder="ID Usuario a agregar">
                            <i class="now-ui-icons users_single-02"></i>
                            <p>Agregar</p>
                        </a>
                    </li>
                    <div id="misamigos">
                        <li>
                            <a href="">
                                <i class="now-ui-icons users_single-02"></i>
                                <p>Amigos</p>
                            </a>
                        </li>
                    </div>


                    <li>
                        <a>
                            <i class="now-ui-icons tech_controller-modern"></i>
                            <p>Mis juegos</p>
                            <input id="buscaru" name="search" type="text" class="form-control" placeholder="Nombre del juego">
                        </a>
                    </li>

                    <div id="misjuegos">
                        <li>
                            <a href="">
                                <i class="now-ui-icons users_single-02"></i>
                                <p>Amigos</p>
                            </a>
                        </li>
                    </div>

                </ul>
            </div>
        </div>
        <!-- Navbar -->
        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent " color-on-scroll="400">

                <div class="navbar-translate">
                    <a class="navbar-brand" href="#" rel="tooltip" title="Home" data-placement="bottom" onclick="inicio()">
                        XGames
                    </a>
                </div>
                <div class="collapse navbar-collapse justify-content-end" data-nav-image="./assets/img/blurred-image-1.jpg">
                    <form>
                        <div class="input-group no-border">
                            <input type="text" value="" class="form-control" placeholder="Search..." id="buscarUsuario" >
                            <span class="input-group-addon" onclick="buscarperfil($('#buscarUsuario').val())">
                                <i class="now-ui-icons ui-1_zoom-bold"></i>
                            </span>
                        </div>
                    </form> 
                    <ul class="navbar-nav">  
                        <il class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="badge badge-pill bg-inverse"><label class="my-1" name="numNotificaciones" id="numNotifiacion">5</label></span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" id="notifiacion">
                                <a class="dropdown-item" href="#">
                                    <p>Item noticia</p>
                                </a>
                                <hr>
                                <a class="dropdown-item" href="#">
                                    <p>#fulanito quiere ser tu amigo</p>
                                    <form>
                                        <button class="btn btn-outline-success my-2 my-sm-0">Aceptar</button>
                                        <button class="btn btn-outline-danger my-2 my-sm-0">Ignorar</button>
                                    </form>
                                </a>
                            </div>
                        </il>

                        <li class="nav-item">
                            <a class="nav-link" rel="tooltip" title="Profile" data-placement="bottom" onclick="actualizarPerfil()">
                                <i class="now-ui-icons users_single-02"></i>
                                <p class="d-lg-none d-xl-none">Profile</p>
                            </a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="now-ui-icons location_world"></i>

                            </a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" id="nickname">nickname</a>
                                <a class="dropdown-item" onclick="cerrarsesion()"> <i class="now-ui-icons media-1_button-power"></i>Cerrar Sesión</a>

                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            <!-- End Navbar -->


            <!-- contenido  -->

            <div class="panel-header panel-header-sm">
            </div>
            <!-- SlideGames
            <div style.display="none">
                            <div class="slider" id="slider">
                              <div class="slide" id="slide-left">
                                <div class="slide-holder">
                                  <div class="slide-bg bg-previous"></div>
                                  <div class="slide-bg bg-current"></div>
                                  <div class="slide-bg bg-next"></div>
                                </div>
                              </div>
                              <div class="slide" id="slide-center">
                                <div class="slide-holder">
                                  <div class="slide-bg bg-previous"></div>
                                  <div class="slide-bg bg-current"></div>
                                  <div class="slide-bg bg-next"></div>
                                </div>
                              </div>
                              <div class="slide" id="slide-right">
                                <div class="slide-holder">
                                  <div class="slide-bg bg-previous"></div>
                                  <div class="slide-bg bg-current"></div>
                                  <div class="slide-bg bg-next"></div>
                                </div>
                              </div>
                            </div>
                            <div class="row">
                                <button class="btn btn-primary btn-block" id="left-arrow">prev</button>
                            <button class="btn btn-primary btn-block" id="right-arrow">next</button>
                            </div>
            
            
                        </div>
            -->
            <!-- SlideGames-->
            <div class="wrapper" >


                <div class="container">
                    <br>
                    <br>
                    <!-- noticias  -->
                    <div class="row" id="noticias">

                    </div>
                    <!-- top  -->
                    <div id="vtop10">
                        <div class="row"  >
                            <div class="col-md-6" >
                                <div class="card" >
                                    <div class="card-header">
                                        <h5 class="card-category">Top 10</h5>
                                        <h4 class="card-title"> Top</h4>
                                    </div>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead class=" text-primary">
                                                <th >
                                                    Nombre
                                                </th>
                                                <th  class="text-right" >
                                                    Calificacion
                                                </th>
                                                </thead>
                                                <tbody id="top">


                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- recomendaciones  -->
                            <div class="col-md-6" id="vrecomendacionesj">
                                <div class="card card-tasks" >
                                    <div class="card-header">
                                        <h5 class="card-category">Tus nuevas recomendaciones</h5>
                                        <h4 class="card-title"style="color:#000000" >Recomendaciones Juegos</h4>
                                    </div>
                                    <div class="card-body">
                                        <div class="table-full-width table-responsive">
                                            <table class="table">
                                                <tbody id="recomendacionesj">


                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="card-footer">
                                        <hr>
                                        <div class="stats"style="color:#000000">
                                            <i class="now-ui-icons loader_refresh spin" style="color:#000000"></i> Updated 3 minutes ago
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- infojuego  -->
                    <div id="infojuego">
                        <h5 class="card-category" id="IdJuego"></h5>
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="card card-chart">
                                    <div class="card-header">
                                        <h5 class="card-category" > imagen </h5>
                                        <h4 class="card-title" id="NombreJuego">Rocket league</h4>
                                        <div class="dropdown">
                                            <button type="button" class="btn btn-round btn-default dropdown-toggle btn-simple btn-icon no-caret" data-toggle="dropdown">
                                                <i class="now-ui-icons loader_gear"></i>
                                            </button>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a class="dropdown-item" href="#">Action</a>
                                                <a class="dropdown-item" href="#">Another action</a>
                                                <a class="dropdown-item" href="#">Something else here</a>
                                                <a class="dropdown-item text-danger" href="#">Remove Data</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <div class="chart-area">
                                            <center>
                                                <img align="center" src=" " id="ImagenJuego" width="350" height="250" >
                                            </center>
                                        </div>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="now-ui-icons arrows-1_refresh-69"></i> Just Updated
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="card card-chart">
                                    <div class="card-header">
                                        <h5 class="card-category">Juego</h5>
                                        <h4 class="card-title">Informacion adicional</h4>
                                        <div class="dropdown">
                                            <button type="button" class="btn btn-round btn-default dropdown-toggle btn-simple btn-icon no-caret" data-toggle="dropdown">
                                                <i class="now-ui-icons loader_gear"></i>
                                            </button>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a class="dropdown-item" href="#">Action</a>
                                                <a class="dropdown-item" href="#">Another action</a>
                                                <a class="dropdown-item" href="#">Something else here</a>
                                                <a class="dropdown-item text-danger" href="#">Remove Data</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <p align="justify" style="color:#000000"><span id="DesarrolladorJuego"> Desarrollador : Psyonix </span></p>
                                        <p align="justify" style="color:#000000"><span id="FechaJuego"> Fecha lanzamiento : 2015 </span></p>
                                        <p align="justify" style="color:#000000"><span id="PlataformaJuego"> Plataforma : PS4,XBOX,PC </span></p>
                                        <p align="justify" style="color:#000000"><span id="GeneroJuego"> Genero: Deportes </span></p>
                                        <p align="justify" style="color:#000000"><span id="IdiomasJuego"> Idiomas:Español,Ingles </span></p>

                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="now-ui-icons arrows-1_refresh-69"></i> Just Updated
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="card card-chart">
                                    <div class="card-header">
                                        <h5 class="card-category">Juego</h5>

                                        <h5 id="promedio"></h5>
                                    </div>
                                    <div class="card-body">

                                        <div class="form-group" id="calificaciones">
                                            <h5 id ="numeroCal">0</h5>
                                            <p class="clasificacion">
                                                <input id="radio1" type="radio" name="estrellas" value="5" onclick="ValorCal(1)">
                                                <label for="radio1">★</label>
                                                <input id="radio2" type="radio" name="estrellas" value="4" onclick="ValorCal(2)">
                                                <label for="radio2">★</label>
                                                <input id="radio3" type="radio" name="estrellas" value="3" onclick="ValorCal(3)">
                                                <label for="radio3">★</label>
                                                <input id="radio4" type="radio" name="estrellas" value="2" onclick="ValorCal(4)">
                                                <label for="radio4">★</label>
                                                <input id="radio5" type="radio" name="estrellas" value="1" onclick="ValorCal(5)">
                                                <label for="radio5">★</label>
                                            </p>
                                            <button class="btn btn-primary btn-round" type="button" onclick="CalificacionK()">Califica</button>
                                        </div>
                                        <br>


                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="now-ui-icons ui-2_time-alarm"></i> Last 7 days
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" >

                            <div class="col-lg-4 col-md-6">
                                <div class="card card-chart">
                                    <div class="card-header">
                                        <h5 class="card-category">Juego</h5>
                                        <h4 class="card-title">Descripcion</h4>
                                    </div>
                                    <div class="card-body">
                                        <p align="justify" style="color:#000000"><span  id="DescripcionJuego"> </span></p>
                                    </div>
                                    <div class="card-footer">
                                        <div class="stats">
                                            <i class="now-ui-icons ui-2_time-alarm"></i> Last 7 days
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- comentarios juegos -->
                        <div class="row">

                            <div class="col-md-6">
                                <div class="card">
                                    <div class="card-header">
                                        <h5 class="card-category">Comentarios</h5>
                                        <h4 class="card-title"> Comentarios</h4>
                                    </div>
                                    <div class="card-body">
                                        <div class="table-full-width table-responsive">
                                            <table class="table">
                                                <tbody id="Coment">
                                                    <tr>
                                                        <td class="text-left">Willy</td>
                                                        <td class="text-left">muy buen juego esta bien hecho</td>
                                                        <td class="td-actions text-right">
                                                            <button type="button" rel="tooltip" title="" class="btn btn-info btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Edit Task">
                                                                <i class="now-ui-icons ui-2_like"></i>
                                                            </button>
                                                            <br>
                                                            <button type="button" rel="tooltip" title="" class="btn btn-danger btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Remove">
                                                                <i class="now-ui-icons ui-1_simple-remove"></i>
                                                            </button>
                                                        </td>
                                                        <td>
                                                            <br>
                                                            <h5 class="card-category">2</h5>
                                                            <h5 class="card-category">3</h5>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <h5 class="card-category" id="nicknamecomentario">Comentarios</h5>
                                        <textarea rows="4" cols="80" class="form-control" placeholder="Ingresa tu comentario." id="textComentario"> </textarea>
                                        <button class="btn btn-primary btn-round" type="button" onclick="addComentarios($('#IdJuego').val(), $('#textComentario').val())" >Publicar</button>
                                    </div>
                                </div>
                            </div>
                            <!-- recomendaciones  -->
                            <div class="col-md-6">
                                <div class="card card-tasks">
                                    <div class="card-header">
                                        <h5 class="card-category">Recomendaciones</h5>
                                        <h4 class="card-title">Recomendaciones Usuarios</h4>
                                    </div>
                                    <div class="card-body">
                                        <div class="table-full-width table-responsive">
                                            <table class="table">
                                                <tbody id="recomendacionesu">

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="card-footer">
                                        <hr>
                                        <div class="stats">
                                            <i class="now-ui-icons loader_refresh spin"></i> Updated 3 minutes ago
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- informacion perfil   -->
                    <div id="InfoPerfil">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="card">
                                    <div class="card-header">
                                        <h5 class="title">User Profile</h5>
                                    </div>
                                    <div class="card-body">
                                        <form>
                                            <div class="row">
                                                <div class="col-md-5 pr-1">
                                                    <div class="form-group">
                                                        <label>Nickname</label>
                                                        <input type="text" class="form-control" disabled="" placeholder="Company" id="Nicknamepr" value="Creative Code Inc.">
                                                    </div>
                                                </div>
                                                <div class="col-md-3 px-1">
                                                    <div class="form-group">
                                                        <label>Nombre</label>
                                                        <input type="text" class="form-control" placeholder="Username" id="Nombrepr" value="michael23">
                                                    </div>
                                                </div>
                                                <div class="col-md-4 pl-1">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Correo</label>
                                                        <input type="email" class="form-control" placeholder="Email" id="Correopr">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6 pr-1">
                                                    <div class="form-group">
                                                        <label>Pais</label>
                                                        <input type="text" class="form-control" placeholder="Company" id="Paispr" value="Mike">
                                                    </div>
                                                </div>
                                                <div class="col-md-6 pl-1">
                                                    <div class="form-group">
                                                        <label>Fecha de nacimiento</label>
                                                        <input type="text" class="form-control" placeholder="Last Name" id="Fechapr" value="Andrew">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Generos que juego</label>
                                                        <input type="text" class="form-control" placeholder="Home Address" id="Generospr" value="Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4 pr-1">
                                                    <div class="form-group">
                                                        <label>Horas promedio que juego</label>
                                                        <input type="text" class="form-control" placeholder="City" id="Horaspr" value="Mike">
                                                    </div>
                                                </div>
                                                <div class="col-md-4 px-1">
                                                    <div class="form-group">
                                                        <label>Dias que juego</label>
                                                        <input type="text" class="form-control" placeholder="Country" id="Diaspr" value="Andrew">
                                                    </div>
                                                </div>
                                                <div class="col-md-4 pl-1">
                                                    <div class="form-group">
                                                        <label>Idioma que hablo</label>
                                                        <input type="text" class="form-control" placeholder="ZIP Code" id="Idiomapr">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Acerca de Mi</label>
                                                        <textarea rows="4" cols="80" class="form-control" placeholder="Here can be your description" id="Acercapr" value="Mike">Lamborghini Mercy, Your chick she so thirsty, I'm in that two seat Lambo.</textarea>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                        <hr>
                                        <div class="button-container">
                                            <button class="btn btn-primary btn-round" type="button" onclick="GuardarCambiosPerfil()">Guardar Cambios</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card card-user">
                                    <div class="image">
                                        <img src="./img//bg5.jpg" alt="...">
                                    </div>
                                    <div class="card-body">
                                        <div class="author">
                                            <a href="#">
                                                <img class="avatar border-gray" src="assets/img//s.jpg" alt="...">
                                                <h5 class="title" id="nickc">Mike Andrew</h5>
                                            </a>
                                            <p class="description" id="nombrec">
                                                michael24
                                            </p>
                                        </div>
                                        <p class="description text-center" id="generosc">
                                            "Lamborghini Mercy
                                            <br> Your chick she so thirsty
                                            <br> I'm in that two seat Lambo"
                                        </p>
                                        <p class="description text-center" id="descripcionc">
                                            "Lamborghini Mercy
                                            <br> Your chick she so thirsty
                                            <br> I'm in that two seat Lambo"
                                        </p>
                                    </div>

                                </div>
                            </div>
                        </div> 
                    </div>

                    <!-- informacion perfil buscado  -->

                    <div id="InfoPerfilBuscar">
                        <div class="col-md-12">
                            <div class="card card-user">
                                <div class="image">
                                    <img src="./img//bg5.jpg" alt="...">
                                </div>
                                <div class="card-body">
                                    <div class="author">
                                        <a href="#">
                                            <img class="avatar border-gray" src="assets/img//s.jpg" alt="...">
                                            <h5 class="title" id="nickpu">Mike Andrew</h5>
                                        </a>
                                        <p class="description" id="nombrepu">
                                            michael24
                                        </p>
                                    </div>
                                    <p class="description text-center" style="color:#000000" id="generospu">
                                        Mensaje Prueba
                                    </p>
                                    <p class="description text-center" style="color:#000000" id="descripcionpu">
                                        "Lamborghini Mercy
                                        <br> Your chick she so thirsty
                                        <br> I'm in that two seat Lambo"
                                    </p>
                                </div>
                                <hr>
                                <div class="button-container" >
                                    <button class="btn btn-primary btn-round" type="button" onclick=" AgregarAmigo($('#nickpu').val())">Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="section" id="carousel">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-md-12">
                                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                                    <ol class="carousel-indicators">
                                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                                    </ol>

                                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                        <i class="now-ui-icons arrows-1_minimal-left"></i>
                                    </a>
                                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                        <i class="now-ui-icons arrows-1_minimal-right"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="popup-box chat-popup" id="qnimate">
                <div class="popup-head">
                    <div class="popup-head-left pull-left" id="namechat"><img src="http://bootsnipp.com/img/avatars/bcf1c0d13e5500875fdd5a7e8ad9752ee16e7462.jpg" alt="iamgurdeeposahan"> Gurdeep Osahan</div>
                    <div class="popup-head-right pull-right">
                        <div class="btn-group">
                            <button class="bg_none pull-right" data-toggle="dropdown" type="button" aria-expanded="false">
                                <i class="now-ui-icons ui-1_settings-gear-63"></i> </button>
                            <ul role="menu" class="dropdown-menu pull-right">
                                <li><a href="#">Media</a></li>
                                <li><a href="#">Block</a></li>
                                <li><a href="#">Clear Chat</a></li>
                            </ul>
                        </div>
                        <button class="bg_none pull-right" id="removeClass" onclick="closechat()"><i class="now-ui-icons ui-1_simple-remove"></i> </button>
                    </div>
                </div>
                <div class="popup-messages">
                    <div class="direct-chat-messages" >
                        <div id="log">
                            <div class="chat-box-single-line">
                                <abbr class="timestamp">October 8th, 2015</abbr>
                            </div>
                            <!-- Message. Default to the left -->
                            <div class="direct-chat-msg doted-border" id="contentchat">
                                <div class="direct-chat-info clearfix">
                                    <span class="direct-chat-img-reply-small pull-left">
                                        <img alt="message user image" src="http://bootsnipp.com/img/avatars/bcf1c0d13e5500875fdd5a7e8ad9752ee16e7462.jpg" class="direct-chat-img2">
                                    </span>
                                    <span class="direct-chat-name pull-left" id="chatNomUsuario1">Usuario 1</span>
                                </div>
                                <div class="direct-chat-text ">
                                    <a id="chatusuario1"> Hey bro, how’s everything going ?</a>
                                </div>
                                <div class="direct-chat-info clearfix">
                                    <span class="direct-chat-timestamp pull-right">3.36 PM</span>
                                </div>
                                <div class="direct-chat-info clearfix">
                                    <span class="direct-chat-img-reply-small pull-right">
                                        <img alt="message user image" src="http://bootsnipp.com/img/avatars/bcf1c0d13e5500875fdd5a7e8ad9752ee16e7462.jpg" class="direct-chat-img2">

                                    </span>
                                    <span class="direct-chat-name pull-right" id="chatNomUsuario2">Usuario 2</span>
                                </div>

                                <div class="direct-chat-text">
                                    <a id="chatusuario2"> Hey bro, how’s everything going ?</a>
                                </div>
                                <div class="direct-chat-info clearfix">
                                    <span class="direct-chat-timestamp pull-right">3.36 PM</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="popup-messages-footer">
                    <input class="form-controll now-ui-icons" placeholder="Mensaje" id="msg">
                    <button class="bg_none pull-right"><i class="now-ui-icons ui-1_check" onclick="send()"></i> </button>

                </div>
            </div>

            <!--<div class="main">

                <div class="section section-basic">
                    <div class="container">

                        
                    </div>
                </div>
            </div>
        </div>

    </div> -->


    </body>
    <!--   Core JS Files   -->


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="js/core/popper.min.js" type="text/javascript"></script>
    <script src="js/core/bootstrap.min.js" type="text/javascript"></script>
    <!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
    <script src="js/plugins/bootstrap-switch.js"></script>
    <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
    <script src="js/plugins/nouislider.min.js" type="text/javascript"></script>
    <!--  Plugin for the DatePicker, full documentation here: https://github.com/uxsolutions/bootstrap-datepicker -->
    <script src="js/plugins/bootstrap-datepicker.js" type="text/javascript"></script>
    <!-- Share Library etc -->
    <script src="js/plugins/jquery.sharrre.js" type="text/javascript"></script>
    <!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
    <script src="js/now-ui-kit.js" type="text/javascript"></script>
    <script type='text/javascript' src="js/noticias.js" ></script>
    <script type='text/javascript' src="js/lista.js" ></script>
    <script type='text/javascript' src="js/recomendaciones.js" ></script>
    <script src="js/InfoJuego.js"></script>
    <script src="js/InfoUsuario.js" ></script>
    <script src="js/chats.js"></script>
    <script src="js/perfilpr.js"></script>
    <script src="js/perfilpu.js"></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/velocity/1.2.3/velocity.min.js'></script>
    <script src="js/SlideGames.js"></script>

    <script type="text/javascript">
                        $(document).ready(function () {
                            // the body of this function is in js/now-ui-kit.js
                            nowuiKit.initSliders();
                        });
                        function scrollToDownload() {
                            if ($('.section-download').length != 0) {
                                $("html, body").animate({
                                    scrollTop: $('.section-download').offset().top
                                }, 1000);
                            }
                        }
    </script>
</html>
