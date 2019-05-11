package com.weather.app.util;

import com.weather.app.model.Main;
import com.weather.app.model.ServiceResponse;
import com.weather.app.model.Sys;
import com.weather.app.model.Weather;
import com.weather.app.model.WeatherResponse;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceResponseBuilderTest {

  @MockBean
  ServiceResponseBuilder srs;

  @Test
  public void createResponseOk() {
    Main main = new Main();
    main.setTemp("263.706");
    Sys  sys   = new Sys();
    sys.setSunrise("1234565435");
    sys.setSunset("1234565435");
    Weather weather = new Weather();
    weather.setMain("Sunny");
    Weather[] array = new Weather[1];
    array[0] = weather;

    WeatherResponse wr = new WeatherResponse();
    wr.setMain(main);
    wr.setSys(sys);
    wr.setWeather(array);
    wr.setName("Mexico City");
    ServiceResponse sr = ServiceResponse.builder()
            .status("ok")
            .error("")
            .cityName("Mexico City")
            .sunrise("4:49 AM")
            .sunset("sunset")
            .celsius("17.7")
            .farenheit("63.9")
            .overallDescription("Sunny")
            .build();
    when(srs.createResponse(wr)).thenReturn(sr);
    ServiceResponse response = srs.createResponse(wr);
    assertEquals("ok",  response.getStatus() );

  }

  @Test
  public void createEmptyResponse() {
    Main main = new Main();
    main.setTemp("263.706");
    Weather weather = new Weather();
    weather.setMain("Sunny");
    Weather[] array = new Weather[1];
    array[0] = weather;

    WeatherResponse wr = new WeatherResponse();
    wr.setMain(main);
    wr.setWeather(array);
    wr.setName("Mexico City");
    ServiceResponse sr = ServiceResponse.builder()
            .status("500")
            .error("Service response is empty")
            .cityName("")
            .sunrise("")
            .sunset("")
            .celsius("")
            .farenheit("")
            .overallDescription("")
            .build();
    when(srs.createResponse(wr)).thenReturn(sr);
    ServiceResponse response = srs.createResponse(wr);
    assertEquals("500",  response.getStatus() );
  }
}