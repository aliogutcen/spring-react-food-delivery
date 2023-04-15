package com.ogutcenali.repository;

import com.ogutcenali.repository.entity.RestaurantAuth;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRestaurantAuthRepository  extends JpaRepository<RestaurantAuth,Long> {
    Optional<RestaurantAuth> findOptionalByMailAndPassword(String mail,String pass);
}
