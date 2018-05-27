/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrm.web.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping(value = "/media")
public class MediaController {
    
    @RequestMapping(method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public void index(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        System.out.println(request.getRemoteAddr());
        InputStream is=this.getClass()
                .getResourceAsStream("/static/assets/img/shiva.jpg");
                
                
        OutputStream os=response.getOutputStream();
        byte[] data=new byte[1024];
        int i=0;
        while((i=is.read(data))!=-1){
            os.write(data, 0, i);
        }
        os.close();
        is.close();
    }
}
