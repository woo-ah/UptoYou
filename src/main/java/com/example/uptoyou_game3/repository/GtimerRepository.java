package com.example.uptoyou_game3.repository;

import com.example.uptoyou_game3.domain.Gtimer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GtimerRepository extends JpaRepository<Gtimer, Long> {
}
