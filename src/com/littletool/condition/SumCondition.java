package com.littletool.condition;

import com.littletool.bean.SignalBean;

public abstract class SumCondition extends BaseCondition{
	
	
	protected static final int MAX_COUNT = 100;
	protected int sumGoal = 5;//设置的求和数
	
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
					break;
				}
				if(index == MAX_COUNT){
					break;
				}
				index++;
			}
			
			
		}
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public void setSumGoal(int sumGoal) {
		this.sumGoal = sumGoal;
	}
}
