package com.littletool.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.littletool.UI.SelectFIlePanel.FileCondition;
import com.littletool.bean.RsiAllBean;
import com.littletool.dao.DbDataDao;
import com.littletool.dao.RsiAllDao;

public class SelectFileService extends BaseService{
	private RsiAllDao rsiAllDao = new RsiAllDao();
	private DbDataDao dbDataDao = new DbDataDao();
	
	public void analyseFileCondition(List<FileCondition> fileConditionList){
		for(FileCondition fileCondition:fileConditionList){
			try {
				insert(fileCondition.selectedFile);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void insert(File file) throws IOException{
		Document document = Jsoup.parse(file,"UTF-8");
		Elements elements = document.getElementsByTag("table");
		if (elements == null || elements.size() == 0) {
			return;
		}
		Element table2 = elements.get(1);
		Elements trs = table2.getElementsByTag("tr");
		boolean first = true;
		int i=0;
		
		List<RsiAllBean> rsiList = new ArrayList<>();
		for (Element tr : trs) {
			if (first) {
				first = false;
				continue;
			}
			if(i>10){
				break;
			}
			i++;
			RsiAllBean rsi = new RsiAllBean();
			rsi.setSourceFile(file.getName());
			String dateStr = tr.child(1).text().replace(".", "-");
			if(dateStr.length()==16){
				dateStr = dateStr + ":00";
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			try {
				rsi.setDate(format.parse(dateStr));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			rsi.setType(tr.child(2).text());
			rsi.setOrderCount(Integer.valueOf(tr.child(3).text()));
			rsi.setHandCount(tr.child(4).text());
			rsi.setPrice(tr.child(5).text());
			rsi.setStopLoss(tr.child(6).text());
			rsi.setProfit(tr.child(7).text());
			rsi.setState(0);
			if (tr.children().size() == 10) {
				String profitSec = tr.child(8).text();
				rsi.setProfitSecond(profitSec);
				rsi.setRemainder(tr.child(9).text());
				float profitSecFlo = Float.valueOf(profitSec);
				if (profitSecFlo > 0) {
					rsi.setState(1);
				}
				if (profitSecFlo < 0) {
					rsi.setState(-1);
				}
			}
			rsiList.add(rsi);
		}
//		rsiAllDao.save(rsiList);
	}

}
