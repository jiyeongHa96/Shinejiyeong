package com.SkyBlue.hr.circumstance.to;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

@Dataset(name = "dsPayDeduction")
public class PayDeductionBean extends BaseBean {
	@Setter
	@Getter
	private String payDeductionItemSeq;
	@Setter
	@Getter
	private String payTypeCode;
	@Setter
	@Getter
	private String payDeductionTypeCode;
	@Setter
	@Getter
	private String inputedYear;
	@Setter
	@Getter
	private String payDeductionItemCode;
	@Setter
	@Getter
	private String payDeductionItemName;
	@Setter
	@Getter
	private String taxTypeCode;
	@Setter
	@Getter
	private String susubApply;
	@Setter
	@Getter
	private String monthSal;
	@Setter
	@Getter
	private String price;
	@Setter
	@Getter
	private String inOutApply;
}