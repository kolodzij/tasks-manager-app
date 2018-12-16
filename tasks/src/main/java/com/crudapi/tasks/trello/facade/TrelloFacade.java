package com.crudapi.tasks.trello.facade;

import com.crudapi.tasks.domain.*;
import com.crudapi.tasks.mapper.TrelloMapper;
import com.crudapi.tasks.service.TrelloService;
import com.crudapi.tasks.trello.validator.TrelloValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrelloFacade {


    @Autowired
    private TrelloService trelloService;
    @Autowired
    private TrelloMapper trelloMapper;
    @Autowired
    private TrelloValidator trelloValidator;

    public List<TrelloBoardDto> fetchTrelloBoards() {
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards((trelloService.fetchTrelloBoards()));
        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(trelloBoards);
        return trelloMapper.mapToBoardsDto(filteredBoards);
    }

    public CreatedTrelloCardDto createCard(final TrelloCardDto trelloCardDto) {
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        trelloValidator.validateCard(trelloCard);
        return trelloService.createdTrelloCard(trelloMapper.mapToCardDto(trelloCard));
    }

}
