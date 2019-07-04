package com.SkyBlue.hr.circumstance.applicationService;

import java.util.List;

import com.SkyBlue.hr.circumstance.to.BaseWorkTimeBean;

public interface BaseWorkTimeAppService {
	public List<BaseWorkTimeBean> findBaseWorkTimeList();

	public void addBaseWorkTime(BaseWorkTimeBean baseWorkTimeBean);
	public void editBaseWorkTime(BaseWorkTimeBean baseWorkTimeBean);
	/*
	public void removeBaseWorkTime(BaseWorkTimeBean baseWorkTimeBean);
	*/
}
