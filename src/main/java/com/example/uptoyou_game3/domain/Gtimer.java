package com.example.uptoyou_game3.domain;

import com.example.uptoyou_game3.dto.GtimerDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Gtimer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable=false) private Long userId;
    @Setter @Column(nullable=false) private Double point;

    protected Gtimer(){}
    private Gtimer(Long userId, Double point){
        this.userId = userId;
        this.point = point;
    }
    public static Gtimer of(Long userId, Double point){
        return new Gtimer(userId, point);
    }
    public GtimerDto.CreateResDto toCreateResDto() {
        return GtimerDto.CreateResDto.builder().id(getId()).build();
    }
}
