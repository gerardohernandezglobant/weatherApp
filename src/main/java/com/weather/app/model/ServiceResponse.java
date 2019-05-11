package com.weather.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
/**
 * Class that represents the response of this application.
 */
public class ServiceResponse {

    private String today;
    private String cityName;
    private String overallDescription;
    private String farenheit;
    private String celsius;
    private String sunrise;
    private String sunset;
    //Error fields
    private String error;
    private String status;

}
