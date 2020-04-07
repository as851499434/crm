package com.briup.service;
/** 
* @author 作者 lf: 
* @version 创建时间：2020年4月1日 下午2:35:08 
* 类说明 
*/

import org.springframework.data.domain.Page;

import com.briup.bean.Chance;

public interface ISalesService {
	
	Page<Chance> findAllChances();
	
	Page<Chance> findAllChances(Integer pageIndex);
	
	//新增销售商机
	void saveChance(Chance chance,Integer creatorId,Integer handlerId);
	
	Chance findChanceById(Integer id);
	
	//删除
	void deleteChance(Integer id);
	
	//查询显示
	Page<Chance> getChances(String customer,String address);
	Page<Chance> getChances(Integer pageIndex,String customer,String address);

	//如果上级开发成功
	//void insertChance(Chance chance);
}
