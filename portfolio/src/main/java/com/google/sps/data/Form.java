package com.google.sps.data;

public final class Form {

  private final long id;
  private final String  name;
  private final String email;
  private final String reason;
  private final String message;
  private final long timestamp;

  public Form(long id, String name,String email, String reason, String message, long timestamp) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.reason = reason;
    this.message = message;
    this.timestamp = timestamp;
  }
}