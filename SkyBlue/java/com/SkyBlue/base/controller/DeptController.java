package com.SkyBlue.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.base.serviceFacade.BaseServiceFacade;
import com.SkyBlue.base.to.DeptBean;
import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class DeptController{
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

    /* 부서목록을 조회하는 메서드 */
	@RequestMapping("/base/findDeptList.do")
	public void findDeptList(@RequestAttribute("inData") PlatformData inData,
				 			 @RequestAttribute("outData") PlatformData outData) throws Exception {
		
		String businessPlaceCode= inData.getVariable("businessPlaceCode").getString();
		List<DeptBean> deptList=baseServiceFacade.findDeptList(businessPlaceCode);
        datasetBeanMapper.beansToDataset(outData, deptList, DeptBean.class);
        /*
         * 	beansToDataset : bean --> dataset
         * */
    }
	
	/*부서관리 (등록/삭제/수정)*/
	@RequestMapping("/base/batchDept.do")
	public void batchDept(@RequestAttribute("inData") PlatformData inData,
			 			  @RequestAttribute("outData") PlatformData outData) throws Exception {
		/*
		 * datasetToBean도 있다.
		 *
		 *  datasetToBeans : dataset --> bean
		 *
		 * */
        List<DeptBean> deptList=datasetBeanMapper.datasetToBeans(inData, DeptBean.class);
        baseServiceFacade.batchDept(deptList);

        //findDeptList(inData,outData);
    }

	
}
