package com.example.springframework.configuration.external;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ExternalConfgApp {

    public static void main (String ...args){
        System.out.println(" @@ ExternalConfgApp::main @@ ");
        ApplicationContext ctx = SpringApplication.run(ExternalConfgApp.class,args);
        DataSource dataSrc = ctx.getBean(DataSource.class);
        System.out.println(dataSrc.getName() + " :: " + dataSrc.getPassword() +" :: "+ dataSrc.getUrl());

    }
}
