package com.example.uptoyou_game3.service.impl;

import com.example.uptoyou_game3.domain.Gtimer;
import com.example.uptoyou_game3.domain.User;
import com.example.uptoyou_game3.dto.DefaultDto;
import com.example.uptoyou_game3.dto.GtimerDto;
import com.example.uptoyou_game3.mapper.GtimerMapper;
import com.example.uptoyou_game3.repository.GtimerRepository;
import com.example.uptoyou_game3.repository.UserRepository;
import com.example.uptoyou_game3.service.GtimerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GtimerServiceImpl implements GtimerService {

    private final GtimerRepository gtimerRepository;
    private final GtimerMapper gtimerMapper;
    private final UserRepository userRepository;

    public GtimerServiceImpl(
            GtimerRepository gtimerRepository
            , GtimerMapper gtimerMapper
            , UserRepository userRepository
    ) {
        this.gtimerRepository = gtimerRepository;
        this.gtimerMapper = gtimerMapper;
        this.userRepository = userRepository;
    }

    public void updatePoint(Long userId){
        // 점수 업데이트
        GtimerDto.DetailResDto resDto = gtimerMapper.max(GtimerDto.ListReqDto.builder().userId(userId).build());
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("no data"));
        Double point = resDto.getPoint() * 100;
        user.setGtimer(point);
        userRepository.save(user);
    }

    @Override
    public GtimerDto.CreateResDto create(GtimerDto.CreateReqDto param){
        GtimerDto.CreateResDto res = gtimerRepository.save(param.toEntity()).toCreateResDto();
        // 점수 업데이트
        updatePoint(param.getUserId());
        return res;
    }
    @Override
    public void update(GtimerDto.UpdateReqDto param){
        Gtimer gtimer = gtimerRepository.findById(param.getId()).orElseThrow(()->new RuntimeException("no data"));
        if(param.getPoint() != null){ gtimer.setPoint(param.getPoint()); }

        // 점수 업데이트
        updatePoint(gtimer.getUserId());

        gtimerRepository.save(gtimer);
    }
    @Override
    public GtimerDto.DetailResDto detail(DefaultDto.DetailReqDto param){
        GtimerDto.DetailResDto selectResDto = gtimerMapper.detail(param);
        return selectResDto;
    }
    @Override
    public List<GtimerDto.DetailResDto> list(GtimerDto.ListReqDto param){
        return detailList(gtimerMapper.list(param));
    }

    public List<GtimerDto.DetailResDto> detailList(List<GtimerDto.DetailResDto> list){
        List<GtimerDto.DetailResDto> newList = new ArrayList<>();
        for(GtimerDto.DetailResDto each : list){
            newList.add(detail(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return newList;
    }
}
