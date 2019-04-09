package com.rim.io.file;

import java.io.File;

public class FileTest3 {

	public static void main(String[] args) {
		File file = new File("C:\\test");
		String str = "to-ru-ji,su";
		str= str.replace(",","-");
		String[] names = str.split("-");
		
		for(int i=0;i<names.length;i++) {
			file = new File("C:\\test\\"+names[i]);
			file.mkdir();
			
		}
			
		
		

	}

}
