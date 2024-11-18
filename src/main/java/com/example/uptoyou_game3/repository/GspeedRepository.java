package com.example.uptoyou_game3.repository;

import com.example.uptoyou_game3.domain.Gspeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GspeedRepository extends JpaRepository<Gspeed, Long> {
}
