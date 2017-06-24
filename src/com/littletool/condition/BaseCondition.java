package com.littletool.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.littletool.Constant;
import com.littletool.bean.DataBean;
import com.littletool.bean.OutputBean;
import com.littletool.bean.SignalBean;

public abstract class BaseCondition {
	public static final String CONDITION_2_DOT_1 = "√{2,}x{1,}√{1}x{1}";
	public static final String CONDITION_2_DOT_2_DOT_1 = "√{2,}x{1,}√{2,}x{1,}√{1}x{1}";
	public static final String CONDITION_2_LINE_1 = "√{2,}x{1}";
	public static final String CONDITION_3_LINE_1 = "√{3,}x{1}";
	public static final String CONDITION_4_LINE_1 = "√{4,}x{1}";
	public static final String CONDITION_5_LINE_1 = "√{5,}x{1}";
	
	protected String condition;
	
	protected List<DataBean> inputDataList;
	protected List<SignalBean> signalList = new ArrayList<SignalBean>();
	
	
	public BaseCondition(List<DataBean> inputDataList){
		this.inputDataList = inputDataList;
	}
	
	public void flagSignal(SignalBean signal){
		int position = signal.getEndPosition()-1;
		inputDataList.get(position).setSignalEnd(true);
		inputDataList.get(position).setColor(Constant.COLOR_SIGNAL_END);
		inputDataList.get(position).setPositionToSignal(signal.getIndex());
	}
	
	public void flagPrepareEnter(int position,int positionToSignal){
		inputDataList.get(position).setEnterReady(true);
		inputDataList.get(position).setColor(Constant.COLOR_PREPARE_ENTER);
		inputDataList.get(position).setPositionToSignal(positionToSignal);
	}
	
	public void find(String textData){
		Pattern p = Pattern.compile(condition);
		Matcher m = p.matcher(textData);
		int count = 0;
		while(m.find()){
			count++;
			SignalBean signal = new SignalBean();
			signal.setIndex(count);
			signal.setBeginPosition(m.start());
			signal.setEndPosition(m.end());
			signalList.add(signal);
		}
	}
	
	public List<OutputBean> outputResult(){
		List<OutputBean> dataList = new ArrayList<>();
		for(DataBean inputData:inputDataList){
			OutputBean outputData = new OutputBean();
			outputData.setConditionColumn(inputData);
			if(inputData.isEnterReady()){
				outputData.setEnterColumn(inputData);
			}
			if(inputData.isSignalEnd()){
				outputData.setSignalColumn(inputData);
			}
			dataList.add(outputData);
		}
		
		return dataList;
	}
	
	public abstract void analyse();
	
}
