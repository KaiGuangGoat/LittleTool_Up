package com.littletool.util;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.util.HSSFColor;

import com.littletool.Constant;


public class ColorUtil {
	static Map<Color, Short> colorMap;
	static{
		colorMap = new HashMap<>();
		colorMap.put(Constant.COLOR_POSITIVE, HSSFColor.GREEN.index);
		colorMap.put(Constant.COLOR_NEGATIVE, HSSFColor.RED.index);
		colorMap.put(Constant.COLOR_SIGNAL_END, HSSFColor.YELLOW.index);
		colorMap.put(Constant.COLOR_PREPARE_ENTER, HSSFColor.SKY_BLUE.index);
		colorMap.put(Color.gray, HSSFColor.GREY_25_PERCENT.index);
		colorMap.put(Constant.COLOR_STOP_LOSS, HSSFColor.PINK.index);
	}
	
	public static Short color2HSSFColor(Color color){
		return colorMap.get(color);
	}
	public static void main(String[] args) {
		System.out.println(color2HSSFColor(Color.green));
	}
}
