package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@SpringBootApplication
public class DemoApplication {
    @Value("${hs.fund.srv.dubbo.registry.client}")
    static String a;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("--------------" + a);

    }

}
