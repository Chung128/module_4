package com.example.su_dung_spring_security.config;

import com.example.su_dung_spring_security.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private MyUserDetailService myUserDetailService;

    @Autowired
    public SecurityConfiguration(MyUserDetailService myUserDetailService) {
        this.myUserDetailService = myUserDetailService;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // mở chặn yêu cầu
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/home","register/**").permitAll();
                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
                    registry.requestMatchers("/user/**").hasRole("USER");
                    registry.anyRequest().authenticated();
                })
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails nomalUser = User.builder()
//                .username("vanchung")
//                .password("$2a$12$9Fi6S0jbfuYeyCQXSTDyh.OfyKqDf0QSg3DXH.erCPkfPHCPkdIoK")
//                .roles("USER")
//                .build();
//        UserDetails adminUser = User.builder()
//                .username("chung")
//                .password("$2a$12$ZzpllV0hqvY30/5HlzhxX.jHCtjXBKs7EzIob6u5LQj3IS6kRaVXa")
//                .roles("ADMIN","USER")
//                .build();
//        return new InMemoryUserDetailsManager(nomalUser,adminUser);
//    }

    @Bean
    public UserDetailsService userDetailsService(){
        return myUserDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
