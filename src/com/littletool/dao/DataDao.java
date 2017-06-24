package com.littletool.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.littletool.bean.DataBean;

public class DataDao {
	
	public static void save(String path,List<DataBean> data){
		System.out.println("savePath:"+path);
		ObjectOutputStream oos = null;
		File file = new File(path);
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(oos != null)
				try {
					
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
	}
	
	public static List<DataBean> load(File file){
		ObjectInputStream ois = null;
		if(file == null){
			return null;
		}
		try {
			FileInputStream fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			return (List<DataBean>)ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			if(ois !=null )
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
	}
	
	public static void delete(){
		
	}
}
