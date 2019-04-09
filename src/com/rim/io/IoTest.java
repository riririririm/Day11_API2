package com.rim.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class IoTest {

	public static void main(String[] args) throws IOException {
		System.out.println("입력:");
		InputStream is = System.in;
		
		try{
			int num = is.read(); //read는 1byte만 읽는다

			System.out.println((char)num);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("종료");

	}

}
