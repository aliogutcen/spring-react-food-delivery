package com.ogutcenali.service;

import com.ogutcenali.dto.request.AddNewProductRequestDto;
import com.ogutcenali.dto.response.ProductResponseDto;
import com.ogutcenali.exception.AuthException;
import com.ogutcenali.exception.ErrorType;
import com.ogutcenali.repository.IProductRepository;
import com.ogutcenali.repository.entity.Category;
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
    private final CategoryService categoryService;

    public ProductService(IProductRepository productRepository, JwtTokenManager jwtTokenManager, CategoryService categoryService) {
        super(productRepository);
        this.productRepository = productRepository;
        this.jwtTokenManager = jwtTokenManager;
        this.categoryService = categoryService;
    }

    public Boolean addNewProduct(AddNewProductRequestDto addNewProductRequestDto) {
        Optional<Long> restaurantId = jwtTokenManager.decodeToken(addNewProductRequestDto.getToken());
        Optional<Product> product = productRepository.findByNameAndRestaurantId(addNewProductRequestDto.getName(), restaurantId.get());
        if (product.isPresent()) throw new AuthException(ErrorType.AUTH_ALREADY_EXISTS);
        Category category = categoryService.getCategory(addNewProductRequestDto.getCategoryName());
        Product pro = Product.builder()
                .name(addNewProductRequestDto.getName())
                .restaurantId(restaurantId.get())
                .price(addNewProductRequestDto.getPrice())
                .sizeOptions(addNewProductRequestDto.getSizeOption())
                .category(category)
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
                    .id(x.getId())
                    .price(x.getPrice())
                    .sizeOptions(x.getSizeOptions())
                    .category(x.getCategory())
                    .build());
        });
        return productResponseDtos;
    }

    public Boolean deleteProduct(String id) {
        Optional<Product> product = findById(id);
        if (product.isEmpty()) throw new AuthException(ErrorType.BAD_REQUEST_ERROR);
        delete(product.get());
        return true;
    }

    public Boolean updateProduct(String id, double price) {
        Optional<Product> product = findById(id);
        if (product.isEmpty()) throw new AuthException(ErrorType.BAD_REQUEST_ERROR);
        product.get().setPrice(price);
        update(product.get());
        return true;
    }

    public Boolean updateProductName(String id, String productName) {
        Optional<Product> product = findById(id);
        if (product.isEmpty()) throw new AuthException(ErrorType.BAD_REQUEST_ERROR);
        product.get().setName(productName);
        update(product.get());
        return true;
    }

    public List<ProductResponseDto> getAllProductForCategory(Category category) {
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        productRepository.findByCategory(category).forEach(x -> {
            productResponseDtos.add(ProductResponseDto.builder()
                    .name(x.getName())
                    .id(x.getId())
                    .price(x.getPrice())
                    .sizeOptions(x.getSizeOptions())
                    .category(x.getCategory())
                    .build());
        });
        return productResponseDtos;
    }
}
