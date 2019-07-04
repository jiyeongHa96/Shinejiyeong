package com.SkyBlue.base.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SkyBlue.base.serviceFacade.BaseServiceFacade;
import com.SkyBlue.base.to.CodeBean;
import com.SkyBlue.base.to.CodeInfoBean;
import com.SkyBlue.base.to.DetailCodeBean;
import com.SkyBlue.common.mapper.DatasetBeanMapper;

import com.tobesoft.xplatform.data.PlatformData;
import com.tobesoft.xplatform.data.DataSet;

@Controller
public class CodeController{
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	
	@RequestMapping("/base/findCodeList.do")
	public void findCodeList(@RequestAttribute("inData") PlatformData inData,
			   				 @RequestAttribute("outData") PlatformData outData) throws Exception{
		List<CodeBean> codeList=baseServiceFacade.findCodeList();
		List<DetailCodeBean> detailCodeList=new ArrayList<DetailCodeBean>();
		for(CodeBean codeBean : codeList){
			List<DetailCodeBean> detailCodeBeanList=codeBean.getDetailCodeList();
			/* ArrayList를  ArrayList에 담을 수 있는 메서드 : addAll   ->add의 경우 ArrayList는 못담는듯 하다 에러가 난다 */
			detailCodeList.addAll(detailCodeBeanList);
		}
		datasetBeanMapper.beansToDataset(outData, codeList, CodeBean.class);
		datasetBeanMapper.beansToDataset(outData, detailCodeList, DetailCodeBean.class);
	}
	
	
	@RequestMapping("/base/batchCode.do")
	public void batchCode(@RequestAttribute("inData") PlatformData inData,
			   			  @RequestAttribute("outData") PlatformData outData) throws Exception{
		DataSet dataset =inData.getDataSet("dsCode");
		/*존재하지 않으면 unknown 나오는 듯? 코드가 변동이 있을 경우. 삭제를 지웠기 때문에  없오도 될듯 . 있어도 되고 or이기 때문에*/
		if(dataset.getRowTypeName(0)!="unknown" || dataset.getRemovedRowCount() >0){
			CodeInfoBean codeInfoBean=new CodeInfoBean(); /*코드와 상세코드 list를 담아 둠.(여러개를 고칠경우 )*/
			codeInfoBean.setCodeList(datasetBeanMapper.datasetToBeans(inData, CodeBean.class));
			codeInfoBean.setDetailCodeList(datasetBeanMapper.datasetToBeans(inData, DetailCodeBean.class));
			baseServiceFacade.batchCode(codeInfoBean);
		}else{
			List<DetailCodeBean> codeDetailList=datasetBeanMapper.datasetToBeans(inData, DetailCodeBean.class);
			baseServiceFacade.batchDetailCode(codeDetailList);
		}

		findCodeList(inData,outData);
	}


}