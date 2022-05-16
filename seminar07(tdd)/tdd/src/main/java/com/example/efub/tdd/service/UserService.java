package com.example.efub.tdd.service;


import com.example.efub.tdd.domain.User;
import com.example.efub.tdd.dto.UserResponseDto;
import com.example.efub.tdd.dto.UserSaveRequestDto;
import com.example.efub.tdd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto findById(Long id){
        User entity = userRepository.getById(id);
        return new UserResponseDto(entity);
    }

    public User save(UserSaveRequestDto requestDTO){
        return userRepository.save(requestDTO.toEntity());
    }
}