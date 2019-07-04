package com.SkyBlue.hr.pm.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name="dsFamilyInfo")
public class FamilyInfoBean extends BaseBean{
	@Setter
	@Getter
	private String empCode,familySeq,familyName,familyBirthDate,relationship,supporting;
	@Setter
	@Getter
	private String cohabitationStatus,disabilityCode,highestEducationCode,job;
	@Setter
	@Getter
	private String companyName,tel;
}
