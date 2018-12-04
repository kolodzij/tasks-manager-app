package com.springintro.springintro.portfolio;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class TaskList {

    private List<String> tasksList = new ArrayList<>();;


    public List<String> addTask(String task) {
        tasksList.add(task);
        return tasksList;
    }

    public List<String> getTasksList() {
        return tasksList;
    }
}
