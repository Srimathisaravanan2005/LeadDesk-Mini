package com.leaddesk.demo.repository;

import com.leaddesk.demo.model.Lead;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LeadRepository extends MongoRepository<Lead, String> {

    List<Lead> findByNameContainingIgnoreCase(String name);

}