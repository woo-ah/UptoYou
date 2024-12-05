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

    @GetMapping("/rpm")
    public String rpm(){
        return "user/create";
    }

    @GetMapping("/home")
    public String home(){
        return "main/home";
    } // templates/main/home.html

    @GetMapping("/game")
    public String game(){
        return "main/game";
    } // templates/main/game.html

    @GetMapping("/shop")
    public String shop(){
        return "main/shop";
    } // templates/main/shop.html

    @GetMapping("/community")
    public String community(){
        return "main/community";
    } // templates/main/community.html

    @GetMapping("/about")
    public String about(){
        return "main/about";
    } // templates/main/about.html

}
