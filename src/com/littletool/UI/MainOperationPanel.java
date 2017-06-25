package com.littletool.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.littletool.Constant;
import com.littletool.bean.DataBean;
import com.littletool.condition.BaseCondition;
import com.littletool.condition.ConditionSelector;
import com.littletool.dao.DataDao;
import com.littletool.util.UIHelper;
import com.littletool.util.Util;

public class MainOperationPanel implements ItemListener{
	
	private JFrame window;
	
	private JTextField jtxEA;
	private String jtxEAString = "";
	
	private JTextField jtxUSD;
	private String jtxUSDString = "";
	
	private Box boxRight;
	
	private Box boxSumCondition;
	
	private Box boxSequenceCondition;
	
	private Box boxTableTitle;
	
	private JTextField jtfInputData;
	
	private List<BaseCondition> conditionList;
	
	private List<Integer> inputNumList;
	
	private List<DataBean> inputDataList;
	
	private List<DataBean> outputDataList;
	
	private StringBuilder textData;
	
	private KeyListener inputListener = new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() == '\n'){
				input();
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	public MainOperationPanel(){
		window = new JFrame("小工具升级版");
		window.setSize(new Dimension(900, 900));
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
				System.out.println("window close");
				save();
			}
		});
		
		inputNumList = new ArrayList<>();
		conditionList = new ArrayList<>();
		inputDataList = new ArrayList<>();
		
		textData = new StringBuilder();
		load();
	}
	
	public void show(){
//		Box boxLeftParent = Box.createHorizontalBox();
		Box boxLeft = Box.createVerticalBox();
		boxLeft.setSize(new Dimension(200,900));
		
//		boxLeftParent.add(boxLeft);
		
		Box boxEAName = UIHelper.createBox("EA名称");
		jtxEA = UIHelper.createJTextField(jtxEAString);
		boxEAName.add(jtxEA);
		boxLeft.add(boxEAName);
		
		Box boxUSD = UIHelper.createBox("货币对");
		jtxUSD = UIHelper.createJTextField(jtxUSDString);
		boxUSD.add(jtxUSD);
		boxLeft.add(boxUSD);
		
		Box box2 = UIHelper.createBox("添加数据");
		jtfInputData = UIHelper.createJTextField("");
		jtfInputData.addKeyListener(inputListener);
		box2.add(jtfInputData);
		boxLeft.add(box2);
		
		boxSumCondition = UIHelper.createBox("求和");
		for(String label:Constant.SUM_CONDITION){
			boxSumCondition.add(sumItemBox(label));
		}
		boxLeft.add(boxSumCondition);
		
		boxSequenceCondition = UIHelper.createBox("顺序");
		for(String label:Constant.SEQUENCE_CONDITION){
			boxSequenceCondition.add(UIHelper.createCheckBox(Constant.SEQUE+label,label,this));
		}
		boxLeft.add(boxSequenceCondition);
		
		boxRight = Box.createVerticalBox();
		
		boxTableTitle = UIHelper.createBoxH("");
		boxTableTitle.setSize(new Dimension(700,200));
//		titleScroll = new JScrollPane();
//		boxTableTitle.add(titleScroll);
		boxTableTitle.add(UIHelper.createTableScrollPane(new String[]{"时间","备注"}));
		boxRight.add(boxTableTitle);
		
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setSize(new Dimension(700,700));
//		boxRight.add(scrollPane);
		
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(layout);
		panel.add(boxLeft);
		panel.add(boxRight);
		
		window.setContentPane(panel);
		window.setVisible(true);
	}
	
	private Box sumItemBox(String item){
		Box box = UIHelper.createBoxH("");
		box.add(UIHelper.createCheckBox(Constant.SUM+item,item,this));
		JTextField jtf = UIHelper.createJTextField(50,30);
		jtf.addKeyListener(inputListener);
		box.add(jtf);
		ConditionSelector.select(Constant.SUM+item).setJtf(jtf);
		return box;
	}
	
	protected void input(){
		String input = jtfInputData.getText();
		jtfInputData.setText("");
		if(!"1".equals(input) && !"-1".equals(input)){
			System.out.println("非法字符");
			update();
			return;
		}
		if("1".equals(input)){
			textData.append("√");
			inputDataList.add(dataInstance(1, Constant.COLOR_POSITIVE));
			inputNumList.add(1);
		} 
		if( "-1".equals(input)){
			textData.append("x");
			inputDataList.add(dataInstance(-1, Constant.COLOR_NEGATIVE));
			inputNumList.add(-1);
		}
		update();
	}
	
	void update(){
		boxTableTitle.removeAll();
		List<JTable> dataTable = new ArrayList<>();
		for(BaseCondition condition:conditionList){
			
			List<DataBean> inputDataListCopy = copyDeep();
			condition.find(textData.toString(), inputDataListCopy);
			condition.analyse();
			outputDataList = condition.outputResult();
			JTable table = condition.loadData(boxTableTitle);
			dataTable.add(table);
//			repain();
		}
		dataTable.add(loadTimeComment());
		for(JTable table:dataTable){
			UIHelper.tableScrollToEn(table);
		}
	}
	
	List<DataBean> copyDeep(){
		List<DataBean> inputDataListCopy = new ArrayList<>(inputDataList.size());
		for(DataBean data:inputDataList){
			inputDataListCopy.add(data.clone());
		}
		return inputDataListCopy;
	}
	
	
	private JTable loadTimeComment(){
		String[] names = {"时间","备注"};
		DataTableModelRender modelRender = new DataTableModelRender(outputDataList, names);
		JTable table = new JTable();
		table.setModel(modelRender);
		table.setDefaultRenderer(Object.class, modelRender);
		JScrollPane scroll = new JScrollPane(table);
		boxTableTitle.add(scroll);
		repain();
		return table;
	}
	
	private DataBean dataInstance(int dataInt,Color color){
		DataBean data = new DataBean();
		data.setData(dataInt);
		data.setColor(color);
		data.setComment("");
		data.setInputTime(Util.getCurrentTimeStr());
		data.setPosition(0);
		data.setPositionToSignal(0);
		data.setEnterReady(false);
		data.setSignalEnd(false);
		return data;
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox jcb = (JCheckBox) e.getItem();
		String name = jcb.getName();
		BaseCondition condition = ConditionSelector.select(name);
		if(condition == null){
			System.out.println("itemStateChanged get condition null,name:"+name);
			return ;
		}
		
		if(jcb.isSelected()){
			conditionList.add(condition);
		}else{
			conditionList.remove(condition);
		}
		update();
		System.out.println("conditionList size:"+conditionList.size());
	}
	
	private void repain(){
		window.revalidate();
	}
	
	private void save(){
		DataDao.save(saveFilepath(), inputDataList);
	}
	
	private void load(){
		File currentParentFile = new File("");
		System.out.println(currentParentFile.getAbsolutePath());
		JFileChooser jfc = new JFileChooser(currentParentFile.getAbsolutePath());
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.showDialog(new JLabel(), "选择");
		File file = jfc.getSelectedFile();
		String[] fileName = file.getName().split("_");
		if(fileName.length == 2){
			jtxEAString = fileName[0];
			jtxUSDString = fileName[1].replace(".data", "");
		}
		
		List<DataBean> loadDataList = DataDao.load(file);
		if(loadDataList != null){
			inputDataList = loadDataList;
			textData.append(Util.getTextData(inputDataList));
			
		}
	}
	
	private String saveFilepath(){
		String fileName = jtxEA.getText()+"_" + jtxUSD.getText();
		if(Util.stringIsEmpty(fileName)){
			fileName = "EA_EURUSD";
		}
		
		return Util.getCurrentPath()+File.separator+fileName+".data";
	}
	
	public static void main(String[] args) {
		MainOperationPanel mainPanel = new MainOperationPanel();
		mainPanel.show();
	}
}
