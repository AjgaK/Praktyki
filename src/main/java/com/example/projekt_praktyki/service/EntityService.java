package com.example.projekt_praktyki.service;

import com.example.projekt_praktyki.model.Entity;
import com.example.projekt_praktyki.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class EntityService {

    @Autowired
    private EntityRepository entityRepository;

    public List<Entity> getAllEntities() {
        System.out.println("Searching all entities in database");
        return entityRepository.findAll();
    }

    @CachePut(value = "cachedEntities", key = "#newEntity.id")
    public void createEntity(Entity newEntity) {
        entityRepository.insert(newEntity);
        System.out.println("Entity inserted: " + newEntity.getName());
    }

    @Cacheable(value = "cachedEntities", key = "#entityName")
    public List<Entity> findEntityByName(String entityName) {
        System.out.println("Searching in database");
        return entityRepository.findByName(entityName);
    }

    @Cacheable(value = "cachedEntities", key = "#id")
    public Entity findEntityById(String id) {
        System.out.println("Searching in database");
        return entityRepository.findById(id);
    }

    @CacheEvict(value = "cachedEntities", key = "#id")
    public void deleteEntity(String id) {
        entityRepository.deleteById(id);
        System.out.println("Entity deleted");
    }

    @CachePut(value = "cachedEntities", key = "#newEntity.id")
    public void saveEntity(Entity newEntity) {
        entityRepository.save(newEntity);
        System.out.println("Entity saved");
    }
}
