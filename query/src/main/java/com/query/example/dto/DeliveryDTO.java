package com.query.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeliveryDTO {
  @Schema(
    required = false,
    requiredMode = RequiredMode.NOT_REQUIRED
  )
  private Long id;
  @Schema(description = "config.id")
  private Long configId;
  @Schema(description = "title")
  private String title;
}
