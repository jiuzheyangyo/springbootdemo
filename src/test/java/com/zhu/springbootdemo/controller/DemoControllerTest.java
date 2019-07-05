package com.zhu.springbootdemo.controller;

import com.zhu.springbootdemo.SpringbootdemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringbootdemoApplication.class})
@ActiveProfiles()
public class DemoControllerTest {

    @Autowired
    DemoController demoController;

    @Test
    public void testDemo(){
        demoController.demo();
    }

}