package com.ogutcenali.repository;

import com.ogutcenali.repository.entity.Category;
import com.ogutcenali.repository.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoryRepository extends MongoRepository<Category,String> {

    Optional<Category> findOptionalByCategoryName(String categoryName);


}
