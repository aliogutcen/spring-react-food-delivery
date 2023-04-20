package com.ogutcenali.controller;

import com.ogutcenali.dto.request.AddAddressRequestDto;
import com.ogutcenali.dto.request.DeleteAddressRequestDto;
import com.ogutcenali.repository.entity.Address;
import com.ogutcenali.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ogutcenali.constant.EndPoints.*;
@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add-address")
    public ResponseEntity<?> addAddress(@RequestBody AddAddressRequestDto addressRequestDto){
        return ResponseEntity.ok(customerService.addAddress(addressRequestDto));
    }
    @GetMapping("/address/{token}")
    public ResponseEntity<List<Address>> getAllAddress(@PathVariable String token){
        return ResponseEntity.ok(customerService.getAllAddress(token));
    }
    @DeleteMapping("/address/delete/")
    public ResponseEntity<?> deleteAddress(@RequestBody DeleteAddressRequestDto deleteAddressRequestDto){
        return ResponseEntity.ok(customerService.deleteAddress(deleteAddressRequestDto));
    }


}
