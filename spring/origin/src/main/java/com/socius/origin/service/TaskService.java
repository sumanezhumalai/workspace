package com.socius.origin.service;

import com.socius.origin.dto.request.CreateTaskRequest;
import com.socius.origin.dto.request.UpdateTaskPriorityRequest;
import com.socius.origin.dto.request.UpdateTaskRequest;
import com.socius.origin.dto.request.UpdateTaskRoutineRequest;
import com.socius.origin.dto.request.UpdateTaskStatusRequest;
import com.socius.origin.dto.response.TaskResponse;
import com.socius.origin.entity.Task;
import com.socius.origin.entity.TaskPriority;
import com.socius.origin.exception.custom.*;
import com.socius.origin.mapper.TaskMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<Task>();

    private Long nextId = 1L;

    public TaskService() {
        tasks.add(
            new Task(nextId++, "L++earn Spring Boot", false, TaskPriority.NORMAL, true)
        );
        tasks.add(
            new Task(
                nextId++,
                "Learn Dependency Injection",
                true,
                TaskPriority.HIGH,
                false
            )
        );
        tasks.add(
            new Task(nextId++, "Build REST API", false, TaskPriority.MEDIUM, true)
        );
        tasks.add(new Task(nextId++, "Learn JPA", false, TaskPriority.NORMAL, false));
    }

    private Task findTask(Long id) {
        return tasks
            .stream()
            .filter(t -> t.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public List<TaskResponse> getAllTasks() {
        return tasks
            .stream()
            .map(TaskMapper::toResponse) // equivalent to .map(task -> TaskMapper.toResponse(task))
            .toList();
    }

    public TaskResponse getTaskById(Long id) {
        return TaskMapper.toResponse(findTask(id));
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public List<TaskResponse> getCompletedTasks() {
        return tasks
            .stream()
            .filter(Task::isCompleted) // equivalent to .map(task -> task.isComepleted(task))
            .map(TaskMapper::toResponse) // equivalent to .map(task -> TaskMapper.toResponse(task))
            .toList();
    }

    public TaskResponse createTask(CreateTaskRequest request) {
        Long id = nextId++;
        Task task = new Task(
            id,
            request.getTitle(),
            request.isCompleted(),
            request.getPriority() != null
                ? request.getPriority()
                : TaskPriority.NORMAL,
            request.isRoutine()
        );

        tasks.add(task);
        return TaskMapper.toResponse(task);
    }

    public TaskResponse updateTask(Long id, UpdateTaskRequest request) {
        Task task = findTask(id);

        task.setTitle(
            request.title() != null ? request.title() : task.getTitle()
        );
        task.setCompleted(
            request.completed() != null
                ? request.completed()
                : task.isCompleted()
        );
        task.setPriority(
            request.priority() != null ? request.priority() : task.getPriority()
        );
        task.setRoutine(
            request.routine() != null ? request.routine() : task.isRoutine()
        );

        return TaskMapper.toResponse(task);
    }

    public TaskResponse updateTaskStatus(
        Long id,
        UpdateTaskStatusRequest request
    ) {
        Task task = findTask(id);

        task.setCompleted(request.completed());

        return TaskMapper.toResponse(task);
    }

    public TaskResponse updateTaskPriority(
        Long id,
        UpdateTaskPriorityRequest request
    ) {
        Task task = findTask(id);

        task.setPriority(request.priority());

        return TaskMapper.toResponse(task);
    }

    public TaskResponse updateTaskRoutine(
        Long id,
        UpdateTaskRoutineRequest request
    ) {
        Task task = findTask(id);

        task.setRoutine(request.routine());

        return TaskMapper.toResponse(task);
    }

    public TaskResponse deleteTask(Long id) {
        Task task = findTask(id);

        tasks.remove(task);

        return TaskMapper.toResponse(task);
    }

    //Schedule Runners
    public void resetRoutineTasks() {
        tasks
            .stream()
            .filter(Task::isRoutine)
            .forEach(task -> task.setCompleted(false));
    }
}
