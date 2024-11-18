package com.example.uptoyou_game3.controller.page;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@RequestMapping("/game")
@Controller
public class GameController {

    @GetMapping("/{page}")
    public String page(@PathVariable String page, @RequestParam(required = false) String userId, Model model) {
        model.addAttribute("userId", userId);
        return "game/" + page; // 예: game/level1.html
    }
}

