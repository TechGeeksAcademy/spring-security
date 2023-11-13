package com.delighthomes.ams.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
@Slf4j
@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        log.info("******** Custom Bean defaultSecurityFilterChain ********");

        /* Basic Configurations */
        return http
                .authorizeHttpRequests(request ->
                        request.requestMatchers("/v1/loans/*","/v1/users/*").authenticated()
                                .anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();

        /* Deny All Requests */
        /*return http
                .authorizeHttpRequests(request ->
                        request.anyRequest().denyAll()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
        */

        /* Permit All Requests */
        /*return http
                .authorizeHttpRequests(request ->
                        request.anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();*/

    }

    /*
    @Bean
    @Profile("dev")
    public void devBean() {
        log.info("Dev Bean");
    }

    @Bean
    @Profile("stage")
    public void stageBean() {
        log.info("Stage Bean");
    }
    */
}
