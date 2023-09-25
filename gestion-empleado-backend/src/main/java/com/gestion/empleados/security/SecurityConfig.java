package com.gestion.empleados.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.gestion.empleados.service.UserService;

@Configuration

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
 
    @Autowired
    private UserService usuarioService;
 
    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
 
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuarioService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
 
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests()
//            .requestMatchers("/**").permitAll()
//            .requestMatchers("/").permitAll()
//            .requestMatchers("/**").permitAll()
//            .requestMatchers("/**").permitAll()
//            .requestMatchers("/**").permitAll()
//            .requestMatchers("/users/{id}").hasAuthority("Administrador")
//            .requestMatchers("/**").hasAnyAuthority("Administrador", "Miembro")
//            .anyRequest().authenticated()
//            .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/escritorio")
//                .failureUrl("/login?error=Usuario o Clave incorrecta")
//            .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login")
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .permitAll();
//    }
    protected void configure(HttpSecurity http) throws Exception {
    	http
    		.authorizeHttpRequests()
    			.anyRequest().authenticated()
    			.and()
    		.formLogin()
    			.and()
    		.httpBasic();
    }
    
}