package com.main;

import java.io.FileWriter;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Duplicate{
	public static void main(String[] args) {
		JFileChooser file = new JFileChooser();
		file.showSaveDialog(null);
		String fileName =	file.getSelectedFile().getAbsolutePath();
		System.out.println(fileName);
		readFile(fileName);
		
	}	
	public static void readFile(String fileName){
		try{
			List<String> fileData =	Files.readAllLines(Paths.get(fileName));
			List<String> newData = new LinkedList<>();
			Map<String,String> noLines = new HashMap<>();
 			for(int i = 0 ;i < fileData.size();i++) {
				if(!newData.contains(fileData.get(i))) {
						newData.add(fileData.get(i));
				}else{
				/*	if(noLines.containsKey(fileData.get(i))) {
					}else {*/
					String value =noLines.get(fileData.get(i));
				//	noLines.put(fileData.get(i), String.valueOf(i+1));
					noLines.put(fileData.get(i), value+","+String.valueOf(i+1));
					System.out.println(noLines);
					//}
				}
			}
 			System.out.println(fileData);
 			System.out.println(newData);
 			
 			
 			
 			String newFileName = fileName.substring(0,fileName.lastIndexOf("\\"));
 			System.out.println(newFileName + "\\Samplenew.txt");
 		     FileWriter writer = new FileWriter(newFileName + "\\Samplenew.txt");
 		      int size = newData.size();
 		        for (int i=0;i<size;i++){					//exception
 		            String str = newData.get(i).toString();
 		            writer.write(str);
 		            if(i < size-1)//This prevent creating a blank like at the end of the file**
 		                writer.write("\n");
 		        }
 		        writer.close();
 		        
 		        System.out.println(writer);
 		       JOptionPane.showMessageDialog(null,"Process Completed No. of Lines: "+size);
			
		}catch(IOException e){
			e.getMessage();
		}

		}
}
	