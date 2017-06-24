package com.littletool.condition;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.littletool.UI.DataTableModelRender;
import com.littletool.bean.DataBean;
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
	
	protected JTextField jtf;
	
	public BaseCondition(){
		
	}
	
	protected void flagSignal(SignalBean signal){
		int position = signal.getEndPosition()-1;
		inputDataList.get(position).setSignalEnd(true);
		inputDataList.get(position).setPositionToSignal(signal.getIndex());
	}
	
	protected void flagPrepareEnter(int position,int positionToSignal){
		inputDataList.get(position).setEnterReady(true);
		inputDataList.get(position).setPositionToSignal(positionToSignal);
	}
	
	public void find(String textData,List<DataBean> inputDataList){
		sumGoal();
		this.inputDataList = inputDataList;
		Pattern p = Pattern.compile(condition);
		Matcher m = p.matcher(textData);
		int count = 0;
		while(m.find()){
			count++;
			SignalBean signal = new SignalBean();
			signal.setIndex(count);
			signal.setBeginPosition(m.start());
			signal.setEndPosition(m.end());
			for(int i=m.start();i<m.end();i++){
				this.inputDataList.get(i).setColor(Color.gray);
			}
			signalList.add(signal);
		}
	}
	
	public List<DataBean> outputResult(){
//		List<OutputBean> dataList = new ArrayList<>();
//		for(DataBean inputData:inputDataList){
//			OutputBean outputData = new OutputBean();
//			outputData.setConditionColumn(inputData);
//			if(inputData.isEnterReady()){
//				outputData.setEnterColumn(inputData);
//			}
//			if(inputData.isSignalEnd()){
//				outputData.setSignalColumn(inputData);
//			}
//			dataList.add(outputData);
//		}
		
		return inputDataList;
	}
	
	public void loadData(Box boxTableTitle){
		
		String[] names = {getKey(),"信号","入场"};
		DataTableModelRender modelRender = new DataTableModelRender(outputResult(), names);
		JTable table = new JTable();
		table.setModel(modelRender);
		table.setDefaultRenderer(Object.class, modelRender);
		JScrollPane scroll = new JScrollPane(table);
		boxTableTitle.add(scroll);
	}
	
	public void setJtf(JTextField jtf){
		this.jtf = jtf;
	}
	
	public abstract void analyse();
	
	public abstract String getKey();
	
	public abstract void sumGoal();
}
