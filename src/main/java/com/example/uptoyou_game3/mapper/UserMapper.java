package com.example.uptoyou_game3.mapper;

import com.example.uptoyou_game3.dto.UserDto;
import java.util.List;

public interface UserMapper {
    List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
}
