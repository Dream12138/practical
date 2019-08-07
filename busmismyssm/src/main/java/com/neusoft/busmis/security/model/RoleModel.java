package com.neusoft.busmis.security.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("role")
@Data
public class RoleModel implements Serializable {

	private int no = 0;
	private String nameString = null;
	
	//关联角色用户列表
	private List<UserModel> userModels = null;
	//关联角色模块列表
	private List<ModuleModel> modelModels = null;
}
