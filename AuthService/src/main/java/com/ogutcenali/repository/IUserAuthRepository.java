package com.ogutcenali.repository;

import com.ogutcenali.repository.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAuthRepository  extends JpaRepository<UserAuth,Long> {
}
