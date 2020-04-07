package com.briup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Customer;
import com.briup.bean.CustomerConstitute;
import com.briup.dao.CustomerDao;
import com.briup.service.ICustomerConstituteService;

/** 
* @author 作者 lf: 
* @version 创建时间：2020年4月3日 上午10:44:27 
* 类说明 
*/
@Service
public class CustomerConstituteServiceImpl implements ICustomerConstituteService{
	@Autowired
	private CustomerDao dao;
	
	@Override
	public List<CustomerConstitute> regionAnalyze() {
		List<CustomerConstitute> list = new ArrayList<>();
		//从数据库将所有客户信息查找出来
		float nums = dao.findAll().size();
		
		String[] regions= {"华中","华东","华北","华南"};
		
		for(String region:regions) {
			float num = dao.findByRegion(region).size();
			float y = num/nums *100;
			CustomerConstitute cc = new CustomerConstitute(region, y, region);
			list.add(cc);
			
		}
		//然后根据地区进行筛选 然后封装成lsit自定义对象
		//System.out.println(list);
		return list;
	}

	@Override
	public List<CustomerConstitute> levelAnalyze() {
		List<CustomerConstitute> list = new ArrayList<>();
		float nums = dao.findAll().size();
		String[] levels= {"普通客户","大客户","重点开发客户","合作伙伴","战略合作伙伴"};
		for(String level:levels) {
			float num = dao.findByLevel(level).size();
			float y = num/nums *100;
			CustomerConstitute cc = new CustomerConstitute(level, y, level);
		
			list.add(cc);
			
		}
		return list;
	}
	
}
