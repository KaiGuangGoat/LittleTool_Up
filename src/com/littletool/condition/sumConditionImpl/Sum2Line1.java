package com.littletool.condition.sumConditionImpl;

import java.util.List;

import com.littletool.bean.DataBean;
import com.littletool.condition.SumCondition;

public class Sum2Line1 extends SumCondition{

	public Sum2Line1(List<DataBean> inputDataList) {
		super(inputDataList);
		condition = CONDITION_2_LINE_1;
	}

}
