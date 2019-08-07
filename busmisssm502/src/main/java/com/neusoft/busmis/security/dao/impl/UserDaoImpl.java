package com.neusoft.busmis.security.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neusoft.busmis.factory.ConnectionFactoryWithC3P0;
import com.neusoft.busmis.factory.ConnectionFactoryWithDBCP;
import com.neusoft.busmis.factory.ConnectionFactoryWithJDBC;
import com.neusoft.busmis.factory.ConnectionFactoryWithJNDI;
import com.neusoft.busmis.security.dao.IUserDao;
import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.RoleModel;
import com.neusoft.busmis.security.model.UserModel;
//用户的DAO实现类
public class UserDaoImpl implements IUserDao {

	@Override
	public void create(UserModel userModel) throws Exception {
		//Connection cn=ConnectionFactoryWithJDBC.getConnection();
		//Connection cn=ConnectionFactoryWithDBCP.getConnection();
		//Connection cn=ConnectionFactoryWithC3P0.getConnection();
		Connection cn=ConnectionFactoryWithJNDI.getConnection();
		String sql="insert into userinfo (USERID,USERPASSWORD,USERNAME)  values (?,?,?,?,?,?,'N')"; //默认为不激活
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, userModel.getId());
		ps.setString(2, userModel.getPassword());
		ps.setString(3, userModel.getName());
		
		ps.setInt(5, userModel.getAge());
		ps.setDate(6, new java.sql.Date(userModel.getJoinDate().getTime()));
		ps.executeUpdate();
		ps.close(); 
		cn.close(); //将连接变成空闲，返给连接池框架。
	}

	@Override
	public void update(UserModel userModel) throws Exception {
		Connection cn=ConnectionFactoryWithJNDI.getConnection();
		String sql="update userinfo set UserPassword=?,UserName=?,UserRole=?,Age=?,JoinDate=?,STATUS=? where USERID=?";
		PreparedStatement ps=cn.prepareStatement(sql);
		
		ps.setString(1, userModel.getPassword());
		ps.setString(2, userModel.getName());
		
		ps.setInt(4, userModel.getAge());
		ps.setDate(5, new java.sql.Date(userModel.getJoinDate().getTime()));
		ps.setString(6, userModel.getStatus());
		ps.setString(7, userModel.getId());
		ps.executeUpdate();
		ps.close(); 
		cn.close(); //将连接变成空闲，返给连接池框架。

	}

	@Override
	public void delete(UserModel userModel) throws Exception {
		Connection cn=ConnectionFactoryWithJNDI.getConnection();
		String sql="delete from userinfo  where USERID=?";
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, userModel.getId());
		ps.executeUpdate();
		ps.close(); 
		cn.close(); //将连接变成空闲，返给连接池框架。
	}

	@Override
	public List<UserModel> selectListByAll() throws Exception {
		List<UserModel> list=new ArrayList<UserModel>();
		Connection cn=ConnectionFactoryWithJNDI.getConnection();
		String sql="select * from userinfo";
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			UserModel um=new UserModel();
			um.setId(rs.getString("UserID"));
			um.setPassword(rs.getString("UserPassword"));
			um.setName(rs.getString("UserName"));
			
			um.setAge(rs.getInt("AGE"));
			um.setJoinDate(rs.getDate("JoinDate"));
			um.setStatus(rs.getString("STATUS"));
			list.add(um);
			
		}
		rs.close();
		ps.close();
		cn.close();
		return list;
	}

	@Override
	public UserModel selectById(String id) throws Exception {
		Connection cn=ConnectionFactoryWithJNDI.getConnection();
		String sql="select * from userinfo where UserID=?";
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		UserModel um=null;
		while(rs.next()) {
			um=new UserModel();
			um.setId(rs.getString("UserID"));
			um.setPassword(rs.getString("UserPassword"));
			um.setName(rs.getString("UserName"));
			
			um.setAge(rs.getInt("AGE"));
			um.setJoinDate(rs.getDate("JoinDate"));
			um.setStatus(rs.getString("STATUS"));
		}
		rs.close();
		ps.close();
		cn.close();
		return um;
	}

	@Override
	public void createWithParam(String id, String password, String name, int age) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserModel> selectListByAllWithPage(int start, int rows) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRole(String id, int roleNo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

	
	@Override
	public int selectCountByUserAndRoles(String id, int roleNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserModel> selectListByAllWithRoles() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRoles(String id, int[] roleNoList) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRoles(String id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RoleModel> selectRoleListByUser(String userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ModuleModel> selectModuleListByUser(String userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> selectListByCondition(int roleNo, String keyName, int minAge, int maxAge, Date startDate,
			Date endDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createWithPhoto(UserModel userModel) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
