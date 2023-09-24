package com.query.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.query.example.entities.ConfigEntity;

public interface ConfigRepository extends JpaRepository<ConfigEntity , Long>{
  
}
