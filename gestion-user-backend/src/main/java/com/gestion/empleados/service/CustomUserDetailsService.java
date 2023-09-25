//package com.gestion.empleados.service;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.gestion.empleados.modelo.User;
//import com.gestion.empleados.repositorio.UserRespository;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private UserRespository userRepository;
//
//    public CustomUserDetailsService(UserRespository userRepository) {
//        this.userRepository = userRepository;
//    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findUserByEmail(email);
//        List<String> roles = Arrays.asList(user.getRol());
//        UserDetails userDetails =
//                org.springframework.security.core.userdetails.User.builder()
//                        .username(user.getMail())
//                        .password(user.getPassword())
//                        .roles("USER")
//                        .build();
//
//        return userDetails;
//    }
//}