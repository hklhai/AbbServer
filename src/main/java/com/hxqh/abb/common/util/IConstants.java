package com.hxqh.abb.common.util;

/**
 * Created by Ocean lin on 2017/7/4.
 */
public interface IConstants {


    //返回Message
    Integer SUCCESS = 1;
    Integer FAIL = 0;
    Integer OCCUPIED = -3;

    String EDITNOMATCHCREATE = "The current user not match the creator";
    String OCCUPIEDINFO = "Already occupied";
    String EDITSUCCESS = "Edit Success!";
    String EDITFAIL = "Edit Fail!";
    String ADDSUCCESS = "Add Success!";
    String AUTHORIZATIONSUCCESS = "Authorization Success!";
    String USEREXISTS = "User name already exists";
    String ROLEEXISTS = "Role name already exists";
    String ADDFAIL = "Add Fail!";
    String DELETESUCCESS = "DELETE Success!";
    String DELETEFAIL = "DELETE Fail!";
    String UPLOADSUCCESS = "Upload Success!";
    String UPLOADFAIL = "Upload Fail!";

    //发送工作流
    String STARTWFSUCCESS = "Start WorkFlow Success!";
    String STARTWFFAIL = "Edit WorkFlow Fail!";
    //审批工作流
    String AUDITSUCCESS = "Audit Success!";
    String AUDITFAIL = "Audit Fail!";

    String ISSTARTWF = "IS Start WorkFlow";
    String ISNOTSTARTWF = "IS NOT Start WorkFlow";
    String STARTWFERROR = "Start WorkFlow Error";


    String OPSUCCESS = "Success!";
    String OPNOUSER = "No User!";
    String OPFAIL = "Fail!";

    String MAILSUCCESS = "Mail Success!";
    String MAILFAIL = "Mail Fail!";

//    boolean BOOLSUCCESS=true;
//    boolean BOOLFail=false;


    //增加与删除状态
    String EDIT = "edit";
    String ADD = "add";


}
