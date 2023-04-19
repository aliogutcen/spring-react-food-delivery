package com.ogutcenali.controller;

import com.ogutcenali.dto.request.AddNewSizeRequestDto;
import com.ogutcenali.dto.response.SizeOptionResponseDto;
import com.ogutcenali.service.SizeOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ogutcenali.constant.EndPoints.*;


@RestController
@RequestMapping(SIZE_OPTION)
@RequiredArgsConstructor
@CrossOrigin("*")
public class SizeOptionController {

    private final SizeOptionService sizeOptionService;
    @PostMapping("/deneme")
    public ResponseEntity<?> addingNewSize(@RequestBody AddNewSizeRequestDto addNewSizeRequestDto){
        return ResponseEntity.ok(sizeOptionService.addNewSize(addNewSizeRequestDto));
    }

    @GetMapping("/getallsize/{token}")
    public ResponseEntity<List<SizeOptionResponseDto>> getAllSizeOptionForRestaurant(@PathVariable String token){
        return ResponseEntity.ok(sizeOptionService.getAllSizeOptionForRestaurant(token));
    }
}
