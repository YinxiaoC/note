package com.yin.note.dao;

import java.util.List;

import com.yin.note.entity.Area;

public interface AreaDao {
    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<Area> queryArea();

    /**
     * 根据Id列出具体区域
     *
     * @return area
     */
    Area queryAreaById(int areaId);

    /**
     * 插入区域信息
     *
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
    int updataArea(Area area);

    /**
     * 删除区域信息
     *
     * @param areaId
     * @return
     */
    int delete(int areaId);
}
