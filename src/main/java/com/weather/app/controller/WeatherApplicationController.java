package com.weather.app.controller;

import com.weather.app.exception.WeatherAppException;
import com.weather.app.model.ServiceResponse;
import com.weather.app.services.AppService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@ComponentScan()
public class WeatherApplicationController{

    @Autowired
    private AppService service;
    @ApiOperation(value = "weather", notes = "weather")
    @GetMapping(value = "/weather/{cityId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponse getWeather (
            @PathVariable(name = "cityId") Integer cityId) throws WeatherAppException {
        return service.getWeather(cityId);
    }
}
