package com.ogutcenali.service;

import com.ogutcenali.dto.request.SendSupportRequestDto;
import com.ogutcenali.dto.response.SupportRegistrationConfirmationResponse;
import com.ogutcenali.rabbitmq.model.SupportRegisterRestaurant;
import com.ogutcenali.rabbitmq.producer.SupportProducer;
import com.ogutcenali.repository.ISupportRepository;
import com.ogutcenali.repository.entity.Support;
import com.ogutcenali.repository.enums.ESupportType;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupportService extends ServiceManager<Support, String> {
    private final ISupportRepository supportRepository;
    private final SupportProducer supportProducer;

    public SupportService(ISupportRepository supportRepository, SupportProducer supportProducer) {
        super(supportRepository);
        this.supportRepository = supportRepository;
        this.supportProducer = supportProducer;
    }

    public Boolean submitDocumentsForRegistrationConfirmation(SendSupportRequestDto sendSupportRequestDto) {
        Support support = Support.builder().eSupportType(ESupportType.FILE_SENDING)
                .mail(sendSupportRequestDto.getMail())
                .title(sendSupportRequestDto.getTitle())
                .subject(sendSupportRequestDto.getSubject())
                .localDate(sendSupportRequestDto.getLocalDate())
                .isClose(false)
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

    public Boolean acceptForRegistrationConfirmation(String id) {
        Optional<Support> support = supportRepository.findById(id);
        support.get().setIsClose(true);
        update(support.get());

        //after accept send query register micro_service

        supportProducer.sendSupportAcceptRegisterForRestaurant(SupportRegisterRestaurant.builder()
                .mail(support.get().getMail())
                .build());
        return true;

    }
}
