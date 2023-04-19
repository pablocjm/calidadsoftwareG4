package com.devfiveurjc.agendaly;

import org.junit.Assert;
import org.junit.Test;

import com.devfiveurjc.agendaly.crud.CRUDTask;
import com.devfiveurjc.agendaly.models.Task;

import java.util.Date;
import java.util.List;

public class CRUDTaskTest {

    @Test
    public void testCreateTask (){
        //Borrar todas las Task
        CRUDTask.deleteAllTasks();

        CRUDTask.addTask(new Task("hola", "que tal", new Date()));
        List<Task> tasks = CRUDTask.getAllTasks();
        Assert.assertEquals(1, tasks.size());
        Assert.assertEquals("hola", tasks.get(0).getTitle());
    }

}
