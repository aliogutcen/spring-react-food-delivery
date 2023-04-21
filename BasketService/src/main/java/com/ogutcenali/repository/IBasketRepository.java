package com.ogutcenali.repository;

import com.ogutcenali.repository.entity.Basket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBasketRepository extends CrudRepository<Basket, String> {
    Optional<Basket> findOptionalByAuthId(Long authId);
}
