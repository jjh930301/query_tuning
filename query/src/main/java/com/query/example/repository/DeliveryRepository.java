package com.query.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.query.example.entities.DeliveryEntity;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity , Long>{
  
}
