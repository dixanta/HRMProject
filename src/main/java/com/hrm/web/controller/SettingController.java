/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.web.controller;

import com.hrm.web.entity.Setting;
import com.hrm.web.repository.SettingRepository;
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
@RequestMapping(value = "/settings")
public class SettingController {
    @Autowired
    private SettingRepository settingRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("settings",
                settingRepository.findAll());
        return "settings/index";
    }
    
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return "settings/add";
    }
    
    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id")Long id,Model model){
        model.addAttribute("setting",settingRepository.findById(id).get());
        return "settings/edit";
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("Setting")Setting setting){
        
        settingRepository.save(setting);
        System.out.println(setting);
        return "redirect:/settings";
    }
    
}
