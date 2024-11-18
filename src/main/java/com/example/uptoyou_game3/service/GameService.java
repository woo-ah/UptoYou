package com.example.uptoyou_game3.service;

import com.example.uptoyou_game3.dto.GameDto;
import com.example.uptoyou_game3.dto.UserDto;

import java.util.List;

public interface GameService {
    void updateLevel1(GameDto.GameReqDto param);
    void updateLevel2(GameDto.GameReqDto param);
    void updateLevel3(GameDto.GameReqDto param);
    GameDto.UsernameResDto userName(Long id);
    GameDto.CheckResDto check(GameDto.CheckReqDto param);
    List<GameDto.AwardResDto> getAllNonNullAvgTime();
}
