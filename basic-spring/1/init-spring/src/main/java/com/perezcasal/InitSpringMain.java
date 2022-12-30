package com.perezcasal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitSpringMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_config.xml");
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        System.out.println(helloWorld.helloWorld());
    }
}
