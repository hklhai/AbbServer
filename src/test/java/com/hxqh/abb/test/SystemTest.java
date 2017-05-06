package com.hxqh.abb.test;

import com.hxqh.abb.model.Location;
import com.hxqh.abb.service.SystemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lh on 2017/5/5.
 */

@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SystemTest {
    @Resource
    private SystemService systemService;

    @Test
    public void testGetLocation() {
        List<Location> locationList = systemService.getLocationList();
        Assert.assertEquals(27, locationList.size());
    }

    //@Test
    public void testAsset() {
        long assetCount = systemService.getAssetCount();
        Assert.assertEquals(257L, assetCount);
    }

    //@Test
    public void testLocationName() {
        List<Location> locationList = systemService.getLocationList();
        for (Location l:locationList) {
            System.out.println(l);
            System.out.println("=======================");
        }
    }



}
