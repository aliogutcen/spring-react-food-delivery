package com.ogutcenali.controller;

import com.ogutcenali.dto.request.RegisterRestaurantRequestDto;
import com.ogutcenali.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

import static com.ogutcenali.constant.EndPoints.RESTAURANT_REGISTER;
import static com.ogutcenali.constant.EndPoints.SAVE;

@RestController
@RequestMapping(RESTAURANT_REGISTER)
@RequiredArgsConstructor
public class RestaurantRegisterController {

    private final RestaurantService restaurantService;


    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<?> doRegisterRestaurant(@RequestBody RegisterRestaurantRequestDto restaurantRequestDto) throws MessagingException {
        return ResponseEntity.ok(restaurantService.register(restaurantRequestDto));
    }
}
