package com.query.example.controller;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.query.example.dto.DeliveryDTO;
import com.query.example.services.ExampleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "example")
@RestController
@RequestMapping("example")
public class ExampleController {
  @Autowired
  private ExampleService exampleService;

  @Operation(summary = "쿼리 튜닝 전(1)")
  @GetMapping("before/first")
  public ResponseEntity<?> beforeFirst(
    @Schema(description = "info.id")
    @ParameterObject Integer infoId
  ) {
    return ResponseEntity
      .ok()
      .body(this.exampleService.beforeFirst(infoId));
  }

  @Operation(summary = "쿼리 튜닝 후(1)")
  @GetMapping("after/first")
  public ResponseEntity<?> afterFirst(
    @Schema(description = "info.id")
    @ParameterObject Integer infoId
  ) {
    return ResponseEntity
      .ok()
      .body(this.exampleService.afterFirst(infoId));
  }

  @Operation(summary = "쿼리 튜닝 전(2)")
  @GetMapping("before/second")
  public ResponseEntity<?> beforeSecond(
    @Schema(description = "config.id")
    @ParameterObject Long configId
  ) {
    return ResponseEntity
      .ok()
      .body(this.exampleService.beforeSecond(configId));
  }

  @Operation(summary = "쿼리 튜닝 후(2)")
  @GetMapping("after/second")
  public ResponseEntity<?> afterSecond(
    @Schema(description = "config.id")
    @ParameterObject Long configId
  ) {
    return ResponseEntity
      .ok()
      .body(this.exampleService.afterSecond(configId));
  }

  @Operation(summary = "insert where")
  @PostMapping("before/insert/where")
  public ResponseEntity<?> beforeInsertWhere(
    @RequestBody DeliveryDTO body
  ) {
    return ResponseEntity
      .ok()
      .body(this.exampleService.beforInsertWhere(body));
  }

  @Operation(summary = "insert where")
  @PostMapping("after/insert/where")
  public ResponseEntity<?> afterInsertWhere(
    @RequestBody DeliveryDTO body
  ) {
    return ResponseEntity
      .ok()
      .body(this.exampleService.afterInsertWhere(body));
  }
}
