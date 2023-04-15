package com.ogutcenali.service;

import com.ogutcenali.dto.request.SendSupportRequestDto;
import com.ogutcenali.dto.response.SupportRegistrationConfirmationResponse;
import com.ogutcenali.repository.ISupportRepository;
import com.ogutcenali.repository.entity.Support;
import com.ogutcenali.repository.enums.ESupportType;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupportService extends ServiceManager<Support, String> {
    private final ISupportRepository supportRepository;

    public SupportService(ISupportRepository supportRepository) {
        super(supportRepository);
        this.supportRepository = supportRepository;
    }

    public Boolean submitDocumentsForRegistrationConfirmation(SendSupportRequestDto sendSupportRequestDto) {
        Support support = Support.builder().eSupportType(ESupportType.FILE_SENDING)
                .mail(sendSupportRequestDto.getMail())
                .title(sendSupportRequestDto.getTitle())
                .subject(sendSupportRequestDto.getSubject())
                .localDate(sendSupportRequestDto.getLocalDate())
                .build();
        save(support);
        return true;
    }

    public List<SupportRegistrationConfirmationResponse> getAllRegistrationConfirmation() {

        List<SupportRegistrationConfirmationResponse> supportRegistrationConfirmationResponses = new ArrayList<>();

        findAll().stream().filter(x -> x.getESupportType().equals(ESupportType.FILE_SENDING)).toList().forEach(x -> {
            supportRegistrationConfirmationResponses.add(SupportRegistrationConfirmationResponse.builder()
                    .eSupportType(ESupportType.FILE_SENDING)
                    .mail(x.getMail()).localDate(x.getLocalDate()).build());
        });
        return supportRegistrationConfirmationResponses;
    }
}
