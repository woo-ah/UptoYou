package com.example.uptoyou_game3.service;

import com.example.uptoyou_game3.dto.DefaultDto;
import com.example.uptoyou_game3.dto.GameDto;
import com.example.uptoyou_game3.dto.GspeedDto;

import java.util.List;

public interface GspeedService {
    GspeedDto.CreateResDto create(GspeedDto.CreateReqDto param);
    void update(GspeedDto.UpdateReqDto param);
    GspeedDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<GspeedDto.DetailResDto> list(GspeedDto.ListReqDto param);
}
