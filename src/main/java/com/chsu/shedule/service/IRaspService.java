package com.chsu.shedule.service;

import java.util.List;
import java.util.Map;

public interface IRaspService {
    public List getRaspList();
    public Map getRaspListByGroup(String group, String dateRange);
    public Map getRaspListByPrepod(String prepod, String dateRange);
    public List getGroupList();
    public List getPrepodList();
    public List getRaspGroup(String group);
}
