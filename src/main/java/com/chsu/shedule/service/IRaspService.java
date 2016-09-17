package com.chsu.shedule.service;

import java.util.List;
import java.util.Map;

public interface IRaspService {
    public List getRaspList();
    public Map getRaspListByGroup(String group, String datePrev, String dateNext);
    public Map getRaspListByPrepod(String prepod, String datePrev, String dateNext);
    public List getGroupList();
    public List getPrepodList();    
}
