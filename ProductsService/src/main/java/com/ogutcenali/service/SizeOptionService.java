package com.ogutcenali.service;

import com.ogutcenali.dto.request.AddNewSizeRequestDto;
import com.ogutcenali.exception.AuthException;
import com.ogutcenali.exception.ErrorType;
import com.ogutcenali.repository.ISizeOptionRepository;
import com.ogutcenali.repository.entity.SizeOption;
import com.ogutcenali.utility.JwtTokenManager;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SizeOptionService extends ServiceManager<SizeOption, String> {

    private final ISizeOptionRepository sizeOptionRepository;
    private final JwtTokenManager jwtTokenManager;

    public SizeOptionService(ISizeOptionRepository sizeOptionRepository, JwtTokenManager jwtTokenManager) {
        super(sizeOptionRepository);
        this.sizeOptionRepository = sizeOptionRepository;
        this.jwtTokenManager = jwtTokenManager;
    }

    public Boolean addNewSize(AddNewSizeRequestDto addNewSizeRequestDto) {
        System.out.println("HATA BURADA MI");
        Optional<Long> restaurantId = jwtTokenManager.decodeToken(addNewSizeRequestDto.getToken());
        if (restaurantId.isEmpty()) throw new AuthException(ErrorType.TOKEN_DECODE_ERROR);
        Optional<SizeOption> sizeOption = sizeOptionRepository.findByLabelAndRestaurantId(addNewSizeRequestDto.getLabel(), restaurantId.get());
        if (sizeOption.isPresent())
            throw new AuthException(ErrorType.AUTH_ALREADY_EXISTS);  //tekrardan exception yazmalıyım
        SizeOption size = SizeOption.builder()
                .restaurantId(restaurantId.get())
                .label(addNewSizeRequestDto.getLabel())
                .price(addNewSizeRequestDto.getPrice())
                .build();
        save(size);
        return true;
    }
}
