package com.rim.io.file;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File file = new File("C:\\test\\ex1.txt");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());

		file = new File("c:\\test\\test2\\ru");
		file.mkdirs();
		
		file = new File("c:\\test\\test2\\ru\\ex2.txt");
		file.delete();
	}

}
