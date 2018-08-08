package com.hxqh.abb.service;

import com.hxqh.abb.model.*;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.version2.Invuse;
import com.hxqh.abb.model.version2.Po;
import com.hxqh.abb.model.view.VDoc;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Ocean lin on 2017/9/12.
 */
public interface FileService {

    void saveFile(MultipartFile file, SessionInfo sessionInfo, String apptable, Long pkid) throws Exception;

    void deleteFile(Long docinfoid) throws Exception;

    Docinfo getFilePath(Long docinfoid);

    List<VDoc> fileAssetList(Asset asset, SessionInfo sessionInfo);

    List<VDoc> fileUdtoolList(Long udtoolid, SessionInfo sessionInfo);

    List<VDoc> fileInventoryList(Inventory inventory, SessionInfo sessionInfo);

    List<VDoc> fileInvuseList(Long invuseid, SessionInfo sessionInfo);

    List<VDoc> filePoList(Long poid, String vendor, String orgid, String ponum, String siteid, SessionInfo sessionInfo);

    List<VDoc> fileWorkorderList(Long workorderid, String wonum, String assetnum, String location, String siteid, String jpnum, Integer pluscjprevnum, String pmnum, SessionInfo sessionInfo);

    List<VDoc> fileUdprojectList(Long udprojectid, SessionInfo sessionInfo);

    List<VDoc> fileSingledelegateList(Long uddelegateid, SessionInfo sessionInfo);

    List<VDoc> fileSafecheckList(Long udsafecheckid, SessionInfo sessionInfo);

    List<VDoc> fileSingleprojectinfoList(Long projectinfoid, SessionInfo sessionInfo);

    List<VDoc> fileOutboxcheckList(Long udoutboxcheckid, SessionInfo sessionInfo);

    List<VDoc> fileSingleudsafechecktable2List(Long udsafechecktable2id, SessionInfo sessionInfo);

    List<VDoc> fileTrainrecordList(Long udtrainrecordid, SessionInfo sessionInfo);

    List<VDoc> fileNowcheckList(Long udnowcheckid, SessionInfo sessionInfo);

    List<VDoc> fileProblemmodifyList(Long udproblemmodifyid, SessionInfo sessionInfo);
}
