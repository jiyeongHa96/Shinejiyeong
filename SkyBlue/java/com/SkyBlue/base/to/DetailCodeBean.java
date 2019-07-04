package com.SkyBlue.base.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsDetailCode")
public class DetailCodeBean extends BaseBean{
	@Getter
	@Setter
	private String code,detailCode,detailCodeName,usingStatus;
	
}
