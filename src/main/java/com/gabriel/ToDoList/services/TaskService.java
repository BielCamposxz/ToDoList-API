package com.gabriel.ToDoList.services;

import com.gabriel.ToDoList.objectvalue.StatusEnum;
import com.gabriel.ToDoList.entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TaskService {
    private final LinkedList<TaskEntity> tasks = new LinkedList<>();

    public void toggleStatus(int id) {
        this.tasks.stream().filter(x -> x.getId() == id).findFirst().ifPresent(TaskEntity::toggleStatus);
    }

    public void saveTask(TaskEntity task) {
        if(this.tasks.isEmpty()) task.setId(1);
        else task.setId(tasks.getLast().getId() + 1);

        this.tasks.add(new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getStatus()
        ));
    }

    public List<TaskEntity> getAll() {
        return this.tasks;
    }

    public void delete(int id) {
        this.tasks.removeIf(s -> s.getId() == id);
    }

    public List<TaskEntity> filterByStatus(StatusEnum status) {
        return  this.tasks.stream().filter(x -> x.getStatus() == status).toList();
    }
}
