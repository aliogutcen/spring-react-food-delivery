package com.ogutcenali.controller;


import com.ogutcenali.dto.request.UpdateRestaurantInformationRequestDto;
import com.ogutcenali.dto.response.GetAllInfoForRestaurant;
import com.ogutcenali.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.ogutcenali.constant.EndPoints.RESTAURANT;
import static com.ogutcenali.constant.EndPoints.UPDATE;

@RestController
@RequestMapping(RESTAURANT)
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    @PostMapping(UPDATE)
    public ResponseEntity<GetAllInfoForRestaurant> updateInformation(@RequestBody UpdateRestaurantInformationRequestDto informationRequestDto){
        return ResponseEntity.ok(restaurantService.updateInformation(informationRequestDto));
    }
    @GetMapping("/{token}")
    public ResponseEntity<GetAllInfoForRestaurant> getAllInfoForRestaurantResponseEntity(@PathVariable String token){
        return ResponseEntity.ok(restaurantService.getAllInfoForRestaurantResponseEntity(token));
    }



}
