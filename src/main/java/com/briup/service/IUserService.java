package com.briup.service;
/** 
* @author 作者 zcg: 
* @version 创建时间：Mar 26, 2020 4:47:44 PM 
* 类说明 
*/

import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.User;

public interface IUserService {
	
	public User findByName(String name);
	
	//查询User信息
	Page<User> findUsersByRole(Integer roleId);
	//根据分页查询User的相关信息
	Page<User> findUsersByRole(Integer roleId,Integer pageIndex);
	//新增用户
	void saveUser(User user);
	
	//通过id查询用户信息
	User finUserById(Integer id);
	
	//根据id删除用户信息
	void deleteUserById(Integer id);
	
	//查询所有职位为经理的用户
	List<User> findByJingli(Integer id);

}











