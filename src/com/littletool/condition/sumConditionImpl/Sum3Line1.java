package com.littletool.condition.sumConditionImpl;

import java.util.List;

import com.littletool.bean.DataBean;
import com.littletool.condition.SumCondition;

public class Sum3Line1 extends SumCondition{

	public Sum3Line1(List<DataBean> inputDataList) {
		super(inputDataList);
		condition = CONDITION_3_LINE_1;
	}

}
