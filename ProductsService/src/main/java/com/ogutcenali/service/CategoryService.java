package com.ogutcenali.service;

import com.ogutcenali.dto.request.AddNewCategory;
import com.ogutcenali.dto.response.ProductResponseDto;
import com.ogutcenali.exception.AuthException;
import com.ogutcenali.exception.ErrorType;
import com.ogutcenali.repository.ICategoryRepository;
import com.ogutcenali.repository.entity.Category;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService extends ServiceManager<Category, String> {

    private final ICategoryRepository categoryRepository;
    private final ProductService productService;

    public CategoryService(ICategoryRepository categoryRepository, ProductService productService) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }


    public Category getCategory(String categoryName) {
        Optional<Category> category = categoryRepository.findOptionalByCategoryName(categoryName);
        if (category.isEmpty()) throw new AuthException(ErrorType.BAD_REQUEST_ERROR);
        return category.get();
    }

    public Object addCategory(AddNewCategory addNewCategory) {
        Optional<Category> category = categoryRepository.findOptionalByCategoryName(addNewCategory.getCategoryName());
        if (category.isPresent()) throw new AuthException(ErrorType.BAD_REQUEST_ERROR);
        Category cat = Category.builder()
                .categoryName(addNewCategory.getCategoryName())
                .desc(addNewCategory.getDesc())
                .isVegan(addNewCategory.getIsVegan())
                .build();
        return true;
    }

    public List<ProductResponseDto> getAllProductForCategory(String id) {
        Optional<Category> category = findById(id);
        return productService.getAllProductForCategory(category.get());
    }

    public Boolean deleteCategory(String id) {
        Optional<Category> category = findById(id);
        delete(category.get());
        return true;
    }
}
