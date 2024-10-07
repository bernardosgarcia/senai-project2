package com.senai.project2.services;

import com.senai.project2.dtos.request.TaskRequestDto;
import com.senai.project2.dtos.response.TaskResponseDto;
import com.senai.project2.models.TaskModel;
import com.senai.project2.models.UserModel;
import com.senai.project2.repositories.TaskRepository;
import com.senai.project2.repositories.UserRepository;
import com.senai.project2.utils.TaskExtensions;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public TaskResponseDto insert(TaskRequestDto taskRequestDto) throws Exception {
        Optional<UserModel> userModel = userRepository.findById(taskRequestDto.userId());
        if (userModel.isPresent()) {
            TaskModel taskModel = taskRepository.save(TaskExtensions.toEntity(taskRequestDto, userModel.get()));
            return TaskExtensions.toDto(taskModel);
        }
        throw new Exception();
    }

    public TaskResponseDto update(Integer id, TaskRequestDto taskRequestDto) throws Exception {
        Optional<TaskModel> oldTaskModel = taskRepository.findById(id);
        if (oldTaskModel.isPresent()) {
            oldTaskModel.get().setCreatedAt(LocalDate.now());
            oldTaskModel.get().setDescription(taskRequestDto.description());
            oldTaskModel.get().setPriority(taskRequestDto.priority());
            TaskModel taskModel = taskRepository.save(oldTaskModel.get());
            return TaskExtensions.toDto(taskModel);
        }
        throw new Exception();
    }

    public Boolean delete(Integer id) {
        try {
            taskRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<TaskResponseDto> getAll(Integer usrId) {
        List<TaskModel> response = taskRepository.findAll(Sort.by(Sort.Direction.ASC, "priority"));
        return response.stream()
                .filter(task -> task.getUser().equals(userRepository.findById(usrId).get()))
                .map(TaskExtensions::toDto)
                .collect(Collectors.toList());
    }

}
