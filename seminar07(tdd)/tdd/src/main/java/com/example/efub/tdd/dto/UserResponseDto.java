package com.example.efub.tdd.dto;


import com.example.efub.tdd.domain.User;
import com.example.efub.tdd.domain.UserType;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
public class UserResponseDto {
    private String name;

    @Enumerated(EnumType.STRING)
    private UserType type;

    public UserResponseDto(User entity){
        this.name = entity.getName();
        this.type = entity.getType();
    }
}