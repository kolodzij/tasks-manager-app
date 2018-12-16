package com.crudapi.tasks.scheduler;

import com.crudapi.tasks.config.AdminConfig;
import com.crudapi.tasks.domain.Mail;
import com.crudapi.tasks.repository.TaskRepository;
import com.crudapi.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component

public class EmailScheduler {

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    private static final String SUBJECT = "Tasks: Once a day email";

    @Scheduled(cron = "0 0 10 * * *") //fixedDelay = 10000
    public void sendInformationEmail() {
        long size = taskRepository.count();
        String taskLabel = "task";
        if (size > 1) taskLabel = "tasks";
        simpleEmailService.send(new Mail(adminConfig.getAdminMail(), "", SUBJECT,
                "Currently in database you got: " + size + " " + taskLabel));
    }
}
