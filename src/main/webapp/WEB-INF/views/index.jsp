<!doctype html>
<%@page isELIgnored="false"%>
<%@ taglib prefix="pro" uri="http://www.springframework.org/tags" %>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- all css here -->
    <link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../assets/css/magnific-popup.css">
    <link rel="stylesheet" href="../../assets/css/slicknav.min.css">
    <link rel="stylesheet" href="../../assets/css/swiper.min.css">
    <link rel="stylesheet" href="../../assets/css/zoomslider.css">
    <link rel="stylesheet" href="../../assets/css/typography.css">
    <link rel="stylesheet" href="../../assets/css/default-css.css">
    <link rel="stylesheet" href="../../assets/css/styles.css">
    <link rel="stylesheet" href="../../assets/css/responsive.css">
    <!-- modernizr css -->
    <script src="../../assets/js/vendor/modernizr-2.8.3.min.js"></script>
    <script src="../../assets/js/myjs/dont_move.js"></script>

</head>


<body>
<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->
<!-- preloader area start -->
<!---<div id="preloader">
	<div class="loader"></div>
</div>--->
<!-- prealoader area end -->
<!-- header area start -->
<header>
    <div class="header-area">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-3">
                    <div class="logo">
                        <a href="index.html">
                            <img src="../../assets/images/icon/logo.png" alt="logo">
                        </a>
                    </div>
                </div>
                <div class="col-lg-9 d-none d-lg-block">
                    <div class="main-menu">
                        <nav id="nav_mobile_menu">
                            <ul id="navigation">
                                <li class="active">
                                    <a href="WEB-INF/views/index.jsp">Home</a>
                                </li>
                                <li>
                                    <a href="WEB-INF/views/pro_programmer.jsp">Programmer</a>
                                </li>
                                <li>
                                    <a href="<pro:url value="/musician"/>">Musician</a>
                                </li>
                                <li>
                                    <a href="#gallery">Gallery</a>
                                </li>
                                <li>
                                    <a href="#blog">blog</a>
                                </li>
                                <li>
                                    <a href="#contact">Contact Us</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <div class="col-12 d-block d-lg-none">
                    <div id="mobile_menu"></div>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- header area end -->
<!-- slider area start -->
<div class="slider-area d-flex align-items-center" id="slider_firefly" data-zs-src='["assets/images/slider/music-bg1.jpg", "assets/images/slider/music-bg2.jpg", "assets/images/slider/music-bg3.jpg"]'>
    <div class="container">
        <div class="music-content">
            <h2>Your Music Career
                <br> Starts Here</h2>
            <a href="WEB-INF/views/pro_musician.jsp">
                <i class="fa fa-play"></i>
            </a>
        </div>
    </div>
</div>
<!-- slider area end -->

<!-- jquery latest version -->
<script src="../../assets/js/vendor/jquery-2.2.4.min.js"></script>
<!-- bootstrap 4 js -->
<script src="../../assets/js/bootstrap.min.js"></script>
<!-- others plugins -->
<script src="../../assets/js/jquery.slicknav.min.js"></script>
<script src="../../assets/js/counterup.min.js"></script>
<script src="../../assets/js/waypoints.js"></script>
<script src="../../assets/js/imagesloaded.pkgd.min.js"></script>
<script src="../../assets/js/isotope.pkgd.min.js"></script>
<script src="../../assets/js/jquery.magnific-popup.min.js"></script>
<script src="../../assets/js/countdown.js"></script>
<script src="../../assets/js/swiper.min.js"></script>
<script src="../../assets/js/plugins.js"></script>
<script src="../../assets/js/jquery.zoomslider.min.js"></script>
<script src="../../assets/js/jquery.firefly.js"></script>
<!-- google map -->
<!---<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBO_5h890WNShs_YLGivCBfs2U89qXR-7Y&callback=initMap"></script>--->
<script src="../../assets/js/scripts.js"></script>
</body>

</html>
