package com.weather.app.controller;

import com.weather.app.model.ServiceResponse;
import com.weather.app.services.WeatherRetrieverService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherApplicationController.class)
public class WeatherApplicationControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private WeatherRetrieverService service;

  @Test
  public void whenAskingACityWeather()
          throws Exception {
    ServiceResponse sr = ServiceResponse.builder()
            .today("06/05/2019")
            .cityName("Mexico City")
            .overallDescription("Haze")
            .farenheit("75.9")
            .celsius("24.4")
            .sunrise("7:06 AM")
            .sunrise("8:00 PM").build();

    given(service.getWeather(3530597)).willReturn(sr);

    mvc.perform(get("/weather/3530597")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

  @Test
  public void whenAskingANonExistingCityWeather()
          throws Exception {
    ServiceResponse sr = ServiceResponse.builder()
            .today("")
            .cityName("")
            .overallDescription("")
            .farenheit("")
            .celsius("")
            .sunrise("")
            .sunrise("")
            .status("404")
            .error("Not Found").build();

    given(service.getWeather(1)).willReturn(sr);

    mvc.perform(get("/weather/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

  @Test
  public void whenTheInputIsWrongWeather()
          throws Exception {
    ServiceResponse sr = ServiceResponse.builder()
            .today("")
            .cityName("")
            .overallDescription("")
            .farenheit("")
            .celsius("")
            .sunrise("")
            .sunrise("")
            .status("500")
            .error("Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer'; nested exception is java.lang.NumberFormatException: For input string: \"1we23\"").build();

    given(service.getWeather(1)).willReturn(sr);

    mvc.perform(get("/weather/1we23")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }
}