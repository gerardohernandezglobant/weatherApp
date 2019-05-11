package com.weather.app.services;

import com.weather.app.model.ServiceResponse;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherRetrieverServiceTest {

  @MockBean
  WeatherRetrieverService wrs;

  @Test
  public void getWeatherWithStatus200() throws Exception{

    ServiceResponse sr = ServiceResponse.builder()
                          .status("ok")
                          .error("")
                          .cityName("London")
                          .sunrise("4:49 AM")
                          .sunset("sunset")
                          .celsius("17.7°C")
                          .farenheit("63.9°F")
                          .overallDescription("Clouds")
                          .build();
    when(wrs.getWeather(6058560)).thenReturn(sr);
    ServiceResponse response = wrs.getWeather(6058560);
    assertEquals("ok",  response.getStatus() );
  }

  @Test
  public void getWeatherWithStatus404() throws Exception{
    ServiceResponse sr = ServiceResponse.builder()
            .status("404")
            .error("Not Found").build();
    when(wrs.getWeather(1)).thenReturn(sr);
    ServiceResponse response = wrs.getWeather(1);
    assertEquals("404",response.getStatus());
  }

  @Test
  public void getWeatherWithStatus400() throws Exception{
    ServiceResponse sr = ServiceResponse.builder()
            .status("400")
            .error("Bad request").build();
    when(wrs.getWeather(112345678)).thenReturn(sr);
    ServiceResponse response = wrs.getWeather(112345678);
    assertEquals("400",response.getStatus());
  }

  @Test
  public void getWeatherWithStatus500() throws Exception{
    ServiceResponse sr = ServiceResponse.builder()
            .status("500")
            .error("Internal Server Error").build();
    when(wrs.getWeather(666)).thenReturn(sr);
    ServiceResponse response = wrs.getWeather(666);
    assertEquals("500",response.getStatus());
  }
}