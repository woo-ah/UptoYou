package com.example.uptoyou_game3.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/gspeed")
@Controller
public class GspeedController {

    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "gspeed/" + page;
    }

    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "gspeed/" + page;
    }

}
