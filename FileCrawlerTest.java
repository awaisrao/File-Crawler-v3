/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spiderv3;

import filecrawler.FileCrawler;
import java.io.File;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author awais
 */
public class FileCrawlerTest {
    
    public FileCrawlerTest() {
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
     * Test of addTree method, of class FileCrawler.
     */
    @org.junit.Test
    public void testAddTree() {
        System.out.println("addTree");
        File file = null;
        Collection<File> all = null;
        FileCrawler.addTree(file, all);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class FileCrawler.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FileCrawler.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
