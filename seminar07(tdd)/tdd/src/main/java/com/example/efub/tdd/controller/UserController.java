package com.example.efub.tdd.controller;


import com.example.efub.tdd.domain.User;
import com.example.efub.tdd.domain.UserType;
import com.example.efub.tdd.dto.UserResponseDto;
import com.example.efub.tdd.dto.UserSaveRequestDto;
import com.example.efub.tdd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/test/{name}")
    private User save(@PathVariable String name){
        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .name(name)
                .type(UserType.NORMAL)
                .build();
        return userService.save(requestDto);
    }

    @GetMapping("/test/{id}")
    private UserResponseDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void userNotFoundHandler(IllegalArgumentException e){}
}
