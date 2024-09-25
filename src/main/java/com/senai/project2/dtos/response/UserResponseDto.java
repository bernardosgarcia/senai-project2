package com.senai.project2.dtos.response;

import java.time.LocalDate;

public record UserResponseDto(Integer id,
                              String login,
                              String password,
                              String email,
                              LocalDate createdAt,
                              LocalDate updatedAt) {
}
