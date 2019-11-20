package com.mypicknpay.webApi.security.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



import com.mypicknpay.webApi.repository.AppUserRepository;
import com.mypicknpay.webApi.security.jwt.JwtAuthEntryPoint;
import com.mypicknpay.webApi.security.jwt.JwtAuthTokenFilter;
import com.mypicknpay.webApi.security.jwt.SecurityConstants;
import com.mypicknpay.webApi.security.service.UserPrincipalService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages="com.mypicknpay.webApi.security.service")
@EnableJpaRepositories(basePackageClasses = AppUserRepository.class)
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
	
	 private static final String[] CORS_ALLOWED_METHODS = {"POST", "GET", "PUT", "OPTIONS", "DELETE", "PATCH"};
	    private static final String[] CORS_ALLOW_HEADERS = {"x-auth-token", "content-type", "x-requested-with", "accept",
	            "origin", "access-control-request-method", "access-control-request-headers",
	            "Authorization", "Cache-Control"};
	
    @Autowired
    UserPrincipalService userDetailsService;
 
    @Autowired
    private JwtAuthEntryPoint unauthorizedHandler;
 
    @Bean
    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
        return new JwtAuthTokenFilter();
    }
 
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
 
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().
                authorizeRequests()
                .antMatchers(HttpMethod.POST,SecurityConstants.SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.POST,SecurityConstants.SIGN_IN_URL).permitAll()
                .antMatchers(HttpMethod.POST,SecurityConstants.ADMIN).hasAnyRole("ADMIN")
                .antMatchers("/**/*.jpeg","/**/*.jpg", "/**/*.png").permitAll()
                .antMatchers(SecurityConstants.USER).permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8082"));
        configuration.setAllowedMethods(Arrays.asList(CORS_ALLOWED_METHODS));
        configuration.setAllowCredentials(false);
        configuration.setAllowedHeaders(Arrays.asList(CORS_ALLOW_HEADERS));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	
	

  
}
