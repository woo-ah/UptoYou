package com.example.uptoyou_game3.mapper;

import com.example.uptoyou_game3.dto.GameDto;

import java.util.List;

public interface GameMapper {
    List<GameDto.AwardResDto> listAll();
}
