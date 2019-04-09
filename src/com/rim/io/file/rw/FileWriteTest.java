package com.rim.io.file.rw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {

	public static void main(String[] args) {
		File file   = new File("C:\\test","writeTest.txt");
		FileWriter fw  =null;
		try {
			fw = new FileWriter(file, true); //(file,true) -> / 추가해서 쓰기 (file,false) -> 덮어쓰기
			fw.write("fiveth Write\r\n"); //\r\n:엔터
			fw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch (IOException e) {
				e.printStackTrace();
			} 
		}

	}

}
