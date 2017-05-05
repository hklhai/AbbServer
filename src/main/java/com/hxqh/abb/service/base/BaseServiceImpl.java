package com.hxqh.abb.service.base;


import com.hxqh.abb.dao.UserDao;
import com.hxqh.abb.webservice.base.BaseParameters;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseServiceImpl<T> implements BaseService {

	private final static Logger logger = Logger.getLogger(BaseServiceImpl.class);
	protected String xml;
	protected BaseParameters<T> parameters = new BaseParameters<T>();

	@Autowired
	private UserDao userDao;
//	@Autowired
//	private ModelDao modelDao;
	

	public boolean initXml(String xml) {
		this.xml = xml;
		initParams();
		if (this.parameters.getModelId() == null || this.parameters.getModelId().equals("")) {
			return true;
		}

		//TODO 权限关闭
//		List<ModelObj> list = this.getMyModelList();
//		boolean contains = false;
//		if (list != null) {
//			for (ModelObj modelObj : list) {
//				if (modelObj.getModelid().toString().equals(this.parameters.getModelId())) {
//					contains = true;
//					break;
//				}
//			}
//		}
//		return contains;
		return true;
	}

//	public List<ModelObj> getMyModelList() {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("userid", new BigDecimal(parameters.getUserId()));
//		params.put("loginpassword", parameters.getPassword());
//		List<UserObj> list = userDao.findAll("userid = :userid AND loginpassword = :loginpassword", params, null);
//		if (list.size() == 1) {
//			UserObj userObj = list.get(0);
//			Set<ModelObj> modelSet = new HashSet<ModelObj>();
//			List<RolemodelObj> rolemodelList = new ArrayList<RolemodelObj>();
//			List<UserroleObj> userroleList = userObj.getTbUserroles();
//			for (UserroleObj userroleObj : userroleList) {
//				for (RolemodelObj rolemodelObj : userroleObj.getTbRole().getTbRolemodels()) {
//					rolemodelList.add(rolemodelObj);
//				}
//			}
//			for (RolemodelObj rolemodelObj : rolemodelList) {
//				ModelObj modelObj = rolemodelObj.getTbModel();
//				if (modelObj.getModelstatus().equals(BigDecimal.ONE)) {
//					modelSet.add(rolemodelObj.getTbModel());
//				}
//			}
//			List<ModelObj> modelList = new ArrayList<ModelObj>();
//			for(ModelObj obj: modelSet) {
//				modelList.add(obj);
//			}
//			// 根据sortnum对modelList排序
//			// 类ModelObj已实现Comparable接口的compareTo方法
//			try{
//			Collections.sort(modelList);}
//			catch(Exception e){
//				e.printStackTrace();
//			}
//			return modelList;
//		} else {
//			return null;
//		}
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.ncut.isbn.service.base.BaseService#getXml()
	 */
	public String getXml() {
		return this.xml;
	}

	@SuppressWarnings("unchecked")
	protected void initParams() {
		try {
			parameters = (BaseParameters<T>) parameters.fromXML(xml);
		} catch (Exception e) {
			logger.error(e);
		}
	}


}
