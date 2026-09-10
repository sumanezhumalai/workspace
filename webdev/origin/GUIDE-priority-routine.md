# Adding Priority (enum) and isRoutine (daily auto-renew) to Task

## Overview

Two new fields on `Task`:
- **priority** — `TaskPriority` enum: `HIGH`, `MEDIUM`, `NORMAL` (default `NORMAL`)
- **isRoutine** — `boolean`, default `false`; when `true`, the task auto-resets to `completed = false` daily

---

## 1. Create `TaskPriority` enum

**New file:** `src/main/java/com/socius/origin/entity/TaskPriority.java`

```java
package com.socius.origin.entity;

public enum TaskPriority {
    HIGH,
    MEDIUM,
    NORMAL
}
```

Jackson automatically deserializes string values to this enum. Invalid values produce a 400 error before the controller is reached (no custom validator needed).

---

## 2. Update `Task.java` — entity fields

| Field | Type | Default |
|-------|------|---------|
| `priority` | `TaskPriority` | `TaskPriority.NORMAL` |
| `isRoutine` | `boolean` | `false` |

### Changes needed:

**Fields:**
```java
private TaskPriority priority = TaskPriority.NORMAL;
private boolean isRoutine = false;
```

**Constructor — add new params:**
```java
public Task(Long id, String title, boolean completed,
            TaskPriority priority, boolean isRoutine) {
    // existing
    this.priority = priority;
    this.isRoutine = isRoutine;
}
```

Keep the old 3-param constructor for backward compat (or drop it if you migrate all call sites).

**Getters/setters:**
```java
public TaskPriority getPriority() { return priority; }
public void setPriority(TaskPriority priority) { this.priority = priority; }
public boolean isRoutine() { return isRoutine; }
public void setRoutine(boolean isRoutine) { this.isRoutine = isRoutine; }
```

---

## 3. Update `CreateTaskRequest.java` — DTO with validation

Add fields with `@NotNull` to enforce required:

```java
@NotNull(message = "Priority is required")
private TaskPriority priority;

private boolean isRoutine;  // optional, defaults to false
```

Add getters/setters.

> Jackson deserialization of an invalid string like `"URGENT"` into `TaskPriority` throws `HttpMessageNotReadableException` → you may want to add a handler in `GlobalExceptionHandler` for a cleaner response.

---

## 4. Update `TaskResponse.java` — record

```java
public record TaskResponse(
    Long id,
    String title,
    boolean completed,
    TaskPriority priority,
    boolean isRoutine
) {}
```

---

## 5. Update `TaskMapper.java` — mapping

Add the new fields to the `toResponse` call:

```java
return new TaskResponse(
    task.getId(),
    task.getTitle(),
    task.isCompleted(),
    task.getPriority(),
    task.isRoutine()
);
```

---

## 6. Update `TaskService.java` — seed data & createTask

**Seed tasks:**
```java
tasks.add(new Task(1L, "Learn Spring Boot", false, TaskPriority.HIGH, true));
tasks.add(new Task(2L, "Learn Dependency Injection", true, TaskPriority.MEDIUM, false));
// ...
```

**createTask:**
```java
public TaskResponse createTask(CreateTaskRequest request) {
    Long id = (long) (tasks.size() + 1);
    Task task = new Task(
        id,
        request.getTitle(),
        request.isCompleted(),
        request.getPriority(),
        request.isRoutine()
    );
    tasks.add(task);
    return TaskMapper.toResponse(task);
}
```

---

## 7. Daily auto-renew for routine tasks

Add `@EnableScheduling` on `OriginApplication.java`:

```java
@SpringBootApplication
@EnableScheduling
public class OriginApplication { ... }
```

Add a scheduled method in `TaskService.java`:

```java
import org.springframework.scheduling.annotation.Scheduled;
// ...

@Scheduled(cron = "0 0 0 * * ?")  // midnight every day
public void resetRoutineTasks() {
    tasks.stream()
         .filter(Task::isRoutine)
         .forEach(task -> task.setcompleted(false));
}
```

---

## 8. (Optional) Better error response for invalid enum values

In `GlobalExceptionHandler.java`, add:

```java
@ExceptionHandler(HttpMessageNotReadableException.class)
public ResponseEntity<ApiResponse<?>> handleInvalidEnum(
    HttpMessageNotReadableException ex
) {
    return ResponseEntity
        .badRequest()
        .body(ApiResponseBuilder.error(
            "Invalid value: priority must be one of HIGH, MEDIUM, NORMAL", null
        ));
}
```

Import: `com.fasterxml.jackson.databind.exc.InvalidFormatException` (the cause of `HttpMessageNotReadableException`).

---

## 9. Future: JPA / database persistence

The project already has `spring-boot-starter-data-jpa` and H2 in the classpath. When you switch from in-memory list to a real repository:

- Annotate `Task` with `@Entity`, `@Id`, `@GeneratedValue`
- Use `@Enumerated(EnumType.STRING)` on the `priority` field
- Create a `TaskRepository extends JpaRepository<Task, Long>`
- Inject the repository into `TaskService` and replace all list operations

---

## Summary of files to touch

| File | Action |
|------|--------|
| `entity/TaskPriority.java` | **Create** — new enum |
| `entity/Task.java` | **Edit** — add fields + constructor + getters/setters |
| `dto/request/CreateTaskRequest.java` | **Edit** — add fields + validation |
| `dto/request/TaskResponse.java` | **Edit** — add fields to record |
| `mapper/TaskMapper.java` | **Edit** — map new fields |
| `service/TaskService.java` | **Edit** — seed data, createTask, add @Scheduled |
| `OriginApplication.java` | **Edit** — add @EnableScheduling |
| `exception/GlobalExceptionHandler.java` | **Edit** (optional) — handle invalid enum |
