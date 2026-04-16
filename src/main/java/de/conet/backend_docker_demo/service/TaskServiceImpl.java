package de.conet.backend_docker_demo.service;

import de.conet.backend_docker_demo.model.Task;
import de.conet.backend_docker_demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Task getTaskById(long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }
}
