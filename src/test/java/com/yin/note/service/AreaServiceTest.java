package com.yin.note.service;

import com.yin.note.dao.AreaDao;
import com.yin.note.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
//调用spring-boot-starter-test
@SpringBootTest
public class AreaServiceTest {
    @Autowired
    //将idea spring core自动解析级别降低到warning ##Autowiring for bean class
    private AreaDao areaDao;

}