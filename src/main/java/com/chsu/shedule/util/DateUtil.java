package com.chsu.shedule.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DateUtil {

    private DateUtil() {}
    
    public static String[] rangeToStringDate(String dateRange) {
        String[] temp = {"",""};
        Matcher matcher = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d").matcher(dateRange);
        int count = 0;
        while(matcher.find()) {
            temp[count] = matcher.group();
            count++;
        }
        if (temp[1].isEmpty()) {
            temp[1] = temp[0];
        }
        return temp;
    }
    
    public static int[] rangeToInt(String rangeWeeks) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(rangeWeeks);
	int[] temp = new int[2];
	int i = 0;
        while (matcher.find()) {
            String value = matcher.group();
            temp[i] = Integer.parseInt(value);
            i++;
	}
	return temp;
    }
    
    public static String dayWeek(Date day) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E");
        simpleDateFormat = new SimpleDateFormat("EEEE", new Locale("ru"));
        return simpleDateFormat.format(day);
    }
    
    public static Date stringToDate(String currentDate) {			
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	Date date = null;
	try {
            date = sdf.parse(currentDate);
	} catch (ParseException e) {
            e.printStackTrace();
	}        
	return date;        
    }
    
    public static String dateToString(Date date) {		
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");		
	return sdf.format(date);
    }
    
    public static List getDateList(String datePrev, String dateNext) {
        List<Date> dateList = new ArrayList();
        
        Date dateStart = DateUtil.stringToDate(datePrev);
        Date dateEnd = DateUtil.stringToDate(dateNext);
        
        Calendar start = Calendar.getInstance();
        start.setTime(dateStart);
        Calendar end = Calendar.getInstance();
        end.setTime(dateEnd);
        
        while (start.compareTo(end) <= 0) {
            dateList.add(start.getTime());
            start.add(Calendar.DATE, 1);
	}
        return dateList;
    }
    
    public static int getNumberWeek(Date date) {		
        long MILLISECONDS_PER_DAY = 24 * 60 * 60 * 1000;
	long MILLISECONDS_PER_WEEK = 7 * MILLISECONDS_PER_DAY;
	    
	Date fromDate = new Date(date.getMonth() < 8 ? date.getYear() - 1 : date.getYear(), 8, 1);
	long longBeetweenDays = date.getTime() - fromDate.getTime();
	long longTimeOfFirstWeek = ((7 - (fromDate.getDay() == 0 ? 6 : fromDate.getDay() - 1)) * MILLISECONDS_PER_DAY);
	int result = (int) (longBeetweenDays < longTimeOfFirstWeek ? 0 : ((longBeetweenDays - longTimeOfFirstWeek) / (MILLISECONDS_PER_WEEK) + 2));
	
	return result;
    }
    
}
