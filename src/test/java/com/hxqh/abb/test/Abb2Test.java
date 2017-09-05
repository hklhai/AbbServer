package com.hxqh.abb.test;

import com.hxqh.abb.service.ServerStationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Ocean lin on 2017/9/5.
 */
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Abb2Test {

    @Autowired
    private ServerStationService serverStationService;

    @Test
    public void testGetTestBook() {
//        Udvehicle udvehicle = new Udvehicle();
//        udvehicle.setDescription("HK TEST 2017-9-5 15:54:42");
//        udvehicle.setHasld(new Integer(1));
//        udvehicle.setRowstamp(12l);
//        Long aLong = serverStationService.addUdvehicle(udvehicle);
//        System.out.println("===============" + aLong);
    }

}
