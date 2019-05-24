package com.uhcl.amazonsellers.controllers;

import com.uhcl.amazonsellers.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public void sendEmail(){
        emailService.sendEmail("plmpradeep@gmail.com","Test","Hello World");
    }
}
