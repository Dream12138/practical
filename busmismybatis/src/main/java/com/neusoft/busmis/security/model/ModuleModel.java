package com.neusoft.busmis.security.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("Model")
@Data
public class ModuleModel implements Serializable {

	private int no = 0;
	private String nameString = null;
	
	//关联的功能对象，一对多
	private List<FunctionModel> functions = null;
	//关联的角色对象，多对多
	private List<RoleModel> roles = null;
	
}
