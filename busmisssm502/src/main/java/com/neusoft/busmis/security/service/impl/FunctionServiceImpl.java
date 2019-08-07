package com.neusoft.busmis.security.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.busmis.factory.MyBatisFactory;
import com.neusoft.busmis.security.dao.IFunctionDao;
import com.neusoft.busmis.security.model.FunctionModel;
import com.neusoft.busmis.security.service.IFunctionService;
//系统功能业务实现类
@Service
@Transactional(rollbackFor=Exception.class)
public class FunctionServiceImpl implements IFunctionService {

	@Override
	public void create(FunctionModel function) throws Exception {
		SqlSession session = MyBatisFactory.getSession();
		IFunctionDao functionDao=session.getMapper(IFunctionDao.class);
		functionDao.create(function);
		
		
		session.commit();
		session.close();

	}

	@Override
	public void update(FunctionModel function) throws Exception {
		

	}

	@Override
	public void delete(FunctionModel fm) throws Exception{
		

	}

	@Override
	public List<FunctionModel> selectListByAll() throws Exception {
		SqlSession session = MyBatisFactory.getSession();
		IFunctionDao functionDao=session.getMapper(IFunctionDao.class);
		List<FunctionModel> list=functionDao.selectListByAll();
		session.commit();
		session.close();
		
		return list;
	}
	
	@Override
	public List<FunctionModel> selectListByAllWithModuleByNestedSelect() throws Exception {
		SqlSession session = MyBatisFactory.getSession();
		IFunctionDao functionDao=session.getMapper(IFunctionDao.class);
		List<FunctionModel> list=functionDao.selectListByAllWithNestedSelect();
		session.commit();
		session.close();
		
		return list;
	}

	@Override
	public List<FunctionModel> selectListByAllWithModuleByNestedResultMap() throws Exception {
		SqlSession session = MyBatisFactory.getSession();
		IFunctionDao functionDao=session.getMapper(IFunctionDao.class);
		List<FunctionModel> list=functionDao.selectListByAllWithNestedResultMap();
		session.commit();
		session.close();
		
		return list;
	}
	
	

	@Override
	public List<FunctionModel> selectListByModule(int moduleNo) throws Exception {
		SqlSession session = MyBatisFactory.getSession();
		IFunctionDao functionDao=session.getMapper(IFunctionDao.class);
		List<FunctionModel> list=functionDao.selectListByModule(moduleNo);
		session.commit();
		session.close();
		
		return list;
		
	}

	@Override
	public FunctionModel selectByNo(int no) throws Exception {
		SqlSession session = MyBatisFactory.getSession();
		IFunctionDao functionDao=session.getMapper(IFunctionDao.class);
		FunctionModel fm=functionDao.selectByNo(no);
		session.commit();
		session.close();
		return fm;
	}

	@Override
	public int selectCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCountByModule(int moduleNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
