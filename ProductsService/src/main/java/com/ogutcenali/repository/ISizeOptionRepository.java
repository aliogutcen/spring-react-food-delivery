package com.ogutcenali.repository;

import com.ogutcenali.repository.entity.SizeOption;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISizeOptionRepository extends MongoRepository<SizeOption, String> {

    Optional<SizeOption> findByLabelAndRestaurantId(String label,Long restaurantId);
}
