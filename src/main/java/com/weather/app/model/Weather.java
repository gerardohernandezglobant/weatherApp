package com.weather.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Weather {
  private String id;
  private String main;
  private String description;
  private String icon;
}
