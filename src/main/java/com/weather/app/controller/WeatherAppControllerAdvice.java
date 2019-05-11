package com.weather.app.controller;

import com.weather.app.exception.WeatherAppException;
import com.weather.app.model.ServiceResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice

public class WeatherAppControllerAdvice {

  @ExceptionHandler(WeatherAppException.class)
  public ServiceResponse handleWeatherException(WeatherAppException ex) {
    return ServiceResponse.builder()
            .error(ex.getMessage())
            .status(ex.getStatus().toString())
            .celsius(StringUtils.EMPTY)
            .farenheit(StringUtils.EMPTY)
            .overallDescription(StringUtils.EMPTY)
            .sunrise(StringUtils.EMPTY)
            .sunset(StringUtils.EMPTY)
            .today(StringUtils.EMPTY)
            .cityName(StringUtils.EMPTY)
            .build();
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ServiceResponse handleBadInputException(MethodArgumentTypeMismatchException ex) {
    return ServiceResponse.builder()
            .error(ex.getMessage())
            .status("500")
            .celsius(StringUtils.EMPTY)
            .farenheit(StringUtils.EMPTY)
            .overallDescription(StringUtils.EMPTY)
            .sunrise(StringUtils.EMPTY)
            .sunset(StringUtils.EMPTY)
            .today(StringUtils.EMPTY)
            .cityName(StringUtils.EMPTY)
            .build();
  }

}