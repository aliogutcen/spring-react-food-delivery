package com.ogutcenali.service;

import com.ogutcenali.repository.IExtraOptionsRepository;
import com.ogutcenali.repository.entity.ExtraOptions;
import com.ogutcenali.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class ExtraOptionsService extends ServiceManager<ExtraOptions, String> {

    private final IExtraOptionsRepository extraOptionsRepository;

    public ExtraOptionsService(IExtraOptionsRepository extraOptionsRepository) {
        super(extraOptionsRepository);
        this.extraOptionsRepository = extraOptionsRepository;
    }
}
