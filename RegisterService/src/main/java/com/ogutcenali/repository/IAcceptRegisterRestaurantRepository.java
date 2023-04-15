package com.ogutcenali.repository;

import com.ogutcenali.repository.entity.AcceptRegisterRestaurant;
import com.ogutcenali.repository.enums.EStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IAcceptRegisterRestaurantRepository extends JpaRepository<AcceptRegisterRestaurant, UUID> {

    Optional<AcceptRegisterRestaurant> findOptionalByRestaurantId(Long id);

}
