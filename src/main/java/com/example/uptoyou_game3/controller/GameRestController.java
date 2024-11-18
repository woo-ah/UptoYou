package com.example.uptoyou_game3.controller;

import com.example.uptoyou_game3.dto.GameDto;
import com.example.uptoyou_game3.dto.UserDto;
import com.example.uptoyou_game3.service.GameService;
import com.example.uptoyou_game3.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/api/game")
@RestController
public class GameRestController {

    private final GameService gameService;

    public GameRestController(
            GameService gameService
    ) {
        this.gameService = gameService;
    }

    @PutMapping("/level1")
    public ResponseEntity<String> updateLevel1(@RequestBody GameDto.GameReqDto param){
        gameService.updateLevel1(param);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/level2")
    public ResponseEntity<String> updateLevel2(@RequestBody GameDto.GameReqDto param){
        gameService.updateLevel2(param);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/level3")
    public ResponseEntity<String> updateLevel3(@RequestBody GameDto.GameReqDto param){
        gameService.updateLevel3(param);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/username")
    public ResponseEntity<GameDto.UsernameResDto> detail(@RequestParam Long id){
        return ResponseEntity.ok(gameService.userName(id));
    }

    @PostMapping("/check-username")
    public ResponseEntity<GameDto.CheckResDto> check(@RequestBody GameDto.CheckReqDto param){
        return ResponseEntity.ok(gameService.check(param));
    }

    @GetMapping("/all")
    public ResponseEntity<List<GameDto.AwardResDto>> getAllData() {
        List<GameDto.AwardResDto> result = gameService.getAllNonNullAvgTime();
        return ResponseEntity.ok(result);
    }


}

