package com.littletool.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
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
	
	public static void main(String[] args) {
		System.out.println(getCurrentTimeStr());
	}
}
