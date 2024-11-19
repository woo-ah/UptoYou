package com.example.uptoyou_game3.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/gtimer")
@Controller
public class GtimerController {

    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "gtimer/" + page;
    }

    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "gtimer/" + page;
    }

}
