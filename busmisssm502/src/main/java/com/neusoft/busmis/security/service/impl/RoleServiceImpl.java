package com.neusoft.busmis.security.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.busmis.factory.MyBatisFactory;
import com.neusoft.busmis.security.dao.IFunctionDao;
import com.neusoft.busmis.security.dao.IRoleDao;
import com.neusoft.busmis.security.model.RoleModel;
import com.neusoft.busmis.security.service.IRoleService;
//角色业务实现类
@Service
@Transactional(rollbackFor=Exception.class)
public class RoleServiceImpl implements IRoleService {

	@Override
	public void add(RoleModel role) throws Exception {
		SqlSession session = MyBatisFactory.getSession();
		IRoleDao roleDao=session.getMapper(IRoleDao.class);
		roleDao.create(role);
		session.commit();
		session.close();
	}

	@Override
	public void modify(RoleModel role) throws Exception {
		

	}

	@Override
	public void delete(RoleModel role) throws Exception {
		SqlSession session = MyBatisFactory.getSession();
		IRoleDao roleDao=session.getMapper(IRoleDao.class);
		roleDao.delete(role);
		session.commit();
		session.close();

	}

	@Override
	public List<RoleModel> getListByAll() throws Exception {
		SqlSession session = MyBatisFactory.getSession();
		IRoleDao roleDao=session.getMapper(IRoleDao.class);
		List<RoleModel> list=roleDao.selectListByAll();
		session.commit();
		session.close();
		return list;
	}

	@Override
	public RoleModel selectByNo(int no) throws Exception {
		SqlSession session = MyBatisFactory.getSession();
		IRoleDao roleDao=session.getMapper(IRoleDao.class);
		RoleModel role=roleDao.selectByNo(no);
		session.commit();
		session.close();
		return role;
	}

	@Override
	public List<RoleModel> getListByUser(String userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
