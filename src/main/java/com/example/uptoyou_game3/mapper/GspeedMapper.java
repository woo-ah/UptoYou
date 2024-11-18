package com.example.uptoyou_game3.mapper;

import com.example.uptoyou_game3.dto.DefaultDto;
import com.example.uptoyou_game3.dto.GspeedDto;

import java.util.List;

public interface GspeedMapper {
    GspeedDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<GspeedDto.DetailResDto> list(GspeedDto.ListReqDto param);
}
