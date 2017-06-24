package com.littletool.condition.sequeConditionImpl;

import java.util.List;

import com.littletool.bean.DataBean;
import com.littletool.condition.SequenceCondition;

public class Sequence3Line1 extends SequenceCondition{

	public Sequence3Line1(List<DataBean> inputDataList) {
		super(inputDataList);
		condition = CONDITION_3_LINE_1;
	}

}
