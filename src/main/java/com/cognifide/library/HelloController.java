package com.cognifide.library;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${books.path:target\books.json}")
    public String name;

    @GetMapping
    public String hello(){
        return "Hello, " + name + "!";
    }
}