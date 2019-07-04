package com.SkyBlue.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.base.serviceFacade.BaseServiceFacade;
import com.SkyBlue.base.to.EtcSalBean;
import com.SkyBlue.base.to.OvertimeSalBean;
import com.SkyBlue.base.to.SudangInfoBean;
import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class BasicSalaryController{
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	
	/* 연장,야간,휴일,기타 수당관련 목록을 불러오는 메서드 */
	@RequestMapping("/base/findSalaryList.do")
	public void findSalaryList(@RequestAttribute("inData") PlatformData inData,
			 				   @RequestAttribute("outData") PlatformData outData) throws Exception{
		List<OvertimeSalBean> overTimeSalList=baseServiceFacade.findOvertimeSalList();
		List<EtcSalBean> etcSalList=baseServiceFacade.findEtcSalList();
		
		datasetBeanMapper.beansToDataset(outData, overTimeSalList, OvertimeSalBean.class);
		datasetBeanMapper.beansToDataset(outData, etcSalList, EtcSalBean.class);
	}
	
	@RequestMapping("/base/batchSudang.do")
	public void batchSudang(@RequestAttribute("inData") PlatformData inData,
			   				@RequestAttribute("outData") PlatformData outData) throws Exception{
			SudangInfoBean sudangInfoBean=new SudangInfoBean();
			sudangInfoBean.setOverTimeSalList(datasetBeanMapper.datasetToBeans(inData, OvertimeSalBean.class));
			sudangInfoBean.setEtcSalList(datasetBeanMapper.datasetToBeans(inData, EtcSalBean.class));
			
			baseServiceFacade.batchSudang(sudangInfoBean);
			
		findSalaryList(inData,outData);
	}


}