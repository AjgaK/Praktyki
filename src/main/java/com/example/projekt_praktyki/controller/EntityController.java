package com.example.projekt_praktyki.controller;

import com.example.projekt_praktyki.model.Entity;
import com.example.projekt_praktyki.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EntityController {

    @Autowired
    private EntityService entityService;

    @GetMapping(value = "/all")
    public List<Entity> getAllEntities() {
        return entityService.getAllEntities();
    }

    @PostMapping(value = "/create")
    public void createEntity(@RequestBody Entity newEntity) {
        entityService.createEntity(newEntity);
    }

    @GetMapping(value = "/findByName")
    public List<Entity> findEntityByName(@RequestParam String entityName) {
        return entityService.findEntityByName(entityName);
    }

    @GetMapping(value = "/findById")
    public Entity findEntityById(@RequestParam String id) {
        return entityService.findEntityById(id);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Void> deleteEntity(@RequestParam String id) {
        Entity entityToDelete = entityService.findEntityById(id);
        if(entityToDelete != null) {
            entityService.deleteEntity(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Void> updateEntity(@PathVariable String id, @RequestBody Entity updatedEntity) {
        Entity entityToUpdate = entityService.findEntityById(id);
        if(entityToUpdate != null) {
            entityToUpdate.setId(updatedEntity.getId());
            entityToUpdate.setName(updatedEntity.getName());
            entityService.saveEntity(entityToUpdate);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
