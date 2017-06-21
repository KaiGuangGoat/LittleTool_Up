package com.littletool.bean;

import java.io.Serializable;
/**
 * 
 * @author Kaiguang
 * @date 2017.6.21
 *
 */
public class SignalBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1959253455166006751L;
	private int index;//第几个信号量
	private int beginPosition;//信号量开始的地方
	private int endPosition;//信号量结束的地方
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getBeginPosition() {
		return beginPosition;
	}
	public void setBeginPosition(int beginPosition) {
		this.beginPosition = beginPosition;
	}
	public int getEndPosition() {
		return endPosition;
	}
	public void setEndPosition(int endPosition) {
		this.endPosition = endPosition;
	}
}
