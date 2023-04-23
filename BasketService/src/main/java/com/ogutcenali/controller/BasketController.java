package com.ogutcenali.controller;

import com.ogutcenali.dto.request.AddToProductRequestDto;
import com.ogutcenali.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @PostMapping("/addbasket")
    public ResponseEntity<?> addToProduct(@RequestBody AddToProductRequestDto addToProductRequestDto) {
        return ResponseEntity.ok(basketService.addToProduct(addToProductRequestDto));
    }
    @GetMapping("/{basketId}")
    public ResponseEntity<Map<String,Integer>> getBasketProducts(@PathVariable String basketId) {
        return ResponseEntity.ok(basketService.getBasketProducts(basketId));
    }
    @DeleteMapping("/deleteproduct/{basketId}")
    public ResponseEntity<?> deleteProductInBasket(@PathVariable String basketId,String productId){
        return ResponseEntity.ok(basketService.deletePorductInBasket(basketId,productId));
    }
    @DeleteMapping("/delete/{basketId}")
    public ResponseEntity<?> deleteAllProductInBasket(@PathVariable String basketId){
        return ResponseEntity.ok(basketService.deleteAllProductInBasket(basketId));
    }
}
