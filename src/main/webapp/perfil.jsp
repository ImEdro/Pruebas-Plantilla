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
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="./assets/css/now-ui-dashboard.css" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="./assets/demo/demo.css" rel="stylesheet" />
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
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="css/demo.css" rel="stylesheet" />
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
                <div class="container-fluid">
                    <div class="navbar-translate">
                        <a class="navbar-brand" href="principal.jsp" rel="tooltip" title="Home" data-placement="bottom" >
                            XGames
                        </a>
                    </div>
                    <div class="collapse navbar-collapse justify-content-end" data-nav-image="./assets/img/blurred-image-1.jpg">
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
                                <a class="nav-link" rel="tooltip" title="Profile" data-placement="bottom" href="perfil.jsp">
                                    <i class="now-ui-icons users_single-02"></i>
                                    <p class="d-lg-none d-xl-none">Profile</p>
                                </a>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="now-ui-icons location_world"></i>
                                    <p>
                                        <span class="d-lg-none d-md-block" id="nickname">nickname</span>
                                    </p>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="#">Configuración</a>
                                    <a class="dropdown-item" onclick="cerrarsesion()"> <i class="now-ui-icons media-1_button-power"></i>Cerrar Sesión</a>

                                </div>
                            </li>
                        </ul>
                    </div>
            </nav>
            <!-- End Navbar -->
            <div class="panel-header panel-header-sm">
            </div>
            <div class="content">
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
                                                <label>Idiomas que hablo</label>
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
                                    <button class="btn btn-primary btn-round" type="button">Guardar Cambios</button>
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
                                    <p class="description" id="nombrec" >
                                        michael24
                                    </p>
                                </div>
                                <p class="description text-center" id="generosc" >
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
            <div class="col-md-12">
                <div class="card card-user">
                    <div class="image">
                        <img src="./img//bg5.jpg" alt="...">
                    </div>
                    <div class="card-body">
                        <div class="author">
                            <a href="#">
                                <img class="avatar border-gray" src="assets/img//s.jpg" alt="...">
                                <h5 class="title">Mike Andrew</h5>
                            </a>
                            <p class="description">
                                michael24
                            </p>
                        </div>
                        <p class="description text-center">
                            Mensaje Prueba
                        </p>
                    </div>
                    <hr>
                    <div class="button-container">
                        <button class="btn btn-primary btn-round" type="button">Agregar</button>
                    </div>
                </div>
            </div>
        </div>

    </body>
    <!--   Core JS Files   -->

    <script src="js/core/jquery.3.2.1.min.js" type="text/javascript"></script>

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

    <script src="js/perfilpr.js"></script>
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
