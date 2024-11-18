package com.example.uptoyou_game3.dto;

import com.example.uptoyou_game3.domain.Gspeed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class GspeedDto {
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class CreateReqDto {
        private Long id;
        private Long userId;
        private Double level1;
        /*
        private Double level2;
        private Double level3;
        */
        public Gspeed toEntity(){
            return Gspeed.of(getUserId(), getLevel1(), 0.0, 0.0);
        }
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class CreateResDto {
        private Long id;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class UpdateReqDto {
        private Long id;
        private Double level1;
        private Double level2;
        private Double level3;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ListReqDto {
        private Long userId;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class DetailResDto {
        private Long id;
        private Long userId;
        private Double level1;
        private Double level2;
        private Double level3;
        private Double level;
        private String userUsername;
    }
}
