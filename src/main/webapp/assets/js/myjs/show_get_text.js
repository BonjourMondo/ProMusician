function getandShowText(str){
    var xmlhttp;
    if (str.length==0){
        document.getElementById("textHint").innerHTML="";
        return;
    }
    if (window.XMLHttpRequest)
    {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {

        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("textHint").innerHTML=xmlhttp.responseText;
        }
    }
    xmlhttp.open("POST","/textarea",true);
    xmlhttp.setRequestHeader("Content-Type"
        , "application/x-www-form-urlencoded");
    // 发送请求
    xmlhttp.send("str="+str);
}



function img_crash() {
    var iframe = document.getElementById('drums_page').contentWindow;
    iframe.crash();
}
function img_hihat() {
    var iframe = document.getElementById('drums_page').contentWindow;
    iframe.hiHat();
}
function img_snare() {
    var iframe = document.getElementById('drums_page').contentWindow;
    iframe.snare();
}
function img_kick() {
    var iframe = document.getElementById('drums_page').contentWindow;
    iframe.kick();
}
function img_floorTom() {
    var iframe = document.getElementById('drums_page').contentWindow;
    iframe.floorTom();
}
function img_leftTom() {
    var iframe = document.getElementById('drums_page').contentWindow;
    iframe.leftTom();
}
function img_rightTom() {
    var iframe = document.getElementById('drums_page').contentWindow;
    iframe.rightTom();
}