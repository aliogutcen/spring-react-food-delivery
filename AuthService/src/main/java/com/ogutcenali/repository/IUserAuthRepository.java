package com.ogutcenali.repository;

import com.ogutcenali.repository.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserAuthRepository extends JpaRepository<UserAuth, Long> {
    Optional<UserAuth> findOptionalByMailAndPassword(String mail, String password);
}
