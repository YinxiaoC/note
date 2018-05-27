package com.yin.note.service.Impl;

import com.yin.note.dao.AreaDao;
import com.yin.note.entity.Area;
import com.yin.note.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
   private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
       // int a = 1/0;(测试了GlobalExceptionHandler)
        return areaDao.queryAreaById(areaId);
    }

    //复杂操作用事务进行管理
    @Transactional
    //默认异常处理是RuntimeException，可以加上(rollbackFor = Exception.class)
    @Override
    public boolean addArea(Area area) {
        //首先判断名字不能为为空,传入的名字也不能为空
        if(area.getAreaName() != null && "".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            //对数据库进行传入操作
            try {
                int effrctNum = areaDao.insertArea(area);
                if (effrctNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("插入信息失败了！ ");
                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败了！ " + e.getMessage());
            }
        }else {
            throw new RuntimeException("区域不能为空");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId() != null && "".equals(area.getAreaId())){
            //area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            //对数据库进行传入操作
            try {
                int effrctNum = areaDao.updataArea(area);
                if (effrctNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("插入信息失败了！ ");
                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败了！ " + e.getMessage());
            }
        }else {
            throw new RuntimeException("区域不能为空");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId > 0){
            try {
                int effrctNum = areaDao.delete(areaId);
                if (effrctNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("插入信息失败了！ ");
                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败了！ " + e.getMessage());
            }
        }else {
            throw new RuntimeException("区域不能为空");
        }
    }
}
