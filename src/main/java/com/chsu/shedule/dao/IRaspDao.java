package com.chsu.shedule.dao;

import java.util.List;

public interface IRaspDao {
    public List getRaspList();
    public List getRaspListByGroup(String group);
    public List getRaspListByPrepod(String prepod);
    public List getGroupList();
    public List getPrepodList();
}
