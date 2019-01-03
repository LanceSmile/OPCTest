package com.bosch.controller;


import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import com.bosch.pojo.OpcServerList;
import com.bosch.service.OPCImpl.OpcServerServiceImpl;
import com.bosch.service.OpcServerService;
import org.jinterop.dcom.common.JIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bosch.pojo.Category;
import com.bosch.service.CategoryService;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	OpcServerService opcServerService;
	@RequestMapping("listCategory")
	public ModelAndView listCategory(){
		ModelAndView mav = new ModelAndView();
		List<Category> cs= categoryService.list();
		
		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategory");
		return mav;
	}
	@RequestMapping("HomePage")
	public ModelAndView HomePage() throws Exception {
		ModelAndView mav = new ModelAndView();
		List<Category> cs= categoryService.list();


		/*Map<Integer, OpcServerList> map=opcServerService.showAllServers("192.168.0.100",
		"Opcuser","123456","");*/

		/*
		for(Map.Entry<Integer, OpcServerList> entry:map.entrySet()){
			System.out.println("key="+entry.getKey()+" "
			+"clid="+entry.getValue().getCLid()+" proid="+entry.getValue().getProID()
			);
		}*/

		// 放入转发参数
        //JSONArray listArray=JSONArray.fromObject(lists);
		mav.addObject("cs", cs);

		mav.setViewName("HomePage");
		return mav;
	}

}
