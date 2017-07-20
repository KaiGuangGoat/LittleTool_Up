package com.littletool.bean;

import java.awt.Color;
import java.io.Serializable;

import com.littletool.stopLoss.StopLossType;
import com.littletool.tuple.TwoTuple;

/**
 * 
 * @author Kaiguang
 * @date 2017.6.21
 *
 */
public class DataBean implements Serializable,Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8356160246769657082L;
	
	private int data;//输入的数据
	private String inputTime;//输入时间
	private int position;//属于第几个
	private Color color;
	private boolean isSignalEnd = false;//是否属于信号量的最后一位
	private boolean isEnterReady = false;//是否准备入场
//	private TwoTuple<Boolean, StopLossType> stop;//是否止损位
	private String stop = "";
	private int positionToSignal;//属于第几个信号量
	private String comment;//备注
	@Override
	public DataBean clone(){
		try {
			return (DataBean) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
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
	public int getPositionToSignal() {
		return positionToSignal;
	}
	public void setPositionToSignal(int positionToSignal) {
		this.positionToSignal = positionToSignal;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getStop() {
		return stop;
	}
	public void setStop(String stop) {
		if(this.stop == null){
			this.stop = stop;
			return;
		}
		this.stop = this.stop+","+stop;
	}
}
