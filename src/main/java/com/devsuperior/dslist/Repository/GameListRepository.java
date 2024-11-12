package com.devsuperior.dslist.Repository;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
