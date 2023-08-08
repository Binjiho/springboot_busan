package com.example.demo.base.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Log4j2
public class SecurityConfig {


    /**
     * 스프링 시큐리티 5.7이전 버전
     * 스프링 시큐리티의 인증을 담당하는 AuthenticationManager는 이전 설정 방법으로 authenticationManagerBuilder를 이용해서 userDetailsService와 passwordEncoder를 설정해주어야 했습니다.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * AuthenticationManager 빈 생성 시 스프링의 내부 동작으로 인해 위에서 작성한 UserSecurityService와 PasswordEncoder가 자동으로 설정됩니다.
     */
//    @Bean
//    AuthenticationManager authenticationManager(
//            AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }


    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> {
            web.ignoring()
                    .antMatchers("/static/**","/css/**", "/js/**", "/images/**", "/lib/**", "/favicon.ico");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
//                .cors().and()
                .csrf().disable();

        http
                .authorizeHttpRequests()
                .antMatchers("/project/**").permitAll()
                .antMatchers("/admin/member/login","/admin/member/login?error","/admin/member/save","/admin/member/check").permitAll()
                .antMatchers("/css/**","/images/**","/js/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll();

        http
                .formLogin()
                .loginPage("/admin/member/login")
                .loginProcessingUrl("/login_Process")
                .usernameParameter("loginId")
                .passwordParameter("loginPw")
                .defaultSuccessUrl("/admin/login/main", true);

        http
//                .logout();
//                .logout(withDefaults());

                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/admin/member/logout"))
                .logoutSuccessUrl("/admin/member/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
        return  http.build();


    }
}
