package com.delighthomes.ams.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
                        request.requestMatchers("/login/**","/logout/**").permitAll()
                                .requestMatchers("/v1/users/**").hasAnyRole("USER")
                                .requestMatchers("/v1/admin/**").hasAnyRole("ADMIN")
                                .requestMatchers("/v1/superadmin/**").hasAnyRole("SUPER_ADMIN")
                                .requestMatchers("/v1/all/**").hasAnyRole("USER", "ADMIN", "SUPER_ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails admin = User.builder().passwordEncoder(encoder::encode)
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                //.authorities("READ", "CREATE", "DELETE")
                .build();

        UserDetails user = User.builder().passwordEncoder(encoder::encode)
                .username("user")
                .password("user")
                .roles("USER")
                //.authorities("READ")
                .build();

        UserDetails superUser = User.builder().passwordEncoder(encoder::encode)
                .username("harish")
                .password("harish")
                .roles("SUPER_ADMIN")
                //.authorities("READ", "CREATE", "DELETE")
                .build();

        return new InMemoryUserDetailsManager(admin, user, superUser);
    }
}
