package com.devfiveurjc.agendaly.crud;

import com.devfiveurjc.agendaly.models.Task;

import java.util.List;

import io.realm.Realm;


public class CRUDTask {

    private static final Realm realm = Realm.getDefaultInstance();

    private static int calculateIndex() {
        Number currentId = realm.where(Task.class).max("id");
        int nextId = 0;
        if (currentId != null) {
            nextId = currentId.intValue() + 1;
        }
        return nextId;
    }

    public static void addTask(Task task) {
        realm.executeTransaction(realm -> {
            int index = CRUDTask.calculateIndex();
            Task realmTask = realm.createObject(Task.class, index);
            setRealmTask(realmTask, task);
        });
    }

    public static void updateTaskCheck(Task realmTask, boolean check) {
        realm.executeTransaction(realm -> {
            realmTask.setCheck(check);
            realm.insertOrUpdate(realmTask);
        });
    }

    public static void updateTask(Task realmTask, Task task) {
        realm.executeTransaction(realm -> {
            setRealmTask(realmTask, task);
        });
    }

    private static void setRealmTask(Task realmTask, Task task) {
        realmTask.setTitle(task.getTitle());
        realmTask.setDescription(task.getDescription());
        realmTask.setDate(task.getDate());
        realmTask.setCheck(task.isCheck());
    }

    public static void deleteAllTasks() {
        realm.executeTransaction(realm -> {
            List<Task> realmTasks = getAllTasks();
            for (Task realmTask : realmTasks) {
                realmTask.deleteFromRealm();
            }
        });
    }

    public static void deleteTask(int id) {
        realm.executeTransaction(realm -> {
            Task realmTask = getTask(id);
            realmTask.deleteFromRealm();
        });
    }

    public static boolean isEmpty() {
        return realm.where(Task.class).findFirst() == null;
    }

    public static List<Task> getAllTasks() {
        return realm.where(Task.class).findAll();
    }

    public static Task getTask(int id) {
        return realm.where(Task.class).equalTo("id", id).findFirst();
    }

}
