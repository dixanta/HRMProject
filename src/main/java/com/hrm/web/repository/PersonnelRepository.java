/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.web.repository;

import com.hrm.web.entity.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public interface PersonnelRepository 
                extends JpaRepository<Personnel, Long> {
    
}
