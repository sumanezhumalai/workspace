package com.socius.origin.exception.custom;

/**
 * TaskNotFoundException
 */
public class TaskNotFoundException extends RuntimeException {

    TaskNotFoundException () {
        super("Task Not Found.");
    }

    public TaskNotFoundException(Long id)
    {
        super("Task not found with id: " + id);
    }

    public TaskNotFoundException (String Message){
        super(Message);
    }
	
}