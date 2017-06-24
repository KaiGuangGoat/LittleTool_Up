package com.littletool.condition.sequeConditionImpl;

import java.util.List;

import com.littletool.bean.DataBean;
import com.littletool.condition.SequenceCondition;

public class Sequence2Dot1 extends SequenceCondition{

	public Sequence2Dot1(List<DataBean> inputDataList) {
		super(inputDataList);
		condition = CONDITION_2_DOT_1;
	}

}
