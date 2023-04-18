package com.ogutcenali.repository;

import com.ogutcenali.repository.entity.ExtraOptions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExtraOptionsRepository  extends MongoRepository<ExtraOptions,String> {
}
