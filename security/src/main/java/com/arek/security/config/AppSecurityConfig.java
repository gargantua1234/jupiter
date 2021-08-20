package com.arek.security.config;

import com.arek.security.jwt.JwtConfig;
import com.arek.security.jwt.JwtTokenVerifier;
import com.arek.security.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.crypto.SecretKey;

import static com.arek.domain.enums.UserPermission.COURSE_WRITE;
import static com.arek.domain.enums.UserRole.*;

@Configuration
@ComponentScan({"com.arek.security"})
@PropertySource("security.properties")
@EnableWebSecurity
@RequiredArgsConstructor
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(jwtConfig, secretKey), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/hello", "/login").permitAll()
                .antMatchers("/users", "/users/**").hasRole(STUDENT.name())
                .antMatchers(HttpMethod.DELETE, "/management/**").hasAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT, "/management/**").hasAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.POST, "/management/**").hasAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.GET, "/management/**").hasAnyRole(ADMIN.name(), ADMIN_TRAINEE.name())
                .anyRequest()
                .authenticated();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        final UserDetails johnUser = User.builder()
                .username("jon")
                .password(passwordEncoder.encode("qwer"))
                .authorities(STUDENT.getGrantedAuthorities())
                .build();

        final UserDetails lindaUser = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("qwer"))
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        final UserDetails tomUser = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("qwer"))
                .authorities(ADMIN_TRAINEE.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                johnUser,
                lindaUser,
                tomUser);
    }
}
