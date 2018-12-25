<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pro" uri="http://www.springframework.org/tags" %>
<%@page isELIgnored="false"%>
<!doctype html>
<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="utf-8"%>
<html class="no-js" lang="en" >

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>ProGrammer--To Be an Artist</title>
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

    <script src="../../assets/js/proscript/protextarea.js"></script>
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
    <!--不可滚动-->
    <script src="../../assets/js/myjs/dont_move.js"></script>
    <!--取消text右边的滑动条-->
    <link rel="stylesheet" href="../../assets/css/procss/proCss.css">
    <%--<script src="../../assets/js/myjs/show_get_text.js"></script>--%>
    <!--alt表示tab键来-->
    <script src="../../assets/js/myjs/tap.js"></script>
    <!--左侧跳到指定位置-->
    <script src="../../assets/js/myjs/my_scrollbar.js"></script>
    <script>
//    ajax传数据
    function getAndShow(code) {
        $.ajax({
            type: "POST",
            url: "/textarea",
            data: {str:code},
            dataType: "json",
            success: function(data){
                document.getElementById("scrollOne").innerHTML=data.code;
            },
            error:function(data){
               //donothing
            }
        });
    }

    var oMyBar1;
    window.onload = function () {
        oMyBar1 = new MyScrollBar({
            selId: 'wrapper1',
            bgColor: 'rgba(50, 50, 50, 0.2)',
            barColor: '#2E8EEA',
            enterColor: '#056FD8',
            enterShow: false,
            borderRadius: 2
        });
        var t = document.getElementById('codeTextarea');
        t.onclick = function () {
            oMyBar1.setSize();
            var v = t.value;
            // 开始到光标位置的内容
            var cv = '';
            if ('selectionStart' in t) {
                cv = v.substr(0, t.selectionStart);
            } else {
                var oSel = document.selection.createRange();
                oSel.moveStart('character', -t.value.length);
                cv = oSel.text;
            }
            // 获取当前是几行
            var cl = cv.split('\n').length-4;
            if(cl<0)
                cl=1;
            var s={
                id:cl,
                time: 400
            };
            oMyBar1.jump(s);
        }
    }
    function barOnKeyUp() {
        oMyBar1.setSize();
//        alert("barOnKeyUp")
        var t = document.getElementById('codeTextarea');
        var v = t.value;
        // 开始到光标位置的内容
        var cv = '';
        if ('selectionStart' in t) {
            cv = v.substr(0, t.selectionStart);
        } else {
            var oSel = document.selection.createRange();
            oSel.moveStart('character', -t.value.length);
            cv = oSel.text;
        }
        // 获取当前是几行
        var cl = cv.split('\n').length-4;
        if(cl<0)
            cl=1;
//        alert(cl);
        var s={
            id:cl,
            time: 400
        };
        oMyBar1.jump(s);
    }
    </script>
    <style type="text/css">
        .box {
            width: 600px; height: 300px; border: 1px solid #444; margin: 10px auto; padding: 0; overflow: hidden;
        }
        .box1 {
            padding: 20px;
            /*overflow: auto;*/
        }
        .textbox{
            border:3px solid #453cad;
            background-color:transparent;
            color: honeydew;
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
                        <a href="index.html">
                            <img src="../../assets/images/icon/logo.png" alt="logo">
                        </a>
                    </div>
                </div>
                <div class="col-lg-9 d-none d-lg-block">
                    <div class="main-menu">
                        <nav id="nav_mobile_menu">
                            <ul id="navigation">
                                <li>
                                    <a href="index.jsp">Home</a>
                                </li>
                                <li>
                                    <a href="pro_programmer.jsp">Programmer</a>
                                </li>
                                <li class="active">
                                    <a href="pro_musician.jsp">Musician</a>
                                </li>
                                <li>
                                    <a href="#gallery">gallery</a>
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
<div class="contact-area bg_dark ptb--100">
    <div class="container">
        <div class="msc-title section-title">
            <span style="margin-right: 100px">Create Your own Music</span>
        </div>
        <div class="row">
            <div class="col-md-7">
                <div class='box box1' id='wrapper1'>
                    <div class="scroll" id="scrollOne">
                        <span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE 20</span><br id="p20"><span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE2 </span><br><span id="1" style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE </span><br>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <form>
                    <textarea
                            id="codeTextarea" rows="12" cols="45" spellcheck="false"
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
                        <a href="#" style="background: #fe942f;" onclick="pro_close()">

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
