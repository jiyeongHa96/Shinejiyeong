package com.SkyBlue.hr.pay.applicationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.common.exception.ProcedureException;
import com.SkyBlue.hr.pay.dao.PayDAO;
import com.SkyBlue.hr.pay.to.ExpensesDeductionBean;
import com.SkyBlue.hr.pay.to.SalaryInputBean;

@Component
@Transactional
public class PayAppServiceImpl implements PayAppService {
   @Autowired
   private PayDAO payDAO;
   

   /* 급여를 계산하는 메서드 */
   @Override
   public List<ExpensesDeductionBean> payCalculate(String paymentDate, String standardDate) throws ProcedureException {
      Map<String, Object> map = new HashMap<>();
      System.out.println(paymentDate+","+standardDate);
      map.put("paymentDate", paymentDate);
      map.put("standardDate", standardDate);
      payDAO.payCalculate(map);
      Map<String, String> result = new HashMap<>();
        result.put("errorCode", map.get("errorCode") + "");
        result.put("errorMsg", map.get("errorMsg") + "");
      return payDAO.selectPayDeductionList(paymentDate);
   }
   
   public List<SalaryInputBean> salaryInputList(String paymentDate){
	   return payDAO.selectSalaryInputList(paymentDate);
   }
}