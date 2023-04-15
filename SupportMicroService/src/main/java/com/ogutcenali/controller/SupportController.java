package com.ogutcenali.controller;

import com.ogutcenali.dto.request.SendSupportRequestDto;
import com.ogutcenali.dto.response.SupportRegistrationConfirmationResponse;
import com.ogutcenali.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ogutcenali.constant.EndPoints.SEND;
import static com.ogutcenali.constant.EndPoints.SUPPORT;

@RestController
@RequestMapping(SUPPORT)
@RequiredArgsConstructor
public class SupportController {

    private final SupportService supportService;



    @PostMapping(SEND)
    public ResponseEntity<?> submitDocumentsForRegistrationConfirmation(@RequestBody SendSupportRequestDto sendSupportRequestDto){
        return ResponseEntity.ok(supportService.submitDocumentsForRegistrationConfirmation(sendSupportRequestDto));
    }

    @GetMapping("/register-configration")
    public ResponseEntity<List<SupportRegistrationConfirmationResponse>> getAllRegistrationConfirmation(){
        return ResponseEntity.ok(supportService.getAllRegistrationConfirmation());

    }


}
