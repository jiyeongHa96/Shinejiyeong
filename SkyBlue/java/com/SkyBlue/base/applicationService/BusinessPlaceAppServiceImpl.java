package com.SkyBlue.base.applicationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.base.dao.BusinessPlaceDAO;
import com.SkyBlue.base.to.BusinessPlaceBean;

@Component
@Transactional
public class BusinessPlaceAppServiceImpl implements BusinessPlaceAppService {
	 @Autowired
	 private BusinessPlaceDAO businessPlaceDAO;
	 
   /* 부서목록을 조회하는 메서드 */
   @Override
   public List<BusinessPlaceBean> findBusinessPlaceList() {
       return businessPlaceDAO.selectBusinessPlaceList();
   }

   /*부서관리 (등록/삭제/수정)*/
	@Override
	public void batchBusinessPlaceList (List<BusinessPlaceBean> businessPlaceList) {
		for(BusinessPlaceBean businessPlaceBean:businessPlaceList){
			switch(businessPlaceBean.getStatus()){ /*mapper에서 bean들의  rowType를 읽어 온듯?? 필요없는경우에 받아만 놓고 사용 안함*/
				case "insert" : businessPlaceDAO.insertBusinessPlace(businessPlaceBean); break;
				case "update" : businessPlaceDAO.updateBusinessPlace(businessPlaceBean); break;
				case "delete" : businessPlaceDAO.deleteBusinessPlace(businessPlaceBean); break;
			}
		}
	}

}


