package com.littletool.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.littletool.bean.DataBean;

public class Util {
	
	public static List<DataBean> copyDeep(List<DataBean> inputDataList){
		List<DataBean> inputDataListCopy = new ArrayList<>(inputDataList.size());
		for(DataBean data:inputDataList){
			inputDataListCopy.add(data.clone());
		}
		return inputDataListCopy;
	}
	
	public static String getCurrentTimeStr(){
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		return format.format(date);
	}
	
	public static boolean stringIsEmpty(String str){
		if(str==null || "".equals(str)){
			return true;
		}
		return false;
	}
	
	public static String getCurrentPath(){
		File file = new File("");
		return file.getAbsolutePath();
	}
	
	public static StringBuilder getTextData(List<DataBean> dataList){
		StringBuilder textData = new StringBuilder();
		for(DataBean data:dataList){
			if(data.getData()==1){
				textData.append("√");
			}
			if(data.getData() == -1){
				textData.append("x");
			}
		}
		return textData;
	}
	
	public static void main(String[] args) {
		System.out.println(getCurrentTimeStr());
	}
}
