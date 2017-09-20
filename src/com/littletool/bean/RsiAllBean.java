package com.littletool.bean;

import java.io.Serializable;
import java.util.Date;

public class RsiAllBean implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4359376866637301797L;

	private int id;
	private Date date;
	private String type = "";
	private int orderCount = 1;
	private String handCount = "";
	private String price = "";
	private String stopLoss = "";//止损
	private String profit = "";//获利1
	private String profitSecond = "";//获利2
	private String remainder = "";//余额
	private int state ;//根据获利2的正负判断：正：1，负-1
	private String sourceFile;//源文件
	private String currencyPair;//货币对
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public String getHandCount() {
		return handCount;
	}
	public void setHandCount(String handCount) {
		this.handCount = handCount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStopLoss() {
		return stopLoss;
	}
	public void setStopLoss(String stopLoss) {
		this.stopLoss = stopLoss;
	}
	public String getProfit() {
		return profit;
	}
	public void setProfit(String profit) {
		this.profit = profit;
	}
	public String getProfitSecond() {
		return profitSecond;
	}
	public void setProfitSecond(String profitSecond) {
		this.profitSecond = profitSecond;
	}
	public String getRemainder() {
		return remainder;
	}
	public void setRemainder(String remainder) {
		this.remainder = remainder;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getSourceFile() {
		return sourceFile;
	}
	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
}
