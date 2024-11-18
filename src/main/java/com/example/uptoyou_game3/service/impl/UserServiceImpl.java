package com.example.uptoyou_game3.service.impl;

import com.example.uptoyou_game3.domain.User;
import com.example.uptoyou_game3.dto.UserDto;
import com.example.uptoyou_game3.repository.UserRepository;
import com.example.uptoyou_game3.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
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
}
