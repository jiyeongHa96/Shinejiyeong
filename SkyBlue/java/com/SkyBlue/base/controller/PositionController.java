package com.SkyBlue.base.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.base.serviceFacade.BaseServiceFacade;
import com.SkyBlue.base.to.PositionBean;
import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.circumstance.to.HobongBean;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class PositionController{
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
    /* 직급목록을 가져오는 메서드 */
	@RequestMapping("/base/findPositionList.do")
	public void findPositionList(@RequestAttribute("inData") PlatformData inData,
 			  					 @RequestAttribute("outData") PlatformData outData) throws Exception {
        List<PositionBean> positionList=baseServiceFacade.findPositionList();
        datasetBeanMapper.beansToDataset(outData, positionList, PositionBean.class);

      }
	
	/*직급하나 조회해서 호봉 가져오는 메서드*/
	@RequestMapping("/base/findHobongList.do")
	public void findHobongList(@RequestAttribute("inData") PlatformData inData,
 			  				   @RequestAttribute("outData") PlatformData outData) throws Exception {
	
		String positionCode = inData.getVariable("positionCode").getString();
		PositionBean position=baseServiceFacade.findPosition(positionCode);
		 List<HobongBean> hobongList=position.getHobongList();
		 datasetBeanMapper.beansToDataset(outData, hobongList, HobongBean.class);
	}
}