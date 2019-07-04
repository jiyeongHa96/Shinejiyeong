package com.SkyBlue.base.applicationService;

import java.util.List;

import com.SkyBlue.base.to.BusinessPlaceBean;


public interface BusinessPlaceAppService{
    public List<BusinessPlaceBean> findBusinessPlaceList();
    public void batchBusinessPlaceList(List<BusinessPlaceBean> businessPlaceList);
}

	