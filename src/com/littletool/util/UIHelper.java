package com.littletool.util;

import java.awt.Dimension;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UIHelper {
	public static JTextField createJTextField(){
		final JTextField jtf = new JTextField("");
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
	
	public static JCheckBox createCheckBox(String name,String lable,ItemListener listener){
		JCheckBox checkBox = new JCheckBox(lable);
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
	
}
