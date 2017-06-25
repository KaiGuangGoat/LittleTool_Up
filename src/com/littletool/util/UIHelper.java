package com.littletool.util;

import java.awt.Dimension;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UIHelper {
	public static JTextField createJTextField(String text){
		final JTextField jtf = new JTextField(text);
		jtf.setMaximumSize(new Dimension(200,50));
		return jtf;
	}
	
	public static JTextField createJTextField(int w,int h){
		final JTextField jtf = new JTextField("");
		jtf.setMaximumSize(new Dimension(w,h));
		return jtf;
	}
	
	public static Box createBox(String title){
		Box box = Box.createVerticalBox();
		box.add(new JLabel(title));
		return box;
	}
	
	public static Box createBoxH(String title){
		Box box = Box.createHorizontalBox();
		box.add(new JLabel(title));
		return box;
	}
	
	public static JButton createButton(String text){
		JButton button = new JButton(text);
		return button;
	}
	
	public static JCheckBox createCheckBox(String name,String lable,boolean selected,ItemListener listener){
		JCheckBox checkBox = new JCheckBox(lable);
		checkBox.setSelected(selected);
		checkBox.setName(name);
		checkBox.addItemListener(listener);
		return checkBox;
	}
	
	public static JScrollPane createTableScrollPane(String[] names){
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel(names, 0);
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		return scroll;
	}
	
	public static void tableScrollToEn(JTable table){
		int rowCount = table.getRowCount();
		table.getSelectionModel().setSelectionInterval(rowCount-1, rowCount-1);
		table.scrollRectToVisible(table.getCellRect(rowCount-1, 0, true));;
	}
	
}
