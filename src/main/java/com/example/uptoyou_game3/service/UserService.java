package com.example.uptoyou_game3.service;

import com.example.uptoyou_game3.dto.UserDto;
import org.springframework.stereotype.Service;


public interface UserService {
    UserDto.CreateResDto create(UserDto.CreateReqDto param);
}
