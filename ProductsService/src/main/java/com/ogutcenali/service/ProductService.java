package com.ogutcenali.service;

import com.ogutcenali.dto.request.AddNewProductRequestDto;
import com.ogutcenali.dto.response.ProductResponseDto;
import com.ogutcenali.exception.AuthException;
import com.ogutcenali.exception.ErrorType;
import com.ogutcenali.repository.IProductRepository;
import com.ogutcenali.repository.entity.Product;
import com.ogutcenali.utility.JwtTokenManager;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ProductService extends ServiceManager<Product, String> {

    private final IProductRepository productRepository;
    private final JwtTokenManager jwtTokenManager;

    public ProductService(IProductRepository productRepository, JwtTokenManager jwtTokenManager) {
        super(productRepository);
        this.productRepository = productRepository;
        this.jwtTokenManager = jwtTokenManager;
    }

    public Boolean addNewProduct(AddNewProductRequestDto addNewProductRequestDto) {
        Optional<Long> restaurantId = jwtTokenManager.decodeToken(addNewProductRequestDto.getToken());
        Optional<Product> product = productRepository.findByNameAndRestaurantId(addNewProductRequestDto.getName(), restaurantId.get());
        if (product.isPresent()) throw new AuthException(ErrorType.AUTH_ALREADY_EXISTS);
        Product pro = Product.builder()
                .name(addNewProductRequestDto.getName())
                .restaurantId(restaurantId.get())
                .price(addNewProductRequestDto.getPrice())
                .extraOptions(addNewProductRequestDto.getExtraOptions())
                .sizeOptions(addNewProductRequestDto.getSizeOption())
                .ingreditions(addNewProductRequestDto.getIngreditions())
                .build();
        save(pro);
        return true;
    }

    public List<ProductResponseDto> getAllProductForRestaurant(String token) {
        Optional<Long> restaurant = jwtTokenManager.decodeToken(token);
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        productRepository.findByRestaurantId(restaurant.get()).forEach(x -> {
            productResponseDtos.add(ProductResponseDto.builder()
                    .name(x.getName())
                    .extraOptions(x.getExtraOptions())
                    .ingreditions(x.getIngreditions())
                    .price(x.getPrice())
                    .sizeOptions(x.getSizeOptions())
                    .build());
        });
        return productResponseDtos;
    }
}
