package com.promusician.aspect;

import com.promusician.web.TextareaController;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class TextareaLogImpl {
//    static Logger logger= Logger.getLogger(TextareaLogImpl.class.getName());

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
