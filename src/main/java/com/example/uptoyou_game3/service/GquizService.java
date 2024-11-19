package com.example.uptoyou_game3.service;

import com.example.uptoyou_game3.dto.DefaultDto;
import com.example.uptoyou_game3.dto.GquizDto;

import java.util.List;

public interface GquizService {
    GquizDto.CreateResDto create(GquizDto.CreateReqDto param);
    void update(GquizDto.UpdateReqDto param);
    GquizDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<GquizDto.DetailResDto> list(GquizDto.ListReqDto param);
}
