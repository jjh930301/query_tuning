package com.query.example.controller;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @Operation(summary = "쿼리 튜닝 전(2)")
  @GetMapping("after/first")
  public ResponseEntity<?> afterFirst(
    @Schema(description = "info.id")
    @ParameterObject Integer infoId
  ) {
    return ResponseEntity
      .ok()
      .body(this.exampleService.afterFirst(infoId));
  }
}
