package com.lambdaschool.bwpotluckplanner711.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig
        extends ResourceServerConfigurerAdapter
{
    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
    {
        resources.resourceId(RESOURCE_ID)
                .stateless(false);
    }

    @Override
    public void configure(HttpSecurity http)
            throws
            Exception
    {
        // our antMatchers control which roles of users have access to which endpoints
        // we must order our antmatchers from most restrictive to least restrictive.
        // So restrict at method level before restricting at endpoint level.
        // permitAll = everyone and their brother
        // authenticated = any authenticated, signed in, user
        // hasAnyRole = must be authenticated and be assigned this role!
        http.authorizeRequests()
                .antMatchers("/",
                        "/h2-console/**",
                        "/swagger-resources/**",
                        "/swagger-resource/**",
                        "/swagger-ui.html",
                        "/v2/api-docs",
                        "/webjars/**",
                        "/createuser",
                        "/login")
                .permitAll()
                .antMatchers("/users/users")
                .hasAnyRole("ADMIN")
                .antMatchers("/potlucks/potlucks")
                .hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,
                        "/potlucks/users/**")
                .authenticated()
                .antMatchers(HttpMethod.POST, "/potlucks/potluck/**")
                .authenticated()
//                .antMatchers(HttpMethod.POST,
//                        "/users/**")
//                .hasAnyRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,
//                        "/users/**")
//                .hasAnyRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,
//                        "/users/**")
//                .hasAnyRole("ADMIN")
//                .antMatchers("/users/**",
//                        "/useremails/**",
//                        "/oauth/revoke-token",
//                        "/logout")
//                .authenticated()
//                .antMatchers("/roles/**")
//                .hasAnyRole("ADMIN")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new OAuth2AccessDeniedHandler());

        http.csrf()
                .disable();

        http.headers()
                .frameOptions()
                .disable();

        http.logout()
                .disable();
    }
}