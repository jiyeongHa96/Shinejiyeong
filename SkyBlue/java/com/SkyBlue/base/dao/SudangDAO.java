package com.SkyBlue.base.dao;

import java.util.List;

import com.SkyBlue.base.to.EtcSalBean;
import com.SkyBlue.base.to.OvertimeSalBean;

public interface SudangDAO {

	public List<OvertimeSalBean> selectOvertimeSalList();
	public List<EtcSalBean> selectEtcSalList();

	public void insertOvertimeSal(OvertimeSalBean overtimeSalBean);
    public void updateOvertimeSal(OvertimeSalBean overtimeSalBean);
    public void deleteOvertimeSal(OvertimeSalBean overtimeSalBean);

    public void insertEtcSal(EtcSalBean etcSalBean);
    public void updateEtcSal(EtcSalBean etcSalBean);
    public void deleteEtcSal(EtcSalBean etcSalBean);
   

}
