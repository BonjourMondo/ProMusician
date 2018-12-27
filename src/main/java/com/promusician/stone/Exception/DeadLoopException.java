package com.promusician.stone.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: LeesangHyuk
 * Date: 2018/12/27 14:52
 * Description:
 */
public class DeadLoopException extends RuntimeException {
    private static final long serialVersionUID = -828282886645672626L;
    public static Logger logger= LoggerFactory.getLogger(DeadLoopException.class);

    public DeadLoopException(String msg){
        super("出现死循环错误，错误代码："+msg);
    }
    public DeadLoopException(){
        super("出现死循环错误,默认处理为无限循环");
    }
}
