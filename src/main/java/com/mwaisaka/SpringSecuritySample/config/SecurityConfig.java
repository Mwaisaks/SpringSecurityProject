package com.mwaisaka.SpringSecuritySample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

          return http.csrf(AbstractHttpConfigurer::disable)
                  .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                  .formLogin(Customizer.withDefaults())
                  .httpBasic(Customizer.withDefaults())
                  .sessionManagement(session ->
                          session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))//make your http stateless
                  .build();

        /*
        Customizer<CsrfConfigurer<HttpSecurity>> csrfConfigurerCustomizer = new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
                customizer.disable();
            }
        };
        This method is a representation of the lambda verion of the first expression, same thing for the rst of the methods
        */
        //return http.build(); //replaced by use of builder pattern
    }
}
