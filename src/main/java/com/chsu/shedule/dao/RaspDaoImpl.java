package com.chsu.shedule.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RaspDaoImpl implements IRaspDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getRaspList() {      
        
        return this.sessionFactory.getCurrentSession()
                        .createQuery("from Rasp")
                        .list();
    }

    @Override
    public List getRaspList(String group) {
        
        return this.sessionFactory.getCurrentSession()
                        .createQuery("from Rasp where grp = ?")
                        .setParameter(0, group)
                        .list();
    }
    
}
