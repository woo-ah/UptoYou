package com.example.uptoyou_game3.service;

import com.example.uptoyou_game3.dto.UserDto;
import com.example.uptoyou_game3.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    UserDto.CreateResDto create(UserDto.CreateReqDto param);
    List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
}
