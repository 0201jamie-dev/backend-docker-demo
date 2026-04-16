package de.conet.backend_docker_demo.repository;

import de.conet.backend_docker_demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll();
    Task findById(long id);
}
