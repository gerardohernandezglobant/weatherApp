package com.weather.app.services;

import com.weather.app.exception.WeatherAppException;
import com.weather.app.model.ServiceResponse;
import com.weather.app.model.WeatherResponse;
import com.weather.app.util.ServiceResponseBuilder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * The type Applicant data service.
 */
@NoArgsConstructor
@PropertySource("classpath:constant.properties")
@Service
public class WeatherRetrieverService implements AppService{

  @Value("${app.api.key}")
  private String apiKey;
  @Value("${app.service.url}")
  private String serviceURL;

  @Autowired
  ServiceResponseBuilder srb;

  /**
   * Retrieves the weather of a city.
   *
   * @param cityId the clientcandidate
   */
  public ServiceResponse getWeather(Integer cityId) throws WeatherAppException{

    RestTemplate restTemplate = new RestTemplate();
    String uri = serviceURL + "?id=" + cityId + "&APPID=" + apiKey ;
    try {
      WeatherResponse wr = restTemplate.getForObject(uri, WeatherResponse.class);
      Optional<WeatherResponse> opt = Optional.of(wr);
      if(opt.isPresent()){
        return srb.createResponse(wr);
      } else {
        return srb.createEmptyResponse();
      }
    }catch (HttpClientErrorException e){
      throw new WeatherAppException(e);
    }
  }
}
