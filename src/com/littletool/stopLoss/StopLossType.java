package com.littletool.stopLoss;

public enum StopLossType {
	NO_STOP,
	NUMERICAL_STOP,
	SINGLE_STOP,
	FIXED_STOP;
	
	public String getValue(){
		switch (this) {
		case NO_STOP:
			return "无损";
		case NUMERICAL_STOP:
			return "数值";
		case SINGLE_STOP:
			return "单量";
		case FIXED_STOP:
			return "固定";
		default:
			return "";
		}
	}
	
}
