package com.socius.origin.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * UpdateTaskRequest
 */
public record UpdateTaskTitleRequest (

    @NotBlank(message = "Title cannot be blank")
    @Size(
        min = 3,
        max = 150,
        message = "Title must be between 3 and 150 characters"
    )
    String title
){}
