package com.littletool.UI;

import java.awt.Component;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.littletool.Constant;
import com.littletool.bean.DataBean;

public class DataTableModelRender implements TableModel,TableCellRenderer{
	
	private List<DataBean> dataList;
	
	private String[] columnNames;
	
	public DataTableModelRender(List<DataBean> dataList,String[] columnNames){
		this.dataList = dataList;
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
		return false;
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
		}
		
		return value;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		
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
