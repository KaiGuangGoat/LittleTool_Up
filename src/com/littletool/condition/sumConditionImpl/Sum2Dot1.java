package com.littletool.condition.sumConditionImpl;

import com.littletool.Constant;
import com.littletool.UI.MainOperationPanel;
import com.littletool.bean.ConfigureBean;
import com.littletool.condition.SumCondition;

public class Sum2Dot1 extends SumCondition{
	
	public static final String KEY = Constant.SUM+"2.1";

	public Sum2Dot1() {
		super();
		condition = CONDITION_2_DOT_1;
	}
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "2.1    "+sumGoal;
	}
	
	@Override
	public void sumGoal() {
		super.sumGoal();
		ConfigureBean config = MainOperationPanel.configureMap.get(KEY);
		if(config != null){
			config.setSumGoal(sumGoal);
		}
	}
}
