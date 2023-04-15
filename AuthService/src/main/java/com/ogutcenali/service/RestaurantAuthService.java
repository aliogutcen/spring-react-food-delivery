package com.ogutcenali.service;

import com.ogutcenali.dto.request.DoLoginAuth;
import com.ogutcenali.dto.response.LoginResponseDto;
import com.ogutcenali.exception.AuthException;
import com.ogutcenali.exception.ErrorType;
import com.ogutcenali.rabbitmq.model.RegisterRestaurantForAuth;
import com.ogutcenali.repository.IRestaurantAuthRepository;
import com.ogutcenali.repository.entity.RestaurantAuth;
import com.ogutcenali.utility.JwtTokenManager;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantAuthService extends ServiceManager<RestaurantAuth, Long> {
    private final IRestaurantAuthRepository restaurantAuthRepository;
    private final JwtTokenManager jwtTokenManager;

    public RestaurantAuthService(IRestaurantAuthRepository restaurantAuthRepository, JwtTokenManager jwtTokenManager) {
        super(restaurantAuthRepository);
        this.restaurantAuthRepository = restaurantAuthRepository;
        this.jwtTokenManager = jwtTokenManager;
    }

    public void registerRestaurant(RegisterRestaurantForAuth registerRestaurantForAuth) {
        RestaurantAuth restaurantAuth = RestaurantAuth.builder()
                .mail(registerRestaurantForAuth.getMail())
                .password(registerRestaurantForAuth.getPassword()).build();
        save(restaurantAuth);
    }

    public LoginResponseDto doLogin(DoLoginAuth doLoginAuth) {
        Optional<RestaurantAuth> restaurantAuth = restaurantAuthRepository.findOptionalByMailAndPassword(doLoginAuth.getMail(), doLoginAuth.getPassword());
        if (restaurantAuth.isEmpty()) throw new AuthException(ErrorType.AUTH_LOGIN_ERROR);
        Optional<String> token =jwtTokenManager.createToken(restaurantAuth.get().getId());
        return LoginResponseDto.builder().token(token.get()).build();
    }
}
