package com.example.uptoyou_game3.dto;

import com.example.uptoyou_game3.domain.Gquiz;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class GquizDto {
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class CreateReqDto {
        private Long id;
        private Long userId;
        private Double point;
        public Gquiz toEntity(){
            return Gquiz.of(getUserId(), getPoint());
        }
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class CreateResDto {
        private Long id;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class UpdateReqDto {
        private Long id;
        private Double point;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ListReqDto {
        private Long userId;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class DetailResDto {
        private Long id;
        private Long userId;
        private Double point;
        private String userUsername;
    }
}