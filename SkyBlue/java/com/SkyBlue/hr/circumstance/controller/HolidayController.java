package com.SkyBlue.hr.circumstance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.SkyBlue.hr.circumstance.serviceFacade.CircumstanceServiceFacade;
import com.SkyBlue.hr.circumstance.to.HolidayBean;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class HolidayController{
	@Autowired
	private CircumstanceServiceFacade circumstanceServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	/* 선택된 기간의 휴일목록을 가져오는 메서드 */
	@RequestMapping("/hr/circumstance/findHolidayList.do")
	public void findHolidayList(@RequestAttribute("inData") PlatformData inData,
				 				@RequestAttribute("outData") PlatformData outData) throws Exception {
		String fromDate = inData.getVariable("fromDate").getString();
		String toDate = inData.getVariable("toDate").getString();
		
		//System.out.println("fromDate----"+fromDate+"---toDate-----"+toDate);
		
		Map<String, Object> dateList=new HashMap<>();
		dateList.put("fromDate", fromDate);
		dateList.put("toDate", toDate);
		
		List<HolidayBean> holidayList=circumstanceServiceFacade.findHolidayList(dateList);
		datasetBeanMapper.beansToDataset(outData, holidayList, HolidayBean.class);
    }
	
	// 휴일관련 일괄처리를 하는 메서드 
	@RequestMapping("/hr/circumstance/batchHoliday.do")
	public void batchHoliday(@RequestAttribute("inData") PlatformData inData,
							 @RequestAttribute("outData") PlatformData outData) throws Exception {
		List<HolidayBean> holidayList=datasetBeanMapper.datasetToBeans(inData, HolidayBean.class);
		circumstanceServiceFacade.batchHoliday(holidayList);
		//findHolidayListAll(inData,outData);
    }
	
	
/*
	// 모든 휴일목록을 가져오는 메서드 
	public void findHolidayListAll(PlatformData inData, PlatformData outData) throws Exception {
		List<HolidayBean> holidayList=circumstanceServiceFacade.findHolidayListAll();
		datasetBeanMapper.beansToDataset(outData, holidayList, HolidayBean.class);
    }
*/


   
}
