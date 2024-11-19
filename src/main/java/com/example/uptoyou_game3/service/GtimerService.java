package com.example.uptoyou_game3.service;

import com.example.uptoyou_game3.dto.DefaultDto;
import com.example.uptoyou_game3.dto.GtimerDto;

import java.util.List;

public interface GtimerService {
    GtimerDto.CreateResDto create(GtimerDto.CreateReqDto param);
    void update(GtimerDto.UpdateReqDto param);
    GtimerDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<GtimerDto.DetailResDto> list(GtimerDto.ListReqDto param);
}
