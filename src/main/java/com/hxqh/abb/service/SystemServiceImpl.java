package com.hxqh.abb.service;

import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.Location;
import com.hxqh.abb.model.Person;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.AssetDto;
import com.hxqh.abb.model.dto.action.Calendar;
import com.hxqh.abb.model.dto.action.IndexDto;
import com.hxqh.abb.model.dto.action.LoginDto;
import com.hxqh.abb.model.version2.Email;
import com.hxqh.abb.model.version2.Phone;
import com.hxqh.abb.model.view.*;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by lh on 2017/4/14.
 */
@Transactional
@Service("systemService")
public class SystemServiceImpl implements SystemService {
    private final static Logger logger = Logger.getLogger(SystemServiceImpl.class);

    @Autowired
    private LocationDao locationDao;
    @Autowired
    private AbbIndexWfassignmentDao abbindexwfassignmentDao;
    @Autowired
    private AbbIndexWorkorderDao abbindexworkorderDao;
    @Autowired
    private AbbIndexAssetDao abbindexassetDao;
    @Resource
    private AbbAssetLocationDao abbassetlocationDao;
    @Resource
    private AbbAssetDao abbassetDao;
    @Resource
    private AbbLoginDao abbloginDao;
    @Resource
    private AbbAssetSpecDao abbAssetSpecDao;
    @Resource
    private AbbAssetUdsparepartDao assetUdsparepartDao;
    @Resource
    private AbbAssetHisMrecordDao abbAssetHisMrecordDao;
    @Resource
    private AbbAssetHisAssetmeterDao abbAssetHisAssetmeterDao;
    @Resource
    private AbbAssetHisWorkorderDao abbAssetHisWorkorderDao;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private EmailDao emailDao;
    @Autowired
    private PhoneDao phoneDao;
    @Autowired
    private VPersonDao vPersonDao;


    @Value(value = "${com.hxqh.abb.usericon}")
    private String uploadPath;

    @Value(value = "${com.hxqh.abb.websitepath}")
    private String websitepath;


    @Value(value = "${com.hxqh.abb.websiteaddres}")
    private String websiteaddress;

    @Value(value = "${com.hxqh.abb.websiteport}")
    private String websiteport;


    public List<Location> getLocationList() {
        return locationDao.findAll();
    }

    @Override
    public long getAssetCount() {
        return abbindexassetDao.getCount();
    }

    @Override
    public List<AbbLogin> getLoginUserList(LoginDto loginDto) {

        Map<String, Object> params = new HashMap<>();
        params.put("loginid", loginDto.getLoginid());
        String where = "loginid=:loginid ";
        List<AbbLogin> maxuserList = abbloginDao.findAll(where, params, null);
        return maxuserList;
    }

    /**
     * 获取主页显示内容
     *
     * @return
     */
    @Override
    public IndexDto getSystemMessage(SessionInfo sessionInfo) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("siteid", sessionInfo.getSiteid());
        params.put("reportedby", sessionInfo.getDisplayname());
        params.put("stateWarn", "报警");
        params.put("stateProWarn", "预报警");

        params.put("assigncode", sessionInfo.getLoginId());

        String workorderWhere = "targstartdate is not null and reportedby=:reportedby";
        String wfWhere = "startdate is not null and duedate is not null";
        String wflWhere = wfWhere + " and assigncode=:assigncode";
        String assetWhere = "siteid=:siteid and (state=:stateWarn or state=:stateProWarn)";
        String wfassignmentWhere = wflWhere;

        List<AbbIndexWorkorder> calendarList = abbindexworkorderDao.findAll(0, 4, workorderWhere, params, " order by workorderid desc");
        List<AbbIndexAsset> assetList = abbindexassetDao.findAll(0, 4, assetWhere, params, " order by assetuid desc");
        List<AbbIndexWfassignment> wfassignmentList = abbindexwfassignmentDao.findAll(0, 5, wfassignmentWhere, params, " order by wfassignmentid desc");
        //增加对Calendar处理
        List<Calendar> calendar = process(calendarList);

        IndexDto indexDto = new IndexDto(calendarList, assetList, wfassignmentList, sessionInfo, calendar);
        return indexDto;
    }

    private List<Calendar> process(List<AbbIndexWorkorder> calendarList) {
        //先放入Map中
        Map<Date, List<String>> map = new HashMap<>();
        Set<Map.Entry<Date, List<String>>> entries = map.entrySet();
        for (AbbIndexWorkorder cal : calendarList) {
            List<String> wList = new ArrayList<>();

            if (map.size() == 0 && cal.getTargstartdate() != null) {
                wList.add(cal.getWonum());
                map.put(cal.getTargstartdate(), wList);
            } else {
                for (Map.Entry<Date, List<String>> entry : entries) {
                    Date key = entry.getKey();
                    if (DateUtils.isSameDay(cal.getTargstartdate(), key)) {
                        entry.getValue().add(cal.getWonum());
                    } else {
                        wList.add(cal.getWonum());
                        map.put(cal.getTargstartdate(), wList);
                    }
                }
            }
        }

        List<Calendar> calendar = new ArrayList<>();
        for (Map.Entry<Date, List<String>> entry : entries) {
            Calendar c = new Calendar(entry.getKey(), entry.getValue());
            calendar.add(c);
        }
        return calendar;
    }


    @Override
    public AssetDto getAssetData(String location, SessionInfo sessionInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("location", location);
        params.put("siteid", sessionInfo.getSiteid());
        String where = "location=:location and siteid=:siteid";
        List<AbbAsset> abbAssetList = abbassetDao.findAll(0, 15, where, params, " order by assetuid desc");
        List<AbbAssetLocation> abbAssetLocationList = abbassetlocationDao.findAll(0, 15, "location=:location", params, " order by locationsid desc");
        AssetDto assetDto = new AssetDto(abbAssetList, abbAssetLocationList.get(0));
        return assetDto;
    }

    @Override
    public List<AbbAsset> getAssetByChild(String childname) {
        Map<String, Object> params = new HashMap<>();
        params.put("childname", childname);
        List<AbbAsset> abbAssetList = abbassetDao.findAll("DESCRIPTION=:childname", params, null);
        return abbAssetList;
    }

    @Override
    public List<AbbAssetSpec> getAssetSpec(String classstructureid) {
        Map<String, Object> params = new HashMap<>();
        params.put("classstructureid", classstructureid);
        List<AbbAssetSpec> assetSpecList = abbAssetSpecDao.findAll("classstructureid=:classstructureid", params, null);
        return assetSpecList;
    }

    @Override
    public List<AbbAssetUdsparepart> getAssetUdspareparts(String classstructureid) {
        Map<String, Object> params = new HashMap<>();
        params.put("classstructureid", classstructureid);
        List<AbbAssetUdsparepart> assetUdsparepartList = assetUdsparepartDao.findAll("classstructureid=:classstructureid", params, null);
        return assetUdsparepartList;
    }

    @Override
    public List<AbbAssetHisMrecord> getAssetHistoryExecution(String classstructureid) {
        Map<String, Object> params = new HashMap<>();
        params.put("classstructureid", classstructureid);
        List<AbbAssetHisMrecord> assetHisWorkorderList = abbAssetHisMrecordDao.findAll("classstructureid=:classstructureid", params, null);
        return assetHisWorkorderList;
    }

    @Override
    public List<AbbAssetHisWorkorder> getAssetHistoryWork(String classstructureid) {
        Map<String, Object> params = new HashMap<>();
        params.put("classstructureid", classstructureid);
        List<AbbAssetHisWorkorder> hisWorkorderList = abbAssetHisWorkorderDao.findAll("classstructureid=:classstructureid", params, null);
        return hisWorkorderList;
    }

    @Override
    public List<AbbAssetHisAssetmeter> getAssetHistoryMonitor(String classstructureid) {
        Map<String, Object> params = new HashMap<>();
        params.put("classstructureid", classstructureid);
        List<AbbAssetHisAssetmeter> assetHisAssetmeterList = abbAssetHisAssetmeterDao.findAll("classstructureid=:classstructureid", params, null);
        return assetHisAssetmeterList;
    }

    @Override
    public String getWebsitPath() {
        return websitepath;
    }

    @Override
    public AbbAsset getAssetById(long assetuid) {
        return abbassetDao.find(assetuid);
    }

    @Override
    public VPerson personData(String personid) {
        Map<String, Object> params = new HashMap<>();
        params.put("personid", personid);

        return vPersonDao.findAll("personid=:personid", params, null).get(0);
    }

    @Override
    public void editPersonData(VPerson vPerson, SessionInfo sessionInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("personid", vPerson.getPersonid());

        Person person = personDao.find(vPerson.getPersonuid());
        if (vPerson.getDisplayname() != null)
            person.setDisplayname(vPerson.getDisplayname());
        // 暂时设置Country存储图片位置
        if (vPerson.getCountry() != null)
            person.setCountry(vPerson.getCountry());
        personDao.update(person);

        if (vPerson.getPhonenum() != null) {
            List<Phone> phoneList = phoneDao.findAll("personid=:personid", params, null);
            // TODO: 2017/11/21 暂时不加判断
            phoneList.get(0).setPhonenum(vPerson.getPhonenum());
            phoneDao.update(phoneList.get(0));
        }
        if (vPerson.getEmailaddress() != null) {
            List<Email> emailList = emailDao.findAll("personid=:personid", params, null);
            emailList.get(0).setEmailaddress(vPerson.getEmailaddress());
            emailDao.save(emailList.get(0));
        }
    }

    @Override
    public void saveFile(MultipartFile files, SessionInfo sessionInfo, Long personuid) {
        String filename = new String();

        if (files.getOriginalFilename() != null && files.getSize() > 0) {
            File f = new File(uploadPath);

            if (!f.exists())
                f.mkdirs();
            filename = uploadPath
                    + "/"
                    + files.getOriginalFilename();
            FileOutputStream outputStream;
            try {
                outputStream = new FileOutputStream(new File(filename));
                outputStream.write(files.getBytes());
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }

        // 转换成URL链接
        StringBuilder url = new StringBuilder();
        url.append("http://").append(websiteaddress).append(":").append(websiteport).
                append("/file/").append(files.getOriginalFilename());

        Person person = personDao.find(personuid);
        // 暂时设置Country存储图片位置
        person.setCountry(url.toString());


        personDao.update(person);
    }
}
