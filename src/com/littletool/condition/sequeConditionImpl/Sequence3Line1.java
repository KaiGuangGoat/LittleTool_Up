package com.littletool.condition.sequeConditionImpl;

import com.littletool.Constant;
import com.littletool.condition.SequenceCondition;

public class Sequence3Line1 extends SequenceCondition{

	public static final String KEY = Constant.SEQUE+"3-1";
	
	public Sequence3Line1() {
		condition = CONDITION_3_LINE_1;
	}
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "3-1";
	}
}
