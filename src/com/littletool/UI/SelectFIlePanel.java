package com.littletool.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.littletool.Constant;
import com.littletool.condition.BaseCondition;
import com.littletool.condition.ConditionSelector;
import com.littletool.service.SelectFileService;
import com.littletool.util.DateChooserJButton;
import com.littletool.util.UIHelper;

public class SelectFIlePanel extends MainOperationPanel{

	public static JFrame window;

	private Box boxUp;
	
	private Box boxDown;
	
	private JTextField startTime;
	
	private JTextField endTime;

	private JPanel panel;

	private JButton addFileButton;
	
	private JButton analyseButton;
	
	private File[] selectFiles ;
	
	private List<FileCondition> fileConditionList;

	public static void main(String[] args) {
		SelectFIlePanel select = new SelectFIlePanel();
		select.show();
	}

	public SelectFIlePanel() {
		super();
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
		
		analyseButton = new JButton("开始分析");
		analyseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				beginAnalyse();
			}
		});
		
		fileConditionList = new ArrayList<>();

		initBoxUp();
		initBoxDown();
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
	
	private void initBoxDown(){
		boxDown = UIHelper.createBoxH("");
		boxDown.add(addFileButton);
		boxDown.add(analyseButton);
	}

	private void init() {
		window.add(boxUp, BorderLayout.NORTH);
		window.add(panel, BorderLayout.CENTER);
		window.add(boxDown,BorderLayout.SOUTH);
	}
	
	private void addSourceFile(){
		for(File file:selectFiles){
			System.out.println(file.getName());
			String fileName = file.getName();
			Box box = UIHelper.createBox(fileName);
			Box condition = UIHelper.createBoxH("");
			condition.add(createBoxSumCondition());
			condition.add(createBoxSequenceCondition());
			box.add(condition);
			
			FileCondition fileCondition = new FileCondition();
			fileCondition.selectedFile = file;
			fileCondition.conditionBox = box;
			fileConditionList.add(fileCondition);
			
			panel.add(box);
		}
		repain();
	}
	
	private Box createBoxSumCondition(){
		Box boxSumCondition = UIHelper.createBox("求和") ;
		for(String label:Constant.SUM_CONDITION_SELECT){
			boxSumCondition.add(sumItemBox(label));
		}
		
		return boxSumCondition;
	}
	
	private Box createBoxSequenceCondition(){
		Box boxSequenceCondition = UIHelper.createBox("顺序");
		for(String label:Constant.SEQUENCE_CONDITION_SELECT){
			boxSequenceCondition.add(UIHelper.createCheckBox(Constant.SEQUE+label,label,false,this));
		}
		return boxSequenceCondition;
	}
	
	private void repain(){
		window.revalidate();
	}

	public void show() {

		// window.setVisible(true);
		window.setVisible(true);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {}
	
	private void beginAnalyse(){
		SelectFileService service = new SelectFileService();
		service.analyseFileCondition(fileConditionList);
	}
	
	public static class FileCondition{
		public File selectedFile;
		public Box conditionBox;
	}

}
