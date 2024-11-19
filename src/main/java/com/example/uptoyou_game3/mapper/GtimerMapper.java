package com.example.uptoyou_game3.mapper;

import com.example.uptoyou_game3.dto.DefaultDto;
import com.example.uptoyou_game3.dto.GtimerDto;

import java.util.List;

public interface GtimerMapper {
    GtimerDto.DetailResDto max(GtimerDto.ListReqDto param);
    GtimerDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<GtimerDto.DetailResDto> list(GtimerDto.ListReqDto param);
}
