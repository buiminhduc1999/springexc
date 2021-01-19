package com.example.demo.repositories;

import com.example.demo.models.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    @Query( value = "SELECT u from StudentEntity u where u.classEntity.id = :id")
    List<StudentEntity> findAllByIdClassEntity(@Param("id") Integer id);

    @Query( value = "SELECT u from StudentEntity u where u.classEntity.name = :name")
    List<StudentEntity> findAllByNameClassEntity(@Param("name") String name);
}
