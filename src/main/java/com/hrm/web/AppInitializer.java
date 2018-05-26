/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author USER
 */
@EnableAutoConfiguration
@SpringBootApplication
public class AppInitializer extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(AppInitializer.class, args);
    }
    
    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(AppInitializer.class);
    }
}
