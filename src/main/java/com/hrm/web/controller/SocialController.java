/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.web.controller;

import com.hrm.web.entity.Social;
import com.hrm.web.repository.SocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author USER
 */

@Controller
@RequestMapping(value = "/socials")
public class SocialController {
    @Autowired
    private SocialRepository socialRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("socials",
                socialRepository.findAll());
        return "socials/index";
    }
    
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return "socials/add";
    }
    
    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id")Long id,Model model){
        model.addAttribute("social",socialRepository.findById(id).get());
        return "socials/edit";
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("Social")Social social){
        
        socialRepository.save(social);
        System.out.println(social);
        return "redirect:/socials";
    }
    
}
