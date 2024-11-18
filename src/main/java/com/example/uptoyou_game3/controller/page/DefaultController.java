package com.example.uptoyou_game3.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class DefaultController {
    @GetMapping({"", "/", "/index"})
    public String empty(){
        return "user/create";
    }
}
