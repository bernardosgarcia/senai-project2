package com.senai.project2.controllers;

import com.senai.project2.dtos.request.TaskRequestDto;
import com.senai.project2.dtos.response.TaskResponseDto;
import com.senai.project2.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public ResponseEntity<TaskResponseDto> Insert(@RequestBody TaskRequestDto taskRequestDto) throws Exception {
        return new ResponseEntity<>(taskService.insert(taskRequestDto), HttpStatus.OK);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<TaskResponseDto> Update(@PathVariable Integer id,
                                                  @RequestBody TaskRequestDto taskRequestDto) throws Exception {
        return new ResponseEntity<>(taskService.update(id, taskRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Boolean> Delete(@PathVariable Integer id) {
        return new ResponseEntity<>(taskService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/task")
    public ResponseEntity<List<TaskResponseDto>> GetAll(@RequestParam Integer usrId) {
        return new ResponseEntity<>(taskService.getAll(usrId), HttpStatus.OK);
    }
}
