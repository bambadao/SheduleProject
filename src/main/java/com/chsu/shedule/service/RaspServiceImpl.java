package com.chsu.shedule.service;

import com.chsu.shedule.dao.IRaspDao;
import com.chsu.shedule.domain.Rasp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RaspServiceImpl implements IRaspService {
    
    @Autowired
    private IRaspDao raspDao;

    @Override
    @Transactional
    public List getRaspList() {
        return this.raspDao.getRaspList();
    }

    @Override
    @Transactional
    public List getRaspListByGroup(String group, String datePrev, String dateNext) {
    
        List rasps = this.raspDao.getRaspListByGroup(group);
        
        return rasps;
    }

    @Override
    @Transactional
    public List getGroupList() {
        
        List groupList = this.raspDao.getGroupList();
        
        return groupList;
    }

    @Override
    @Transactional
    public List getPrepodList() {
        
        List prepods = this.raspDao.getPrepodList();
        
        return prepods;
    }

    @Override
    @Transactional
    public List getRaspListByPrepod(String prepod, String datePrev, String dateNext) {
       
        List rasps = this.raspDao.getRaspListByGroup(prepod);
        
        return rasps;
    }
    
}
