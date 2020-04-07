package com.briup.web.controller;
/** 
* @author 作者 lf: 
* @version 创建时间：2020年4月3日 上午10:42:20 
* 类说明 
*/

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.CustomerConstitute;
import com.briup.service.ICustomerConstituteService;

@Controller
public class CustomerConstituteController {
	
	@Autowired
	private ICustomerConstituteService service;
	
	@RequestMapping("toCustomerConstitute")
	public String toCustomerConstitute() {
		return "pages/CustomerConstitute";
	}
	
	@RequestMapping("regionAnalyze")
	@ResponseBody
	public List<CustomerConstitute> toregionAnalyze(){
		return service.regionAnalyze();
	}
	
	@RequestMapping("levelAnalyze")
	@ResponseBody
	public List<CustomerConstitute> tolevelAnalyze(){
		return service.levelAnalyze();
	}
}
