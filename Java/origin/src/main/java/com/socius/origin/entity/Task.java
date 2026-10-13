package com.socius.origin.entity;

public class Task {

    private Long id;
    private String title;
    private boolean completed;
    private TaskPriority priority = TaskPriority.NORMAL;
    private boolean routine = false;

    public Task(
        Long id,
        String title,
        boolean completed,
        TaskPriority priority,
        boolean routine
    ) {
        this.id = id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setcompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}
