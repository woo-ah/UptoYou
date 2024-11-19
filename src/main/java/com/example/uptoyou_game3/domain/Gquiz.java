package com.example.uptoyou_game3.domain;

import com.example.uptoyou_game3.dto.GquizDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Gquiz {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable=false) private Long userId;
    @Setter @Column(nullable=false) private Double point;

    protected Gquiz(){}
    private Gquiz(Long userId, Double point){
        this.userId = userId;
        this.point = point;
    }
    public static Gquiz of(Long userId, Double point){
        return new Gquiz(userId, point);
    }
    public GquizDto.CreateResDto toCreateResDto() {
        return GquizDto.CreateResDto.builder().id(getId()).build();
    }
}
