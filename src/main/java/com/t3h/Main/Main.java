package com.t3h.Main;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Lap trinh on 3/28/2018.
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
