package com.SkyBlue.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import com.SkyBlue.base.serviceFacade.BaseServiceFacade;
import com.SkyBlue.base.to.AuthorityBean;
import com.SkyBlue.base.to.AuthorityInfoBean;
import com.SkyBlue.base.to.MenuAuthorityBean;
import com.SkyBlue.common.mapper.DatasetBeanMapper;
import com.tobesoft.xplatform.data.PlatformData;

@Controller
public class AuthorityController{
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	 
    /* 권한에따른 menu목록을 가져오는 메서드 */ 
	@RequestMapping("/base/findMenuAuthorityList.do")
    public void findMenuAuthorityList(@RequestAttribute("inData") PlatformData inData,
            						  @RequestAttribute("outData") PlatformData outData) throws Exception {
    	String authorityCode = inData.getVariable("authorityCode").getString();
    	//입력한 변수를 얻어와서 String으로 변경 하는 듯?
    	List<MenuAuthorityBean> menuAuthorityList = baseServiceFacade.findMenuAuthorityList(authorityCode);
        datasetBeanMapper.beansToDataset(outData, menuAuthorityList, MenuAuthorityBean.class);
    }

   /* 권한목록을 가져오는 메서드 */
	@RequestMapping("/base/findAuthorityList.do")
    public void findAuthorityList(@RequestAttribute("inData") PlatformData inData,
    							  @RequestAttribute("outData") PlatformData outData) throws Exception {
    	List<AuthorityBean> authorityList = baseServiceFacade.findAuthorityList();
		datasetBeanMapper.beansToDataset(outData, authorityList, AuthorityBean.class);
    }

    /* 모든 메뉴를 다가져오는 메서드 */
	@RequestMapping("/base/findMenuAuthorityListAll.do")
    public void findMenuAuthorityListAll(@RequestAttribute("inData") PlatformData inData,
    									 @RequestAttribute("outData") PlatformData outData) throws Exception {
    	List<MenuAuthorityBean> menuAuthorityList = baseServiceFacade.findMenuAuthorityListAll();
        datasetBeanMapper.beansToDataset(outData, menuAuthorityList, MenuAuthorityBean.class);
    }
   
    /* 메뉴권한관련해서 일괄처리하는 메서드 */
	@RequestMapping("/base/batchAuthority.do")
    public void batchAuthority(@RequestAttribute("inData") PlatformData inData,
			  				   @RequestAttribute("outData") PlatformData outData) throws Exception {
    	//System.out.println(inData);
    	//권한은 변동을 하지 않아도 실행이 된다. 
    	AuthorityInfoBean authorityInfoBean=new AuthorityInfoBean();
    	//authorityInfoBean.setAuthorityList(datasetBeanMapper.datasetToBeans(inData, AuthorityBean.class));
    	authorityInfoBean.setMenuAuthorityList(datasetBeanMapper.datasetToBeans(inData, MenuAuthorityBean.class));
        baseServiceFacade.batchAuthority(authorityInfoBean);
        //findAuthorityList(inData,outData);
        findMenuAuthorityListAll(inData,outData);
    }

}
