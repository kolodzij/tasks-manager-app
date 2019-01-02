package com.crudapi.tasks.controller;

import com.crudapi.tasks.domain.CreatedTrelloCardDto;
import com.crudapi.tasks.domain.TrelloBoardDto;
import com.crudapi.tasks.domain.TrelloCardDto;
import com.crudapi.tasks.service.TrelloService;
import com.crudapi.tasks.trello.facade.TrelloFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

//    @Autowired
//    private TrelloService trelloService;

    @Autowired
    private TrelloFacade trelloFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/boards")
    public List<TrelloBoardDto> getTrelloBoards() {

        return trelloFacade.fetchTrelloBoards();

    /*
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
        trelloBoards.forEach(trelloBoardDto ->  {
            System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
            System.out.println("This board contains lists: ");
            trelloBoardDto.getLists().forEach(trelloList ->
                    System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));

        });
*/


//        trelloBoards.stream()
//                .filter(board -> board.getId().isPresent() && board.getName().isPresent() && board.getName().contains("Kodilla"))
//                .forEach(trelloBoardDto -> {
//                    System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());
//                    System.out.println("This board contains lists: ");
//                    trelloBoardDto.getLists().forEach(trelloList ->
//                            System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
//                });

    }


    @RequestMapping(method=RequestMethod.POST, value = "/cards")
    public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloFacade.createCard(trelloCardDto);
    }





}
