package com.ogutcenali.service;

import com.ogutcenali.dto.request.DoLoginAuth;
import com.ogutcenali.dto.response.LoginResponseDto;
import com.ogutcenali.exception.AuthException;
import com.ogutcenali.exception.ErrorType;
import com.ogutcenali.rabbitmq.model.RegisterUser;

import com.ogutcenali.repository.IUserAuthRepository;
import com.ogutcenali.repository.entity.UserAuth;
import com.ogutcenali.utility.JwtTokenManager;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthService extends ServiceManager<UserAuth, Long> {

    private final IUserAuthRepository userAuthRepository;
    private final JwtTokenManager jwtTokenManager;

    public UserAuthService(IUserAuthRepository userAuthRepository, JwtTokenManager jwtTokenManager) {
        super(userAuthRepository);
        this.userAuthRepository = userAuthRepository;
        this.jwtTokenManager = jwtTokenManager;
    }

    public void registerUser(RegisterUser registerUserForAuth) {
        UserAuth userAuth = UserAuth.builder()
                .mail(registerUserForAuth.getMail())
                .username(registerUserForAuth.getUsername())
                .password(registerUserForAuth.getPassword())
                .authid(registerUserForAuth.getUserId())
                .build();
        save(userAuth);
    }

    public LoginResponseDto doLogin(DoLoginAuth doLoginAuth) {
        Optional<UserAuth> userAuth = userAuthRepository.findOptionalByMailAndPassword(doLoginAuth.getMail(), doLoginAuth.getPassword());
        if (userAuth.isEmpty()) throw new AuthException(ErrorType.AUTH_LOGIN_ERROR);
        Optional<String> token = jwtTokenManager.createToken(userAuth.get().getId());
        LoginResponseDto loginResponseDto = LoginResponseDto.builder().token(token.get()).build();
        return loginResponseDto;
    }


}
