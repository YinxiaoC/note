package com.yin.note.dao;

import com.yin.note.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

//测试运行器
@RunWith(SpringRunner.class)
//调用spring-boot-starter-test
@SpringBootTest
public class areaDaoTest {
    //动态实现areaDao的加载
@Autowired
        //将idea spring core自动解析级别降低到warning ##Autowiring for bean class
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(3, areaList.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("西湖",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("余杭");
        area.setPriority(10);
        int effNum = areaDao.insertArea(area);
        assertEquals(1,effNum);
    }

    @Test
    @Ignore
    public void updataArea() {
        Area area = new Area();
        area.setAreaId(1);
        area.setAreaName("西湖区");
       area.setLastEditTime(new Date());
        int effNum = areaDao.updataArea(area);
        assertEquals(1,effNum);
    }

    @Test

    public void delete() {
        int effNum = areaDao.delete(4);
        assertEquals(1,effNum);
    }
}