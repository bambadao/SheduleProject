package com.chsu.shedule.dao;

import com.chsu.shedule.domain.Rasp;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RaspDaoImpl implements IRaspDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    @Override
    public List getRaspList() {      
        
        return this.currentSession()
                        .createQuery("from Rasp")
                        .list();
    }

    @Override
    public List getRaspListByGroup(String group) {
        
        return this.currentSession()
                        .createQuery("from Rasp where grp = ?")
                        .setParameter(0, group)
                        .list();
    }

    @Override
    public List getGroupList() {
        
        return this.currentSession()
                        .createCriteria(Rasp.class)
                        .setProjection(Projections.distinct(Projections.property("grp")))
                        .addOrder(Order.asc("grp"))
                        .list();
    }

    @Override
    public List getPrepodList() {
        
        return this.currentSession()
                        .createCriteria(Rasp.class)
                        .setProjection(Projections.distinct(Projections.property("dol")))
                        .addOrder(Order.asc("dol"))
                        .list();
    }

    @Override
    public List getRaspListByPrepod(String prepod) {
        
        return this.currentSession()
                        .createQuery("from Rasp where dol = ?")
                        .setParameter(0, prepod)
                        .list();
    }
    
}
