package com.query.example.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FirstVO {
  private Long id;
  private Long serviceId;
  private String address;
  private String addressA;
  private String addressN;
  private LocalDateTime createdAt;
  private String title;
}
