package com.senai.project2.dtos.response;

import java.time.LocalDate;

public record TaskResponseDto(Integer id,
                              String description,
                              Integer priority,
                              Integer userId,
                              String userEmail,
                              LocalDate createdAt,
                              LocalDate updatedAt) {
}
