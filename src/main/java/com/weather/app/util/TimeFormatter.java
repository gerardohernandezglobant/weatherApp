package com.weather.app.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@PropertySource("classpath:constant.properties")
@Component
public class TimeFormatter {

  private TimeFormatter() {}


  static final long TIME_CONSTANT = 1000;

  @Value("${app.util.time.pattern}")
  private String timePattern;

  public String formatTime(String time){

    Date unixTime = new Date(new Long(time)*TIME_CONSTANT);
    SimpleDateFormat dateFormat = new SimpleDateFormat(timePattern);
    return dateFormat.format(unixTime);
  }
}
