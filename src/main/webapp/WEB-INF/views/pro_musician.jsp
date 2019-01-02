<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pro" uri="http://www.springframework.org/tags" %>
<%@page isELIgnored="false"%>
<!doctype html>
<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="utf-8"%>
<html class="no-js" lang="en" >

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>ProMusician--Start here</title>
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

    <!--行号-->
    <script src="../../assets/js/myjs/protextarea.js"></script>
    <!--不可滚动-->
    <script src="../../assets/js/myjs/dont_move.js"></script>
    <!--text相关Js-->
    <script src="../../assets/js/myjs/show_get_text.js"></script>
    <!--alt表示tab键来-->
    <script src="../../assets/js/myjs/tap.js"></script>
    <!--左侧跳到指定位置-->
    <script src="../../assets/js/myjs/my_scrollbar.js"></script>
    <!--自定义的Css-->
    <link rel="stylesheet" href="../../assets/css/procss/proCss.css">
    <!--打击乐器的js-->
    <script src="../../assets/js/myjs/drumbeat.js"></script>
    <!--弹窗的alert-->
    <script src="../../assets/js/myjs/alert.js"></script>

    <style type="text/css">
        /*text*/
        .box {
            width: 600px; height: 375px; border:3px solid #453cad; margin: 10px auto; padding: 0; overflow: hidden;
        }
        .box1 {
            padding: 20px;
            /*overflow: auto;*/
        }
        .textbox{
            border:3px solid #453cad;
            background-color:transparent;
            color: #ffcb2a;
            padding-left: 10px;
            /*margin-left: 10px;*/
            height: auto;
            resize:none;
            overflow-y: scroll;
            font-size: 15px ;
            line-height: 2;
        }
        .textbox::-webkit-scrollbar {
            width: 5px;
            height: 10px;
            background-color: #b5b1b1;
        }
        .textbox::-webkit-scrollbar-track {
            -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
            border-radius: 10px;
            background-color: black;

        }
        .textbox::-webkit-scrollbar-thumb {
            border-radius: 10px;
            -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, .3);
            background-color: #b5b1b1;
        }

        .span_lineNo{
            font-size: 14px;
            letter-spacing: 0.09em;
            color: #ffcb2a;
        }
        .span_hover:hover{
            text-shadow:-1px 0 #fff938,
            0 1px #fff938,
            1px 0 #fff938,
            0 -1px #fff938;
        }
        .span_text_hover{
            text-shadow:-1px 0 #fff938,
            0 1px #fff938,
            1px 0 #fff938,
            0 -1px #fff938;
        }
        .span_KeyofWhile{
        }
        .span_KeyofRHY{
        }
        .span_KeyofBPM{
        }
        .span_KeyofTimes{
        }
        .span_KeyofSymbol{
        }
        .span_KeyofIFELSE{

        }
        .span_all{
            color: #ffcb2a;
        }

        .bpm_btn {
            font-size: 1.65em;
            font-weight: bold;
            line-height: 1;
            width: auto;
            padding: 0.5rem;
            vertical-align: middle;
            text-decoration: none;
            color: #89939B;
            border: 0;
            border-radius: 2px;
            background: #ffcb2a;
        }

        .bpm_btn:hover {
            color: #2d2e36;
            border-color: #2d2e36;
            outline: none;
        }

        .bpm_btn .fa {
            vertical-align: middle;
        }
    </style>
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
                        <a href="<pro:url value="/"/>">
                            <img src="../../assets/images/icon/logo.png" alt="logo">
                        </a>
                    </div>
                </div>
                <div class="col-lg-9 d-none d-lg-block">
                    <div class="main-menu">
                        <nav id="nav_mobile_menu">
                            <ul id="navigation">
                                <li>
                                    <a target="_blank" href="<pro:url value="/"/>">Home</a>
                                </li>
                                <li>
                                    <a target="_blank" href="<pro:url value="/programmer"/>">Programmer</a>
                                </li>
                                <li class="active">
                                    <a target="_blank" href="<pro:url value="/musician"/>">Musician</a>
                                </li>
                                <li>
                                    <a target="_blank" href="<pro:url value="/gallery"/>">Gallery</a>
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
<!-- contact area start -->
<iframe src="<pro:url value="/drums"/>" id="drums_page" style="position: absolute;margin-top: 10px;margin-left: 200px;z-index: 1000;"
        frameborder="0" width="220" scrolling="No"
        height="200" leftmargin="0" topmargin="0"></iframe>
<div class="contact-area bg_dark ptb--100" style="background: url(../../assets/images/slider/mohu_bpm.jpg) center/cover no-repeat;">
    <div class="container" >
        <div class="msc-title section-title">
            <span style="margin-right: 100px">Create Your own Music</span>
        </div>
        <div class="row" >
            <div class="col-md-7">
                <div class='box box1' id='wrapper1'>
                    <div class="scroll textHint span_all" id="scrollOne">
                            <span class="span_lineNo" id="1">1&nbsp;&nbsp;&nbsp;&nbsp;</span>bpm:Express rhythmic speed.&nbsp;&nbsp; <button class="bpm_btn bpm_btn-tooltip btn-sequencer" id="sequencer-visible-btn" aria-label="BPM"><i class="fa fa-th"></i></button>&nbsp;<span class="span_KeyofBPM span_text_hover">BPM&nbsp;</span>;<br>
                            <span class="span_lineNo" id="2">2&nbsp;&nbsp;&nbsp;&nbsp;</span>times:Represents the number of hits.(you could never end it)&nbsp;&nbsp;<span class="span_KeyofTimes span_text_hover">TIMES&nbsp;</span>;<br>
                            <span class="span_lineNo" id="3">3&nbsp;&nbsp;&nbsp;&nbsp;</span>if/elese,while:Same as java or other language can do&nbsp;&nbsp;<span class="span_KeyofIFELSE span_text_hover">IF&nbsp;</span>;<span class="span_KeyofIFELSE span_text_hover">ELSE&nbsp;</span>;<span class="span_KeyofWhile span_text_hover">WHILE&nbsp;</span>;<br>
                            <span class="span_lineNo" id="4">3&nbsp;&nbsp;&nbsp;&nbsp;</span>rhy:Represent a beat.(short for rhythm)&nbsp;&nbsp;<span class="span_KeyofRHY span_text_hover">RHY&nbsp;</span><br/>
                            <span class="span_lineNo" id="5">4&nbsp;&nbsp;&nbsp;&nbsp;</span>sn:<img class="" style="height: 30px;width: 30px" src="../../assets/images/proimage/snare.png" onclick="img_snare();">;&nbsp;fl:<img class="" style="height: 30px;width: 30px" src="../../assets/images/proimage/floor_tom.png" onclick="img_floorTom();">;&nbsp;hi:<img class="" style="height: 30px;width: 30px" src="../../assets/images/proimage/hi_hat.png" onclick="img_hihat();">;&nbsp;bi:<img class="" style="height: 30px;width: 30px" src="../../assets/images/proimage/left_tom.png" onclick="img_leftTom();">;&nbsp;sm:<img class="" style="height: 30px;width: 30px" src="../../assets/images/proimage/right_tom.png" onclick="img_rightTom();">;&nbsp;ki:<img class="" style="height: 30px;width: 30px" src="../../assets/images/proimage/kick.png" onclick="img_kick();">;&nbsp;cr:<img class="" style="height: 30px;width: 30px" src="../../assets/images/proimage/crash.png" onclick="img_crash();"><br>
                       </div>
                </div>
            </div>
            <div class="col-md-4">
                <form>
                    <textarea
                            id="codeTextarea" rows="13" cols="46" spellcheck="false"
                            class="textbox"
                            onkeyup="getAndShow(this.value);tap();barOnKeyUp()"
                            <%--onclick=""--%>
                            >${template_promusician}</textarea>
                </form>
                <script type="text/javascript">
                    createTextAreaWithLines('codeTextarea');
                </script>
            </div>
            <div class="probutton col-md-1" >
                <div class="row">
                    <div class="col-md-12">
                        <a href="#" style="background: #fecc2f;">

                            Hints
                        </a>
                    </div>
                    <div class="col-md-12">
                        <a href="#" style="background: #feb52f;">

                            Forum
                        </a>
                    </div>
                    <div class="col-md-12">
                        <a href="<pro:url value="/textarea/test"/>" style="background: #feab2f;">

                            Debug
                        </a>
                    </div>
                    <div class="col-md-12">
                        <%--pro_close();CheckAndRun()--%>
                        <a href="javascript:void(0)" style="background: #fe942f;" onclick="CheckAndRun();">

                            Start
                        </a>
                    </div>
                    <div class="col-md-12">
                        <a href="<pro:url value="/textarea/commit"/>" style="background: #fe832f;">

                            Commit
                        </a>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<!-- contact area end -->

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
