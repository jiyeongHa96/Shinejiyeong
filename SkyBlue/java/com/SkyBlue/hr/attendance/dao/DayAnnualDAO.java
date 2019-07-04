package com.SkyBlue.hr.attendance.dao;

import java.util.List;
import java.util.Map;

import com.SkyBlue.hr.attendance.to.ConditionBean;
import com.SkyBlue.hr.attendance.to.DayAnnualBean;

public interface DayAnnualDAO {
	public List<DayAnnualBean> selectAnnualMgt(Map<String, Object> map);
	
	public List<DayAnnualBean> selectDayAnnualListByCondition(Map<String, Object> map);
	
	public void insertDayAnnual(DayAnnualBean dayAnnualBean);	
	public void updateDayAnnual(DayAnnualBean dayAnnualBean);
	public void deleteDayAnnual(DayAnnualBean dayAnnualBean);	
	public void updateDayAnnualDays(DayAnnualBean dayAnnualBean);
}
