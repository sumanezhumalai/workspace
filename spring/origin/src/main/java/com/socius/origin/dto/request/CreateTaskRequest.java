package com.socius.origin.dto.request;

import com.socius.origin.entity.TaskPriority;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTaskRequest {

    @NotBlank(message = "Title cannot be blank")
    @Size(
        min = 3,
        max = 150,
        message = "Title must be between 3 and 150 characters"
    )
    private String title;

    private boolean completed;

    private TaskPriority priority;

    private boolean routine;

    public CreateTaskRequest() {}

    CreateTaskRequest(
        String title,
        boolean completed,
        TaskPriority priority,
        boolean routine
    ) {
        this.title = title;
        this.completed = completed;
        this.priority = priority;
        this.routine = routine;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public boolean isRoutine() {
        return routine;
    }

    public void setRoutine(boolean routine) {
        this.routine = routine;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setcompleted(boolean completed) {
        this.completed = completed;
    }
}
