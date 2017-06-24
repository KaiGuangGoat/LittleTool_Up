package com.littletool.condition.sumConditionImpl;

import java.util.List;

import com.littletool.bean.DataBean;
import com.littletool.condition.SumCondition;

public class Sum2Dot1 extends SumCondition{

	public Sum2Dot1(List<DataBean> inputDataList) {
		super(inputDataList);
		condition = CONDITION_2_DOT_1;
	}

}
