package com.example.uptoyou_game3.service.impl;

import com.example.uptoyou_game3.domain.Gquiz;
import com.example.uptoyou_game3.domain.User;
import com.example.uptoyou_game3.dto.DefaultDto;
import com.example.uptoyou_game3.dto.GquizDto;
import com.example.uptoyou_game3.mapper.GquizMapper;
import com.example.uptoyou_game3.repository.GquizRepository;
import com.example.uptoyou_game3.repository.UserRepository;
import com.example.uptoyou_game3.service.GquizService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GquizServiceImpl implements GquizService {

    private final GquizRepository gquizRepository;
    private final GquizMapper gquizMapper;
    private final UserRepository userRepository;

    public GquizServiceImpl(
            GquizRepository gquizRepository
            , GquizMapper gquizMapper
            , UserRepository userRepository
    ) {
        this.gquizRepository = gquizRepository;
        this.gquizMapper = gquizMapper;
        this.userRepository = userRepository;
    }

    public void updatePoint(Long userId){
        // 점수 업데이트
        GquizDto.DetailResDto resDto = gquizMapper.max(GquizDto.ListReqDto.builder().userId(userId).build());
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("no data"));
        Double point = resDto.getPoint();
        user.setGquiz(point);
        userRepository.save(user);
    }

    @Override
    public GquizDto.CreateResDto create(GquizDto.CreateReqDto param){
        GquizDto.CreateResDto res = gquizRepository.save(param.toEntity()).toCreateResDto();
        // 점수 업데이트
        updatePoint(param.getUserId());
        return res;
    }
    @Override
    public void update(GquizDto.UpdateReqDto param){
        Gquiz gquiz = gquizRepository.findById(param.getId()).orElseThrow(()->new RuntimeException("no data"));
        if(param.getPoint() != null){ gquiz.setPoint(param.getPoint()); }

        // 점수 업데이트
        updatePoint(gquiz.getUserId());

        gquizRepository.save(gquiz);
    }
    @Override
    public GquizDto.DetailResDto detail(DefaultDto.DetailReqDto param){
        GquizDto.DetailResDto selectResDto = gquizMapper.detail(param);
        return selectResDto;
    }
    @Override
    public List<GquizDto.DetailResDto> list(GquizDto.ListReqDto param){
        return detailList(gquizMapper.list(param));
    }

    public List<GquizDto.DetailResDto> detailList(List<GquizDto.DetailResDto> list){
        List<GquizDto.DetailResDto> newList = new ArrayList<>();
        for(GquizDto.DetailResDto each : list){
            newList.add(detail(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return newList;
    }
}
