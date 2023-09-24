package com.query.example.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "info")
@Entity(name= "info")
public class InfoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(
    name = "service_id",
    columnDefinition = "int not null"
  )
  private Long serviceId;

  @Column(
    name = "address",
    nullable = true,
    columnDefinition = "varchar(500) COMMENT '주소'"
  )
  private String address;

  @Column(
    name = "address_a",
    nullable = true,
    columnDefinition = "varchar(500) COMMENT '도시'"
  )
  private String addressA;

  @Column(
    name = "address_n",
    nullable = true,
    columnDefinition = "varchar(500) COMMENT '국가'"
  )
  private String addressN;

  @Column(
    name = "created_at",
    columnDefinition = "datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '생성일'"
  )
  private LocalDateTime createdAt;
}
