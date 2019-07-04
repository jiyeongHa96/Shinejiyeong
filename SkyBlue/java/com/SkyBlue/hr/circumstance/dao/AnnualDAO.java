package com.SkyBlue.hr.circumstance.dao;

import java.util.List;
import java.util.Map;

import com.SkyBlue.hr.circumstance.to.AnnualBean;

public interface AnnualDAO {
	public List<AnnualBean> selectAnnualList();
	
	public Map<String, Object> createAnnual(Map<String, Object> map);
	
	public void updateAnnual(AnnualBean annulBean);
	
	public void deleteAnnual(AnnualBean annulBean);	
	
	public void updateAnnualMgt(Map<String, Object> map);
	
}
