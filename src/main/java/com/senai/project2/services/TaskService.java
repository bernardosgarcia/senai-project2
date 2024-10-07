package com.senai.project2.services;

import com.senai.project2.dtos.request.TaskRequestDto;
import com.senai.project2.dtos.response.TaskResponseDto;
import com.senai.project2.models.TaskModel;
import com.senai.project2.repositories.TaskRepository;
import com.senai.project2.utils.TaskExtensions;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponseDto Insert(TaskRequestDto taskRequestDto) {
        TaskModel taskModel = taskRepository.save(TaskExtensions.toEntity(taskRequestDto));
        return TaskExtensions.toDto(taskModel);
    }

    public TaskResponseDto Update(Integer id, TaskRequestDto taskRequestDto) {
        Optional<TaskModel> oldTaskModel = taskRepository.findById(id);
        if (oldTaskModel.isPresent()) {
            oldTaskModel.get().setCreatedAt(LocalDate.now());
            oldTaskModel.get().setDescription(taskRequestDto.description());
            oldTaskModel.get().setPriority(taskRequestDto.priority());
            TaskModel taskModel = taskRepository.save(oldTaskModel.get());
            return TaskExtensions.toDto(taskModel);
        }
        return null;
    }

}
