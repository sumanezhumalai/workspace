package com.socius.origin.dto.request;

import jakarta.validation.constraints.NotNull;

/**
 * UpdateTaskStatusRequest
 */
public record UpdateTaskStatusRequest(
    @NotNull(message = "Completed status is required")
    Boolean completed
){}