package com.customer_details.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customer_details.model.CarDetails;

@Repository
public interface CarDetailsRepository extends MongoRepository<CarDetails,String> {
}
