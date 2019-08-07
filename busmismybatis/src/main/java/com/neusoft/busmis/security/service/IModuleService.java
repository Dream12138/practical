package com.neusoft.busmis.security.service;

import java.util.List;

import com.neusoft.busmis.security.model.ModuleModel;

//系统功能模块业务接口
public interface IModuleService {

	public void add(ModuleModel role) throws Exception;
	
	public void modify(ModuleModel role) throws Exception;
	
	public void delete(ModuleModel role) throws Exception;
	
	//只取得模块列表，并不需要关联的功能列表
	public List<ModuleModel> getListByAll() throws Exception;
	
	//取得模块列表，并取得关联的功能属性列表，使用内嵌式select方式
	public List<ModuleModel> getselectListByAllWithFunctionByNestedSelect() throws Exception;
	
	//取得模块列表，并取得关联的功能属性列表，使用内嵌式ResultMap方式
	public List<ModuleModel> getselectListByAllWithFunctionByNestedResultMap() throws Exception;

	//取得模块列表，并取得关联的角色属性列表，使用内嵌式select方式
	public List<ModuleModel> getListByAllWithRolesByNestedSelect() throws Exception;
	
	//取得模块列表，并取得关联的角色属性列表，使用内嵌式ResultMap方式
	public List<ModuleModel> getListByAllWithRolesByNestedResultMap() throws Exception;
	
	//取得模块列表，并取得关联的功能和角色属性列表，使用内嵌式select方式
	public List<ModuleModel> getListByAllWithFunctionAndRolesFunctionByNestedSelect() throws Exception;
	
	//取得模块列表，并取得关联的功能和角色属性列表，使用内嵌式ResultMap
	public List<ModuleModel> getListByAllWithFunctionAndRolesFunctionByNestedResultMap() throws Exception;
	
	public ModuleModel getByNo(int no) throws Exception;
	
	//取得所有的模块个数
	public int getCountByAll() throws Exception;
	
	//取得指定的角色模块列表
	public List<ModuleModel> getListByRole(int roleNo) throws Exception;
	
	//验证指定角色是否有此模块权限
	//参数：模块编号，角色编号
	public boolean checkAccessForRole(int moduleNo, int roleNo) throws Exception;
}
