package com.littletool.bean;

import java.io.Serializable;

/**
 * 
 * @author Kaiguang
 * @date 2017.6.21
 *
 */
public class DataBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8356160246769657082L;
	
	private int data;//输入的数据
	private String inputTime;//输入时间
	private int position;//属于第几个
	private String color;
	private boolean isSignalEnd = false;//是否属于信号量的最后一位
	private boolean isEnterReady = false;//是否准备入场
	private String comment;//备注
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public String getInputTime() {
		return inputTime;
	}
	public void setInputTime(String inputTime) {
		this.inputTime = inputTime;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isSignalEnd() {
		return isSignalEnd;
	}
	public void setSignalEnd(boolean isSignalEnd) {
		this.isSignalEnd = isSignalEnd;
	}
	public boolean isEnterReady() {
		return isEnterReady;
	}
	public void setEnterReady(boolean isEnterReady) {
		this.isEnterReady = isEnterReady;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
