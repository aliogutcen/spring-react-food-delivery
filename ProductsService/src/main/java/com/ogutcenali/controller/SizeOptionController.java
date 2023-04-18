package com.ogutcenali.controller;

import com.ogutcenali.dto.request.AddNewSizeRequestDto;
import com.ogutcenali.service.SizeOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ogutcenali.constant.EndPoints.*;


@RestController
@RequestMapping(SIZE_OPTION)
@RequiredArgsConstructor
public class SizeOptionController {

    private final SizeOptionService sizeOptionService;
    @PostMapping("/deneme")
    public ResponseEntity<?> addingNewSize(@RequestBody AddNewSizeRequestDto addNewSizeRequestDto){

        return ResponseEntity.ok(sizeOptionService.addNewSize(addNewSizeRequestDto));
    }

    @GetMapping("/xx")
    public ResponseEntity<String> deneme(){
        return ResponseEntity.ok("deneme");
    }
}
