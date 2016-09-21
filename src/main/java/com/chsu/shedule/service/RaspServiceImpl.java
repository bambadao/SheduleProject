package com.chsu.shedule.service;

import com.chsu.shedule.dao.IRaspDao;
import com.chsu.shedule.domain.Rasp;
import com.chsu.shedule.util.DateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Map getRaspListByGroup(String group, String datePrev, String dateNext) {    
        //List raspList = this.raspDao.getRaspListByGroup(group);
        Map raspMap = this.toChooseByDate(this.raspDao.getRaspListByGroup(group), datePrev, dateNext);        
        return raspMap;
    }

    @Override
    @Transactional
    public Map getRaspListByPrepod(String prepod, String datePrev, String dateNext) {        
        //List rasps = this.raspDao.getRaspListByGroup(prepod);        
        Map raspMap = this.toChooseByDate(this.raspDao.getRaspListByPrepod(prepod), datePrev, dateNext);
        return raspMap;
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
    
    private Map toChooseByDate(List<Rasp> list, String datePrev, String dateNext) {
        
        //Initialization map output data.
        Map<String, ArrayList<Rasp>> raspMap = new HashMap<>();
        //Initialization array between datePrev and DateNext, and put date String in output map/
        List<Date> dateList = DateUtil.getDateList(datePrev, dateNext);
        for (Date date: dateList) {
            raspMap.put(DateUtil.dateToString(date), new ArrayList<Rasp>());
        }
        
        //foreach input array
        for (Rasp rasp: list) {
            //get date parameter of object input array
            int[] rangeRasp = DateUtil.rangeToInt(rasp.getNachNed());
            int dayWeekRasp = DateUtil.dayWeekToInt(rasp.getDNed());
            String parityRasp = rasp.getChNch();
            //foreach date array between date.
            for (Date date: dateList) {                
                int weekNumberDate = DateUtil.getNumberWeek(date);
                if ((rangeRasp[0] <= weekNumberDate)&&(rangeRasp[1] >= weekNumberDate)) {
                    if (dayWeekRasp == date.getDay()) {
                        String parityDate = (weekNumberDate & 1) == 0 ? "чет" : "нечет";
                        if ((parityRasp.equalsIgnoreCase("ежен")) || (parityRasp.equalsIgnoreCase(parityDate))) {
                            raspMap.get(DateUtil.dateToString(date)).add(rasp);
                        }
                    }
                }
            }
            
        }
        
        return raspMap;
    }

    @Override
    @Transactional
    public List getRaspGroup(String group) {
        List raspList = this.raspDao.getRaspListByGroup(group);       
        return raspList;
    }
}
