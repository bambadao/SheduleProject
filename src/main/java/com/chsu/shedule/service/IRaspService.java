package com.chsu.shedule.service;

import java.util.List;

public interface IRaspService {
    public List getRaspList();
    public List getRaspListByGroup(String group, String datePrev, String dateNext);
    public List getRaspListByPrepod(String prepod, String datePrev, String dateNext);
    public List getGroupList();
    public List getPrepodList();    
}
