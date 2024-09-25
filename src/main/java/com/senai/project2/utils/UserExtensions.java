package com.senai.project2.utils;

import com.senai.project2.dtos.request.UserRequestDto;
import com.senai.project2.dtos.response.UserResponseDto;
import com.senai.project2.models.UserModel;

import java.time.LocalDate;

public class UserExtensions {

    public static UserModel toEntity(UserRequestDto userRequestDTO) {
        UserModel userModel = new UserModel();
        userModel.setLogin(userRequestDTO.login());
        userModel.setPassword(userRequestDTO.password());
        userModel.setEmail(userRequestDTO.email());
        userModel.setCreatedAt(LocalDate.now());
        return userModel;
    }

    public static UserResponseDto toDto(UserModel userModel) {
        return new UserResponseDto(
                userModel.getId(),
                userModel.getLogin(),
                userModel.getPassword(),
                userModel.getEmail(),
                userModel.getCreatedAt(),
                userModel.getUpdatedAt()
        );
    }
}
