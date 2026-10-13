package com.socius.origin.dto.request;

import com.socius.origin.entity.TaskPriority;

public record UpdateTaskRequest (
    String title,
    Boolean completed,
    TaskPriority priority,
    Boolean routine
){}