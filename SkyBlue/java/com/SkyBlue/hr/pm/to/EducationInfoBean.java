package com.SkyBlue.hr.pm.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsEducationInfo")
public class EducationInfoBean extends BaseBean{
	@Setter
	@Getter
	private String empCode,educationSeq,campus,major,subMajor,enterDate,graduationDate,grade,location;

}
