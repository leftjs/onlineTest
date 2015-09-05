package com.iweb.dao;

import java.util.List;

import com.iweb.entity.User;

public interface IUserDAO {
	/**
	 * 注册
	 */
	public boolean add(User user) throws Exception ;
	
	/**
	 * 删除
	 */
	public boolean remove(int id) throws Exception ;
	
	/**
	 * 获得用户列表
	 */
	public List<User> list() throws Exception ;
	
	/**
	 * 登录
	 */
	public User login(String loginname, String password) throws Exception ;
	
	/**
	 * 检测用户的唯一性
	 */
	public int has(String loginname) throws Exception ;
	
	/**
	 * 根据ID查找用户
	 */
	public User find(int id) throws Exception ;
}
