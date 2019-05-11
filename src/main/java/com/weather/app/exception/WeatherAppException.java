package com.weather.app.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.client.HttpClientErrorException;

@Getter
@Setter
public class WeatherAppException extends Exception{
  private final Integer status;
  private final String message;

  public WeatherAppException(HttpClientErrorException e){
    status = e.getRawStatusCode();
    message = e.getStatusText();
  }
}
