package com.chsu.shedule.service;

import java.util.List;

public interface IRaspService {
    public List getRaspList();
    public List getRaspList(String group, String datePrev, String dateNext);
    
}
