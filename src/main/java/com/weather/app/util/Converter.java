package com.weather.app.util;

import java.text.DecimalFormat;


public class Converter {

  private Converter () {}

  static final Double TEMPERATURE = 273.15;
  private static DecimalFormat df = new DecimalFormat("#.#");

  public static String convertKelvinToCelsius(String kelvin){
    Double celsius= new Double(kelvin) - TEMPERATURE;
    return df.format(celsius) ;
  }

  public static String convertKelvinToFerenheit(String kelvin){
    Double farenheit= new Double(kelvin) - TEMPERATURE;
    farenheit = farenheit * 9 / 5;
    farenheit += 32;
    return df.format(farenheit) ;
  }
}
