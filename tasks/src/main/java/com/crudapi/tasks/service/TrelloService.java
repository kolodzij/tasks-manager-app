package com.crudapi.tasks.service;

import com.crudapi.tasks.config.AdminConfig;
import com.crudapi.tasks.domain.CreatedTrelloCard;
import com.crudapi.tasks.domain.Mail;
import com.crudapi.tasks.domain.TrelloBoardDto;
import com.crudapi.tasks.domain.TrelloCardDto;
import com.crudapi.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class TrelloService {

    @Autowired
    private TrelloClient trelloClient;

    @Autowired
    private SimpleEmailService emailService;

    @Autowired
    private AdminConfig adminConfig;

    private static final String SUBJECT = "Tasks: New Trello card";

    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCard createdTrelloCard(final TrelloCardDto trelloCardDto) {

        CreatedTrelloCard newCard = trelloClient.createNewCard(trelloCardDto);

        ofNullable(newCard).ifPresent(card -> emailService.send(new Mail(
                adminConfig.getAdminMail(),
                "",
                SUBJECT,
                "New card: " + card.getName() + " has been created on your Trello account")));

        return newCard;
    }


}
