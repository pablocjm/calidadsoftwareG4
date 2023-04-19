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
    
    @Test
    public void testDeleteTask(){
        //Borrar todas las Task
        CRUDTask.deleteAllTasks();

        CRUDTask.addTask(new Task("hola", "que tal", new Date()));
        List<Task> tasks = CRUDTask.getAllTasks();
        int id = tasks.get(0).getId();

        CRUDTask.deleteTask(id);
        tasks = CRUDTask.getAllTasks();
        Assert.assertEquals(0, tasks.size());
    }

    @Test
    public void testUpdateTask(){
        //Borrar todas las Task
        CRUDTask.deleteAllTasks();

        CRUDTask.addTask(new Task("hola", "que tal", new Date()));
        List<Task> tasks = CRUDTask.getAllTasks();
        Task newTask = new Task("hey", "esto es nuevo", new Date());
        CRUDTask.updateTask(tasks.get(0), newTask);

        Assert.assertEquals("esto es nuevo", tasks.get(0).getDescription());
        Assert.assertEquals("hey", tasks.get(0).getTitle());
    }

}
