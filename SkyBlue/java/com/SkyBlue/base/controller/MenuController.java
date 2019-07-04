package com.SkyBlue.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.base.serviceFacade.BaseServiceFacade;
import com.SkyBlue.base.to.MenuBean;
import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class MenuController{
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	/* menu목록을 가져오는 메서드 */
	@RequestMapping("/base/findMenuList.do")
	public void findMenuList(@RequestAttribute("inData") PlatformData inData,
				 			 @RequestAttribute("outData") PlatformData outData) throws Exception{
		List<MenuBean> menuList=baseServiceFacade.findMenuList();
		datasetBeanMapper.beansToDataset(outData, menuList, MenuBean.class);
	}
}