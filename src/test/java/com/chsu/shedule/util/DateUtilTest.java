/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chsu.shedule.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Qwerty
 */
public class DateUtilTest {
    
    public DateUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test    
    public void testRangeToStringDate(){
        System.out.println("rangeToStringDate");
        String dateRange = "11/09/2016 - 15/09/2016";
        String[] expResult = {"11/09/2016", "15/09/2016"};
        String[] result = DateUtil.rangeToStringDate(dateRange);
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of rangeToInt method, of class DateUtil.
     */
    @org.junit.Test
    public void testRangeToInt() {
        System.out.println("rangeToInt");
        String rangeWeeks = "от 4 до 31";
        int[] expResult = {4,31};
        int[] result = DateUtil.rangeToInt(rangeWeeks);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of dayWeekToInt method, of class DateUtil.
     */
    @org.junit.Test
    public void testDayWeek() {
        System.out.println("dayWeekToInt");
        Date day = new Date(2016-1900,8,13);
        String expResult = "вторник";
        String result = DateUtil.dayWeek(day);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringToDate method, of class DateUtil.
     */
    @org.junit.Test
    public void testStringToDate() {
        System.out.println("stringToDate");
        String currentDate = "11.09.2016";
        Date expResult = new Date(2016-1900,8,11);
        Date result = DateUtil.stringToDate(currentDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of dateToString method, of class DateUtil.
     */
    @org.junit.Test
    public void testDateToString() {
        System.out.println("dateToString");
        Date date = new Date(2016-1900,8,11);
        String expResult = "11.09.2016";
        String result = DateUtil.dateToString(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateList method, of class DateUtil.
     */
    @org.junit.Test
    public void testGetDateList() {
        System.out.println("getDateList");
        String datePrev = "01.09.2016";
        String dateNext = "03.09.2016";
        List expResult = null; 
        List<Date> list = new ArrayList<Date>();
        list.add(new Date(2016-1900, 8, 1));
        list.add(new Date(2016-1900, 8, 2));
        list.add(new Date(2016-1900, 8, 3));
        expResult = list;
        List result = DateUtil.getDateList(datePrev, dateNext);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberWeek method, of class DateUtil.
     */
    @org.junit.Test
    public void testGetNumberWeek() {
        System.out.println("getNumberWeek");
        Date date = new Date(2016-1900, 8, 14);
        int expResult = 3;
        int result = DateUtil.getNumberWeek(date);
        assertEquals(expResult, result);
    }
    
}
