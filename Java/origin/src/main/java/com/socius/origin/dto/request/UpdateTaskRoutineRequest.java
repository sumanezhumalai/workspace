package com.socius.origin.dto.request;

import jakarta.validation.constraints.NotNull;

/**
 * UpdateTaskStatusRequest
 */
public record UpdateTaskRoutineRequest(
    @NotNull(message = "Routine status is required")
    Boolean routine
){}