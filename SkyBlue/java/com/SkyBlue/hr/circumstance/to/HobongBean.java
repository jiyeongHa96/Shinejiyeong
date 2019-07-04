package com.SkyBlue.hr.circumstance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsHobong")
public class HobongBean extends BaseBean{
	@Setter
	@Getter
	private String hobong,positionCode,baseSal,bonus,sigub;

}
