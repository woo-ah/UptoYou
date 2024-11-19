package com.example.uptoyou_game3.service.impl;

import com.example.uptoyou_game3.domain.User;
import com.example.uptoyou_game3.dto.UserDto;
import com.example.uptoyou_game3.dto.UserDto;
import com.example.uptoyou_game3.mapper.UserMapper;
import com.example.uptoyou_game3.repository.UserRepository;
import com.example.uptoyou_game3.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserServiceImpl(
            UserRepository userRepository
            ,UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto.CreateResDto create(UserDto.CreateReqDto param) {
        System.out.println("create");
        User user = userRepository.findByUsername(param.getUsername());
        if(user != null){
            return UserDto.CreateResDto.builder().id((long)-200).build();
            //throw new RuntimeException("already exist");
        }
        return userRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public List<UserDto.DetailResDto> list(UserDto.ListReqDto param){
        return userMapper.list(param);
    }
}
