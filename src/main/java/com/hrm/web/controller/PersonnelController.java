/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.web.controller;

import com.hrm.web.entity.Personnel;
import com.hrm.web.repository.PersonnelRepository;
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
@RequestMapping(value = "/personnels")
public class PersonnelController {
    @Autowired
    private PersonnelRepository personnelRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("personnels",
                personnelRepository.findAll());
        return "personnels/index";
    }
    
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return "personnels/add";
    }
    
    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id")Long id,Model model){
        model.addAttribute("personnel",personnelRepository.findById(id).get());
        return "personnels/edit";
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("Personnel")Personnel personnel){
        
        personnelRepository.save(personnel);
        System.out.println(personnel);
        return "redirect:/personnels";
    }
    
}
