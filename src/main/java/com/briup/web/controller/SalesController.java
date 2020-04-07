package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.service.ISalesService;
import com.briup.service.IUserService;



/** 
* @author 作者 lf: 
* @version 创建时间：2020年4月1日 下午2:35:33 
* 类说明 
*/
@Controller
public class SalesController {

	@Autowired
	private ISalesService service;
	@Autowired
	private IUserService userService;
	
	@RequestMapping("toSales")
	public String toChance(HttpSession session,String customer,String address) {
		List<User> jinglis = userService.findByJingli(4);
		session.setAttribute("jinglis", jinglis);
		
		Page<Chance> chances = service.findAllChances();
		session.setAttribute("chances", chances);
		return "pages/sales";
	}
	//分页跳转
	@RequestMapping("pageChance")
	public String pageChance(Integer pageIndex,HttpSession session) {
		Page<Chance> chances = service.findAllChances(pageIndex);
		session.setAttribute("chances", chances);
		return "pages/sales";
	}
	
	//新增
	@RequestMapping("saveChance")
	@ResponseBody
	public String saveChance(Chance chance,Integer creator,Integer handler) {
		
		if(chance.getId()!=null) {
			service.saveChance(chance,creator,handler);
			return "修改成功";
		}else {
			service.saveChance(chance,creator,handler);
			return "添加成功";
		}
		
	}
	
	@RequestMapping("findChanceById")
	@ResponseBody
	public Chance findChanceById(Integer id) {
		return service.findChanceById(id);
	}
	
	@RequestMapping("deleteChanceById")
	@ResponseBody
	public String deleteChanceById(Integer id) {
		service.deleteChance(id);
		return "删除成功";
		
	}
	
	
}
