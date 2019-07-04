package com.SkyBlue.base.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.base.serviceFacade.BaseServiceFacade;
import com.SkyBlue.base.to.CompanyBean;
import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.tobesoft.xplatform.data.PlatformData;


@Controller
public class CompanyController{
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

    /* 회사 조회하는 메서드 */
	@RequestMapping("/base/findCompany.do")
	public void findCompany(@RequestAttribute("inData") PlatformData inData,
				 			@RequestAttribute("outData") PlatformData outData) throws Exception {
        CompanyBean companyBean=baseServiceFacade.findCompany();
        datasetBeanMapper.beanToDataset(outData, companyBean, CompanyBean.class);
        /*
         * 	beansToDataset : bean --> dataset
         * */
    }
	
	/*회사관리 (등록/삭제/수정)*/
	@RequestMapping("/base/batchCompany.do")
	public void batchCompany(@RequestAttribute("inData") PlatformData inData,
 						     @RequestAttribute("outData") PlatformData outData) throws Exception {
		/*
		 * datasetToBean도 있다.
		 *
		 *  datasetToBeans : dataset --> bean
		 *
		 * */
		CompanyBean companyBean=datasetBeanMapper.datasetToBean(inData, CompanyBean.class);
        baseServiceFacade.batchCompany(companyBean);

        findCompany(inData,outData);
    }

	
}
