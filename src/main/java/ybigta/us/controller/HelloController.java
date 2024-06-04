package ybigta.us.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {

    @GetMapping("/")
    public String Hello() {
        return "index";
    }

}
