package com.ogutcenali.controller;

import com.ogutcenali.dto.response.AllApprovalRegisterRestaurant;
import com.ogutcenali.service.AcceptRegisterRestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.ogutcenali.constant.EndPoints.ACCPET_RESTAURANT;
import static com.ogutcenali.constant.EndPoints.GET_ALL_APPROVAL;

@RestController
@RequestMapping(ACCPET_RESTAURANT)
@RequiredArgsConstructor
public class AcceptRegisterRestaurantController {

    private final AcceptRegisterRestaurantService acceptRegisterRestaurantService;


    @GetMapping(GET_ALL_APPROVAL)
    public ResponseEntity<List<AllApprovalRegisterRestaurant>> getAllApproval(){
        return ResponseEntity.ok(acceptRegisterRestaurantService.getALLAproval());
    }

    @PostMapping("/apply/{id}")
    public ResponseEntity<?> applyRestaurant(@PathVariable UUID id){
        return ResponseEntity.ok(acceptRegisterRestaurantService.applyRestaurant(id));
    }
}
