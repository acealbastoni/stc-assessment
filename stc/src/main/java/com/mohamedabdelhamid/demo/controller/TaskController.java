package com.mohamedabdelhamid.demo.controller;
import org.springframework.web.bind.annotation.*;

import com.mohamedabdelhamid.demo.model.Task;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        // Implement logic to retrieve task by ID
        return null;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        // Implement logic to create a new task
        return null;
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        // Implement logic to update an existing task
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        // Implement logic to delete a task
    }
}
