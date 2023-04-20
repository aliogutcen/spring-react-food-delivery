package com.ogutcenali.repository;

import com.ogutcenali.repository.entity.Address;
import com.ogutcenali.repository.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends MongoRepository<Customer,String> {

    Optional<Customer> findOptionalByAuthId(Long authid);


    List<Address> findByAuthId(Long authid);
}
