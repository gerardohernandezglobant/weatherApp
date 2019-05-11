package com.weather.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
  private String name;
  private String dt;
  private Weather[] weather;
  private Main main;
  private Sys sys;

  //Error fields
  private String timestamp;
  private String status;
  private String error;
  private String message;
  private String path;
}
