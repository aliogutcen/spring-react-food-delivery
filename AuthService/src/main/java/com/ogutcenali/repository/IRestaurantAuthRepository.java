package com.ogutcenali.repository;

import com.ogutcenali.repository.entity.RestaurantAuth;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantAuthRepository  extends JpaRepository<RestaurantAuth,Long> {
}
