package com.SkyBlue.hr.attendance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsCondition")
public class ConditionBean extends BaseBean{
	@Setter
	@Getter
	private String deptCode,approvalStatus,basicDay,empCode;
}
