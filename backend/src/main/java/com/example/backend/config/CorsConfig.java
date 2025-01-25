package com.example.backend.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(false);  // Important if you are sending credentials like cookies or basic auth headers
        config.addAllowedOrigin("*");  // Consider limiting to specific domains in production
        config.addAllowedHeader("*");  // Allows all headers
        config.addAllowedMethod("*");  // Allows all methods

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
