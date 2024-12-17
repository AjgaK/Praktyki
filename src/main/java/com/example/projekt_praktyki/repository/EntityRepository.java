package com.example.projekt_praktyki.repository;

import com.example.projekt_praktyki.model.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntityRepository extends MongoRepository<Entity, Long> {
    List<Entity> findByName(String name);
    void deleteById(String id);
    Entity findById(String id);
}
