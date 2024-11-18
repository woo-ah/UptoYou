package com.example.uptoyou_game3.service.impl;

import com.example.uptoyou_game3.domain.User;
import com.example.uptoyou_game3.dto.GameDto;
import com.example.uptoyou_game3.mapper.GameMapper;
import com.example.uptoyou_game3.repository.UserRepository;
import com.example.uptoyou_game3.service.GameService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final UserRepository userRepository;
    private final GameMapper gameMapper;

    public GameServiceImpl(
            UserRepository userRepository
            , GameMapper gameMapper

    ) {
        this.userRepository = userRepository;
        this.gameMapper = gameMapper;
    }


    @Override
    public void updateLevel1(GameDto.GameReqDto param) {
        System.out.println("update");
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        user.setFirstTime(param.getTime());
        userRepository.save(user);
    }

    @Override
    public void updateLevel2(GameDto.GameReqDto param) {
        System.out.println("update");
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        user.setSecondTime(param.getTime());
        userRepository.save(user);
    }

    @Override
    public void updateLevel3(GameDto.GameReqDto param) {
        System.out.println("update");
        User user = userRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        user.setThirdTime(param.getTime());

        double firstTime = Double.parseDouble(user.getFirstTime());
        double secondTime = Double.parseDouble(user.getSecondTime());
        double thirdTime = Double.parseDouble(user.getThirdTime());

        user.setAvgTime(String.valueOf((firstTime+secondTime+thirdTime)/3));
        userRepository.save(user);
    }


    @Override
    public GameDto.UsernameResDto userName(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        GameDto.UsernameResDto dto = new GameDto.UsernameResDto();
        dto.setUsername(user.getUsername());
        return dto;
    }



    @Override
    public GameDto.CheckResDto check(GameDto.CheckReqDto param){
        User user = userRepository.findByUsername(param.getUsername());
        GameDto.CheckResDto dto = new GameDto.CheckResDto();
        if (user == null) {
            dto.setReal(false);

        } else {
            dto.setReal(true);
        }
        return dto;
    }

    @Override
    public List<GameDto.AwardResDto> getAllNonNullAvgTime() {
        return gameMapper.listAll();
    }
}
