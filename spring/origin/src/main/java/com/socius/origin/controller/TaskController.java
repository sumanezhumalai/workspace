package com.socius.origin.controller;

import com.socius.origin.dto.request.CreateTaskRequest;
import com.socius.origin.dto.request.UpdateTaskPriorityRequest;
import com.socius.origin.dto.request.UpdateTaskRequest;
import com.socius.origin.dto.request.UpdateTaskRoutineRequest;
import com.socius.origin.dto.request.UpdateTaskStatusRequest;
import com.socius.origin.dto.response.ApiResponse;
import com.socius.origin.dto.response.ApiResponseBuilder;
import com.socius.origin.dto.response.TaskResponse;
import com.socius.origin.service.TaskService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ApiResponse<List<TaskResponse>> getAllTask() {
        return ApiResponseBuilder.success(
            "Tasks retrieved successfully",
            taskService.getAllTasks()
        );
    }

    @GetMapping("/count")
    public ResponseEntity<ApiResponse<Integer>> getTaskCount() {
        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponseBuilder.success(
                "Count retrieved successfully",
                taskService.getTaskCount()
            )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> getTaskById(
        @PathVariable Long id
    ) {
        TaskResponse taskResponse = taskService.getTaskById(id);

        // if (task == null) {  //Handles at Service layer
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponseBuilder.error("Task retrieval failed", "No task found with id " + id));
        // }

        return ResponseEntity.ok(
            ApiResponseBuilder.success(
                "Task retrieved successfully",
                taskResponse
            )
        );
    }

    @GetMapping("/completed")
    public ResponseEntity<ApiResponse<List<TaskResponse>>> getCompletedTasks() {
        List<TaskResponse> completedTasks = taskService.getCompletedTasks();
        return ResponseEntity.ok(
            ApiResponseBuilder.success(
                "Task retrieved successfully",
                completedTasks
            )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TaskResponse>> createTask(
        @Valid @RequestBody CreateTaskRequest request
    ) {
        TaskResponse taskResponse = taskService.createTask(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(
            ApiResponseBuilder.success(
                "Task created successfully",
                taskResponse
            )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskResponse>> updateTask(
        @PathVariable Long id,
        @RequestBody UpdateTaskRequest request
    ) {
        TaskResponse taskResponse = taskService.updateTask(id, request);

        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponseBuilder.success(
                "The Task with Id: " + id + " updated Successfully",
                taskResponse
            )
        );
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<TaskResponse>> updateTaskStatus(
        @PathVariable Long id,
        @RequestBody UpdateTaskStatusRequest request
    ) {
        TaskResponse taskResponse = taskService.updateTaskStatus(id, request);

        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponseBuilder.success(
                "The Task with Id: " + id + " status updated Successfully",
                taskResponse
            )
        );
    }

    @PatchMapping("/{id}/priority")
    public ResponseEntity<ApiResponse<TaskResponse>> updateTaskPriority(
        @PathVariable Long id,
        @RequestBody UpdateTaskPriorityRequest request
    ) {
        TaskResponse taskResponse = taskService.updateTaskPriority(id, request);

        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponseBuilder.success(
                "The Task with Id: " + id + " Priority updated Successfully",
                taskResponse
            )
        );
    }

    @PatchMapping("/{id}/routine")
    public ResponseEntity<ApiResponse<TaskResponse>> updateTaskRoutine(
        @PathVariable Long id,
        @RequestBody UpdateTaskRoutineRequest request
    ) {
        TaskResponse taskResponse = taskService.updateTaskRoutine(id, request);

        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponseBuilder.success(
                "The Task with Id: " + id + " Routine updated Successfully",
                taskResponse
            )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskResponse>> deleteTask(
        @PathVariable Long id
    ) {
        TaskResponse taskResponse = taskService.deleteTask(id);

        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponseBuilder.success(
                "Task with id " + id + " deleted successfullu",
                taskResponse
            )
        );
    }
}
