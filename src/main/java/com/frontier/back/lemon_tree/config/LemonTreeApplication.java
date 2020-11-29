package com.frontier.back.lemon_tree.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class LemonTreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LemonTreeApplication.class, args);
    }

}
