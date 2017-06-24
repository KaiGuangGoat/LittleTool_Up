package com.littletool.condition.sequeConditionImpl;

import java.util.List;

import com.littletool.bean.DataBean;
import com.littletool.condition.SequenceCondition;

public class Sequence4Line1 extends SequenceCondition{

	public Sequence4Line1(List<DataBean> inputDataList) {
		super(inputDataList);
		condition = CONDITION_4_LINE_1;
	}

}
