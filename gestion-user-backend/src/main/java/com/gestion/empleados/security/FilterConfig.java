//package com.gestion.empleados.security;
//
//import java.util.Arrays;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.filter.ShallowEtagHeaderFilter;
//
//@Configuration
//public class FilterConfig {
//
//    @Bean
//    public FilterRegistrationBean<ShallowEtagHeaderFilter> filterRegistrationBean() {
//        FilterRegistrationBean<ShallowEtagHeaderFilter> filterBean = new FilterRegistrationBean<ShallowEtagHeaderFilter>();
//        filterBean.setFilter(new ShallowEtagHeaderFilter());
//        filterBean.setUrlPatterns(Arrays.asList("*"));
//        return filterBean;
//    }
//
//}