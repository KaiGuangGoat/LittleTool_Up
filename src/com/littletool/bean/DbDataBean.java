package com.littletool.bean;

import java.io.Serializable;
import java.util.Date;

public class DbDataBean implements Serializable{
	private long id;
	private Date date;
	private int value;
	private String sourceFile;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+id+"--date:"+date.toString()+"-- value:"+value +"-- sourceFile:"+sourceFile;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getSourceFile() {
		return sourceFile;
	}
	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}
}
