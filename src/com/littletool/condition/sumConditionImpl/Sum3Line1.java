package com.littletool.condition.sumConditionImpl;

import com.littletool.Constant;
import com.littletool.condition.SumCondition;

public class Sum3Line1 extends SumCondition{
	
	public static final String KEY = Constant.SUM+"3-1";

	public Sum3Line1() {
		condition = CONDITION_3_LINE_1;
	}

	@Override
	public String getKey() {
		return "3-1    "+sumGoal;
	}
}
