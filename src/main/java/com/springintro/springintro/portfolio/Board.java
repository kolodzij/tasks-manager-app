package com.springintro.springintro.portfolio;

import org.springframework.stereotype.Component;


public class Board {

    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }


    public void addToDoList(String task) {
        this.toDoList.addTask(task);
    }

    public void addInProgressList(String task) {
        this.inProgressList.addTask(task);
    }

    public void addDoneList(String task) {
        this.doneList.addTask(task);
    }


    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }
}

