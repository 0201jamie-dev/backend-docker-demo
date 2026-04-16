package de.conet.backend_docker_demo.service;

import de.conet.backend_docker_demo.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(long id);
    void deleteTaskById(long id);
    void addTask(Task task);
}
