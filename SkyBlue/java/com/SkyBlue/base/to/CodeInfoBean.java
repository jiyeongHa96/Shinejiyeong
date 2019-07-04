package com.SkyBlue.base.to;

import java.util.List;

import com.SkyBlue.common.to.BaseBean;

import lombok.Getter;
import lombok.Setter;

public class CodeInfoBean extends BaseBean{
	@Setter
	@Getter
	private List<CodeBean> codeList;
	@Setter
	@Getter
	private List<DetailCodeBean> detailCodeList;

}
