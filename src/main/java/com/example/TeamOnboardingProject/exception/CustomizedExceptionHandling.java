package com.example.TeamOnboardingProject.exception;

import com.example.TeamOnboardingProject.exception.customizedException.MemberNotFoundException;
import com.example.TeamOnboardingProject.exception.customizedException.ProjectNotFoundException;
import com.example.TeamOnboardingProject.exception.customizedException.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ProjectNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(ProjectNotFoundException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("Project Not Found");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }
    @ExceptionHandler(value = MemberNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(MemberNotFoundException exception, WebRequest webRequest){
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("Member Not Found");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }
    @ExceptionHandler(value = TaskNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(TaskNotFoundException exception, WebRequest webRequest){
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage("Task Not Found");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

}
