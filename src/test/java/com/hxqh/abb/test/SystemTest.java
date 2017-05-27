package com.hxqh.abb.test;

import com.hxqh.abb.common.util.MXCipherXUtils;
import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.*;
import com.hxqh.abb.model.dto.action.AssetDto;
import com.hxqh.abb.model.dto.action.IndexDto;
import com.hxqh.abb.model.dto.action.LoginDto;
import com.hxqh.abb.model.view.*;
import com.hxqh.abb.service.LocationService;
import com.hxqh.abb.service.SystemService;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import psdi.util.MXException;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
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
    private OrganizationDao organizationDao;
    @Resource
    private SiteDao siteDao;
    @Resource
    private LocationDao locationDao;
    @Resource
    private UdtoolDao udtoolDao;
    @Resource
    private InventoryDao inventoryDao;
    @Resource
    private AssetattributeDao assetattributeDao;
    @Resource
    private ClassstructureDao classstructureDao;
    @Resource
    private CompanyDao companyDao;
    @Resource
    private InvbalanceDao invbalanceDao;
    @Resource
    private ItemDao itemDao;
    @Resource
    private MeterDao meterDao;
    @Resource
    private PersonDao personDao;
    @Resource
    private ServiceaddressDao serviceaddressDao;
    @Resource
    private AbbIndexAssetDao abbindexassetDao;
    @Resource
    private AbbIndexWfassignmentDao abbindexwfassignmentDao;
    @Resource
    private AbbIndexWorkorderDao abbindexworkorderDao;
    @Resource
    private AbbInventoryDao abbinventoryDao;
    @Resource
    private AbbMapDao abbmapDao;
    @Resource
    private AbbUdtoolDao abbudtoolDao;
    @Resource
    private AbbAssetLocationDao abbassetlocationDao;
    @Resource
    private AbbAssetDao abbassetDao;
    @Resource
    private AbbLocationDao abblocationDao;
    @Resource
    private AbbLoginDao abbloginDao;
    @Resource
    LocationService locationService;

    @Test
    public void view() {
//        List<AbbLocation> childLocation = locationService.getChildLocation("HZ-HZ");
//        for(AbbLocation l :childLocation)
//        {
//            System.out.println(l.getDescription());
//        }

        AssetDto ao = systemService.getAssetData("AO");
        System.out.println(ao);
//        List<AbbLogin> list0=abbloginDao.findAll();
//        Assert.assertEquals(27,list0.size());


//        List<AbbIndexAsset> list0=abbindexassetDao.findAll();
//        Assert.assertEquals(257,list0.size());
//
//        List<AbbIndexWfassignment> list1=abbindexwfassignmentDao.findAll();
//        Assert.assertEquals(1439,list1.size());
//
//        List<AbbIndexWorkorder> list2=abbindexworkorderDao.findAll();
//        Assert.assertEquals(8,list2.size());
//
//        List<AbbInventory> list3=abbinventoryDao.findAll();
//        Assert.assertEquals(160,list3.size());

//        List<AbbMap> list0=abbmapDao.findAll();
//        Assert.assertEquals(27,list0.size());
//
//        List<AbbUdtool> list1=abbudtoolDao.findAll();
//        Assert.assertEquals(27,list1.size());

//        List<AbbAssetLocation> list0=abbassetlocationDao.findAll();
//        Assert.assertEquals(28,list0.size());
//
//        List<AbbAsset> list1=abbassetDao.findAll();
//        Assert.assertEquals(257,list1.size());
//        List<AbbLocation> list0=abblocationDao.findAll();
//        Assert.assertEquals(27,list0.size());

    }


    @Test
    public void test8Class() {
//        List<Assetattribute> list0=assetattributeDao.findAll();
//        Assert.assertEquals(410,list0.size());
//
//        List<Classstructure> list1=classstructureDao.findAll();
//        Assert.assertEquals(48,list1.size());
//
//        List<Company> list2=companyDao.findAll();
//        Assert.assertEquals(111,list2.size());
//
//        List<Invbalance> list3=invbalanceDao.findAll();
//        Assert.assertEquals(160,list3.size());
//
//        List<Item> list4=itemDao.findAll();
//        Assert.assertEquals(122,list4.size());
//
//        List<Meter> list5=meterDao.findAll();
//        Assert.assertEquals(169,list5.size());
//
//        List<Person> list6=personDao.findAll();
//        Assert.assertEquals(77,list6.size());

        List<Serviceaddress> list7 = serviceaddressDao.findAll();
        Assert.assertEquals(0, list7.size());
    }


    //@Test
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

//        List<Maxuser> loginUserList = systemService.getLoginUserList(loginDtoSu);
//        Assert.assertEquals(1, loginUserList.size());
//        List<Maxuser> loginUserList2 = systemService.getLoginUserList(loginDtoFail);
//        Assert.assertEquals(0, loginUserList2.size());
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
//        Assert.assertEquals(257, assetDao.findAll().size());
//        Assert.assertEquals(8, workorderDao.findAll().size());
        //Assert.assertEquals(1438, wfassignmentDao.findAll().size());
        //System.out.println(workorderDao.findAll().size());
        //System.out.println(wfassignmentDao.findAll().size());
    }

    /**
     * 密码测试 通过 2017-5-8 16:51:37
     */
    //@Test
    public void testLoginByMaximo() {
        String password = "maxadmin";
        String pwd = null;
        try {
            pwd = MXCipherXUtils.encodePwd(password);
        } catch (MXException e) {
            e.printStackTrace();
        }
        //System.out.println(pwd);
        Assert.assertEquals("10FE6F4650B2ACB49A2121D7E6133E64", pwd);
    }


    /**
     * 测试 org site
     */
    // @Test
    public void testOrgAndSite() {
        List<Organization> all = organizationDao.findAll();
        Assert.assertEquals(4, all.size());
        List<Site> all1 = siteDao.findAll();
        Assert.assertEquals(11, all1.size());
    }


    // @Test
    public void testCopy() {
        Maxuser maxuser = new Maxuser();
        maxuser.setLoginid("111");
        maxuser.setPassword("222");
        maxuser.setDefsite("234");
        LoginDto loginDto = new LoginDto();
        try {
            BeanUtils.copyProperties(loginDto, maxuser);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(loginDto);
    }


    //@Test
    public void testLocationsAndUDTool() {
        List<Location> all = locationDao.findAll();
        List<Udtool> all1 = udtoolDao.findAll();

        Assert.assertEquals(27, all.size());
        Assert.assertEquals(27, all1.size());
    }

    //@Test
    public void testInventoryAndAssetMan() {
        List<Inventory> all = inventoryDao.findAll();
        Assert.assertEquals(160, all.size());
    }


}
