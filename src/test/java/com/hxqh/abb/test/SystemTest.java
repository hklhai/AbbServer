package com.hxqh.abb.test;

import com.hxqh.abb.common.util.MXCipherXUtils;
import com.hxqh.abb.dao.AssetDao;
import com.hxqh.abb.dao.MaxuserDao;
import com.hxqh.abb.dao.WfassignmentDao;
import com.hxqh.abb.dao.WorkorderDao;
import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.Maxuser;
import com.hxqh.abb.model.dto.LoginDto;
import com.hxqh.abb.service.SystemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import psdi.util.MXException;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lh on 2017/5/5.
 */

@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SystemTest {
    @Resource
    private SystemService systemService;

    @Resource
    private AssetDao assetDao;
    @Resource
    private WorkorderDao workorderDao;

    @Resource
    private WfassignmentDao wfassignmentDao;

    @Resource
    private MaxuserDao maxuserDao;

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
        for (Location l : locationList) {
            System.out.println(l);
            System.out.println("=======================");
        }
    }

    /**
     * login Test
     */
    @Test
    public void testGetLoginUserList() throws Exception {
        LoginDto loginDtoSu = new LoginDto("maxadmin", "maxadmin");
        LoginDto loginDtoFail = new LoginDto("maxadmin", "xxx");

        List<Maxuser> loginUserList = systemService.getLoginUserList(loginDtoSu);
        Assert.assertEquals(1, loginUserList.size());
        List<Maxuser> loginUserList2 = systemService.getLoginUserList(loginDtoFail);
        Assert.assertEquals(0, loginUserList2.size());


    }

    public static String toHexString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }

    /**
     * Index page data access Test
     */
    @Test
    public void testIndexAccess() {
        Assert.assertEquals(257, assetDao.findAll().size());
        Assert.assertEquals(8, workorderDao.findAll().size());
        Assert.assertEquals(1438, wfassignmentDao.findAll().size());
        //System.out.println(workorderDao.findAll().size());
        //System.out.println(wfassignmentDao.findAll().size());
    }

    /**
     * 密码测试 通过 2017-5-8 16:51:37
     */
    @Test
    public void testLoginByMaximo() {
        String password = "maxadmin";
        String pwd = null;
        try {
            pwd = MXCipherXUtils.encodePwd(password);
        } catch (MXException e) {
            e.printStackTrace();
        }
        System.out.println(pwd);
        Assert.assertEquals("10FE6F4650B2ACB49A2121D7E6133E64", pwd);
    }



}
