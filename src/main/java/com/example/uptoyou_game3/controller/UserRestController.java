package com.example.uptoyou_game3.controller;

import com.example.uptoyou_game3.dto.UserDto;
import com.example.uptoyou_game3.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/user")
@RestController
public class UserRestController {

    private final UserService userService;
    public UserRestController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<UserDto.CreateResDto> create(@RequestBody UserDto.CreateReqDto param){
        return ResponseEntity.ok(userService.create(param));
    }

}
