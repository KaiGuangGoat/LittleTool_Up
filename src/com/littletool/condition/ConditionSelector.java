package com.littletool.condition;

import java.util.HashMap;
import java.util.Map;

import com.littletool.condition.sequeConditionImpl.Sequence2Dot1;
import com.littletool.condition.sequeConditionImpl.Sequence2Dot2Dot1;
import com.littletool.condition.sequeConditionImpl.Sequence3Line1;
import com.littletool.condition.sequeConditionImpl.Sequence4Line1;
import com.littletool.condition.sequeConditionImpl.Sequence5Line1;
import com.littletool.condition.sumConditionImpl.Sum2Dot1;
import com.littletool.condition.sumConditionImpl.Sum2Line1;
import com.littletool.condition.sumConditionImpl.Sum3Line1;

public class ConditionSelector {
	
	static Map<String, BaseCondition> conditionMap;
	
	static{
		conditionMap = new HashMap<>();
		conditionMap.put(Sum2Dot1.KEY,new Sum2Dot1());
		conditionMap.put(Sum2Line1.KEY,new Sum2Line1());
		conditionMap.put(Sum3Line1.KEY,new Sum3Line1());
		conditionMap.put(Sequence2Dot1.KEY,new Sequence2Dot1());
		conditionMap.put(Sequence2Dot2Dot1.KEY,new Sequence2Dot2Dot1());
		conditionMap.put(Sequence3Line1.KEY,new Sequence3Line1());
		conditionMap.put(Sequence4Line1.KEY,new Sequence4Line1());
		conditionMap.put(Sequence5Line1.KEY,new Sequence5Line1());
	}
	
	
	public static BaseCondition select(String name){
		return conditionMap.get(name);
	}
}
