package com.littletool.condition.sequeConditionImpl;

import java.util.List;

import com.littletool.bean.DataBean;
import com.littletool.condition.SequenceCondition;

public class Sequence5Line1 extends SequenceCondition{

	public Sequence5Line1(List<DataBean> inputDataList) {
		super(inputDataList);
		condition = CONDITION_5_LINE_1;
	}

}
