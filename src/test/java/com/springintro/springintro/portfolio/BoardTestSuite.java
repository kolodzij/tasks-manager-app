package com.springintro.springintro.portfolio;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BoardTestSuite {

    @Autowired
    Board board;

    @Test
    public void testTaskAdd() {

        //Given
        board.addDoneList("DoneListTask");
        board.addInProgressList("InProgressTask");
        board.addToDoList("ToDoList");

        Assert.assertEquals(1, board.getDoneList().getTasksList().size());


    }


}
