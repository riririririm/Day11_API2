package com.rim.io.file;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FileTest5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Random  r = new Random();
		
		File file = new File("C:\\test\\"+r.nextInt());
		
		if (file.exists()) {
			System.out.println("이미 존재하는 디렉토리명");
			//file.delete();
			
		}else {
			System.out.println("생성 성공");
			file.mkdir();
		}
		
		
		
		

	}

}
