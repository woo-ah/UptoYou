package com.example.uptoyou_game3.service.impl;

import com.example.uptoyou_game3.domain.Gspeed;
import com.example.uptoyou_game3.domain.User;
import com.example.uptoyou_game3.dto.DefaultDto;
import com.example.uptoyou_game3.dto.GspeedDto;
import com.example.uptoyou_game3.mapper.GspeedMapper;
import com.example.uptoyou_game3.repository.GspeedRepository;
import com.example.uptoyou_game3.repository.UserRepository;
import com.example.uptoyou_game3.service.GspeedService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GspeedServiceImpl implements GspeedService {

    private final GspeedRepository gspeedRepository;
    private final GspeedMapper gspeedMapper;
    private final UserRepository userRepository;

    public GspeedServiceImpl(
            GspeedRepository gspeedRepository
            , GspeedMapper gspeedMapper
            , UserRepository userRepository
    ) {
        this.gspeedRepository = gspeedRepository;
        this.gspeedMapper = gspeedMapper;
        this.userRepository = userRepository;
    }

    @Override
    public GspeedDto.CreateResDto create(GspeedDto.CreateReqDto param){
        return gspeedRepository.save(param.toEntity()).toCreateResDto();
    }
    @Override
    public void update(GspeedDto.UpdateReqDto param){
        Gspeed gspeed = gspeedRepository.findById(param.getId()).orElseThrow(()->new RuntimeException("no data"));
        if(param.getLevel1() != null){ gspeed.setLevel1(param.getLevel1()); }
        if(param.getLevel2() != null){ gspeed.setLevel2(param.getLevel2()); }
        if(param.getLevel3() != null){ gspeed.setLevel3(param.getLevel3()); }
        gspeedRepository.save(gspeed);

        // 점수 업데이트
        Long userId = gspeed.getUserId();
        GspeedDto.DetailResDto resDto = gspeedMapper.max(GspeedDto.ListReqDto.builder().userId(userId).build());
        if(resDto != null){
            User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("no data"));
            Double level = resDto.getLevel();
            System.out.println("level : " + level);
            user.setGspeed(resDto.getLevel());
            userRepository.save(user);
        }
    }
    @Override
    public GspeedDto.DetailResDto detail(DefaultDto.DetailReqDto param){
        GspeedDto.DetailResDto selectResDto = gspeedMapper.detail(param);
        return selectResDto;
    }
    @Override
    public List<GspeedDto.DetailResDto> list(GspeedDto.ListReqDto param){
        return detailList(gspeedMapper.list(param));
    }

    public List<GspeedDto.DetailResDto> detailList(List<GspeedDto.DetailResDto> list){
        List<GspeedDto.DetailResDto> newList = new ArrayList<>();
        for(GspeedDto.DetailResDto each : list){
            newList.add(detail(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return newList;
    }
}
