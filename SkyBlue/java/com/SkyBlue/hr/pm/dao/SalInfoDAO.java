package com.SkyBlue.hr.pm.dao;

import java.util.List;

import com.SkyBlue.hr.pm.to.SalInfoBean;

public interface SalInfoDAO {
    public List<SalInfoBean> selectSalInfoAll();
    
    public void updateSalInfo(SalInfoBean salInfoBean);
}
