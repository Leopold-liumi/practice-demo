package com.leopold.spring.boot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * Created by LIUMI969 on 2018/3/21.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class App {



    @PostConstruct
    public void printInfo(){

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
