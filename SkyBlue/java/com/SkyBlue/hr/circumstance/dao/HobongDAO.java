package com.SkyBlue.hr.circumstance.dao;

import java.util.List;

import com.SkyBlue.hr.circumstance.to.HobongBean;

public interface HobongDAO {
	public List<HobongBean> selectHobongList();	
	
	public void insertHobong(HobongBean hobongBean);
	public void updateHobong(HobongBean hobongBean);
	public void deleteHobong(HobongBean hobongBean);
	
}
