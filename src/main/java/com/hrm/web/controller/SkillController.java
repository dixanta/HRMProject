/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.web.controller;

import com.hrm.web.entity.Skill;
import com.hrm.web.repository.SkillRepository;
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
@RequestMapping(value = "/skills")
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("skills",
                skillRepository.findAll());
        return "skills/index";
    }
    
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return "skills/add";
    }
    
    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id")Long id,Model model){
        model.addAttribute("skill",skillRepository.findById(id).get());
        return "skills/edit";
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("Skill")Skill skill){
        
        skillRepository.save(skill);
        System.out.println(skill);
        return "redirect:/skills";
    }
    
}
