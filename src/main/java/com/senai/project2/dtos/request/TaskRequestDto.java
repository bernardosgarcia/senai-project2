package com.senai.project2.dtos.request;

public record TaskRequestDto(String description,
                             Integer priority,
                             Integer userId) {
}
