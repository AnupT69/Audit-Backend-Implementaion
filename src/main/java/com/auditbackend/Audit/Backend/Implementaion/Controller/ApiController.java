package com.auditbackend.Audit.Backend.Implementaion.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class ApiController {

    @GetMapping("/secure/hello")
    public String getMessage(){
        return "Hello this is a secured api";
    }

    @GetMapping("/hello")
    public String getMessageHello(){
        return "Hello this is not a secure message";
    }
}


