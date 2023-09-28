package com.carry.myproject.security.config;

import com.carry.myproject.security.filter.ValidateCodeFilter;
import com.carry.myproject.security.handler.FastAuthenticationFailureHandler;
import com.carry.myproject.security.handler.FastAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private FastAuthenticationSuccessHandler fastAuthenticationSuccessHandler;
    @Autowired
    private FastAuthenticationFailureHandler fastAuthenticationFailureHandler;
    @Autowired
    private ValidateCodeFilter validateCodeFilter;
    @Autowired
    private DataSource dataSource;

//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
//        jdbcTokenRepository.setDataSource(dataSource);
//        jdbcTokenRepository.setCreateTableOnStartup(false);
//        return jdbcTokenRepository;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login")
                .successHandler(fastAuthenticationSuccessHandler)
                .failureHandler(fastAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/login.html", "/captcha/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
//                .and()
//                .rememberMe()
//                .tokenRepository(persistentTokenRepository())
//                .tokenValiditySeconds(3600)
//                .userDetailsService(userDetailsService())
                .and().csrf().disable();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManager();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(HttpMethod.OPTIONS);
    }
}
