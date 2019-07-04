package com.SkyBlue.base.to;

import java.util.List;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.annotation.Remove;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsCode")
public class CodeBean extends BaseBean{

	@Setter
	@Getter
	private String code,codeName,usingStatus;
	
	@Setter
	@Getter
	private List<DetailCodeBean> detailCodeList;



}
