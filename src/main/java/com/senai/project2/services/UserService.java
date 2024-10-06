package com.senai.project2.services;

import com.senai.project2.dtos.request.UserRequestDto;
import com.senai.project2.dtos.response.UserResponseDto;
import com.senai.project2.models.UserModel;
import com.senai.project2.repositories.UserRepository;
import com.senai.project2.utils.UserExtensions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository _userRepository;

    public UserService(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    public UserResponseDto Insert(UserRequestDto userRequestDTO)  {
        UserModel userModel = _userRepository.save(UserExtensions.toEntity(userRequestDTO));
        return UserExtensions.toDto(userModel);
    }

    public List<UserResponseDto> GetAll() {
        List<UserModel> userList = _userRepository.findAll();
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for (UserModel userModel : userList) {
            userResponseDtoList.add(UserExtensions.toDto(userModel));
        }
        return userResponseDtoList;
    }

    public UserResponseDto Update(Integer id, UserRequestDto userRequestDTO) throws Exception {
        try
        {
            UserModel existingUser = _userRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));

            UserModel updatedUser = UserExtensions.toEntity(userRequestDTO);
            updatedUser.setId(existingUser.getId());
            UserModel savedUser = _userRepository.save(updatedUser);
            
            return UserExtensions.toDto(savedUser);
        }
        catch (Exception e)
        {
            throw new Exception(e);
        }

    }

}
