package com.example.uptoyou_game3.domain;

import com.example.uptoyou_game3.dto.GspeedDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Gspeed {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable=false) private Long userId;
    @Setter @Column(nullable=false) private Double level1;
    @Setter @Column(nullable=false) private Double level2;
    @Setter @Column(nullable=false) private Double level3;

    protected Gspeed(){}
    private Gspeed(Long userId, Double level1, Double level2, Double level3){
        this.userId = userId;
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
    }
    public static Gspeed of(Long userId, Double level1, Double level2, Double level3){
        return new Gspeed(userId, level1, level2, level3);
    }
    public GspeedDto.CreateResDto toCreateResDto() {
        return GspeedDto.CreateResDto.builder().id(getId()).build();
    }
}
