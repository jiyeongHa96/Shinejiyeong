package com.SkyBlue.base.applicationService;

import java.util.List;

import com.SkyBlue.base.to.EtcSalBean;
import com.SkyBlue.base.to.OvertimeSalBean;
import com.SkyBlue.base.to.SudangInfoBean;

public interface BasicSalaryAppService {
    public List<OvertimeSalBean> findOvertimeSalList();
    public List<EtcSalBean> findEtcSalList();
    
    public void batchSudang(SudangInfoBean sudangInfoBean);
}
