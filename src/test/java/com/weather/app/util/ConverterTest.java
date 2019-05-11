package com.weather.app.util;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

  @Test
  public void convertKelvinToCelsius() {
    String kelvinDegrees = "0";
    assertEquals("-273.1",Converter.convertKelvinToCelsius(kelvinDegrees));
  }

  @Test
  public void convertKelvinToCelsius2() {
    String kelvinDegrees = "273.15";
    assertEquals("0",Converter.convertKelvinToCelsius(kelvinDegrees));
  }

  @Test
  public void convertKelvinToCelsius3() {
    String kelvinDegrees = "293.15";
    assertEquals("20",Converter.convertKelvinToCelsius(kelvinDegrees));
  }

  @Test
  public void convertKelvinToFerenheit() {
    String kelvinDegrees = "300";
    assertEquals("80.3",Converter.convertKelvinToFerenheit(kelvinDegrees));
  }

  @Test
  public void convertKelvinToFerenheit2() {
    String kelvinDegrees = "273.15";
    assertEquals("32",Converter.convertKelvinToFerenheit(kelvinDegrees));
  }

  @Test
  public void convertKelvinToFerenheit3() {
    String kelvinDegrees = "263.70";
    assertEquals("15",Converter.convertKelvinToFerenheit(kelvinDegrees));
  }
}