package com.SkyBlue.base.applicationService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.base.dao.PostDAO;
import com.SkyBlue.base.to.AddressBean;
import com.SkyBlue.base.to.SidoBean;
import com.SkyBlue.base.to.SigunguBean;

@Component
@Transactional
public class PostAppServiceImpl implements PostAppService {
	@Autowired
    private PostDAO postDAO;
    

    /* 특별시,광역시,도를 조회하는 메서드 */
	@Override
	public List<SidoBean> findSido() {
		return postDAO.findSido();
	}

	/* 특별시,광역시,도에 해당하는 시,군,구를 조회하는 메서드 */
	@Override
	public List<SigunguBean> findSiGunGuList(String sido) {
		return postDAO.findSiGunGuList(sido);
	}

	/* 전체조건에 맞는 주소를 가지고 오는 메서드 */
	@Override
	public List<AddressBean> findAddrList(Map<String, Object> addrList) {
		return postDAO.findAddrList(addrList);
	}
	
}
