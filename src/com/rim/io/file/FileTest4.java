package com.rim.io.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileTest4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		File file = new File("C:\\test\\ru");
		String[] names = file.list();
		String[] type = new String[names.length];

//		for (int i = 0; i < names.length; i++) {
//			int index = names[i].indexOf(".");
//			type[i] = names[i].substring(index + 1);
//			if (type[i].equals("jpg") == false) {
//				file = new File("C:\\test\\ru\\" + names[i]);
//				file.delete();
//			}
//		}

		System.out.println("디렉토리명 입력:");

		String name = sc.next();

		file = new File("C:\\test\\ru\\" + name);
		
		
		if (file.exists()) {
			System.out.println("이미 존재하는 디렉토리명");
			System.out.println(name + " 디렉토리 삭제 완료");
			file.delete();
			
		}else {
			System.out.println("생성 성공");
			file.mkdir();
//		} else {
//			try {
//				System.out.println("파일 생성 성공");
//				file.createNewFile();
//			} catch (IOException e) {
//				System.out.println("파일 생성 실패");
//				e.printStackTrace();
//			}
		}
		
		
		
		

	}

}
