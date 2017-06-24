package com.littletool.condition;

import java.util.List;

import com.littletool.bean.DataBean;
import com.littletool.bean.SignalBean;

public abstract class SequenceCondition extends BaseCondition{

	public SequenceCondition(List<DataBean> inputDataList) {
		super(inputDataList);
	}
	
	@Override
	public void analyse() {
		for(SignalBean signal:signalList){
			flagSignal(signal);
			flagPrepareEnter(signal.getEndPosition()-1, signal.getIndex());
		}
	}
	
}
