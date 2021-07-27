package com.back.ofertaBack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ofertaPublica/back")
public class BackController {

    @GetMapping
    public String getOrders(){
        return "API Test!";
    }
}
