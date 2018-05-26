/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.web.controller;

import com.hrm.web.entity.DemandFollowup;
import com.hrm.web.repository.DemandFollowupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author USER
 */

@Controller
@RequestMapping(value = "/demands/followups")
public class DemandFollowupController {
    @Autowired
    private DemandFollowupRepository followupRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("followups",
                followupRepository.findAll());
        return "demandfollowups/index";
    }
    
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public @ResponseBody String save(@ModelAttribute("DemandFollowup")DemandFollowup demand){
        
        followupRepository.save(demand);
        System.out.println(demand);
        return "success";
    }
    
}
