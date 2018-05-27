/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.web.repository;

import com.hrm.web.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public interface SettingRepository 
                extends JpaRepository<Setting, Long> {
    
    @Query(value = "select value from settings where name=:name",nativeQuery = true)
    String getByName(@Param("name") String name);
}
