package org.revature.RevTaskManagement.controller;

import org.revature.RevTaskManagement.models.*;
import org.revature.RevTaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/by-username/{username}")
    public List<Task> getTasksByUsername(@PathVariable String username) {
        return taskService.getTasksByUsername(username);
    }

    @PutMapping("/update-milestone")
    public Task updateTaskMilestone(
            @RequestParam int taskId,
            @RequestParam int milestoneId) {
        return taskService.updateTaskMilestone(taskId, milestoneId);
    }

    @GetMapping("/user/{userId}/project/{projectId}")
    public ResponseEntity<List<Task>> getTasksByUserIdAndProjectId(@PathVariable int userId, @PathVariable int projectId) {
        List<Task> tasks = taskService.getTasksByUserIdAndProjectId(userId, projectId);
        return ResponseEntity.ok(tasks);
    }

}