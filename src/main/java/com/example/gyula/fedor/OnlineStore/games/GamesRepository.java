package com.example.gyula.fedor.OnlineStore.games;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {
}
