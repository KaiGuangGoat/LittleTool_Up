package com.littletool.util;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UIHelper {
	public static JTextField createJTextField(){
		final JTextField jtf = new JTextField("");
		jtf.setMaximumSize(new Dimension(200,50));
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
	
	public static JCheckBox createCheckBox(String lable){
		JCheckBox checkBox = new JCheckBox(lable);
		return checkBox;
	}
}
