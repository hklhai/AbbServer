package com.hxqh.abb.test;

import com.hxqh.abb.axis2.APPAUTHStub;
import com.hxqh.abb.dao.WfassignmentDao;
import org.apache.axis2.AxisFault;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.rmi.RemoteException;

/**
 * Created by dell on 2017-05-16.
 */
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Axis2Test {


    @Resource
    private WfassignmentDao wfassignmentDao;

    /**
     * 利用axis2插件生成客户端方式调用 wsdl2java简化客户端的编写
     * <p>
     * <p>
     * * 2.	审批工作流接口
     * 接口地址：http://120.76.239.5:9080/meaweb/wsdl/WFSERVICE.wsdl
     * 调用方法：wfGoOn(String  processname, String  mboName, String  keyValue,
     * String  key, int  zx, String desc, String loginid)
     * 提交参数：
     * processname：流程名称
     * mboName：当前记录所属的表名
     * keyValue： 当前表的唯一主键字段名，一般为表名+ID
     * key：唯一主键的值
     * zx：审批结果，1通过，0不通过
     * desc：审批意见
     * Loginid:当前登录人的ID
     */

    @Test
    public void test() {
    }


    /**
     * 审批工作流
     */
//    @Test
//    public void testWfGoOn() {
//        Wfassignment wfassignment = wfassignmentDao.find(3592l);
//        WFSERVICEStub wfService = null;
//        try {
//            wfService = new WFSERVICEStub();
//        } catch (AxisFault axisFault) {
//            axisFault.printStackTrace();
//        }
//
//        //设置Param
//        WfservicewfGoOn goOnService = new WfservicewfGoOn();
//        WfservicewfGoOnType wfParam = new WfservicewfGoOnType();
//
//        /*****************************设置参数********************************/
//        wfParam.setProcessname(wfassignment.getProcessname());//processname：流程名称
//        wfParam.setMboName("WFASSIGNMENT");//mboName：当前记录所属的表名
//        wfParam.setKeyValue(String.valueOf(wfassignment.getWfassignmentid()));// 当前表的唯一主键字段名，一般为表名+ID
//        wfParam.setKey("WFASSIGNMENTID"); //唯一主键的值
//        wfParam.setZx(1);//审批结果，1通过，0不通过
//        wfParam.setDesc("同意调拨申请，lh测试使用" + new Date());//desc：审批意见
//        wfParam.setLoginid("MAXADMIN");  //当前登录人的ID
//        /*****************************设置参数********************************/
//
//
//        goOnService.setWfservicewfGoOn(wfParam);
//        try {
//            String response = wfService.wfGoOn(goOnService).getWfservicewfGoOnResponse().get_return();
//            System.out.println("===================");
//            System.out.println(response);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 发送工作流
     */
//    @Test
//    public void testStartWF2startWF2() {
//        WFSERVICEStub wfService = null;
//        try {
//            wfService = new WFSERVICEStub();
//        } catch (AxisFault axisFault) {
//            axisFault.printStackTrace();
//        }
//        //设置Param
//        WfservicestartWF2 wfservicestartWF2 = new WfservicestartWF2();
//        WfservicestartWF2Type  wfParam= new WfservicestartWF2Type();
//
//        /*****************************设置参数********************************/
//        wfParam.setProcessname("UDBEDAPPLY");//processname：流程名称
//        wfParam.setMbo("UDBEDAPPLY");
//        wfParam.setKeyValue("139");// 当前表的唯一主键字段名，一般为表名+ID
//        wfParam.setKey("UDBEDAPPLYID"); //唯一主键的值
//        wfParam.setLoginid("MAXADMIN");  //当前登录人的ID
//
//        /*****************************设置参数********************************/
//
//        wfservicestartWF2.setWfservicestartWF2(wfParam);
//        try {
//            String response = wfService.startWF2(wfservicestartWF2).getWfservicestartWF2Response().get_return();
//            System.out.println("===================");
//            System.out.println(response);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }


    /**
     * 权限调用接口
     */
    @Test
    public void testGetUserApp() {
        APPAUTHStub appauthStub = null;
        try {
            appauthStub = new APPAUTHStub();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
        //设置Param
        APPAUTHStub.AppauthgetUserApp appauthgetUserApp = new APPAUTHStub.AppauthgetUserApp();
        APPAUTHStub.AppauthgetUserAppType appuserParam = new APPAUTHStub.AppauthgetUserAppType();

        /*****************************设置参数********************************/
        appuserParam.setUsername("maxadmin"); //20018124
        /*****************************设置参数********************************/
        appauthgetUserApp.setAppauthgetUserApp(appuserParam);

        try {
            String response = appauthStub.getUserApp(appauthgetUserApp).getAppauthgetUserAppResponse().get_return();
//            System.out.println("===================");
//            System.out.println(response);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
