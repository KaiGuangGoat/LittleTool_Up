package com.littletool.io;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.littletool.Constant;
import com.littletool.bean.DataBean;
import com.littletool.condition.BaseCondition;
import com.littletool.util.ColorUtil;
import com.littletool.util.Util;

public class OutByExcel {
	private HSSFWorkbook workBook ;
	private HSSFSheet sheet ;
	
	public OutByExcel(){
		workBook = new HSSFWorkbook();
		sheet = workBook.createSheet();
	}
	
	public void out(List<BaseCondition> conditionList,String fileName){
		if(conditionList == null || conditionList.size() == 0){
			return;
		}
		
		HSSFRow row = sheet.createRow(0);
		int columnNameIndex = 0;
		for(BaseCondition condition:conditionList){
			row.createCell(columnNameIndex++).setCellValue(condition.getKey());
			row.createCell(columnNameIndex++).setCellValue("信号");
			row.createCell(columnNameIndex++).setCellValue("入场");
			row.createCell(columnNameIndex++).setCellValue("止损");
			columnNameIndex++;
		}
		row.createCell(columnNameIndex++).setCellValue("时间");
		row.createCell(columnNameIndex++).setCellValue("备注");
		
		sheet.createFreezePane(columnNameIndex, 1);
		
		List<DataBean> dataList0 = conditionList.get(0).outputResult();
		int dataLen = dataList0.size();
		int i = 0;
		if(dataLen > 300){
			i=dataLen-300;
		}
		for(;i<dataLen;i++){
			HSSFRow rowData = sheet.createRow(i+1);
			
			int columnIndex = 0;
			for(BaseCondition condition:conditionList){
				
				DataBean dataBean = condition.outputResult().get(i);
				
//				rowData.createCell(columnIndex++).setCellValue(dataBean.getData());
				setCellStyleIntValue(rowData.createCell(columnIndex++), dataBean.getColor(), dataBean.getData());
				setCellStyleStringValue(rowData.createCell(columnIndex++), Constant.COLOR_SIGNAL_END, dataBean.isSignalEnd()?dataBean.getPositionToSignal()+"":"");
				setCellStyleStringValue(rowData.createCell(columnIndex++), Constant.COLOR_PREPARE_ENTER, dataBean.isEnterReady()?"备入"+dataBean.getPositionToSignal():"");
				setCellStyleStringValue(rowData.createCell(columnIndex++), Constant.COLOR_STOP_LOSS, dataBean.getStop()!=null?dataBean.getStop():"");
				columnIndex++;
			}
			rowData.createCell(columnIndex++).setCellValue(dataList0.get(i).getInputTime());
			rowData.createCell(columnIndex++).setCellValue(dataList0.get(i).getComment());
		}
		
		
		write(fileName, workBook);
	}
	
	private void setCellStyleIntValue(HSSFCell cell,Color color,int value){
		HSSFCellStyle style = workBook.createCellStyle();
		Short fg = ColorUtil.color2HSSFColor(color);
		if(fg!=null)
			style.setFillForegroundColor(fg);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		cell.setCellValue(value);
	}
	
	private void setCellStyleStringValue(HSSFCell cell,Color color,String value){
		HSSFCellStyle style = workBook.createCellStyle();
		Short fg = ColorUtil.color2HSSFColor(color);
		if(fg!=null && !Util.stringIsEmpty(value)){
			style.setFillForegroundColor(fg);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		}
		cell.setCellStyle(style);
		cell.setCellValue(value);
	}
	
	private String write(String fileName,HSSFWorkbook workBook){
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			workBook.write(fos);
			fos.close();
			return "";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
