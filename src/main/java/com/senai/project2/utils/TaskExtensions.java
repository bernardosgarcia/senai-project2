package com.senai.project2.utils;

import com.senai.project2.dtos.request.TaskRequestDto;
import com.senai.project2.dtos.response.TaskResponseDto;
import com.senai.project2.models.TaskModel;
import com.senai.project2.models.UserModel;

import java.time.LocalDate;

public class TaskExtensions {

    public static TaskModel toEntity(TaskRequestDto taskRequestDTO) {
        UserModel userModel = new UserModel();
        userModel.setId(taskRequestDTO.userId());

        TaskModel taskModel = new TaskModel();
        taskModel.setDescription(taskRequestDTO.description());
        taskModel.setUsrId(userModel);
        taskModel.setPriority(taskRequestDTO.priority());
        taskModel.setCreatedAt(LocalDate.now());
        return taskModel;
    }

    public static TaskResponseDto toDto(TaskModel taskModel) {
        return new TaskResponseDto(
                taskModel.getId(),
                taskModel.getDescription(),
                taskModel.getPriority(),
                taskModel.getUsrId().getId(),
                taskModel.getUsrId().getEmail(),
                taskModel.getCreatedAt(),
                taskModel.getUpdatedAt()
        );
    }
}
