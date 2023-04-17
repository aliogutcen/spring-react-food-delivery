package com.ogutcenali.controller;

import com.ogutcenali.dto.request.UpdateRestaurantInformationRequestDto;
import com.ogutcenali.dto.response.GetAllInfoForRestaurant;
import com.ogutcenali.mapper.IRestaurantMapper;
import com.ogutcenali.repository.entity.Restaurant;
import com.ogutcenali.repository.enums.WeekDays;
import com.ogutcenali.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  com.ogutcenali.constant.EndPoints.*;
import java.util.List;
import java.util.Optional;

import static com.ogutcenali.constant.EndPoints.RESTAURANT;
import static com.ogutcenali.constant.EndPoints.UPDATE;

@RestController
@RequestMapping(RESTAURANT)
@RequiredArgsConstructor
public class RestaurantController {

    private RestaurantService restaurantService;

    @PostMapping(UPDATE)
    public ResponseEntity<GetAllInfoForRestaurant> updateInformation(@RequestBody UpdateRestaurantInformationRequestDto informationRequestDto){
        return ResponseEntity.ok(restaurantService.updateInformation(informationRequestDto));
    }

}
