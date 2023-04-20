package com.ogutcenali.service;

import com.ogutcenali.dto.request.RegisterUserRequestDto;
import com.ogutcenali.exception.ErrorType;
import com.ogutcenali.exception.RegisterException;
import com.ogutcenali.rabbitmq.model.RegisterUser;
import com.ogutcenali.rabbitmq.producer.RegisterProducer;
import com.ogutcenali.repository.IUserRepository;
import com.ogutcenali.repository.entity.User;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends ServiceManager<User, Long> {

    private final IUserRepository userRepository;
    private final RegisterProducer registerProducer;

    public UserService(IUserRepository userRepository, RegisterProducer registerProducer) {
        super(userRepository);
        this.userRepository = userRepository;
        this.registerProducer = registerProducer;
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
        registerProducer.registerUserForAuth(RegisterUser.builder()
                .mail(user.getMail())
                .password(user.getPassword())
                .username(user.getUsername())
                .userId(user.getId())
                .build());
        return true;
    }
}
