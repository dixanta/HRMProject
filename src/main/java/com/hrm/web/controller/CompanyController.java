/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.web.controller;

import com.hrm.web.entity.Company;
import com.hrm.web.repository.CompanyRepository;
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
@RequestMapping(value = "/companies")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("companies",
                companyRepository.findAll());
        return "companies/index";
    }
    
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        return "companies/add";
    }
    
    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
    public String edit(@PathVariable("id")Long id,Model model){
        model.addAttribute("company",companyRepository.findById(id).get());
        return "companies/edit";
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("Company")Company company){
        company.setLatitude("");
        company.setLongitude("");
        company.setLogo("");
        companyRepository.save(company);
        System.out.println(company);
        return "redirect:/companies";
    }
    
}
