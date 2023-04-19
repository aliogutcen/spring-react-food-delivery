package com.ogutcenali.controller;

import com.ogutcenali.dto.request.AddNewProductRequestDto;
import com.ogutcenali.dto.response.ProductResponseDto;
import com.ogutcenali.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("PRODUCT")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> addNewProduct(@RequestBody AddNewProductRequestDto addNewProductRequestDto){
        return ResponseEntity.ok(productService.addNewProduct(addNewProductRequestDto));
    }
    @GetMapping("/products/{token}")
    public ResponseEntity<List<ProductResponseDto>> getAllProductForRestaurant(@PathVariable String token){
        return ResponseEntity.ok(productService.getAllProductForRestaurant(token));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable String id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
    @PutMapping("/update/price/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody double price ){
        return ResponseEntity.ok(productService.updateProduct(id, price));
    }
    @PutMapping("/update/name/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody String productName ){
        return ResponseEntity.ok(productService.updateProductName(id, productName));
    }

    @GetMapping("/category/")
    public ResponseEntity<List<ProductResponseDto>>

}
