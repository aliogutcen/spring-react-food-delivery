package com.ogutcenali.repository;

import com.ogutcenali.repository.entity.Support;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupportRepository  extends MongoRepository<Support,String> {
}
