package com.promusician.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommitLogImpl {
    @Pointcut("execution(* com.promusician.kafka.KafkaMessageProducer.send(..))")
    public void sendSuccess(){}

    @Before("sendSuccess()")
    public void begin(){
        System.out.println("开始发送");
    }

    @AfterReturning("sendSuccess()")
    public void afterreturning(){
        System.out.println("异步发送完毕");
    }

    @AfterThrowing("sendSuccess()")
    public void afterthrowing(){
        System.out.println("发送失败");
    }
}
