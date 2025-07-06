package com.example.tich_hop_security_cho_ung_dung_blog.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private MyUserDetailService myUserDetailService;

    @Autowired
    public SecurityConfiguration(MyUserDetailService myUserDetailService) {
        this.myUserDetailService = myUserDetailService;
        System.out.println("🔥 SecurityConfiguration được khởi tạo");
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // mở chặn yêu cầu
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/blogs/home","/blogs/login" ).permitAll();
                    registry.requestMatchers("/blogs","/blogs/create","/blogs/*/edit","/blogs/*/delete","/blogs/*/detail").hasRole("ADMIN");
                    registry.anyRequest().authenticated();
                })
                .formLogin(loginConfig -> {
                    loginConfig
                            .loginPage("/blogs/login").permitAll()
                            .defaultSuccessUrl("/blogs/home",true) //dung true để bỏ qua redirect ngược
                            .permitAll();
                })
                .logout(logoutConfig -> {
                    logoutConfig
                            .logoutSuccessUrl("/blogs/login?logout")
                            .permitAll();
                })
                .build();
    }


    //Xác thực và phân quyền người dùng dựa trên dữ liệu từ myUserDetailService.
    @Bean
    public UserDetailsService userDetailsService() {
        return myUserDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Cho phép kiểm soát giao diện dựa trên vai trò và trạng thái xác thực trong HTML.
    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }
}
