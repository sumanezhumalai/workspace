package com.socius.origin.mapper;

import com.socius.origin.dto.response.TaskResponse;
import com.socius.origin.entity.Task;

/**
 * TaskMapper
 */
public class TaskMapper {

    TaskMapper() {}

    public static TaskResponse toResponse(Task task) {
        return new TaskResponse(
            task.getId(),
            task.getTitle(),
            task.isCompleted(),
            task.getPriority(),
            task.isRoutine()
        );
    }
}
