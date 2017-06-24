package com.littletool.condition;

import com.littletool.bean.SignalBean;

public abstract class SequenceCondition extends BaseCondition{

	public SequenceCondition() {
	}
	
	@Override
	public void analyse() {
		for(SignalBean signal:signalList){
			flagSignal(signal);
			flagPrepareEnter(signal.getEndPosition()-1, signal.getIndex());
		}
	}
	
	@Override
	public void sumGoal() {
		// TODO Auto-generated method stub
		
	}
}
