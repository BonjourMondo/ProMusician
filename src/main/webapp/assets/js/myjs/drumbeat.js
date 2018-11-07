var pro_init;
var stop=false;
/**
 * 初步设想，首先，这一轮所有要打击的乐器按照7*1（7个乐器，每一拍轮训）的形式入队列（短循环），队列标记循环次数。
 * 循环完次数后，次数回归原来的值。并且将移动至下一个短队列。如此循环。
 */
    //轮询方式：
    //入队可以按照1001110的形式，通过移位来判断这轮有没有叫号
    //好的智障了，它可能带有这个函数，请先读懂源码。
var bpm=150;
var interval=60000/bpm;
function pro_close(){//停止
    if(stop){
        window.clearInterval(pro_init)
        stop=false;
    }else{
        pro_init=setInterval("hiHat()",interval);
        stop=true;
    }
}