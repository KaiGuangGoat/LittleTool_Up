package com.littletool.condition;

import com.littletool.bean.DataBean;
import com.littletool.bean.SignalBean;
import com.littletool.stopLoss.StopLossType;
import com.littletool.util.Util;

public abstract class SumCondition extends BaseCondition{
	
	
	protected static final int MAX_COUNT = 100;
	protected int sumGoal = 5;//设置的求和数
	protected static final int FIXED_COUNT = 200;
	
	
	@Override
	public void analyse() {
		for(SignalBean signal:signalList){
			int startPosition = 0;
			int index = 0;//偏移量
			int sum = 0;
			startPosition = signal.getEndPosition();
			flagSignal(signal);
			while(true){
				if(startPosition + index >= inputDataList.size()){
					break;
				}
				int data = inputDataList.get(startPosition + index).getData();
				sum = sum + data;
				if(sum==sumGoal){
					flagPrepareEnter(startPosition + index,signal.getIndex());
					analyseStopLoss(startPosition + index,signal);
					break;
				}
				if(index == MAX_COUNT){
					break;
				}
				index++;
			}
		}
	}
	
	private void analyseStopLoss(int start,SignalBean signal){
		if(start+1>=inputDataList.size()){
			return;
		}
		int sum = 0;
		for(int i=start+1;i<inputDataList.size();i++){
			DataBean data = inputDataList.get(i);
			sum = sum + data.getData();
			if(sum==10){
				flagStopLoss(i, StopLossType.NUMERICAL_STOP, signal.getIndex());
				return;
			}
			if(sum==-20){
				flagStopLoss(i, StopLossType.NO_STOP, signal.getIndex());
				return;
			}
			if(i-(signal.getEndPosition()-1)==FIXED_COUNT){
				flagStopLoss(i, StopLossType.FIXED_STOP, signal.getIndex());
				return;
			}
		}
	}
	
	@Override
	public void sumGoal() {
		String sumGoalStr = jtf.getText().trim();
		if(Util.stringIsEmpty(sumGoalStr)){
			return;
		}
		try {
			sumGoal = Integer.valueOf(sumGoalStr);
		} catch (Exception e) {
			sumGoal = 5;
		}
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public void setSumGoal(int sumGoal) {
		this.sumGoal = sumGoal;
	}
}
