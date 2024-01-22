package br.com.ecommerce.products.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
            .authorizeHttpRequests(httpRequest -> httpRequest
            .requestMatchers("/actuator/**").permitAll()
            .anyRequest().authenticated())
            .oauth2ResourceServer(server -> server.jwt(Customizer.withDefaults()))
            .build();
    }
}
