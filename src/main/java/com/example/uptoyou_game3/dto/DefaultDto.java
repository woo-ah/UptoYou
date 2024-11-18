package com.example.uptoyou_game3.dto;

import com.example.uptoyou_game3.domain.Gspeed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class DefaultDto {
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class DetailReqDto {
        private Long id;
    }
}
