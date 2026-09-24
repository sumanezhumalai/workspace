package com.socius.origin.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.socius.origin.service.TaskService;

/**
 * TaskSchedular
 */
 @Component
public class TaskSchedular {

	private TaskService taskService;

	public TaskSchedular ( TaskService taskService){
	    this.taskService = taskService;
	}

	@Scheduled(cron = "0 0 0 * * ?")
	public void resetRoutineTasks(){
        taskService.resetRoutineTasks();
	}
	
}