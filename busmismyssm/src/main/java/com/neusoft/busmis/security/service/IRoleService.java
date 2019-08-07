package com.neusoft.busmis.security.service;

import java.util.List;

import com.neusoft.busmis.security.model.RoleModel;

//角色业务接口
public interface IRoleService {

	public void add(RoleModel role) throws Exception;
	
	public void modify(RoleModel role) throws Exception;
	
	public void delete(RoleModel role) throws Exception;
	
	//取得所有的角色
	public List<RoleModel> getListByAll() throws Exception;
	
	//取得指定用户的角色列表
	//依照编号，编号唯一，所以只有单个，直接返回即可
	public RoleModel selectByNo(int no) throws Exception;
	//依照名字查找，可能单个，也可能多个，因此使用List
	public List<RoleModel> getListByUser(String name) throws Exception;
}
