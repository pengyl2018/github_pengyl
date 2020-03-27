package com.example.demo.service;

import com.example.demo.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> queryArea();
    Area queryAreaById(int areaId);
    boolean insertArea(Area area);
    boolean updateArea(Area area);
    boolean deleteArea(int areaId);
}
