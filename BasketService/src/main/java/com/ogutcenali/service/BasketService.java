package com.ogutcenali.service;

import com.ogutcenali.dto.request.AddToProductRequestDto;
import com.ogutcenali.repository.IBasketRepository;
import com.ogutcenali.repository.entity.Basket;
import com.ogutcenali.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final IBasketRepository basketRepository;
    private final JwtTokenManager jwtTokenManager;

    public Object addToProduct(AddToProductRequestDto addToProductRequestDto) {
        Optional<Long> authId = jwtTokenManager.decodeToken(addToProductRequestDto.getToken());
        Optional<Basket> basket = basketRepository.findOptionalByAuthId(authId.get());
        if (basket.isEmpty()) {
            Map<String, Integer> products = new HashMap<>();
            products.put(addToProductRequestDto.getProductId(), addToProductRequestDto.getQuantity());
            Basket cart = Basket.builder()
                    .authId(authId.get())
                    .products(products)
                    .build();
            basketRepository.save(cart);
        } else {
            if (basket.get().getProducts().containsKey(addToProductRequestDto.getProductId())) {
                basket.get().getProducts().replace(addToProductRequestDto.getProductId(), basket.get().getProducts().get(addToProductRequestDto.getProductId()) + addToProductRequestDto.getQuantity());
                basketRepository.save(basket.get());
            } else {
                basket.get().getProducts().put(addToProductRequestDto.getProductId(), addToProductRequestDto.getQuantity());
                basketRepository.save(basket.get());
            }
        }

        return true;
    }
}
