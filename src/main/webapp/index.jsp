<%-- 
    Document   : index
    Created on : 9/04/2018, 12:19:49 AM
    Author     : william
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="/assets/css/now-ui-dashboard.css?v=1.0.1" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="/assets/demo/demo.css" rel="stylesheet" />
        <link rel="apple-touch-icon" sizes="76x76" href="./img/apple-icon.png">
        <link rel="icon" type="image/png" href="./img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title> X games</title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
        <!-- CSS Files -->
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/now-ui-kit.css?v=1.1.0" rel="stylesheet" />
        <!-- Canonical SEO -->
        <link rel="canonical" href="https://www.creative-tim.com/product/now-ui-kit" />
        <!--  Social tags      -->
        <meta name="keywords" content="bootstrap 4, bootstrap 4 uit kit, bootstrap 4 kit, now ui, now ui kit, creative tim, html kit, html css template, web template, bootstrap, bootstrap 4, css3 template, frontend, responsive bootstrap template, bootstrap ui kit, responsive ui kit">
        <meta name="description" content="Start your development with a beautiful Bootstrap 4 UI kit. It is yours Free.">
        <!-- Schema.org markup for Google+ -->
        <meta itemprop="name" content="Now UI Kit by Creative Tim">
        <meta itemprop="description" content="Start your development with a beautiful Bootstrap 4 UI kit. It is yours Free.">
        <meta itemprop="image" content="http://s3.amazonaws.com/creativetim_bucket/products/56/original/opt_nuk_thumbnail.jpg">
        <!-- Twitter Card data -->
        <meta name="twitter:card" content="product">
        <meta name="twitter:site" content="@creativetim">
        <meta name="twitter:title" content="Now UI Kit by Creative Tim">
        <meta name="twitter:description" content="Start your development with a beautiful Bootstrap 4 UI kit. It is yours Free.">
        <meta name="twitter:creator" content="@creativetim">
        <meta name="twitter:image" content="http://s3.amazonaws.com/creativetim_bucket/products/56/original/opt_nuk_thumbnail.jpg">
        <meta name="twitter:data1" content="Now UI Kit by Creative Tim">
        <meta name="twitter:label1" content="Product Type">
        <meta name="twitter:data2" content="Free">
        <meta name="twitter:label2" content="Price">
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

        <%  if (session.getAttribute("sessionNombre") != null) {
                    response.sendRedirect("principal.jsp");
                }%>
        <!-- Navbar -->

        <nav class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent " color-on-scroll="400">
            <div class="container">
                <div class="navbar-translate">
                    <a class="navbar-brand" href="http://demos.creative-tim.com/now-ui-kit/index.html" rel="tooltip" title="Designed by Invision. Coded by Creative Tim" data-placement="bottom" target="_blank">
                        X games
                    </a>
                    <button class="navbar-toggler navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-bar bar1"></span>
                        <span class="navbar-toggler-bar bar2"></span>
                        <span class="navbar-toggler-bar bar3"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse justify-content-end" data-nav-image="./img/blurred-image-1.jpg">
                    <ul class="navbar-nav">

                        <li class="nav-item">
                            <a class="nav-link" rel="tooltip" title="Login" data-placement="bottom" href="#" data-toggle="modal" data-target="#myModal">
                                <i class="now-ui-icons users_single-02"></i>
                                <p class="d-lg-none d-xl-none">Login</p>
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" rel="tooltip" title="Follow us on Twitter" data-placement="bottom" href="https://twitter.com/CreativeTim" target="_blank">
                                <i class="fa fa-twitter"></i>
                                <p class="d-lg-none d-xl-none">Twitter</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" rel="tooltip" title="Like us on Facebook" data-placement="bottom" href="https://www.facebook.com/CreativeTim" target="_blank">
                                <i class="fa fa-facebook-square"></i>
                                <p class="d-lg-none d-xl-none">Facebook</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" rel="tooltip" title="Follow us on Instagram" data-placement="bottom" href="https://www.instagram.com/CreativeTimOfficial" target="_blank">
                                <i class="fa fa-instagram"></i>
                                <p class="d-lg-none d-xl-none">Instagram</p>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="wrapper">
            <div class="page-header clear-filter" filter-color="orange">
                <div class="page-header-image" data-parallax="true" style="background-image: url('https://orig00.deviantart.net/aa13/f/2012/307/7/d/gaming_background_by_nathytopbloke-d5jtsl0.jpg');">
                </div>
                <div class="container">
                    <div class="content-center brand">
                        <div class="container" >
                            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" >
                                <ol class="carousel-indicators">
                                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                                    <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img class="d-block w-100" src="http://hdqwalls.com/wallpapers/league-of-legends-game-poster.jpg" alt="First slide">
                                        <div class="overlay">
                                            <div class="text">
                                                <p>
                                                    Mi texto
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img class="d-block w-100" src="http://media.comicbook.com/2017/10/wow-wallpapers-hd-1039342.jpg" alt="Second slide">
                                        <div class="overlay">
                                            <div class="text">
                                                <p>
                                                    Mi texto2
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img class="d-block w-100" src="https://images8.alphacoders.com/877/thumb-1920-877849.jpg" alt="Third slide">
                                        <div class="overlay">
                                            <div class="text">
                                                <p>
                                                    Mi texto3
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img class="d-block w-100" src="https://images7.alphacoders.com/521/thumb-1920-521305.png" alt="fourth slide">
                                        <div class="overlay">
                                            <div class="text">
                                                <p>
                                                    Mi texto4
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Previous</span>
                                </a>
                                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </div>
                        </div>
                    </div>
                        <h6 class="category category-absolute">Designed by
                            USergio Coded by
                            <a href="https://www.creative-tim.com" target="_blank">
                                <img src="./img/creative-tim-white-slim2.png" class="creative-tim-logo" />
                            </a>.</h6>
                </div>
            </div>
            <!-- Sart Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header justify-content-center">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                <i class="now-ui-icons ui-1_simple-remove"></i>
                            </button>
                            <h4 class="title title-up">Login</h4>
                        </div>
                        <div class="modal-body">
                            <div class="content">
                                <div class="input-group form-group-no-border input-lg">
                                    <span class="input-group-addon">
                                        <i class="now-ui-icons users_circle-08"></i>
                                    </span>
                                    <input type="text" class="form-control" placeholder="Email..." id="email">
                                </div>
                                <div class="input-group form-group-no-border input-lg">
                                    <span class="input-group-addon">
                                        <i class="now-ui-icons text_caps-small"></i>
                                    </span>
                                    <input type="password" placeholder="Password..." class="form-control" id="password"/>
                                </div>
                            </div>
                            <div class="footer text-center">
                                <a class="btn btn-primary btn-round btn-lg btn-block" onclick="iniciarsesion($('#email').val(), $('#password').val())">Get Started</a>
                            </div>  
                            <div class="pull-left">
                                <h6>
                                    <a class="nav-link" data-placement="bottom" href="#" data-toggle="modal"  data-target="#myModalSign">Create Account</a>
                                </h6>
                            </div>
                            <div class="pull-right">
                                <h6>
                                    <a href="#pablo" class="link">Need Help?</a>
                                </h6>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--  End Modal -->
            <div class="modal fade" id="myModalSign" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header justify-content-center">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                <i class="now-ui-icons ui-1_simple-remove"></i>
                            </button>
                            <h4 class="title title-up">Registro</h4>
                        </div>
                        <div class="modal-body">
                            <div class="content">
                                <h6>Nickname</h6>
                                <div class="input-group form-group-no-border input-lg">
                                    <span class="input-group-addon">
                                        <i class="now-ui-icons users_circle-08"></i>
                                    </span>
                                    <input type="text" class="form-control" placeholder="Nickname..." id="email">
                                </div>
                                <h6>Nombre</h6>
                                <div class="input-group form-group-no-border input-lg">
                                    <span class="input-group-addon">
                                        <i class="now-ui-icons text_caps-small"></i>
                                    </span>
                                    <input type="text" placeholder="Nombre..." class="form-control" id="name"/>
                                </div>
                                <h6>Contraseña</h6>
                                <div class="input-group form-group-no-border input-lg">
                                    <span class="input-group-addon">
                                        <i class="now-ui-icons objects_key-25"></i>
                                    </span>
                                    <input type="password" placeholder="Password..." class="form-control" id="password"/>
                                </div>
                                <h6>Correo</h6>
                                <div class="input-group form-group-no-border input-lg">
                                    <span class="input-group-addon">
                                        <i class="now-ui-icons ui-1_email-85"></i>
                                    </span>
                                    <input type="text" placeholder="Correo..." class="form-control" id="correo"/>
                                </div>
                            </div>
                            <div class="footer text-center">
                                <a class="btn btn-primary btn-round btn-lg btn-block" >Empezemos</a>
                            </div>  
                        </div>
                    </div>
                </div>
           </div>
            <!-- Mini Modal -->
            <div class="modal fade modal-mini modal-primary" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header justify-content-center">
                            <div class="modal-profile">
                                <i class="now-ui-icons users_circle-08"></i>
                            </div>
                        </div>
                        <div class="modal-body">
                            <p>Always have an access to your profile</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-link btn-neutral">Back</button>
                            <button type="button" class="btn btn-link btn-neutral" data-dismiss="modal">Close</button>
                        </div>
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
    <script src="js/now-ui-kit.js?v=1.1.0" type="text/javascript"></script>

    <script type='text/javascript' src="js/IniciarSesion.js"></script>
    <script type='text/javascript' src="js/ohsnap.js"></script>
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
