package com.SpringSecurigiriDemo.SpringSecurigiriDemo.config;

import jakarta.servlet.http.PushBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  public UserDetailsService userDetailsService() {

//    UserDetails user1= User.withUsername("user1").password(encoder.encode("pw1")).roles("ADMIN").build();
//    UserDetails user2= User.withUsername("user2").password(encoder.encode("pw2")).roles("USER").build();
//    UserDetails user3= User.withUsername("user3").password(encoder.encode("pw3")).roles("USER").build();
//
//
//    return new InMemoryUserDetailsManager(user1,user2,user3);

    return new UserInfoDetailsService();
  }


  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
   return http.csrf().disable()
    .authorizeHttpRequests()
    .requestMatchers("/welcome","/saveUser").permitAll()
    .and()
    .authorizeHttpRequests().requestMatchers("/**")
    .authenticated().and().formLogin()
    .and()
    .build();

  }

  @Bean
  public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService());
    provider.setPasswordEncoder(passwordEncoder());
    return provider;
  }

}
