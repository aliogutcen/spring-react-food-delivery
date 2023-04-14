package com.ogutcenali.repository;

import com.ogutcenali.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findOptionalByUsernameOrMail(String username, String mail);
}
