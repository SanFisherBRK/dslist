package com.devsuperior.dslist.services;

import com.devsuperior.dslist.Repository.GameRepository;
import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projectios.GameMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) //Mostra que é somente para leitura e não escrita
    public GameDTO fidById(Long id){
        Game result = gameRepository.findById(id).orElseThrow();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true) //Mostra que é somente para leitura e não escrita
    public List<GameMinDTO> findAll(){
       List<Game> result =  gameRepository.findAll();
       List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // Convertendo List Game em List GameMinDTO
       return dto;
    }

    @Transactional(readOnly = true) //Mostra que é somente para leitura e não escrita
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result =  gameRepository.searchByList(listId);
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // Convertendo List Game em List GameMinDTO
        return dto;
    }


}
