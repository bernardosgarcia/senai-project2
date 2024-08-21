//package com.senai.project2.controllers;
//
//import com.senai.project2.dtos.AuthRequestDTO;
//import com.senai.project2.services.AuthService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AuthController {
//
//    private final AuthService authService;
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping("/getToken")
//    public ResponseEntity<String> getToken(@RequestBody AuthRequestDTO authRequestDTO) throws Exception {
//        return new ResponseEntity<>(authService.getToken(authRequestDTO), HttpStatus.OK);
//    }
//}
