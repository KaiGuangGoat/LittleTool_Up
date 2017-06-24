package com.littletool.bean;

public class OutputBean {
	private DataBean conditionColumn;//条件
	private DataBean signalColumn;//信号
	private DataBean enterColumn;//入场
	public DataBean getConditionColumn() {
		return conditionColumn;
	}
	public void setConditionColumn(DataBean conditionColumn) {
		this.conditionColumn = conditionColumn;
	}
	public DataBean getSignalColumn() {
		return signalColumn;
	}
	public void setSignalColumn(DataBean signalColumn) {
		this.signalColumn = signalColumn;
	}
	public DataBean getEnterColumn() {
		return enterColumn;
	}
	public void setEnterColumn(DataBean enterColumn) {
		this.enterColumn = enterColumn;
	}
}
