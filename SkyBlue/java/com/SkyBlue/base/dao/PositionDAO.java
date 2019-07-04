package com.SkyBlue.base.dao;

import java.util.List;

import com.SkyBlue.base.to.PositionBean;

public interface PositionDAO {
	public List<PositionBean> selectPositionList();
	
	public PositionBean selectPosition(String positionCode);
}
