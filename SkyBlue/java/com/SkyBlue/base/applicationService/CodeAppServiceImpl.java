package com.SkyBlue.base.applicationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.base.dao.CodeDAO;
import com.SkyBlue.base.to.CodeBean;
import com.SkyBlue.base.to.CodeInfoBean;
import com.SkyBlue.base.to.DetailCodeBean;


@Component
@Transactional
public class CodeAppServiceImpl implements CodeAppService {
	@Autowired
    private CodeDAO codeDAO;
	

	/* 코드목록을 반환하는 메서드 */
	@Override
	public List<CodeBean> findCodeList() {
		return codeDAO.selectCodeList();
	}
	

	 //코드관련정보를 일괄적으로 처리하는 메서드 (코드 + 상세코드)
	@Override
	public void batchCode(CodeInfoBean codeInfoBean) {
		for(CodeBean codeBean :codeInfoBean.getCodeList()){
			switch(codeBean.getStatus()){
				case "insert" : codeDAO.insertCode(codeBean); break;
				case "update" : codeDAO.updateCode(codeBean); break;
				case "delete" : codeDAO.deleteCode(codeBean); break;
			}

		}

		for(DetailCodeBean detailCodeBean:codeInfoBean.getDetailCodeList()){
			switch(detailCodeBean.getStatus()){
				case "insert" : codeDAO.insertDetailCode(detailCodeBean); break;
				case "update" : codeDAO.updateDetailCode(detailCodeBean); break;
				case "delete" : codeDAO.deleteDetailCode(detailCodeBean); break;
			}
		}
	}

	// 상세코드관련정보를 일괄적으로 처리하는 메서드 
	@Override
	public void batchDetailCode(List<DetailCodeBean> detailCodeList) {
		for(DetailCodeBean detailCodeBean:detailCodeList){
			switch(detailCodeBean.getStatus()){
				case "insert" : codeDAO.insertDetailCode(detailCodeBean); break;
				case "update" : codeDAO.updateDetailCode(detailCodeBean); break;
				case "delete" : codeDAO.deleteDetailCode(detailCodeBean); break;
			}
		}
	}
	

}
