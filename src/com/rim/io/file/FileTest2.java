package com.rim.io.file;

import java.io.File;

public class FileTest2 {

	public static void main(String[] args) {
		File file = new File("C:\\");
		File[] file_names = file.listFiles(); //파일 객체를 가져옴
		
		for(int i=0;i<file_names.length;i++) {
			if(file_names[i].isFile()) {
				System.out.println("이름:"+file_names[i].getName()+"파일크기:"+file_names[i].length());
			}else if(file_names[i].isDirectory()) {
				System.out.println(file_names[i].getName()+">>폴더입니다.");
			}
		}
		
		String[] names = file.list(); //이름만 가져옴
		for(int i=0;i<names.length;i++) {
			File file2 = new File(file, names[i]);
		}
		
	}

}
