package com.api.library.security;



import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resource) {
        resource.resourceId("restservice");
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
