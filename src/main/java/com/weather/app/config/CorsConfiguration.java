package com.weather.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedMethods("GET", "POST")
            .allowedHeaders("Access-Control-Allow-Origin").allowedOrigins("localhost");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
            .addResourceHandler("/resources/**")
            .addResourceLocations("classpath:/other-resources/");
  }
}