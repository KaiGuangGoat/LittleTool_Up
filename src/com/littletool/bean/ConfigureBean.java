package com.littletool.bean;

import java.io.Serializable;

public class ConfigureBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3917521244329991397L;
	private boolean selected=false;
	private int sumGoal=5;
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public int getSumGoal() {
		return sumGoal;
	}
	public void setSumGoal(int sumGoal) {
		this.sumGoal = sumGoal;
	}
}
