package com.user.task.mangement.repository;

import java.util.List;

import com.user.task.mangement.entity.Task;
import com.user.task.mangement.response.enums.PriorityLevel;

public interface TaskRepository {

	Task save(Task task);
    Task findById(Long id);
    List<Task> findByProjectId(Long projectId);
    List<Task> findByPriority(PriorityLevel priority);
    List<Task> findAll();
    void deleteById(Long id);
}
