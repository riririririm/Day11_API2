package com.rim.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IoTest2 {

	public static void main(String[] args){
		// 키보드로 입력받은 문자열 출력
		// byte로 받아서 byte -> 문자 -> 문자열

		System.out.println("입력:");
		InputStream is = System.in;// byte
		InputStreamReader ir = new InputStreamReader(is); // 문자처리
		BufferedReader br = new BufferedReader(ir);

		try {
			String str = br.readLine();
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//예외 발생하든 안하든 실행
			try {
				br.close();
				ir.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
