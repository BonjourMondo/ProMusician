package com.promusician.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class TextareaLogImpl {

    @Pointcut("execution(* com.promusician.service.AnalyserServiceImpl.analyseInputText(..))")
    public void getText(){}


    @Before("getText()")
    public void isSuccessText() {
        System.out.println("打印");
    }
    @AfterReturning("getText()")
    public void this_text(){
        System.out.println("打印完毕");
    }
}
