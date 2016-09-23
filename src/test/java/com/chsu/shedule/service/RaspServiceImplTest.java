/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chsu.shedule.service;

import com.chsu.shedule.domain.Rasp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class RaspServiceImplTest {
    
    public RaspServiceImplTest() {
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

    /**
     * Test of getRaspList method, of class RaspServiceImpl.
     */
    @Test
    @Ignore
    public void testGetRaspList() {
        System.out.println("getRaspList");
        RaspServiceImpl instance = new RaspServiceImpl();
        List expResult = null;
        List result = instance.getRaspList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRaspListByGroup method, of class RaspServiceImpl.
     */
    @Test
    @Ignore
    public void testGetRaspListByGroup() {
        System.out.println("getRaspListByGroup");
        String group = "";
        String datePrev = "";
        String dateNext = "";
        RaspServiceImpl instance = new RaspServiceImpl();
        Map expResult = null;
        //Map result = instance.getRaspListByGroup(group, datePrev, dateNext);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRaspListByPrepod method, of class RaspServiceImpl.
     */
    @Test
    @Ignore
    public void testGetRaspListByPrepod() {
        System.out.println("getRaspListByPrepod");
        String prepod = "";
        String datePrev = "";
        String dateNext = "";
        RaspServiceImpl instance = new RaspServiceImpl();
        Map expResult = null;
        //Map result = instance.getRaspListByPrepod(prepod, datePrev, dateNext);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupList method, of class RaspServiceImpl.
     */
    @Test
    @Ignore
    public void testGetGroupList() {
        System.out.println("getGroupList");
        RaspServiceImpl instance = new RaspServiceImpl();
        List expResult = null;
        List result = instance.getGroupList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrepodList method, of class RaspServiceImpl.
     */
    @Test
    @Ignore
    public void testGetPrepodList() {
        System.out.println("getPrepodList");
        RaspServiceImpl instance = new RaspServiceImpl();
        List expResult = null;
        List result = instance.getPrepodList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRaspGroup method, of class RaspServiceImpl.
     */
    @Test
    @Ignore
    public void testGetRaspGroup() {
        System.out.println("getRaspGroup");
        String group = "";
        RaspServiceImpl instance = new RaspServiceImpl();
        List expResult = null;
        List result = instance.getRaspGroup(group);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    @Ignore
    public void testToChooseByDate() {
        System.out.println("toChooseByDate");
        List<Rasp> list = new ArrayList<>();
        list.add(new Rasp("7ЗМО-61", "вторник", "16-50 - 18-20", "31.10.2014", "обз.лк Обзорные лекции" 
                            , "c 1 по 9" , "нечет", "Крылова Н.П. доцент", "204 Сов.10" , 1, 1, 1, 1));
        String dateRange = "11.09.2016 - 15.09.2016";
        RaspServiceImpl instance = new RaspServiceImpl();
        Map<String, ArrayList<Rasp>> expResult = new HashMap<>();
        Map result = instance.toChooseByDate(list, dateRange);
        assertEquals(expResult, result);
    }
    
}
