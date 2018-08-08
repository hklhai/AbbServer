package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.IConstants;
import com.hxqh.abb.model.Asset;
import com.hxqh.abb.model.Docinfo;
import com.hxqh.abb.model.Inventory;
import com.hxqh.abb.model.TbApp;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.Message;
import com.hxqh.abb.model.view.VDoc;
import com.hxqh.abb.service.CommonService;
import com.hxqh.abb.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import scala.math.Ordering;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Ocean lin on 2017/9/12.
 */
@Controller
@RequestMapping("/file")
@SessionAttributes(value = "sessionInfo")
public class FileController {

    @Autowired
    private FileService fileService;
    @Autowired
    private CommonService commonService;

    @ResponseBody
    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    public Message uploadfileUpload(@RequestParam("files") MultipartFile files,
                                    @ModelAttribute("sessionInfo") SessionInfo sessionInfo,
                                    @RequestParam("appname") String appname,
                                    @RequestParam("pkid") Long pkid) {
        Message message = null;
        TbApp appName = commonService.getAppName(appname);
        try {
            fileService.saveFile(files, sessionInfo, appName.getApptable(), pkid);
            message = new Message(IConstants.SUCCESS, IConstants.UPLOADSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.UPLOADFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
    public Message deleteFile(@RequestParam("docinfoid") Long docinfoid) {

        Message message = null;
        try {
            fileService.deleteFile(docinfoid);
            message = new Message(IConstants.SUCCESS, IConstants.DELETESUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.DELETEFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /*
     * Download a file from
     *   - inside project, located in resources folder.
     *   - outside project, located in File system somewhere.
     */
    @RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response, @RequestParam("docinfoid") Long docinfoid) throws IOException {

        //获取文件路径
        Docinfo docinfo = fileService.getFilePath(docinfoid);
        String s = new String();
        String urlname = docinfo.getUrlname();
        if (urlname.contains("\\")) {
            s = urlname.replace("\\", "\\\\");
        } else {
            s = urlname;
        }

        File file = new File(s);
        if (!file.exists()) {
            String errorMessage = "Sorry. The file you are looking for does not exist";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }

        System.out.println("mimetype : " + mimeType);

        response.setContentType(mimeType);

        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + docinfo.getDescription() + "\""));


        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }


    /**
     * fileAssetList  设备主数据附件
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileAssetList", method = RequestMethod.GET)
    public List<VDoc> fileAssetList(Asset asset, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileAssetList(asset, sessionInfo);
    }


    /**
     * fileUdtoolList  工具台账附件
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileUdtoolList", method = RequestMethod.POST)
    public List<VDoc> fileUdtoolList(@RequestParam("udtoolid") Long udtoolid,
                                     @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileUdtoolList(udtoolid, sessionInfo);
    }


    /**
     * fileInventoryList  库存管理附件
     *
     * @return
     */
    // TODO: 2017/10/31 计划不做部分
    @ResponseBody
    @RequestMapping(value = "/fileInventoryList", method = RequestMethod.GET)
    public List<VDoc> fileInventoryList(Inventory inventory,
                                        @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileInventoryList(inventory, sessionInfo);
    }

    /**
     * fileInvuseList  物资发放、备件调拨、物资退库附件公用
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileInvuseList", method = RequestMethod.POST)
    public List<VDoc> fileInvuseList(@RequestParam("invuseid") Long invuseid,
                                     @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileInvuseList(invuseid, sessionInfo);
    }

    /**
     * filePoList  采购清单、接收、旧料回收、废料回收附件公用
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/filePoList", method = RequestMethod.GET)
    public List<VDoc> filePoList(
            @RequestParam("poid") Long poid,
            @RequestParam("vendor") String vendor,
            @RequestParam("orgid") String orgid,
            @RequestParam("ponum") String ponum,
            @RequestParam("siteid") String siteid,
            @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.filePoList(poid, vendor, orgid, ponum, siteid, sessionInfo);
    }

    /**
     * fileWorkorderList  工单管理附件
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileWorkorderList", method = RequestMethod.GET)
    public List<VDoc> fileWorkorderList(
            @RequestParam("workorderid") Long workorderid,
            @RequestParam("wonum") String wonum,
            @RequestParam("assetnum") String assetnum,
            @RequestParam("location") String location,
            @RequestParam("siteid") String siteid,
            @RequestParam("jpnum") String jpnum,
            @RequestParam("pluscjprevnum") Integer pluscjprevnum,
            @RequestParam("pmnum") String pmnum,
            @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileWorkorderList(workorderid, wonum, assetnum, location, siteid, jpnum, pluscjprevnum, pmnum, sessionInfo);
    }


    /*============================无纸化项目开始 ==========================*/

    /**
     * fileUdprojectList  项目管理
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileUdprojectList", method = RequestMethod.POST)
    public List<VDoc> fileUdprojectList(@RequestParam("udprojectid") Long udprojectid,
                                        @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileUdprojectList(udprojectid, sessionInfo);
    }

    /**
     * fileSingledelegateList  委派单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileUddelegateList", method = RequestMethod.POST)
    public List<VDoc> fileSingledelegateList(@RequestParam("uddelegateid") Long uddelegateid,
                                             @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileSingledelegateList(uddelegateid, sessionInfo);
    }

    /**
     * fileSafecheckList  项目安全计划
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileUdsafecheckList", method = RequestMethod.POST)
    public List<VDoc> fileSafecheckList(@RequestParam("udsafecheckid") Long udsafecheckid,
                                        @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileSafecheckList(udsafecheckid, sessionInfo);
    }

    /**
     * fileSingleprojectinfoList  项目服务联络函
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileProjectinfoList", method = RequestMethod.POST)
    public List<VDoc> fileSingleprojectinfoList(@RequestParam("projectinfoid") Long projectinfoid,
                                                @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileSingleprojectinfoList(projectinfoid, sessionInfo);
    }

    /**
     * fileOutboxcheckList  设备开箱检验
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileUdoutboxcheckList", method = RequestMethod.POST)
    public List<VDoc> fileOutboxcheckList(@RequestParam("udoutboxcheckid") Long udoutboxcheckid,
                                          @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileOutboxcheckList(udoutboxcheckid, sessionInfo);
    }

    /**
     * fileSingleudsafechecktable2List  现场服务安全检查
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileUdsafechecktable2List", method = RequestMethod.POST)
    public List<VDoc> fileSingleudsafechecktable2List(@RequestParam("udsafechecktable2id") Long udsafechecktable2id,
                                                      @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileSingleudsafechecktable2List(udsafechecktable2id, sessionInfo);
    }

    /**
     * fileTrainrecordList  现场培训记录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileUdtrainrecordList", method = RequestMethod.POST)
    public List<VDoc> fileTrainrecordList(@RequestParam("udtrainrecordid") Long udtrainrecordid,
                                          @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileTrainrecordList(udtrainrecordid, sessionInfo);
    }

    /**
     * fileNowcheckList  设备安装/调试/送电现场检查
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileUdnowcheckList", method = RequestMethod.POST)
    public List<VDoc> fileNowcheckList(@RequestParam("udnowcheckid") Long udnowcheckid,
                                       @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileNowcheckList(udnowcheckid, sessionInfo);
    }

    /**
     * fileProblemmodifyList  现场问题整改通知书
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/fileUdproblemmodifyList", method = RequestMethod.POST)
    public List<VDoc> fileProblemmodifyList(@RequestParam("udproblemmodifyid") Long udproblemmodifyid,
                                            @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        return fileService.fileProblemmodifyList(udproblemmodifyid, sessionInfo);
    }

    /*============================无纸化项目开始 ==========================*/


}
