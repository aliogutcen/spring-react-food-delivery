package com.ogutcenali.controller;

import com.ogutcenali.dto.request.AddNewProductRequestDto;
import com.ogutcenali.dto.response.ProductResponseDto;
import com.ogutcenali.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> addNewProduct(@RequestBody AddNewProductRequestDto addNewProductRequestDto){
        return ResponseEntity.ok(productService.addNewProduct(addNewProductRequestDto));
    }

    @GetMapping("/getall/{token}")
    public ResponseEntity<List<ProductResponseDto>> getAllProductForRestaurant(@PathVariable String token){
        return ResponseEntity.ok(productService.getAllProductForRestaurant(token));
    }
}
