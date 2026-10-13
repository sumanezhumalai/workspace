package com.socius.origin.dto.response;

import com.socius.origin.entity.TaskPriority;

public record TaskResponse(
    Long id,
    String title,
    boolean completed,
    TaskPriority priority,
    boolean routine
) {}
