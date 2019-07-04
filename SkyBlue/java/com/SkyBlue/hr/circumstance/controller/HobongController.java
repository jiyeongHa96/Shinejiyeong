package com.SkyBlue.hr.circumstance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.circumstance.serviceFacade.CircumstanceServiceFacade;
import com.SkyBlue.hr.circumstance.to.HobongBean;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class HobongController{
	@Autowired
	private CircumstanceServiceFacade circumstanceServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	/* 호봉목록을 가져오는 메서드 */
	@RequestMapping("/hr/circumstance/findHobongList.do")
	public void findHobongList(@RequestAttribute("inData") PlatformData inData,
				 			   @RequestAttribute("outData") PlatformData outData) throws Exception {
       List<HobongBean> hobongList=circumstanceServiceFacade.findHobongList();
       datasetBeanMapper.beansToDataset(outData, hobongList, HobongBean.class);
    }

	/* 호봉관련처리를 일괄적으로 하는 메서드 */
	@RequestMapping("/hr/circumstance/batchHobong.do")
	public void batchHobong(@RequestAttribute("inData") PlatformData inData,
				 			@RequestAttribute("outData") PlatformData outData) throws Exception {
	   List<HobongBean> hobongList=datasetBeanMapper.datasetToBeans(inData, HobongBean.class);
	   circumstanceServiceFacade.batchHobong(hobongList);
	   findHobongList(inData,outData);
	}
}
