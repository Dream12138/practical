package com.neusoft.busmis.security.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("Function")
@Data
public class FunctionModel implements Serializable {

	private int no = 0;
	private String nameString = null;
	private String urlString = null;
	
	//外键对应字段
	private ModuleModel module = null;
}
