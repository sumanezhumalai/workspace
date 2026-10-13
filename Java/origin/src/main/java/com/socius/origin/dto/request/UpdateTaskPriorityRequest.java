package com.socius.origin.dto.request;

import com.socius.origin.entity.TaskPriority;

import jakarta.validation.constraints.NotNull;

/**
 * UpdateTaskStatusRequest
 */
public record UpdateTaskPriorityRequest(
    @NotNull(message = "Priority status is required")
    TaskPriority priority
){}