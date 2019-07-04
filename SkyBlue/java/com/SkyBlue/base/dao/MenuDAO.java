package com.SkyBlue.base.dao;

import java.util.List;

import com.SkyBlue.base.to.MenuBean;

public interface MenuDAO {
	List<MenuBean> selectMenuList();
}
