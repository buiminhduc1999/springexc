package com.example.demo.repositories;

import com.example.demo.models.entities.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Integer> {
}
