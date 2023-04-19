package com.ogutcenali.repository;

import com.ogutcenali.repository.entity.Category;
import com.ogutcenali.repository.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends MongoRepository<Product, String> {

    Optional<Product> findByNameAndRestaurantId(String productName,Long restaurantId);
    List<Product> findByRestaurantId(Long restaurantId);

    List<Product> findByCategory(Category category);
}
