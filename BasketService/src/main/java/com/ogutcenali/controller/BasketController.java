package com.ogutcenali.controller;

import com.ogutcenali.dto.request.AddToProductRequestDto;
import com.ogutcenali.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @PostMapping("/addbasket")
    public ResponseEntity<?> addToProduct(@RequestBody AddToProductRequestDto addToProductRequestDto) {
        return ResponseEntity.ok(basketService.addToProduct(addToProductRequestDto));
    }
}
