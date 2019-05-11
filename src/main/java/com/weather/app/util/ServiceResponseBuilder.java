package com.weather.app.util;

import com.weather.app.model.ServiceResponse;
import com.weather.app.model.WeatherResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


@PropertySource("classpath:constant.properties")
@Component
public class ServiceResponseBuilder {

  @Value("${app.util.date.format}")
  private String datePattern;

  @Value("${app.error.status}")
  private String noAnswerStatus;

  @Value("${app.error.message}")
  private String noanswerMessage;

  @Autowired
  TimeFormatter tf;


  public ServiceResponse createResponse (WeatherResponse wr){
    SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
    Optional<String> temperatureKelvin = Optional.ofNullable((wr.getMain().getTemp()));
    Optional<String> sunriseInMillis   = Optional.ofNullable(wr.getSys().getSunrise());
    Optional<String> sunsetInMillis    = Optional.ofNullable(wr.getSys().getSunset());

    if(temperatureKelvin.isPresent() && sunriseInMillis.isPresent() &&
            sunsetInMillis.isPresent()) {
      return ServiceResponse.builder()
              .today(sdf.format(new Date()))
              .cityName(wr.getName())
              .overallDescription((wr.getWeather())[0].getMain())
              .celsius(Converter.convertKelvinToCelsius(temperatureKelvin.get()))
              .farenheit(Converter.convertKelvinToFerenheit(temperatureKelvin.get()))
              .sunrise(tf.formatTime(sunriseInMillis.get()))
              .sunset(tf.formatTime(sunsetInMillis.get()))
              .status("200")
              .error("").build();
    }else return createEmptyResponse();
  }

  public ServiceResponse createEmptyResponse(){
    return ServiceResponse.builder()
            .today(StringUtils.EMPTY)
            .cityName(StringUtils.EMPTY)
            .overallDescription(StringUtils.EMPTY)
            .celsius(StringUtils.EMPTY)
            .farenheit(StringUtils.EMPTY)
            .sunrise(StringUtils.EMPTY)
            .sunset(StringUtils.EMPTY)
            .status(noAnswerStatus)
            .error(noanswerMessage).build();
  }
}
