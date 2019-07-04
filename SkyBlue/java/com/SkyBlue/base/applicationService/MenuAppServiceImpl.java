package com.SkyBlue.base.applicationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.SkyBlue.base.dao.MenuDAO;
import com.SkyBlue.base.to.MenuBean;

@Component
@Transactional
public class MenuAppServiceImpl implements MenuAppService {
	@Autowired
	private MenuDAO menuDAO;
	

	@Override
	/* menu 목록을 가져오는 메서드 */
	public List<MenuBean> findMenuList() {
		return menuDAO.selectMenuList();
	}
}
