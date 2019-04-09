package com.rim.io.file.rw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileReadTest {

	public static void main(String[] args) {
		File file   = new File("C:\\test","readTest.txt");
		FileReader fr  =null;
		BufferedReader br = null;
		ArrayList<String> names = new ArrayList<String>();
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String str = null;
			br.readLine();
			
			while((str = br.readLine())!=null) {
				String[] str2 = str.split("-"); //1라인
//				for(int i=0;i<str2.length;i++) {
//					System.out.println(str2[i]);
//				}
				for(String s:str2) {//인덱스번호가 필요하지 않을때
					//str2에서 하나 꺼내서 s에 담아라
					names.add(s);
				}
			}//end of while
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			br.close();
			fr.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(String s:names) {
			System.out.println(s);
		}

	}

}
