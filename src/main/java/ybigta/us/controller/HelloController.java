package ybigta.us.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ybigta.us.dto.RecordDto;

import java.io.IOException;

public class HelloController {

    @GetMapping("/")
    public String Hello() {
        return "index";
    }

}
