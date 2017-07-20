package com.littletool.condition;

import com.littletool.bean.DataBean;
import com.littletool.bean.SignalBean;
import com.littletool.stopLoss.StopLossType;

public abstract class SequenceCondition extends BaseCondition{

	public SequenceCondition() {
	}
	
	@Override
	public void analyse() {
		for(SignalBean signal:signalList){
			flagSignal(signal);
			flagPrepareEnter(signal.getEndPosition()-1, signal.getIndex());
			analyseStopLoss(signal.getEndPosition(),signal.getIndex());
		}
	}
	
	private void analyseStopLoss(int start,int signalIndex){
		if(start >= inputDataList.size()){
			return;
		}
		int sum = 0;
		for(int i=start;i<inputDataList.size();i++){
			DataBean dataBean = inputDataList.get(i);
			sum = sum + dataBean.getData();
			if(sum==10){
				flagStopLoss(i, StopLossType.NUMERICAL_STOP,signalIndex);
				return;
			}
			if(sum == -10){
				flagStopLoss(i, StopLossType.NO_STOP,signalIndex);
				return;
			}
			if(i-start == 99){
				flagStopLoss(i, StopLossType.SINGLE_STOP,signalIndex);
				return;
			}
		}
		
		
	}
	
	@Override
	public void sumGoal() {
		// TODO Auto-generated method stub
		
	}
}
