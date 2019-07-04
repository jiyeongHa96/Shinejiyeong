package com.SkyBlue.base.to;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.SkyBlue.common.annotation.Dataset;
import com.SkyBlue.common.to.BaseBean;
import com.SkyBlue.hr.circumstance.to.HobongBean;

import lombok.Getter;
import lombok.Setter;


@Dataset(name="dsPosition")
@Alias("positionBean")
public class PositionBean extends BaseBean{

	@Setter
	@Getter
	private String positionName,positionCode;
	@Setter
	@Getter
    private List<HobongBean> hobongList;

}
