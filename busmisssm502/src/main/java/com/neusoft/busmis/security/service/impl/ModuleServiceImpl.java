package com.neusoft.busmis.security.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.busmis.factory.MyBatisFactory;
import com.neusoft.busmis.security.dao.IFunctionDao;
import com.neusoft.busmis.security.dao.IModuleDao;
import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.service.IModuleService;
//系统模块业务实现类
@Service("ModuleService")
@Transactional(rollbackFor=Exception.class)
public class ModuleServiceImpl implements IModuleService {
	@Autowired
	private IModuleDao moduleDao=null;
	

	@Override
	public void add(ModuleModel module) throws Exception {
		moduleDao.create(module);
			
		
	}

	@Override
	public void modify(ModuleModel role) throws Exception {
		moduleDao.update(role);

	}

	@Override
	public void delete(ModuleModel role) throws Exception {
		moduleDao.delete(role);

	}

	@Override
	@Transactional(readOnly=true)
	public List<ModuleModel> getListByAll() throws Exception {
		return moduleDao.selectListByAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public ModuleModel getByNo(int no) throws Exception {
		
		return moduleDao.selectByNo(no);
	}

	@Override
	@Transactional(readOnly=true)
	public int getCountByAll() throws Exception {
		
		return moduleDao.selectCountByAll();
	}

	@Override
	public List<ModuleModel> getListByRole(int roleNo) throws Exception {
		
		return null;
	}

	@Override
	public boolean checkAccessForRole(int moduleNo, int roleNo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ModuleModel> getselectListByAllWithFunctionsByNestedSelect() throws Exception {
		
		return moduleDao.selectListByAllWithFunctionsByNestedSelect();
		
		
	}

	@Override
	public List<ModuleModel> getselectListByAllWithFunctionsByNestedResultMap() throws Exception {
		
		return moduleDao.selectListByAllWithFunctionsByNestedResultMap();
	}

	@Override
	public List<ModuleModel> getListByAllWithRolesByNestedSelect() throws Exception {
		
		return moduleDao.selectListByAllWithRolesByNestedSelect(); 
	}

	@Override
	public List<ModuleModel> getListByAllWithRolesByNestedResultMap() throws Exception {
		return moduleDao.selectListByAllWithRolesByNestedResultMap();
	}

	@Override
	public List<ModuleModel> getListByAllWithFunctionsAndRolesFunctionByNestedSelect() throws Exception {
		
		return null;
	}

	@Override
	public List<ModuleModel> getListByAllWithFunctionsAndRolesFunctionsByNestedResultMap() throws Exception {
		
		return null;
	}

}
