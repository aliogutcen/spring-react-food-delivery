package com.ogutcenali.controller;

import com.ogutcenali.dto.request.RegisterUserRequestDto;
import com.ogutcenali.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ogutcenali.constant.EndPoints.SAVE;
import static com.ogutcenali.constant.EndPoints.USER_REGISTER;

@RestController
@RequestMapping(USER_REGISTER)
@RequiredArgsConstructor
public class UserRegisterController {

    private final UserService userService;

    @PostMapping(SAVE)
    public ResponseEntity<?> doRegister(@RequestBody RegisterUserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.registerUser(userRequestDto));
    }
}
