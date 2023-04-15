package com.ogutcenali.controller;


import com.ogutcenali.dto.request.DoLoginAuth;
import com.ogutcenali.dto.response.LoginResponseDto;
import com.ogutcenali.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.ogutcenali.constant.RestEndPoints.*;
@RestController
@RequestMapping(USER_AUTH)
@RequiredArgsConstructor
public class UserAuthController {

    private final UserAuthService userAuthService;

    @PostMapping(LOGIN)
    public ResponseEntity<LoginResponseDto> doLogin(@RequestBody DoLoginAuth doLoginAuth){
        return ResponseEntity.ok(userAuthService.doLogin(doLoginAuth));
    }
}
