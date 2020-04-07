package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Chance;
import com.briup.bean.Role;
import com.briup.bean.User;
import com.briup.dao.SalesDao;
import com.briup.dao.UserDao;
import com.briup.service.ISalesService;

/**
 * @author 作者 lf:
 * @version 创建时间：2020年4月1日 下午2:47:06 类说明
 */
@Service
public class SalesServiceImpl implements ISalesService {

	@Autowired
	private SalesDao dao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Page<Chance> findAllChances() {
		
		return findAllChances(0);
	}

	@Override
	public Page<Chance> findAllChances(Integer pageIndex) {
		Page<Chance> page = dao.findAll(PageRequest.of(pageIndex, 2));
		return page;
		
	}

	@Override
	public void saveChance(Chance chance,Integer creatorId,Integer handlerId) {
		
		System.out.println(creatorId+"----"+handlerId);
		
		User creatorUser = userDao.findById(creatorId).get();
		User handlerUser = userDao.findById(handlerId).orElse(null);
		
		
		chance.setCreator(creatorUser);
		
		chance.setHandler(handlerUser);
		
		dao.save(chance);
	
	}

	@Override
	public Chance findChanceById(Integer id) {
		
		return dao.findById(id).get();
	}

	@Override
	public void deleteChance(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public Page<Chance> getChances(String customer, String address) {
		
		return null;
	}

	@Override
	public Page<Chance> getChances(Integer pageIndex, String customer, String address) {
		if((customer!=null && customer.trim()!="") && address !=null && address.trim()!="") {
			//根据客户名字以及区域进行查询
			
			return null;
		}else if(customer !=null && customer.trim()!=""){
			//根据客户名字查询
			
			return null;
		}else if(address !=null && address.trim()!="") {
			//根据区域查询
			
			return dao.findByAddress(address, PageRequest.of(pageIndex, 2));
		}else {
			//无条件查询 将所有信息查询出来
			
			return dao.findAll(PageRequest.of(pageIndex, 2));
		}
		
	}

}
