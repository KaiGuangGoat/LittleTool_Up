package com.littletool.UI;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.littletool.util.UIHelper;

public class MainOperationPanel {
	
	private JFrame window;
	
	
	public MainOperationPanel(){
		window = new JFrame("小工具升级版");
		window.setSize(new Dimension(900, 900));
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void show(){
//		Box boxLeftParent = Box.createHorizontalBox();
		Box boxLeft = Box.createVerticalBox();
		boxLeft.setSize(new Dimension(200,900));
		
//		boxLeftParent.add(boxLeft);
		
		Box box1 = UIHelper.createBox("EA名称");
		box1.add(UIHelper.createJTextField());
		boxLeft.add(box1);
		
		Box box2 = UIHelper.createBox("添加数据");
		box2.add(UIHelper.createJTextField());
		boxLeft.add(box2);
		
		Box box3 = UIHelper.createBox("求和");
		box3.add(UIHelper.createCheckBox("2.1"));
		box3.add(UIHelper.createCheckBox("2-1"));
		box3.add(UIHelper.createCheckBox("3-1"));
		boxLeft.add(box3);
		
		Box box4 = UIHelper.createBox("顺序");
		box4.add(UIHelper.createCheckBox("2.1"));
		box4.add(UIHelper.createCheckBox("2.2.1"));
		box4.add(UIHelper.createCheckBox("3-1"));
		box4.add(UIHelper.createCheckBox("4-1"));
		box4.add(UIHelper.createCheckBox("5-1"));
		boxLeft.add(box4);
		
		Box boxRight = Box.createVerticalBox();
		
		Box boxTableTitle = UIHelper.createBox("test");
		boxTableTitle.setSize(new Dimension(700,200));
		boxRight.add(boxTableTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(new Dimension(700,700));
		boxRight.add(scrollPane);
		
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(layout);
		panel.add(boxLeft);
		panel.add(boxRight);
		
		window.setContentPane(panel);
		window.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		MainOperationPanel mainPanel = new MainOperationPanel();
		mainPanel.show();
	}
}
