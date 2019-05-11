package com.weather.app.services;

import com.weather.app.exception.WeatherAppException;
import com.weather.app.model.ServiceResponse;

public interface AppService {

  ServiceResponse getWeather(Integer cityId) throws WeatherAppException;
}
