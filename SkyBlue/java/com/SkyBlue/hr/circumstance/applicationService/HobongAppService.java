package com.SkyBlue.hr.circumstance.applicationService;

import java.util.List;

import com.SkyBlue.hr.circumstance.to.HobongBean;

public interface HobongAppService {
	public List<HobongBean> findHobongList();
	
	public void batchHobong(List<HobongBean> hobongList);
	
}
