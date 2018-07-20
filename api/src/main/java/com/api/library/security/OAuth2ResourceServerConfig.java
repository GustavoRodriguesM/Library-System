package com.api.library.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
    @Override
    public void configure(ResourceServerSecurityConfigurer config) {
        config.tokenServices(tokenServices());
    }
 
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
 
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123");
        return converter;
    }
 
    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/books").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/authors").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/categories").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/books/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/authors/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/categories/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/books/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/authors/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/categories/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();
    }
    
    
}