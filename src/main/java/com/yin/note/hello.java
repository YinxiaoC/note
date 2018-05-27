package com.yin.note;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller，
@RestController
public class hello {
    @RequestMapping( value = "/hello",method = RequestMethod.GET)
    public String Hello(){
        return  "hello SpringBoot";
    }
}
