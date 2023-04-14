package com.ogutcenali.service;

import com.ogutcenali.dto.request.RegisterUserRequestDto;
import com.ogutcenali.exception.ErrorType;
import com.ogutcenali.exception.RegisterException;
import com.ogutcenali.repository.IUserRepository;
import com.ogutcenali.repository.entity.User;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends ServiceManager<User, Long> {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public Boolean registerUser(RegisterUserRequestDto userRequestDto) {

        Optional<User> userOptional = userRepository.findOptionalByUsernameOrMail(userRequestDto.getUsername(), userRequestDto.getMail());
        if (userOptional.isPresent()) throw new RegisterException(ErrorType.USER_ALREADY_EXISTS);
        User user = User.builder()
                .mail(userRequestDto.getMail())
                .username(userRequestDto.getUsername())
                .password(userRequestDto.getPassword())
                .phoneNumber(userRequestDto.getPhone())
                .build();
        save(user);

        /**
         * AUTH SERVICE KAYIT GONDERILECEK
         */

        return true;
    }
}
