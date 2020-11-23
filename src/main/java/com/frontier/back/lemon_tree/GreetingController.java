package com.frontier.back.lemon_tree;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class GreetingController {

    @GetMapping("/")
    public String hello()
    {
        return "Hello javaTpoint";
    }

}