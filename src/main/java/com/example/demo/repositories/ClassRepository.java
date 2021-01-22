package com.example.demo.repositories;

import com.example.demo.models.entities.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClassRepository extends JpaRepository<ClassEntity, Integer> {
    @Query("SELECT c FROM ClassEntity c WHERE c.id =:id")
    ClassEntity findByIds(@Param("id") Integer id);
}
