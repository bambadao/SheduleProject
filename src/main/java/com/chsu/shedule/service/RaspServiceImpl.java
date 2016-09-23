package com.chsu.shedule.service;

import com.chsu.shedule.dao.IRaspDao;
import com.chsu.shedule.domain.Rasp;
import com.chsu.shedule.util.DateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.List;
import java.util.Locale;
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
    public Map getRaspListByGroup(String group, String dateRange) {    
        //List raspList = this.raspDao.getRaspListByGroup(group);
        Map raspMap = this.toChooseByDate(this.raspDao.getRaspListByGroup(group), dateRange);        
        return raspMap;
    }

    @Override
    @Transactional
    public Map getRaspListByPrepod(String prepod, String dateRange) {        
        //List rasps = this.raspDao.getRaspListByGroup(prepod);        
        Map raspMap = this.toChooseByDate(this.raspDao.getRaspListByPrepod(prepod), dateRange);
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
    
    public Map toChooseByDate(List<Rasp> list, String dateRange) {
        
        //Initialization map output data.
        Map<String, ArrayList<Rasp>> raspMap = new TreeMap<>();
        //Initialization array between datePrev and DateNext, and put date String in output map/
        String[] dates = DateUtil.rangeToStringDate(dateRange);
        List<Date> dateList = DateUtil.getDateList(dates[0], dates[1]);
        for (Date date: dateList) {
            raspMap.put(DateUtil.dateToString(date), new ArrayList<Rasp>());
        }
        
        //foreach input array
        for (Rasp rasp: list) {
            //get date parameter of object input array
            int[] rangeRasp = DateUtil.rangeToInt(rasp.getNachNed());
            //int dayWeekRasp = DateUtil.dayWeekToInt(rasp.getDNed());
            String parityRasp = rasp.getChNch();
            //foreach date array between date.
            for (Date date: dateList) {                
                int weekNumberDate = DateUtil.getNumberWeek(date);
                if ((rangeRasp[0] <= weekNumberDate)&&(rangeRasp[1] >= weekNumberDate)) {
                    String dateWeek = DateUtil.dayWeek(date);
                    if (rasp.getDNed().equalsIgnoreCase(dateWeek)) {
                        String parityDate = (weekNumberDate & 1) == 0 ? "чет" : "нечет";
                        if ((parityRasp.equalsIgnoreCase("ежен")) || (parityRasp.equalsIgnoreCase(parityDate))) {
                            raspMap.get(DateUtil.dateToString(date)).add(rasp);
                        }
                    }
                }
            }
            
        }
        
        for (Iterator<Map.Entry<String, ArrayList<Rasp>>> it = raspMap.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, ArrayList<Rasp>> temp = it.next();
            if (temp.getValue().isEmpty()) {
                it.remove();
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
