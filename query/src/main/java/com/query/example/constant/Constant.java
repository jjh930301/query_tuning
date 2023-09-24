package com.query.example.constant;

public class Constant {
  public static final String COLLATE = " CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ";
  public static final String DB_URI = System.getenv("DB_URI");
  public static final String DB_NAME = System.getenv("DB_NAME");
  public static final String DB_USER = System.getenv("DB_USER");
  public static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
}
