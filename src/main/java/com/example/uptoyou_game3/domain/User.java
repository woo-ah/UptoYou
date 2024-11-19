package com.example.uptoyou_game3.domain;

import com.example.uptoyou_game3.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable=false, unique=true) private String username;

    @Setter @Column(nullable=false) private Double gspeed;
    @Setter @Column(nullable=false) private Double gtimer;
    @Setter @Column(nullable=false) private Double gquiz;

    protected User(){}
    private User(String username, Double gspeed, Double gtimer, Double gquiz){
        this.username = username;
        this.gspeed = gspeed;
        this.gtimer = gtimer;
        this.gquiz = gquiz;
    }
    public static User of(String username){
        return new User(username, 0.0, 0.0, 0.0);
    }
    public UserDto.CreateResDto toCreateResDto() {
        return UserDto.CreateResDto.builder().id(getId()).build();
    }
}
