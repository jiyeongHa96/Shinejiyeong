package com.SkyBlue.hr.circumstance.dao;

import java.util.List;

import com.SkyBlue.hr.circumstance.to.BaseWorkTimeBean;

public interface BaseWorkTimeDAO {
	public List<BaseWorkTimeBean> selectBaseWorkTimeList();
	
	public void insertBaseWorkTime(BaseWorkTimeBean baseWorkTimeBean);
	public void updateBaseWorkTime(BaseWorkTimeBean baseWorkTimeBean);
	/*
	public void deleteBaseWorkTime(BaseWorkTimeBean baseWorkTimeBean);
	*/
}
