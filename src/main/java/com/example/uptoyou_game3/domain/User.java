package com.example.uptoyou_game3.domain;

import com.example.uptoyou_game3.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable=false, unique=true)
    private String username;

    @Setter
    private String firstTime;

    @Setter
    private String secondTime;

    @Setter
    private String thirdTime;

    @Setter String avgTime;

    protected User(){}
    private User(String username){
        this.username = username;
    }

    public static User of(String username){
        return new User(username);
    }

    public UserDto.CreateResDto toCreateResDto() {
        return UserDto.CreateResDto.builder().id(getId()).build();
    }
}
