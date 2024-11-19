package com.example.uptoyou_game3.mapper;

import com.example.uptoyou_game3.dto.DefaultDto;
import com.example.uptoyou_game3.dto.GquizDto;

import java.util.List;

public interface GquizMapper {
    GquizDto.DetailResDto max(GquizDto.ListReqDto param);
    GquizDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<GquizDto.DetailResDto> list(GquizDto.ListReqDto param);
}
