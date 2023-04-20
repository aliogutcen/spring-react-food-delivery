package com.ogutcenali.controller;

import com.ogutcenali.dto.request.AddNewCategory;
import com.ogutcenali.dto.response.CategoryResponse;
import com.ogutcenali.dto.response.ProductResponseDto;
import com.ogutcenali.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ogutcenali.constant.EndPoints.*;
@RestController
@RequestMapping(CATEGORY)
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;
    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody AddNewCategory addNewCategory){
        return ResponseEntity.ok(categoryService.addCategory(addNewCategory));
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<ProductResponseDto>> getAllProductForCategory(@PathVariable String id){
        return ResponseEntity.ok(categoryService.getAllProductForCategory(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable String id){
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }
}
