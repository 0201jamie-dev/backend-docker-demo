package de.conet.backend_docker_demo.controller;

import de.conet.backend_docker_demo.model.Task;
import de.conet.backend_docker_demo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/getTasks")
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/getTasks/{id}")
    public Task getTaskById(@RequestParam @PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("deleteTask/{id}")
    public void deleteTaskById(@PathVariable("id") Long id) {
        taskService.deleteTaskById(id);
    }

    @PostMapping("/newTask")
    public void newTask(@RequestBody Task task) {
        taskService.addTask(task);
    }
}
