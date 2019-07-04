package com.SkyBlue.hr.circumstance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsBaseWorkTime")
public class BaseWorkTimeBean extends BaseBean{
	@Setter
	@Getter
	private String applyYear,attendTime,quitTime,overTime,nightTime,lunchStartTime;
	@Setter
	@Getter
	private String lunchEndTime,dinnerStartTime,dinnerEndTime;

}
