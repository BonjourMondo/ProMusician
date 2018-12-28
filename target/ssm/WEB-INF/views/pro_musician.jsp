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

    <link rel="stylesheet" href="../../assets/css/procss/proCss.css">
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

    <script>
//        /textarea/start"
        function CheckAndRun(){
//            alert("!!!");
            var v=document.getElementById("codeTextarea");
            var code=v.value;
            $.ajax({
                type: "POST",
                url: "/textarea/start",
                data: {str:code},
                dataType: "json",
                success: function(data){
                    //调用乐器打击代码
//                    alert("s");
                    if(data.error_code=="success"){
                        //成功场景
                        //处理字符串，并映射为Instrument
                        var instruments=data.code.split(",");
                        for(var i=0;i<instruments.length;i++){
//                            alert(instruments[i]);

                            var beat_instruments=instruments[i].split("|");
                            for(var j=0;j<beat_instruments.length;j++){
                                //  music:"sn"|"fl"|"hi"|"bi"|"sm"|"ki"|"cr"
//                                alert(beat_instruments[j]+"");
                                if(beat_instruments[j].indexOf("cr")!=-1){
                                    alert("cr");
                                }else if(beat_instruments[j].indexOf("ki")!=-1){

                                }else if(beat_instruments[j].indexOf("sm")!=-1){

                                }else if(beat_instruments[j].indexOf("bi")!=-1){

                                }else if(beat_instruments[j].indexOf("hi")!=-1){

                                }else if(beat_instruments[j].indexOf("fl")!=-1){

                                }else if(beat_instruments[j].indexOf("sn")!=-1){

                                }
                            }
                        }

                        //调用子页面的function
//                        document.getElementById("drums_page").contentWindow.pro_close();
                    }else if (data.error_code=="loops"){
                        //循环场景
//                        setTempo();
                    }else if(data.error_code=="parser_error"){
                      alert(data.error_msg);
                    }else if(data.error_code=="stone_error"){
                        alert(data.error_msg);
                    }else{
                        alert(data.error_msg);
                    }
                },
                error:function(data){
                    //donothing
                    alert("f");
                }
            });
            return false;
        }



// Tempo varibles
var bpm = 150;
var interval = 60000 / bpm;
var intervalId;
// Set tempo
function setTempo() {
    window.clearInterval(intervalId);
//    alert("ss2s");
    intervalId = window.setInterval(sequencer, interval);
}

function sequencer () {
//    alert("sss");
    hiHat();
}


    </script>
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
                    <div class="scroll textHint span_all" id="scrollOne">
                        <%--<div class="row textHint" id="textHint">--%>
                            <span class=\"span_lineNo\" id=“1">1&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <button class="bpm_btn bpm_btn-tooltip btn-sequencer" id="sequencer-visible-btn" aria-label="BPM"><i class="fa fa-th"></i></button>
                            <span class="span_KeyofBPM">BPM&nbsp;</span>
                            <br/>
                            <button onclick="pro_close();">ssss</button>
                            <span class=\"span_lineNo\" id=“1">1&nbsp;&nbsp;&nbsp;&nbsp;</span>
                            <span class="span_KeyofBPM">BPM&nbsp;</span>
                        <span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE 20</span><br id="p20"><span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE2 </span><br><span id="1" style="color:#F00">ELSE </span><br><span style="color:#F00">ELSE </span><br>
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
