package com.lov2code.resthomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestDemoHomeworkApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(RestDemoHomeworkApplication.class, args);
        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s);
        }
    }

}
