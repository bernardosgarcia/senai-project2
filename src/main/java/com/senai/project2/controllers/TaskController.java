package com.senai.project2.controllers;

import com.senai.project2.dtos.request.TaskRequestDto;
import com.senai.project2.dtos.response.TaskResponseDto;
import com.senai.project2.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public ResponseEntity<TaskResponseDto> Insert(TaskRequestDto taskRequestDto) {
        return new ResponseEntity<>(taskService.Insert(taskRequestDto), HttpStatus.OK);
    }
}
