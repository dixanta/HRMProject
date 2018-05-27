/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.web;

import com.hrm.web.repository.SettingRepository;
import com.hrm.web.util.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author USER
 */
@Configuration
public class AppConfigurer {
    
   @Autowired
   private SettingRepository setting;
   
   @Bean
   public Mailer getMailer(){
       Mailer mailer=new Mailer();
       mailer.setFrom(setting.getByName("email"));
       mailer.setHost(setting.getByName("email_host"));
       mailer.setPort(setting.getByName("email_port"));
       mailer.setUserName(setting.getByName("email_username"));
       mailer.setPassword(setting.getByName("email_password"));
       return mailer;
   }
   
}
