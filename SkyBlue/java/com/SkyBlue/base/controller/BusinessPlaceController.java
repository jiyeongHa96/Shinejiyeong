package com.SkyBlue.base.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.base.serviceFacade.BaseServiceFacade;
import com.SkyBlue.base.to.BusinessPlaceBean;
import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class BusinessPlaceController{
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

    /* 부서목록을 조회하는 메서드 */
	@RequestMapping("/base/findBusinessPlaceList.do")
  	public void findBusinessPlaceList(@RequestAttribute("inData") PlatformData inData,
			   						  @RequestAttribute("outData") PlatformData outData) throws Exception {
          List<BusinessPlaceBean> businessPlaceList=baseServiceFacade.findBusinessPlaceList();
          datasetBeanMapper.beansToDataset(outData, businessPlaceList, BusinessPlaceBean.class);
          /*
           * 	beansToDataset : bean --> dataset
           * */
      }
  	
  	/*부서관리 (등록/삭제/수정)*/
	@RequestMapping("/base/batchBusinessPlaceList.do")
  	public void batchBusinessPlaceList(@RequestAttribute("inData") PlatformData inData,
				  					   @RequestAttribute("outData") PlatformData outData) throws Exception {
  		/*
  		 * datasetToBean도 있다.
  		 *
  		 *  datasetToBeans : dataset --> bean
  		 *
  		 * */
          List<BusinessPlaceBean> businessPlaceList=datasetBeanMapper.datasetToBeans(inData, BusinessPlaceBean.class);
          baseServiceFacade.batchBusinessPlaceList(businessPlaceList);

          findBusinessPlaceList(inData,outData);
      }

	
}
