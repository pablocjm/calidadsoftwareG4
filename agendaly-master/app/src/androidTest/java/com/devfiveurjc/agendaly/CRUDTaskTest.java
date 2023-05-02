package com.devfiveurjc.agendaly;

import com.devfiveurjc.agendaly.crud.CRUDTask;
import com.devfiveurjc.agendaly.models.Task;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class CRUDTaskTest {

    @Test
    public void testCreateTask (){
        //Borrar todas las Task
        CRUDTask.deleteAllTasks();

        CRUDTask.addTask(new Task("hola", "que tal", "media", new Date()));
        List<Task> tasks = CRUDTask.getAllTasks();
        Assert.assertEquals(1, tasks.size());
        Assert.assertEquals("hola", tasks.get(0).getTitle());
        Assert.assertEquals("que tal", tasks.get(0).getDescription());
        Assert.assertEquals("media", tasks.get(0).getImportance());
        Assert.assertEquals(date, tasks.get(0).getDate());
    }
    
    @Test
    public void testDeleteTask(){
        //Borrar todas las Task
        CRUDTask.deleteAllTasks();

        CRUDTask.addTask(new Task("hola", "que tal", "media", new Date()));
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

        CRUDTask.addTask(new Task("hola", "que tal", "alta", new Date()));
        List<Task> tasks = CRUDTask.getAllTasks();
        Task newTask = new Task("hey", "esto es nuevo", "media", new Date());
        CRUDTask.updateTask(tasks.get(0), newTask);

        Assert.assertEquals("esto es nuevo", tasks.get(0).getDescription());
        Assert.assertEquals("hey", tasks.get(0).getTitle());
        Assert.assertEquals("media", tasks.get(0).getImportance());
    }

    //Test implementado para el TDD
    @Test
    public void testAddImportance (){
        //Borrar todas las Task
        CRUDTask.deleteAllTasks();

        CRUDTask.addTask(new Task("hola", "que tal", "media", new Date()));
        List<Task> tasks = CRUDTask.getAllTasks();
        Assert.assertEquals("media", tasks.get(0).getImportance());
    }
}
