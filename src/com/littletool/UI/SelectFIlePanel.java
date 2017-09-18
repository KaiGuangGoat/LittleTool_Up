package com.littletool.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import com.littletool.Constant;
import com.littletool.util.DateChooserJButton;
import com.littletool.util.UIHelper;

public class SelectFIlePanel {

	public static JFrame window;

	private Box boxUp;
	
	private JTextField startTime;
	
	private JTextField endTime;

	private JPanel panel;

	private JButton addFileButton;
	
	private File[] selectFiles ;

	public static void main(String[] args) {
		SelectFIlePanel select = new SelectFIlePanel();
		select.show();
	}

	public SelectFIlePanel() {
		window = new JFrame(Constant.VERSION_NAME);
		window.setSize(new Dimension(900, 900));
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
				System.out.println("window close");

			}
		});
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 4, 5, 5));

		addFileButton = new JButton("添加源文件 +");
		addFileButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File currentParentFile = new File("");
				
				JFileChooser jfc = new JFileChooser(currentParentFile.getAbsolutePath());
				jfc.setMultiSelectionEnabled(true);
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				jfc.showDialog(new JLabel(), "选择");
				selectFiles = jfc.getSelectedFiles();
				addSourceFile();
			}
		});

		initBoxUp();
		init();
	}

	private void initBoxUp() {
		boxUp = UIHelper.createBoxH("");
		boxUp.add(new JLabel("原始金额："));
		final JTextField jtf = new JTextField();
		jtf.setMinimumSize(new Dimension(20, 100));
		boxUp.add(jtf);

		boxUp.add(new JLabel("开始时间："));
		startTime = new DateChooserJButton();
		boxUp.add(startTime);
		
		boxUp.add(new JLabel("结束时间："));
		endTime = new DateChooserJButton();
		boxUp.add(endTime);
	}

	private void init() {
		window.add(boxUp, BorderLayout.NORTH);
		window.add(panel, BorderLayout.CENTER);
		
		panel.add(addFileButton);
	}
	
	private void addSourceFile(){
		for(File file:selectFiles){
			System.out.println(file.getName());
			String fileName = file.getName();
			Box box = UIHelper.createBox(fileName);
			box.add(new JButton("click"));
			panel.add(box);
		}
		repain();
	}
	
	private void repain(){
		window.revalidate();
	}

	public void show() {

		// window.setVisible(true);
		window.setVisible(true);
	}

}
