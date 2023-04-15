package com.ogutcenali.controller;
import com.ogutcenali.dto.request.DoLoginAuth;
import com.ogutcenali.dto.response.LoginResponseDto;
import com.ogutcenali.service.RestaurantAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ogutcenali.constant.RestEndPoints.*;
@RestController
@RequestMapping(RESTAURANT_AUTH)
@RequiredArgsConstructor
public class RestaurantAuthController {

    private final RestaurantAuthService restaurantAuthService;
    @PostMapping(LOGIN)
    @CrossOrigin("*")
    public ResponseEntity<LoginResponseDto> doLogin(@RequestBody DoLoginAuth doLoginAuth){
        return ResponseEntity.ok(restaurantAuthService.doLogin(doLoginAuth));
    }
}
