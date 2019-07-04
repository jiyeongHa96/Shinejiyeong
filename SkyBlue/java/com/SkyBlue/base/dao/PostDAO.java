package com.SkyBlue.base.dao;

import java.util.List;
import java.util.Map;

import com.SkyBlue.base.to.AddressBean;
import com.SkyBlue.base.to.SidoBean;
import com.SkyBlue.base.to.SigunguBean;

public interface PostDAO {
	public List<SidoBean> findSido();
	public List<SigunguBean> findSiGunGuList(String sido);
	public List<AddressBean> findAddrList(Map<String, Object> addrList);
}

