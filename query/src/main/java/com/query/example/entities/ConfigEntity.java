package com.query.example.entities;

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
@Table(name= "config")
@Entity(name= "config")
public class ConfigEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(
    name = "idx",
    columnDefinition = "bigint not null"
  )
  private Long idx;

  @Column(
    name = "info_id",
    columnDefinition = "int not null"
  )
  private Long infoId;

  @Column(
    name = "delivery_id",
    columnDefinition = "int not null"
  )
  private Long deliveryId;
}
