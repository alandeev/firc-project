package com.alan.crud.models;

public class HttpResponse {
  public Object model = null;
  public Number statusCode = 400; 
  HttpResponse(Object model, Number statusCode) {
    this.model = model;
    this.statusCode = statusCode;
  }
}
