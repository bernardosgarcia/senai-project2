package com.senai.project2.controllers;

import com.senai.project2.dtos.request.UserRequestDto;
import com.senai.project2.dtos.response.UserResponseDto;
import com.senai.project2.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> Insert(@RequestBody UserRequestDto userRequestDTO) throws Exception {
        return new ResponseEntity<>(userService.Insert(userRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserResponseDto>> GetAll() {
        List<UserResponseDto> userList = userService.GetAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<UserResponseDto> Update(@PathVariable Integer id, @RequestBody UserRequestDto userRequestDTO) throws Exception {
        UserResponseDto userResponseDto = userService.Update(id, userRequestDTO);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

}
