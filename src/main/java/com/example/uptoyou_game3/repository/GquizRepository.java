package com.example.uptoyou_game3.repository;

import com.example.uptoyou_game3.domain.Gquiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GquizRepository extends JpaRepository<Gquiz, Long> {
}
