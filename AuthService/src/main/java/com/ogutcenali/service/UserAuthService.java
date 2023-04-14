package com.ogutcenali.service;

import com.ogutcenali.rabbitmq.model.RegisterUserForAuth;
import com.ogutcenali.repository.IUserAuthRepository;
import com.ogutcenali.repository.entity.UserAuth;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService extends ServiceManager<UserAuth, Long> {

    private final IUserAuthRepository userAuthRepository;

    public UserAuthService(IUserAuthRepository userAuthRepository) {
        super(userAuthRepository);
        this.userAuthRepository = userAuthRepository;
    }

    public void registerUser(RegisterUserForAuth registerUserForAuth) {
        UserAuth userAuth = UserAuth.builder()
                .mail(registerUserForAuth.getMail())
                .username(registerUserForAuth.getUsername())
                .password(registerUserForAuth.getPassword())
                .build();
        save(userAuth);
    }
}
