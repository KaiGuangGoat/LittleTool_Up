package com.littletool.UI;

import java.awt.Component;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.littletool.Constant;
import com.littletool.bean.DataBean;

public class DataTableModelRender implements TableModel,TableCellRenderer{
	
	private List<DataBean> dataList;
	
	private List<DataBean> orgDataList;//原始数据，用来修改和删除用的
	
	private String[] columnNames;
	
	public DataTableModelRender(List<DataBean> dataList,List<DataBean>orgDataList,String[] columnNames){
		this.dataList = dataList;
		this.orgDataList = orgDataList;
		this.columnNames = columnNames;
	}

	@Override
	public int getRowCount() {
		return dataList==null?0:dataList.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return columnNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DataBean dataBean = dataList.get(rowIndex);
		String value = "";
		
		if(columnNames.length == 2){
			switch (columnIndex) {
			case 0:
				value = dataBean.getInputTime();
				break;

			case 1:
				value = dataBean.getComment();
				break;
			}
			return value;
		}
		
		switch(columnIndex){
		case 0:
			value = dataBean.getData()+"";
			break;
		case 1:
			if(dataBean.isSignalEnd()){
				value = "信号"+dataBean.getPositionToSignal();
			}
			break;
		case 2:
			if(dataBean.isEnterReady()){
				value = "备入"+dataBean.getPositionToSignal()+"";
			}
			break;
		case 3:
			value = dataBean.getInputTime();
			break;
		case 4:
			value = dataBean.getComment();
			break;
		}
		
		return value;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		DataBean dataBean = dataList.get(rowIndex);
		String value = aValue.toString();
		switch(columnIndex){
		case 0:
			if("1".equals(value)){
				dataBean.setData(1);
				dataBean.setColor(Constant.COLOR_POSITIVE);
				orgDataList.get(rowIndex).setData(1);
				orgDataList.get(rowIndex).setColor(Constant.COLOR_POSITIVE);
			}
			if("-1".equals(value)){
				dataBean.setData(-1);
				dataBean.setColor(Constant.COLOR_NEGATIVE);
				orgDataList.get(rowIndex).setData(-1);
				orgDataList.get(rowIndex).setColor(Constant.COLOR_NEGATIVE);
			}
			break;
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			dataBean.setComment(value);
			orgDataList.get(rowIndex).setComment(value);
			break;
		}
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Component render = new DefaultTableCellRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		DataBean dataBean = dataList.get(row);
		if(columnNames.length == 2){
			return render;
		}
		switch(column){
		case 0:
			render.setBackground(dataBean.getColor());
			break;
		case 1:
			if(dataBean.isSignalEnd()){
				render.setBackground(Constant.COLOR_SIGNAL_END);
			}
			break;
		case 2:
			if(dataBean.isEnterReady()){
				render.setBackground(Constant.COLOR_PREPARE_ENTER);
			}
			break;
		}
		
		return render;
	}

}
