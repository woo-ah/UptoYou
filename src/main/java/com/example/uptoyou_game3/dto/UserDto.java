package com.example.uptoyou_game3.dto;

import com.example.uptoyou_game3.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class UserDto {

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class CreateReqDto {
        private String username;

        public User toEntity(){
            return User.of(getUsername());
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class CreateResDto {
        private Long id;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ListReqDto {
        private Long id;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class DetailResDto {
        private Long id;
        private String username;
        private Double point;
        private Double gquiz;
        private Double gspeed;
        private Double gtimer;
    }

}
