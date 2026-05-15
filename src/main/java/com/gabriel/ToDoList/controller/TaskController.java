package com.gabriel.ToDoList.controller;

import com.gabriel.ToDoList.objectvalue.StatusEnum;
import com.gabriel.ToDoList.entity.TaskEntity;
import com.gabriel.ToDoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public void saveTask(@RequestBody TaskEntity task)
    {
        this.taskService.saveTask(task);
    }

    @GetMapping
    public List<TaskEntity> getAllTask() {
        return this.taskService.getAll();
    }

    @PutMapping("{id}")
    public void toggleStatusTask(@PathVariable int id) {
        this.taskService.toggleStatus(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.taskService.delete(id);
    }

    @GetMapping("filter")
    public List<TaskEntity> getTask(@RequestParam(value = "status") StatusEnum status) {
       return this.taskService.filterByStatus(status);
    }
}
