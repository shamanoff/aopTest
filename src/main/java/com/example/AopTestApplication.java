package com.example;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopTestApplication {


    public static void main(String[] args) {
        SpringApplication.run(AopTestApplication.class, args);
        MessageWriter target = new MessageWriter();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);


        MessageWriter proxy = (MessageWriter) pf.getProxy();

//        target.writeMessage();
//        System.out.println("");
        proxy.writeMessage();
    }
}
